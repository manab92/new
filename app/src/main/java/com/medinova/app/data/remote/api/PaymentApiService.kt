package com.medinova.app.data.remote.api

import com.medinova.app.data.model.*
import com.medinova.app.data.remote.ApiConstants
import com.medinova.app.data.remote.dto.ApiResponse
import retrofit2.Response
import retrofit2.http.*

interface PaymentApiService {
    
    @POST(ApiConstants.Payment.CREATE_INTENT)
    suspend fun createPaymentIntent(
        @Body request: CreatePaymentRequest
    ): Response<ApiResponse<PaymentIntent>>
    
    @POST(ApiConstants.Payment.CONFIRM)
    suspend fun confirmPayment(
        @Body request: ConfirmPaymentRequest
    ): Response<ApiResponse<Payment>>
    
    @GET(ApiConstants.Payment.HISTORY)
    suspend fun getPaymentHistory(
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20,
        @Query("start_date") startDate: String? = null,
        @Query("end_date") endDate: String? = null
    ): Response<ApiResponse<List<Payment>>>
    
    @GET(ApiConstants.Payment.METHODS)
    suspend fun getPaymentMethods(): Response<ApiResponse<List<PaymentMethod>>>
    
    @POST(ApiConstants.Payment.ADD_METHOD)
    suspend fun addPaymentMethod(
        @Body request: AddPaymentMethodRequest
    ): Response<ApiResponse<PaymentMethod>>
    
    @DELETE(ApiConstants.Payment.DELETE_METHOD)
    suspend fun deletePaymentMethod(
        @Path("methodId") methodId: String
    ): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Payment.SET_DEFAULT)
    suspend fun setDefaultPaymentMethod(
        @Path("methodId") methodId: String
    ): Response<ApiResponse<Unit>>
    
    @POST(ApiConstants.Payment.REFUND)
    suspend fun requestRefund(
        @Path("paymentId") paymentId: String,
        @Body request: RefundRequest
    ): Response<ApiResponse<Payment>>
    
    @GET(ApiConstants.Payment.INVOICE)
    suspend fun getInvoice(
        @Path("paymentId") paymentId: String
    ): Response<ApiResponse<Invoice>>
}

data class ConfirmPaymentRequest(
    val paymentIntentId: String,
    val paymentMethodId: String? = null
)

data class AddPaymentMethodRequest(
    val type: String,
    val token: String,
    val isDefault: Boolean = false
)

data class Invoice(
    val invoiceId: String,
    val paymentId: String,
    val appointmentId: String,
    val amount: Double,
    val currency: String,
    val issueDate: String,
    val dueDate: String,
    val status: String,
    val downloadUrl: String
)