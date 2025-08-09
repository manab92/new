package com.medinova.app.data.remote.api

import com.medinova.app.data.model.*
import com.medinova.app.data.remote.ApiConstants
import com.medinova.app.data.remote.dto.ApiResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface CommunicationApiService {
    
    @GET(ApiConstants.Communication.CHAT_ROOMS)
    suspend fun getChatRooms(): Response<ApiResponse<List<ChatRoom>>>
    
    @GET(ApiConstants.Communication.MESSAGES)
    suspend fun getMessages(
        @Path("appointmentId") appointmentId: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 50,
        @Query("before") before: String? = null
    ): Response<ApiResponse<List<ChatMessage>>>
    
    @POST(ApiConstants.Communication.SEND_MESSAGE)
    suspend fun sendMessage(
        @Path("appointmentId") appointmentId: String,
        @Body message: SendMessageRequest
    ): Response<ApiResponse<ChatMessage>>
    
    @POST(ApiConstants.Communication.MARK_READ)
    suspend fun markMessagesAsRead(
        @Path("appointmentId") appointmentId: String,
        @Body request: MarkReadRequest
    ): Response<ApiResponse<Unit>>
    
    @Multipart
    @POST(ApiConstants.Communication.UPLOAD_MEDIA)
    suspend fun uploadMedia(
        @Part file: MultipartBody.Part,
        @Part("appointment_id") appointmentId: String,
        @Part("message_type") messageType: String
    ): Response<ApiResponse<MediaUploadResponse>>
    
    @POST(ApiConstants.Communication.VIDEO_TOKEN)
    suspend fun getVideoToken(
        @Path("appointmentId") appointmentId: String
    ): Response<ApiResponse<VideoTokenResponse>>
    
    @POST(ApiConstants.Communication.VOICE_TOKEN)
    suspend fun getVoiceToken(
        @Path("appointmentId") appointmentId: String
    ): Response<ApiResponse<VoiceTokenResponse>>
    
    @GET(ApiConstants.Communication.CALL_STATUS)
    suspend fun getCallStatus(
        @Path("appointmentId") appointmentId: String
    ): Response<ApiResponse<CallStatus>>
    
    @POST(ApiConstants.Communication.END_CALL)
    suspend fun endCall(
        @Path("appointmentId") appointmentId: String,
        @Body request: EndCallRequest
    ): Response<ApiResponse<Unit>>
}

data class SendMessageRequest(
    val messageText: String? = null,
    val messageType: String = "text",
    val mediaUrl: String? = null,
    val replyToMessageId: String? = null
)

data class MarkReadRequest(
    val messageIds: List<String>
)

data class MediaUploadResponse(
    val fileId: String,
    val fileName: String,
    val fileUrl: String,
    val fileSize: Long,
    val mimeType: String,
    val thumbnailUrl: String? = null
)

data class VideoTokenResponse(
    val accessToken: String,
    val roomName: String,
    val identity: String,
    val expiresAt: String
)

data class VoiceTokenResponse(
    val accessToken: String,
    val roomName: String,
    val identity: String,
    val expiresAt: String
)

data class CallStatus(
    val appointmentId: String,
    val status: String, // "waiting", "in_progress", "ended"
    val participants: List<CallParticipant>,
    val startTime: String? = null,
    val endTime: String? = null,
    val duration: Int? = null // in seconds
)

data class CallParticipant(
    val userId: String,
    val name: String,
    val role: String, // "patient", "doctor"
    val joinTime: String? = null,
    val leaveTime: String? = null,
    val isOnline: Boolean = false
)

data class EndCallRequest(
    val duration: Int, // in seconds
    val reason: String? = null
)