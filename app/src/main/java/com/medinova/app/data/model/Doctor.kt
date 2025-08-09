package com.medinova.app.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "doctors")
data class Doctor(
    @PrimaryKey
    @Json(name = "doctor_id")
    val doctorId: String,
    
    @Json(name = "name")
    val name: String,
    
    @Json(name = "email")
    val email: String,
    
    @Json(name = "phone_number")
    val phoneNumber: String? = null,
    
    @Json(name = "specialty")
    val specialty: String,
    
    @Json(name = "sub_specialty")
    val subSpecialty: String? = null,
    
    @Json(name = "profile_picture_url")
    val profilePictureUrl: String? = null,
    
    @Json(name = "about")
    val about: String? = null,
    
    @Json(name = "experience_years")
    val experienceYears: Int,
    
    @Json(name = "consultation_fee")
    val consultationFee: Double,
    
    @Json(name = "average_rating")
    val averageRating: Double = 0.0,
    
    @Json(name = "total_reviews")
    val totalReviews: Int = 0,
    
    @Json(name = "qualifications")
    val qualifications: List<String> = emptyList(),
    
    @Json(name = "languages")
    val languages: List<String> = emptyList(),
    
    @Json(name = "clinic_address")
    val clinicAddress: String? = null,
    
    @Json(name = "clinic_name")
    val clinicName: String? = null,
    
    @Json(name = "availability_schedule")
    val availabilitySchedule: List<AvailabilitySlot> = emptyList(),
    
    @Json(name = "is_online")
    val isOnline: Boolean = false,
    
    @Json(name = "next_available_slot")
    val nextAvailableSlot: String? = null,
    
    @Json(name = "consultation_types")
    val consultationTypes: List<String> = listOf("video", "voice", "chat"),
    
    @Json(name = "is_verified")
    val isVerified: Boolean = false,
    
    @Json(name = "license_number")
    val licenseNumber: String? = null,
    
    @Json(name = "created_at")
    val createdAt: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class AvailabilitySlot(
    @Json(name = "day_of_week")
    val dayOfWeek: String,
    
    @Json(name = "start_time")
    val startTime: String,
    
    @Json(name = "end_time")
    val endTime: String,
    
    @Json(name = "is_available")
    val isAvailable: Boolean = true
) : Parcelable

enum class MedicalSpecialty(val displayName: String) {
    GENERAL_MEDICINE("General Medicine"),
    CARDIOLOGY("Cardiology"),
    DERMATOLOGY("Dermatology"),
    PEDIATRICS("Pediatrics"),
    ORTHOPEDICS("Orthopedics"),
    GYNECOLOGY("Gynecology"),
    NEUROLOGY("Neurology"),
    PSYCHIATRY("Psychiatry"),
    OPHTHALMOLOGY("Ophthalmology"),
    ENT("ENT"),
    RADIOLOGY("Radiology"),
    PATHOLOGY("Pathology"),
    ANESTHESIOLOGY("Anesthesiology"),
    EMERGENCY_MEDICINE("Emergency Medicine"),
    FAMILY_MEDICINE("Family Medicine"),
    INTERNAL_MEDICINE("Internal Medicine"),
    SURGERY("Surgery"),
    ONCOLOGY("Oncology"),
    ENDOCRINOLOGY("Endocrinology"),
    NEPHROLOGY("Nephrology"),
    GASTROENTEROLOGY("Gastroenterology"),
    PULMONOLOGY("Pulmonology"),
    RHEUMATOLOGY("Rheumatology"),
    UROLOGY("Urology"),
    PLASTIC_SURGERY("Plastic Surgery"),
    PHYSIOTHERAPY("Physiotherapy"),
    NUTRITION("Nutrition & Dietetics")
}

enum class ConsultationType(val displayName: String) {
    VIDEO_CALL("Video Call"),
    VOICE_CALL("Voice Call"),
    CHAT("Chat"),
    IN_PERSON("In-Person")
}