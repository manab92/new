package com.medinova.app.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "users")
data class User(
    @PrimaryKey
    @Json(name = "user_id")
    val userId: String,
    
    @Json(name = "name")
    val name: String,
    
    @Json(name = "email")
    val email: String,
    
    @Json(name = "phone_number")
    val phoneNumber: String? = null,
    
    @Json(name = "date_of_birth")
    val dateOfBirth: String? = null,
    
    @Json(name = "profile_picture_url")
    val profilePictureUrl: String? = null,
    
    @Json(name = "gender")
    val gender: String? = null,
    
    @Json(name = "address")
    val address: String? = null,
    
    @Json(name = "emergency_contact")
    val emergencyContact: String? = null,
    
    @Json(name = "blood_group")
    val bloodGroup: String? = null,
    
    @Json(name = "medical_history")
    val medicalHistory: String? = null,
    
    @Json(name = "is_verified")
    val isVerified: Boolean = false,
    
    @Json(name = "created_at")
    val createdAt: String,
    
    @Json(name = "updated_at")
    val updatedAt: String? = null
) : Parcelable

enum class Gender {
    MALE, FEMALE, OTHER, PREFER_NOT_TO_SAY
}

enum class BloodGroup {
    A_POSITIVE, A_NEGATIVE, B_POSITIVE, B_NEGATIVE,
    AB_POSITIVE, AB_NEGATIVE, O_POSITIVE, O_NEGATIVE
}