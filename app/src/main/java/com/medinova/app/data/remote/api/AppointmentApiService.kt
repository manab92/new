package com.medinova.app.data.remote.api

import com.medinova.app.data.model.*
import com.medinova.app.data.remote.ApiConstants
import com.medinova.app.data.remote.dto.ApiResponse
import retrofit2.Response
import retrofit2.http.*

interface AppointmentApiService {
    
    @POST(ApiConstants.Appointment.BOOK)
    suspend fun bookAppointment(
        @Body request: BookAppointmentRequest
    ): Response<ApiResponse<AppointmentWithDetails>>
    
    @GET(ApiConstants.Appointment.LIST)
    suspend fun getAppointments(
        @Query("status") status: String? = null,
        @Query("start_date") startDate: String? = null,
        @Query("end_date") endDate: String? = null,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<AppointmentWithDetails>>>
    
    @GET(ApiConstants.Appointment.DETAILS)
    suspend fun getAppointmentDetails(
        @Path("appointmentId") appointmentId: String
    ): Response<ApiResponse<AppointmentWithDetails>>
    
    @POST(ApiConstants.Appointment.CANCEL)
    suspend fun cancelAppointment(
        @Path("appointmentId") appointmentId: String,
        @Body request: CancelAppointmentRequest
    ): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Appointment.RESCHEDULE)
    suspend fun rescheduleAppointment(
        @Path("appointmentId") appointmentId: String,
        @Body request: RescheduleAppointmentRequest
    ): Response<ApiResponse<AppointmentWithDetails>>
    
    @POST(ApiConstants.Appointment.COMPLETE)
    suspend fun completeAppointment(
        @Path("appointmentId") appointmentId: String,
        @Body request: CompleteAppointmentRequest
    ): Response<ApiResponse<Unit>>
    
    @GET(ApiConstants.Appointment.HISTORY)
    suspend fun getAppointmentHistory(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<AppointmentWithDetails>>>
    
    @GET(ApiConstants.Appointment.UPCOMING)
    suspend fun getUpcomingAppointments(
        @Query("limit") limit: Int = 10
    ): Response<ApiResponse<List<AppointmentWithDetails>>>
    
    @GET(ApiConstants.Appointment.PAST)
    suspend fun getPastAppointments(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<AppointmentWithDetails>>>
    
    @POST(ApiConstants.Appointment.JOIN_MEETING)
    suspend fun joinMeeting(
        @Path("appointmentId") appointmentId: String
    ): Response<ApiResponse<MeetingDetails>>
}

// Request/Response DTOs for Appointment Service
data class BookAppointmentRequest(
    val doctorId: String,
    val appointmentTime: String,
    val consultationType: String,
    val symptoms: String? = null,
    val notes: String? = null
)

data class CancelAppointmentRequest(
    val reason: String
)

data class RescheduleAppointmentRequest(
    val newAppointmentTime: String,
    val reason: String? = null
)

data class CompleteAppointmentRequest(
    val diagnosis: String? = null,
    val prescription: String? = null,
    val notes: String? = null,
    val followUpRequired: Boolean = false,
    val followUpDate: String? = null
)

data class MeetingDetails(
    val meetingId: String,
    val meetingLink: String,
    val accessToken: String? = null,
    val roomName: String? = null
)