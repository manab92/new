package com.medinova.app.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "appointments")
data class Appointment(
    @PrimaryKey
    @Json(name = "appointment_id")
    val appointmentId: String,
    
    @Json(name = "user_id")
    val userId: String,
    
    @Json(name = "doctor_id")
    val doctorId: String,
    
    @Json(name = "appointment_time")
    val appointmentTime: String,
    
    @Json(name = "status")
    val status: String,
    
    @Json(name = "consultation_type")
    val consultationType: String,
    
    @Json(name = "payment_id")
    val paymentId: String? = null,
    
    @Json(name = "symptoms")
    val symptoms: String? = null,
    
    @Json(name = "notes")
    val notes: String? = null,
    
    @Json(name = "prescription")
    val prescription: String? = null,
    
    @Json(name = "diagnosis")
    val diagnosis: String? = null,
    
    @Json(name = "follow_up_required")
    val followUpRequired: Boolean = false,
    
    @Json(name = "follow_up_date")
    val followUpDate: String? = null,
    
    @Json(name = "session_duration")
    val sessionDuration: Int? = null, // in minutes
    
    @Json(name = "session_recording_url")
    val sessionRecordingUrl: String? = null,
    
    @Json(name = "meeting_link")
    val meetingLink: String? = null,
    
    @Json(name = "meeting_id")
    val meetingId: String? = null,
    
    @Json(name = "reminder_sent")
    val reminderSent: Boolean = false,
    
    @Json(name = "created_at")
    val createdAt: String,
    
    @Json(name = "updated_at")
    val updatedAt: String? = null,
    
    @Json(name = "cancelled_at")
    val cancelledAt: String? = null,
    
    @Json(name = "cancellation_reason")
    val cancellationReason: String? = null,
    
    @Json(name = "refund_amount")
    val refundAmount: Double? = null
) : Parcelable

enum class AppointmentStatus(val displayName: String) {
    SCHEDULED("Scheduled"),
    CONFIRMED("Confirmed"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed"),
    CANCELLED("Cancelled"),
    RESCHEDULED("Rescheduled"),
    NO_SHOW("No Show"),
    EXPIRED("Expired")
}

@Parcelize
@JsonClass(generateAdapter = true)
data class AppointmentWithDetails(
    val appointment: Appointment,
    val doctor: Doctor,
    val user: User? = null
) : Parcelable