package com.medinova.app.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "chat_messages")
data class ChatMessage(
    @PrimaryKey
    @Json(name = "_id")
    val id: String,
    
    @Json(name = "appointment_id")
    val appointmentId: String,
    
    @Json(name = "sender_id")
    val senderId: String,
    
    @Json(name = "receiver_id")
    val receiverId: String,
    
    @Json(name = "message_text")
    val messageText: String? = null,
    
    @Json(name = "message_type")
    val messageType: String = MessageType.TEXT.name,
    
    @Json(name = "media_url")
    val mediaUrl: String? = null,
    
    @Json(name = "media_type")
    val mediaType: String? = null,
    
    @Json(name = "file_name")
    val fileName: String? = null,
    
    @Json(name = "file_size")
    val fileSize: Long? = null,
    
    @Json(name = "thumbnail_url")
    val thumbnailUrl: String? = null,
    
    @Json(name = "timestamp")
    val timestamp: String,
    
    @Json(name = "is_read")
    val isRead: Boolean = false,
    
    @Json(name = "is_delivered")
    val isDelivered: Boolean = false,
    
    @Json(name = "is_sent")
    val isSent: Boolean = true,
    
    @Json(name = "reply_to_message_id")
    val replyToMessageId: String? = null,
    
    @Json(name = "edited_at")
    val editedAt: String? = null,
    
    @Json(name = "deleted_at")
    val deletedAt: String? = null,
    
    @Json(name = "metadata")
    val metadata: Map<String, String>? = null
) : Parcelable

enum class MessageType(val displayName: String) {
    TEXT("Text"),
    IMAGE("Image"),
    VIDEO("Video"),
    AUDIO("Audio"),
    DOCUMENT("Document"),
    PRESCRIPTION("Prescription"),
    APPOINTMENT_UPDATE("Appointment Update"),
    SYSTEM("System Message"),
    LOCATION("Location"),
    CONTACT("Contact")
}

@Parcelize
@JsonClass(generateAdapter = true)
data class MessageStatus(
    @Json(name = "message_id")
    val messageId: String,
    
    @Json(name = "status")
    val status: String,
    
    @Json(name = "timestamp")
    val timestamp: String,
    
    @Json(name = "user_id")
    val userId: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class ChatRoom(
    @Json(name = "appointment_id")
    val appointmentId: String,
    
    @Json(name = "participants")
    val participants: List<String>,
    
    @Json(name = "last_message")
    val lastMessage: ChatMessage? = null,
    
    @Json(name = "unread_count")
    val unreadCount: Map<String, Int> = emptyMap(),
    
    @Json(name = "is_active")
    val isActive: Boolean = true,
    
    @Json(name = "created_at")
    val createdAt: String,
    
    @Json(name = "updated_at")
    val updatedAt: String
) : Parcelable