package com.medinova.app.data.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiResponse<T>(
    @Json(name = "success")
    val success: Boolean,
    
    @Json(name = "message")
    val message: String? = null,
    
    @Json(name = "data")
    val data: T? = null,
    
    @Json(name = "error")
    val error: ApiError? = null,
    
    @Json(name = "meta")
    val meta: MetaData? = null
)

@JsonClass(generateAdapter = true)
data class ApiError(
    @Json(name = "code")
    val code: String,
    
    @Json(name = "message")
    val message: String,
    
    @Json(name = "details")
    val details: Map<String, Any>? = null,
    
    @Json(name = "timestamp")
    val timestamp: String? = null
)

@JsonClass(generateAdapter = true)
data class MetaData(
    @Json(name = "pagination")
    val pagination: Pagination? = null,
    
    @Json(name = "request_id")
    val requestId: String? = null,
    
    @Json(name = "version")
    val version: String? = null
)

@JsonClass(generateAdapter = true)
data class Pagination(
    @Json(name = "current_page")
    val currentPage: Int,
    
    @Json(name = "per_page")
    val perPage: Int,
    
    @Json(name = "total")
    val total: Int,
    
    @Json(name = "total_pages")
    val totalPages: Int,
    
    @Json(name = "has_next")
    val hasNext: Boolean,
    
    @Json(name = "has_prev")
    val hasPrev: Boolean
)

// Sealed class for handling different response states
sealed class ApiResult<out T> {
    data class Success<T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Throwable) : ApiResult<Nothing>()
    data class Loading(val isLoading: Boolean = true) : ApiResult<Nothing>()
}

// Extension function to convert ApiResponse to ApiResult
fun <T> ApiResponse<T>.toResult(): ApiResult<T> {
    return if (success && data != null) {
        ApiResult.Success(data)
    } else {
        val errorMessage = error?.message ?: message ?: "Unknown error"
        ApiResult.Error(Exception(errorMessage))
    }
}