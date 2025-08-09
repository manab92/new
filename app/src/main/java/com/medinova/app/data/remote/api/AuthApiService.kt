package com.medinova.app.data.remote.api

import com.medinova.app.data.model.*
import com.medinova.app.data.remote.ApiConstants
import com.medinova.app.data.remote.dto.ApiResponse
import retrofit2.Response
import retrofit2.http.*

interface AuthApiService {
    
    @POST(ApiConstants.Auth.LOGIN)
    suspend fun login(
        @Body request: LoginRequest
    ): Response<ApiResponse<AuthResponse>>
    
    @POST(ApiConstants.Auth.REGISTER)
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<ApiResponse<AuthResponse>>
    
    @POST(ApiConstants.Auth.LOGOUT)
    suspend fun logout(): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Auth.REFRESH_TOKEN)
    suspend fun refreshToken(
        @Body request: RefreshTokenRequest
    ): Response<ApiResponse<AuthResponse>>
    
    @POST(ApiConstants.Auth.FORGOT_PASSWORD)
    suspend fun forgotPassword(
        @Body request: ForgotPasswordRequest
    ): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Auth.RESET_PASSWORD)
    suspend fun resetPassword(
        @Body request: ResetPasswordRequest
    ): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Auth.VERIFY_OTP)
    suspend fun verifyOtp(
        @Body request: VerifyOtpRequest
    ): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Auth.RESEND_OTP)
    suspend fun resendOtp(
        @Body request: Map<String, String>
    ): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Auth.SOCIAL_LOGIN)
    suspend fun socialLogin(
        @Body request: SocialLoginRequest
    ): Response<ApiResponse<AuthResponse>>
    
    @POST(ApiConstants.Auth.CHANGE_PASSWORD)
    suspend fun changePassword(
        @Body request: ChangePasswordRequest
    ): Response<ApiResponse<Unit>>
}