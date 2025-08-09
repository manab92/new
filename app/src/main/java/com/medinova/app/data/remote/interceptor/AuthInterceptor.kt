package com.medinova.app.data.remote.interceptor

import com.medinova.app.data.local.preferences.PreferencesManager
import com.medinova.app.data.remote.ApiConstants
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val preferencesManager: PreferencesManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        
        // Skip auth for certain endpoints
        val url = request.url.toString()
        if (shouldSkipAuth(url)) {
            return chain.proceed(request)
        }

        val accessToken = runBlocking {
            preferencesManager.getAccessToken().first()
        }

        val newRequest = if (accessToken.isNotEmpty()) {
            request.newBuilder()
                .addHeader(ApiConstants.Headers.AUTHORIZATION, "Bearer $accessToken")
                .addHeader(ApiConstants.Headers.CONTENT_TYPE, ApiConstants.ContentType.JSON)
                .addHeader(ApiConstants.Headers.ACCEPT, ApiConstants.ContentType.JSON)
                .addHeader(ApiConstants.Headers.X_PLATFORM, "android")
                .build()
        } else {
            request.newBuilder()
                .addHeader(ApiConstants.Headers.CONTENT_TYPE, ApiConstants.ContentType.JSON)
                .addHeader(ApiConstants.Headers.ACCEPT, ApiConstants.ContentType.JSON)
                .addHeader(ApiConstants.Headers.X_PLATFORM, "android")
                .build()
        }

        return chain.proceed(newRequest)
    }

    private fun shouldSkipAuth(url: String): Boolean {
        val skipAuthEndpoints = listOf(
            "auth/login",
            "auth/register",
            "auth/forgot-password",
            "auth/reset-password",
            "auth/verify-otp",
            "auth/social-login",
            "doctors/specialties"
        )
        
        return skipAuthEndpoints.any { endpoint ->
            url.contains(endpoint)
        }
    }
}