package com.medinova.app.data.remote

object ApiConstants {
    
    // Base URLs for different environments
    const val BASE_URL_DEV = "https://api-dev.medinova.com/"
    const val BASE_URL_STAGING = "https://api-staging.medinova.com/"
    const val BASE_URL_PROD = "https://api.medinova.com/"
    
    // Current base URL (change based on build variant)
    const val BASE_URL = BASE_URL_DEV
    
    // API Versioning
    const val API_VERSION = "v1"
    
    // Timeout settings
    const val CONNECT_TIMEOUT = 30L
    const val READ_TIMEOUT = 30L
    const val WRITE_TIMEOUT = 30L
    
    // Auth Service Endpoints
    object Auth {
        const val LOGIN = "${API_VERSION}/auth/login"
        const val REGISTER = "${API_VERSION}/auth/register"
        const val LOGOUT = "${API_VERSION}/auth/logout"
        const val REFRESH_TOKEN = "${API_VERSION}/auth/refresh"
        const val FORGOT_PASSWORD = "${API_VERSION}/auth/forgot-password"
        const val RESET_PASSWORD = "${API_VERSION}/auth/reset-password"
        const val VERIFY_OTP = "${API_VERSION}/auth/verify-otp"
        const val RESEND_OTP = "${API_VERSION}/auth/resend-otp"
        const val SOCIAL_LOGIN = "${API_VERSION}/auth/social-login"
        const val CHANGE_PASSWORD = "${API_VERSION}/auth/change-password"
    }
    
    // User Service Endpoints
    object User {
        const val PROFILE = "${API_VERSION}/user/profile"
        const val UPDATE_PROFILE = "${API_VERSION}/user/profile"
        const val UPLOAD_AVATAR = "${API_VERSION}/user/avatar"
        const val DELETE_ACCOUNT = "${API_VERSION}/user/delete"
        const val MEDICAL_HISTORY = "${API_VERSION}/user/medical-history"
        const val EMERGENCY_CONTACTS = "${API_VERSION}/user/emergency-contacts"
    }
    
    // Doctor Service Endpoints
    object Doctor {
        const val SEARCH = "${API_VERSION}/doctors/search"
        const val DETAILS = "${API_VERSION}/doctors/{doctorId}"
        const val AVAILABILITY = "${API_VERSION}/doctors/{doctorId}/availability"
        const val REVIEWS = "${API_VERSION}/doctors/{doctorId}/reviews"
        const val SPECIALTIES = "${API_VERSION}/doctors/specialties"
        const val NEARBY = "${API_VERSION}/doctors/nearby"
        const val FEATURED = "${API_VERSION}/doctors/featured"
        const val FAVORITES = "${API_VERSION}/doctors/favorites"
        const val ADD_FAVORITE = "${API_VERSION}/doctors/{doctorId}/favorite"
        const val REMOVE_FAVORITE = "${API_VERSION}/doctors/{doctorId}/favorite"
    }
    
    // Appointment Service Endpoints
    object Appointment {
        const val BOOK = "${API_VERSION}/appointments/book"
        const val LIST = "${API_VERSION}/appointments"
        const val DETAILS = "${API_VERSION}/appointments/{appointmentId}"
        const val CANCEL = "${API_VERSION}/appointments/{appointmentId}/cancel"
        const val RESCHEDULE = "${API_VERSION}/appointments/{appointmentId}/reschedule"
        const val COMPLETE = "${API_VERSION}/appointments/{appointmentId}/complete"
        const val HISTORY = "${API_VERSION}/appointments/history"
        const val UPCOMING = "${API_VERSION}/appointments/upcoming"
        const val PAST = "${API_VERSION}/appointments/past"
        const val JOIN_MEETING = "${API_VERSION}/appointments/{appointmentId}/join"
    }
    
    // Communication Service Endpoints
    object Communication {
        const val CHAT_ROOMS = "${API_VERSION}/chat/rooms"
        const val MESSAGES = "${API_VERSION}/chat/rooms/{appointmentId}/messages"
        const val SEND_MESSAGE = "${API_VERSION}/chat/rooms/{appointmentId}/messages"
        const val MARK_READ = "${API_VERSION}/chat/rooms/{appointmentId}/mark-read"
        const val UPLOAD_MEDIA = "${API_VERSION}/chat/upload"
        const val VIDEO_TOKEN = "${API_VERSION}/video/token/{appointmentId}"
        const val VOICE_TOKEN = "${API_VERSION}/voice/token/{appointmentId}"
        const val CALL_STATUS = "${API_VERSION}/calls/{appointmentId}/status"
        const val END_CALL = "${API_VERSION}/calls/{appointmentId}/end"
    }
    
    // Payment Service Endpoints
    object Payment {
        const val CREATE_INTENT = "${API_VERSION}/payments/create-intent"
        const val CONFIRM = "${API_VERSION}/payments/confirm"
        const val HISTORY = "${API_VERSION}/payments/history"
        const val METHODS = "${API_VERSION}/payments/methods"
        const val ADD_METHOD = "${API_VERSION}/payments/methods/add"
        const val DELETE_METHOD = "${API_VERSION}/payments/methods/{methodId}"
        const val SET_DEFAULT = "${API_VERSION}/payments/methods/{methodId}/default"
        const val REFUND = "${API_VERSION}/payments/{paymentId}/refund"
        const val INVOICE = "${API_VERSION}/payments/{paymentId}/invoice"
    }
    
    // Notification Service Endpoints
    object Notification {
        const val REGISTER_DEVICE = "${API_VERSION}/notifications/register-device"
        const val PREFERENCES = "${API_VERSION}/notifications/preferences"
        const val HISTORY = "${API_VERSION}/notifications/history"
        const val MARK_READ = "${API_VERSION}/notifications/{notificationId}/read"
        const val MARK_ALL_READ = "${API_VERSION}/notifications/mark-all-read"
    }
    
    // Media Service Endpoints
    object Media {
        const val UPLOAD = "${API_VERSION}/media/upload"
        const val DOWNLOAD = "${API_VERSION}/media/download/{fileId}"
        const val DELETE = "${API_VERSION}/media/{fileId}"
        const val MEDICAL_RECORDS = "${API_VERSION}/media/medical-records"
        const val PRESCRIPTIONS = "${API_VERSION}/media/prescriptions"
        const val REPORTS = "${API_VERSION}/media/reports"
    }
    
    // Review Service Endpoints
    object Review {
        const val CREATE = "${API_VERSION}/reviews"
        const val UPDATE = "${API_VERSION}/reviews/{reviewId}"
        const val DELETE = "${API_VERSION}/reviews/{reviewId}"
        const val DOCTOR_REVIEWS = "${API_VERSION}/reviews/doctor/{doctorId}"
        const val USER_REVIEWS = "${API_VERSION}/reviews/user"
        const val HELPFUL = "${API_VERSION}/reviews/{reviewId}/helpful"
    }
    
    // WebSocket endpoints
    object WebSocket {
        const val CHAT = "wss://ws.medinova.com/chat"
        const val CALL_SIGNALING = "wss://ws.medinova.com/call-signaling"
        const val APPOINTMENT_UPDATES = "wss://ws.medinova.com/appointments"
    }
    
    // Headers
    object Headers {
        const val AUTHORIZATION = "Authorization"
        const val CONTENT_TYPE = "Content-Type"
        const val ACCEPT = "Accept"
        const val USER_AGENT = "User-Agent"
        const val X_API_KEY = "X-API-Key"
        const val X_CLIENT_VERSION = "X-Client-Version"
        const val X_DEVICE_ID = "X-Device-Id"
        const val X_PLATFORM = "X-Platform"
    }
    
    // Content Types
    object ContentType {
        const val JSON = "application/json"
        const val MULTIPART = "multipart/form-data"
        const val FORM_ENCODED = "application/x-www-form-urlencoded"
    }
    
    // Response Codes
    object ResponseCode {
        const val SUCCESS = 200
        const val CREATED = 201
        const val NO_CONTENT = 204
        const val BAD_REQUEST = 400
        const val UNAUTHORIZED = 401
        const val FORBIDDEN = 403
        const val NOT_FOUND = 404
        const val INTERNAL_SERVER_ERROR = 500
        const val SERVICE_UNAVAILABLE = 503
    }
}