package com.medinova.app

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import dagger.hilt.android.HiltAndroidApp
import com.google.firebase.FirebaseApp
import timber.log.Timber

@HiltAndroidApp
class MedinovaApplication : Application() {

    companion object {
        const val NOTIFICATION_CHANNEL_ID = "medinova_notifications"
        const val APPOINTMENT_CHANNEL_ID = "appointment_notifications"
        const val CHAT_CHANNEL_ID = "chat_notifications"
        const val CALL_CHANNEL_ID = "call_notifications"
    }

    override fun onCreate() {
        super.onCreate()
        
        // Initialize Firebase
        FirebaseApp.initializeApp(this)
        
        // Initialize Timber for logging
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        
        // Create notification channels
        createNotificationChannels()
        
        Timber.d("Medinova Application initialized")
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            // General notifications channel
            val generalChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "General Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "General app notifications"
                enableLights(true)
                enableVibration(true)
            }

            // Appointment notifications channel
            val appointmentChannel = NotificationChannel(
                APPOINTMENT_CHANNEL_ID,
                "Appointment Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Appointment reminders and updates"
                enableLights(true)
                enableVibration(true)
            }

            // Chat notifications channel
            val chatChannel = NotificationChannel(
                CHAT_CHANNEL_ID,
                "Chat Notifications",
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description = "New messages from doctors"
                enableLights(true)
                enableVibration(true)
            }

            // Call notifications channel
            val callChannel = NotificationChannel(
                CALL_CHANNEL_ID,
                "Call Notifications",
                NotificationManager.IMPORTANCE_HIGH
            ).apply {
                description = "Incoming video/voice calls"
                enableLights(true)
                enableVibration(true)
            }

            notificationManager.createNotificationChannels(
                listOf(generalChannel, appointmentChannel, chatChannel, callChannel)
            )
        }
    }
}