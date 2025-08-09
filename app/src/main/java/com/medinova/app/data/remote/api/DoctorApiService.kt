package com.medinova.app.data.remote.api

import com.medinova.app.data.model.*
import com.medinova.app.data.remote.ApiConstants
import com.medinova.app.data.remote.dto.ApiResponse
import retrofit2.Response
import retrofit2.http.*

interface DoctorApiService {
    
    @GET(ApiConstants.Doctor.SEARCH)
    suspend fun searchDoctors(
        @Query("query") query: String? = null,
        @Query("specialty") specialty: String? = null,
        @Query("location") location: String? = null,
        @Query("latitude") latitude: Double? = null,
        @Query("longitude") longitude: Double? = null,
        @Query("radius") radius: Int? = null,
        @Query("consultation_type") consultationType: String? = null,
        @Query("availability") availability: String? = null,
        @Query("min_rating") minRating: Double? = null,
        @Query("max_fee") maxFee: Double? = null,
        @Query("language") language: String? = null,
        @Query("gender") gender: String? = null,
        @Query("experience_years") experienceYears: Int? = null,
        @Query("sort_by") sortBy: String? = null,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<Doctor>>>
    
    @GET(ApiConstants.Doctor.DETAILS)
    suspend fun getDoctorDetails(
        @Path("doctorId") doctorId: String
    ): Response<ApiResponse<Doctor>>
    
    @GET(ApiConstants.Doctor.AVAILABILITY)
    suspend fun getDoctorAvailability(
        @Path("doctorId") doctorId: String,
        @Query("date") date: String? = null,
        @Query("days") days: Int? = 7
    ): Response<ApiResponse<List<AvailabilitySlot>>>
    
    @GET(ApiConstants.Doctor.REVIEWS)
    suspend fun getDoctorReviews(
        @Path("doctorId") doctorId: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 10,
        @Query("sort_by") sortBy: String? = "created_at",
        @Query("rating") rating: Int? = null
    ): Response<ApiResponse<List<ReviewWithUser>>>
    
    @GET(ApiConstants.Doctor.SPECIALTIES)
    suspend fun getSpecialties(): Response<ApiResponse<List<String>>>
    
    @GET(ApiConstants.Doctor.NEARBY)
    suspend fun getNearbyDoctors(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("radius") radius: Int = 10,
        @Query("specialty") specialty: String? = null,
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<Doctor>>>
    
    @GET(ApiConstants.Doctor.FEATURED)
    suspend fun getFeaturedDoctors(
        @Query("limit") limit: Int = 10
    ): Response<ApiResponse<List<Doctor>>>
    
    @GET(ApiConstants.Doctor.FAVORITES)
    suspend fun getFavoriteDoctors(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): Response<ApiResponse<List<Doctor>>>
    
    @POST(ApiConstants.Doctor.ADD_FAVORITE)
    suspend fun addToFavorites(
        @Path("doctorId") doctorId: String
    ): Response<ApiResponse<Unit>>
    
    @DELETE(ApiConstants.Doctor.REMOVE_FAVORITE)
    suspend fun removeFromFavorites(
        @Path("doctorId") doctorId: String
    ): Response<ApiResponse<Unit>>
}