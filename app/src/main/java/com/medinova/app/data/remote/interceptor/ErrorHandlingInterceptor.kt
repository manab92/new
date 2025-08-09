package com.medinova.app.data.remote.interceptor

import com.medinova.app.data.remote.ApiConstants
import okhttp3.Interceptor
import okhttp3.Response
import timber.log.Timber
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class ErrorHandlingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        
        return try {
            val response = chain.proceed(request)
            
            when (response.code) {
                ApiConstants.ResponseCode.UNAUTHORIZED -> {
                    Timber.w("Unauthorized access - token might be expired")
                    // Handle token refresh or logout
                }
                ApiConstants.ResponseCode.FORBIDDEN -> {
                    Timber.w("Forbidden access")
                }
                ApiConstants.ResponseCode.NOT_FOUND -> {
                    Timber.w("Resource not found: ${request.url}")
                }
                ApiConstants.ResponseCode.INTERNAL_SERVER_ERROR -> {
                    Timber.e("Internal server error")
                }
                ApiConstants.ResponseCode.SERVICE_UNAVAILABLE -> {
                    Timber.e("Service unavailable")
                }
            }
            
            response
        } catch (e: Exception) {
            Timber.e(e, "Network error occurred")
            
            val errorMessage = when (e) {
                is UnknownHostException -> "No internet connection"
                is SocketTimeoutException -> "Connection timeout"
                is IOException -> "Network error"
                else -> "Unknown error: ${e.message}"
            }
            
            Timber.e("Network error: $errorMessage")
            throw e
        }
    }
}