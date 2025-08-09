package com.medinova.app.data.local.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "medinova_preferences")

@Singleton
class PreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    private object PreferencesKeys {
        val ACCESS_TOKEN = stringPreferencesKey("access_token")
        val REFRESH_TOKEN = stringPreferencesKey("refresh_token")
        val USER_ID = stringPreferencesKey("user_id")
        val USER_EMAIL = stringPreferencesKey("user_email")
        val USER_NAME = stringPreferencesKey("user_name")
        val IS_LOGGED_IN = booleanPreferencesKey("is_logged_in")
        val IS_FIRST_LAUNCH = booleanPreferencesKey("is_first_launch")
        val BIOMETRIC_ENABLED = booleanPreferencesKey("biometric_enabled")
        val NOTIFICATION_ENABLED = booleanPreferencesKey("notification_enabled")
        val APPOINTMENT_REMINDERS = booleanPreferencesKey("appointment_reminders")
        val CHAT_NOTIFICATIONS = booleanPreferencesKey("chat_notifications")
        val CALL_NOTIFICATIONS = booleanPreferencesKey("call_notifications")
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val LANGUAGE = stringPreferencesKey("language")
        val FCM_TOKEN = stringPreferencesKey("fcm_token")
    }

    // Authentication
    suspend fun saveAuthTokens(accessToken: String, refreshToken: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.ACCESS_TOKEN] = accessToken
            preferences[PreferencesKeys.REFRESH_TOKEN] = refreshToken
            preferences[PreferencesKeys.IS_LOGGED_IN] = true
        }
    }

    fun getAccessToken(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.ACCESS_TOKEN] ?: ""
    }

    fun getRefreshToken(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.REFRESH_TOKEN] ?: ""
    }

    fun isLoggedIn(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.IS_LOGGED_IN] ?: false
    }

    suspend fun clearAuthTokens() {
        context.dataStore.edit { preferences ->
            preferences.remove(PreferencesKeys.ACCESS_TOKEN)
            preferences.remove(PreferencesKeys.REFRESH_TOKEN)
            preferences[PreferencesKeys.IS_LOGGED_IN] = false
        }
    }

    // User Info
    suspend fun saveUserInfo(userId: String, email: String, name: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.USER_ID] = userId
            preferences[PreferencesKeys.USER_EMAIL] = email
            preferences[PreferencesKeys.USER_NAME] = name
        }
    }

    fun getUserId(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.USER_ID] ?: ""
    }

    fun getUserEmail(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.USER_EMAIL] ?: ""
    }

    fun getUserName(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.USER_NAME] ?: ""
    }

    // App Settings
    fun isFirstLaunch(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.IS_FIRST_LAUNCH] ?: true
    }

    suspend fun setFirstLaunchCompleted() {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.IS_FIRST_LAUNCH] = false
        }
    }

    suspend fun setBiometricEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.BIOMETRIC_ENABLED] = enabled
        }
    }

    fun isBiometricEnabled(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.BIOMETRIC_ENABLED] ?: false
    }

    // Notification Settings
    suspend fun setNotificationEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.NOTIFICATION_ENABLED] = enabled
        }
    }

    fun isNotificationEnabled(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.NOTIFICATION_ENABLED] ?: true
    }

    suspend fun setAppointmentRemindersEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.APPOINTMENT_REMINDERS] = enabled
        }
    }

    fun isAppointmentRemindersEnabled(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.APPOINTMENT_REMINDERS] ?: true
    }

    suspend fun setChatNotificationsEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.CHAT_NOTIFICATIONS] = enabled
        }
    }

    fun isChatNotificationsEnabled(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.CHAT_NOTIFICATIONS] ?: true
    }

    suspend fun setCallNotificationsEnabled(enabled: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.CALL_NOTIFICATIONS] = enabled
        }
    }

    fun isCallNotificationsEnabled(): Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.CALL_NOTIFICATIONS] ?: true
    }

    // Theme and Language
    suspend fun setThemeMode(themeMode: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.THEME_MODE] = themeMode
        }
    }

    fun getThemeMode(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.THEME_MODE] ?: "system"
    }

    suspend fun setLanguage(language: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.LANGUAGE] = language
        }
    }

    fun getLanguage(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.LANGUAGE] ?: "en"
    }

    // FCM Token
    suspend fun saveFcmToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.FCM_TOKEN] = token
        }
    }

    fun getFcmToken(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[PreferencesKeys.FCM_TOKEN] ?: ""
    }

    // Clear all preferences
    suspend fun clearAllPreferences() {
        context.dataStore.edit { preferences ->
            preferences.clear()
        }
    }
}