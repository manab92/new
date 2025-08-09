package com.medinova.app.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "reviews")
data class Review(
    @PrimaryKey
    @Json(name = "review_id")
    val reviewId: String,
    
    @Json(name = "appointment_id")
    val appointmentId: String,
    
    @Json(name = "user_id")
    val userId: String,
    
    @Json(name = "doctor_id")
    val doctorId: String,
    
    @Json(name = "rating")
    val rating: Int, // 1-5 stars
    
    @Json(name = "comment")
    val comment: String? = null,
    
    @Json(name = "helpful_count")
    val helpfulCount: Int = 0,
    
    @Json(name = "is_verified")
    val isVerified: Boolean = false,
    
    @Json(name = "consultation_type")
    val consultationType: String? = null,
    
    @Json(name = "experience_tags")
    val experienceTags: List<String> = emptyList(),
    
    @Json(name = "created_at")
    val createdAt: String,
    
    @Json(name = "updated_at")
    val updatedAt: String? = null
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ReviewWithUser(
    val review: Review,
    val userName: String,
    val userProfilePicture: String? = null,
    val isAnonymous: Boolean = false
) : Parcelable

enum class ReviewTag(val displayName: String) {
    PROFESSIONAL("Professional"),
    CARING("Caring"),
    PUNCTUAL("Punctual"),
    KNOWLEDGEABLE("Knowledgeable"),
    GOOD_LISTENER("Good Listener"),
    CLEAR_EXPLANATION("Clear Explanation"),
    THOROUGH("Thorough"),
    PATIENT("Patient"),
    EMPATHETIC("Empathetic"),
    RESPONSIVE("Responsive"),
    FRIENDLY("Friendly"),
    EXPERIENCED("Experienced")
}