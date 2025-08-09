package com.medinova.app.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "email")
    val email: String,
    
    @Json(name = "password")
    val password: String,
    
    @Json(name = "device_token")
    val deviceToken: String? = null
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class RegisterRequest(
    @Json(name = "name")
    val name: String,
    
    @Json(name = "email")
    val email: String,
    
    @Json(name = "password")
    val password: String,
    
    @Json(name = "phone_number")
    val phoneNumber: String? = null,
    
    @Json(name = "date_of_birth")
    val dateOfBirth: String? = null,
    
    @Json(name = "gender")
    val gender: String? = null,
    
    @Json(name = "device_token")
    val deviceToken: String? = null
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class AuthResponse(
    @Json(name = "user")
    val user: User,
    
    @Json(name = "access_token")
    val accessToken: String,
    
    @Json(name = "refresh_token")
    val refreshToken: String,
    
    @Json(name = "token_type")
    val tokenType: String = "Bearer",
    
    @Json(name = "expires_in")
    val expiresIn: Long
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class RefreshTokenRequest(
    @Json(name = "refresh_token")
    val refreshToken: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ForgotPasswordRequest(
    @Json(name = "email")
    val email: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ResetPasswordRequest(
    @Json(name = "email")
    val email: String,
    
    @Json(name = "otp")
    val otp: String,
    
    @Json(name = "new_password")
    val newPassword: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ChangePasswordRequest(
    @Json(name = "old_password")
    val oldPassword: String,
    
    @Json(name = "new_password")
    val newPassword: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class VerifyOtpRequest(
    @Json(name = "email")
    val email: String,
    
    @Json(name = "otp")
    val otp: String,
    
    @Json(name = "type")
    val type: String // "email_verification", "password_reset", "phone_verification"
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class SocialLoginRequest(
    @Json(name = "provider")
    val provider: String, // "google", "facebook", "apple"
    
    @Json(name = "token")
    val token: String,
    
    @Json(name = "device_token")
    val deviceToken: String? = null
) : Parcelable