package com.medinova.app.data.remote.api

import com.medinova.app.data.model.User
import com.medinova.app.data.remote.ApiConstants
import com.medinova.app.data.remote.dto.ApiResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.*

interface UserApiService {
    
    @GET(ApiConstants.User.PROFILE)
    suspend fun getUserProfile(): Response<ApiResponse<User>>
    
    @PUT(ApiConstants.User.UPDATE_PROFILE)
    suspend fun updateUserProfile(
        @Body user: User
    ): Response<ApiResponse<User>>
    
    @Multipart
    @POST(ApiConstants.User.UPLOAD_AVATAR)
    suspend fun uploadAvatar(
        @Part avatar: MultipartBody.Part
    ): Response<ApiResponse<String>>
    
    @DELETE(ApiConstants.User.DELETE_ACCOUNT)
    suspend fun deleteAccount(): Response<ApiResponse<Unit>>
    
    @GET(ApiConstants.User.MEDICAL_HISTORY)
    suspend fun getMedicalHistory(): Response<ApiResponse<List<MedicalRecord>>>
    
    @POST(ApiConstants.User.MEDICAL_HISTORY)
    suspend fun addMedicalRecord(
        @Body record: MedicalRecord
    ): Response<ApiResponse<MedicalRecord>>
    
    @GET(ApiConstants.User.EMERGENCY_CONTACTS)
    suspend fun getEmergencyContacts(): Response<ApiResponse<List<EmergencyContact>>>
    
    @POST(ApiConstants.User.EMERGENCY_CONTACTS)
    suspend fun addEmergencyContact(
        @Body contact: EmergencyContact
    ): Response<ApiResponse<EmergencyContact>>
}

data class MedicalRecord(
    val id: String? = null,
    val condition: String,
    val diagnosedDate: String,
    val description: String? = null,
    val medications: List<String> = emptyList(),
    val allergies: List<String> = emptyList()
)

data class EmergencyContact(
    val id: String? = null,
    val name: String,
    val phoneNumber: String,
    val relationship: String,
    val isPrimary: Boolean = false
)