package com.medinova.app.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@JsonClass(generateAdapter = true)
@Entity(tableName = "payments")
data class Payment(
    @PrimaryKey
    @Json(name = "payment_id")
    val paymentId: String,
    
    @Json(name = "appointment_id")
    val appointmentId: String,
    
    @Json(name = "user_id")
    val userId: String,
    
    @Json(name = "doctor_id")
    val doctorId: String,
    
    @Json(name = "amount")
    val amount: Double,
    
    @Json(name = "currency")
    val currency: String = "USD",
    
    @Json(name = "payment_method")
    val paymentMethod: String,
    
    @Json(name = "payment_status")
    val paymentStatus: String,
    
    @Json(name = "stripe_payment_intent_id")
    val stripePaymentIntentId: String? = null,
    
    @Json(name = "stripe_charge_id")
    val stripeChargeId: String? = null,
    
    @Json(name = "transaction_id")
    val transactionId: String? = null,
    
    @Json(name = "gateway_response")
    val gatewayResponse: String? = null,
    
    @Json(name = "platform_fee")
    val platformFee: Double = 0.0,
    
    @Json(name = "doctor_earnings")
    val doctorEarnings: Double,
    
    @Json(name = "discount_amount")
    val discountAmount: Double? = null,
    
    @Json(name = "coupon_code")
    val couponCode: String? = null,
    
    @Json(name = "refund_amount")
    val refundAmount: Double? = null,
    
    @Json(name = "refund_reason")
    val refundReason: String? = null,
    
    @Json(name = "created_at")
    val createdAt: String,
    
    @Json(name = "updated_at")
    val updatedAt: String? = null,
    
    @Json(name = "refunded_at")
    val refundedAt: String? = null
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class PaymentMethod(
    @Json(name = "id")
    val id: String,
    
    @Json(name = "type")
    val type: String, // "card", "wallet", "bank_transfer"
    
    @Json(name = "card_last_four")
    val cardLastFour: String? = null,
    
    @Json(name = "card_brand")
    val cardBrand: String? = null,
    
    @Json(name = "card_exp_month")
    val cardExpMonth: Int? = null,
    
    @Json(name = "card_exp_year")
    val cardExpYear: Int? = null,
    
    @Json(name = "is_default")
    val isDefault: Boolean = false,
    
    @Json(name = "created_at")
    val createdAt: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class PaymentIntent(
    @Json(name = "payment_intent_id")
    val paymentIntentId: String,
    
    @Json(name = "client_secret")
    val clientSecret: String,
    
    @Json(name = "amount")
    val amount: Double,
    
    @Json(name = "currency")
    val currency: String,
    
    @Json(name = "appointment_id")
    val appointmentId: String
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class CreatePaymentRequest(
    @Json(name = "appointment_id")
    val appointmentId: String,
    
    @Json(name = "amount")
    val amount: Double,
    
    @Json(name = "payment_method_id")
    val paymentMethodId: String? = null,
    
    @Json(name = "coupon_code")
    val couponCode: String? = null,
    
    @Json(name = "save_payment_method")
    val savePaymentMethod: Boolean = false
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class RefundRequest(
    @Json(name = "payment_id")
    val paymentId: String,
    
    @Json(name = "amount")
    val amount: Double? = null, // null for full refund
    
    @Json(name = "reason")
    val reason: String
) : Parcelable

enum class PaymentStatus(val displayName: String) {
    PENDING("Pending"),
    PROCESSING("Processing"),
    COMPLETED("Completed"),
    FAILED("Failed"),
    CANCELLED("Cancelled"),
    REFUNDED("Refunded"),
    PARTIALLY_REFUNDED("Partially Refunded"),
    DISPUTED("Disputed")
}

enum class PaymentMethodType(val displayName: String) {
    CARD("Credit/Debit Card"),
    GOOGLE_PAY("Google Pay"),
    PAYPAL("PayPal"),
    BANK_TRANSFER("Bank Transfer"),
    WALLET("Digital Wallet"),
    CASH("Cash")
}