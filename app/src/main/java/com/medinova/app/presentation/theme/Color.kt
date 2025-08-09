package com.medinova.app.presentation.theme

import androidx.compose.ui.graphics.Color

// Medical Blue - Primary Color Palette
val MedicalBlue10 = Color(0xFF001D36)
val MedicalBlue20 = Color(0xFF003258)
val MedicalBlue30 = Color(0xFF004881)
val MedicalBlue40 = Color(0xFF0B5FA8)
val MedicalBlue50 = Color(0xFF2E76CF)
val MedicalBlue60 = Color(0xFF4B8EE8)
val MedicalBlue70 = Color(0xFF6FA6FF)
val MedicalBlue80 = Color(0xFF94BFFF)
val MedicalBlue90 = Color(0xFFB9D8FF)
val MedicalBlue95 = Color(0xFFDCECFF)
val MedicalBlue99 = Color(0xFFFCFCFF)

// Medical Green - Secondary Color Palette (Success states)
val MedicalGreen10 = Color(0xFF00210B)
val MedicalGreen20 = Color(0xFF003919)
val MedicalGreen30 = Color(0xFF005227)
val MedicalGreen40 = Color(0xFF006C35)
val MedicalGreen50 = Color(0xFF008744)
val MedicalGreen60 = Color(0xFF1FA354)
val MedicalGreen70 = Color(0xFF3FBF65)
val MedicalGreen80 = Color(0xFF5FDC77)
val MedicalGreen90 = Color(0xFF7FF98A)
val MedicalGreen95 = Color(0xFFBFFDD1)
val MedicalGreen99 = Color(0xFFF0FFF4)

// Medical Teal - Tertiary Color Palette (Accent)
val MedicalTeal10 = Color(0xFF001F24)
val MedicalTeal20 = Color(0xFF003640)
val MedicalTeal30 = Color(0xFF004F58)
val MedicalTeal40 = Color(0xFF006970)
val MedicalTeal50 = Color(0xFF008389)
val MedicalTeal60 = Color(0xFF1F9EA4)
val MedicalTeal70 = Color(0xFF3FB9C0)
val MedicalTeal80 = Color(0xFF5FD5DC)
val MedicalTeal90 = Color(0xFF7FF1F8)
val MedicalTeal95 = Color(0xFFBFF8FC)
val MedicalTeal99 = Color(0xFFF0FEFF)

// Error Red Palette
val ErrorRed10 = Color(0xFF410E0B)
val ErrorRed20 = Color(0xFF601410)
val ErrorRed30 = Color(0xFF8C1D18)
val ErrorRed40 = Color(0xFFB3261E)
val ErrorRed50 = Color(0xFFDC362E)
val ErrorRed60 = Color(0xFFE46962)
val ErrorRed70 = Color(0xFFEC928E)
val ErrorRed80 = Color(0xFFF2B8B5)
val ErrorRed90 = Color(0xFFF9DEDC)
val ErrorRed95 = Color(0xFFFCEEEE)
val ErrorRed99 = Color(0xFFFFFBF9)

// Warning Orange Palette
val WarningOrange10 = Color(0xFF2D1B00)
val WarningOrange20 = Color(0xFF4A2800)
val WarningOrange30 = Color(0xFF683600)
val WarningOrange40 = Color(0xFF8A4500)
val WarningOrange50 = Color(0xFFAE5500)
val WarningOrange60 = Color(0xFFD46600)
val WarningOrange70 = Color(0xFFFC7800)
val WarningOrange80 = Color(0xFFFF8B47)
val WarningOrange90 = Color(0xFFFFB690)
val WarningOrange95 = Color(0xFFFFDCCA)
val WarningOrange99 = Color(0xFFFFFBF8)

// Neutral Grey Palette
val Grey10 = Color(0xFF0F0F0F)
val Grey20 = Color(0xFF1C1C1C)
val Grey30 = Color(0xFF2B2B2B)
val Grey40 = Color(0xFF3C3C3C)
val Grey50 = Color(0xFF4F4F4F)
val Grey60 = Color(0xFF636363)
val Grey70 = Color(0xFF787878)
val Grey80 = Color(0xFF8E8E8E)
val Grey90 = Color(0xFFA5A5A5)
val Grey95 = Color(0xFFBDBDBD)
val Grey99 = Color(0xFFFAFAFA)

// Blue Grey Palette (Surface variants)
val BlueGrey10 = Color(0xFF0F1419)
val BlueGrey20 = Color(0xFF1D2025)
val BlueGrey30 = Color(0xFF2C2F35)
val BlueGrey40 = Color(0xFF3D4046)
val BlueGrey50 = Color(0xFF505259)
val BlueGrey60 = Color(0xFF64656D)
val BlueGrey70 = Color(0xFF797A82)
val BlueGrey80 = Color(0xFF8F9098)
val BlueGrey90 = Color(0xFFA6A6AF)
val BlueGrey95 = Color(0xFFBEBEC7)
val BlueGrey99 = Color(0xFFF9F9FF)

// Common Colors
val Color.White get() = Color(0xFFFFFFFF)
val Color.Black get() = Color(0xFF000000)
val Color.Transparent get() = Color(0x00000000)

// Medical specific semantic colors
val OnlineGreen = MedicalGreen50
val OfflineGrey = Grey60
val UrgentRed = ErrorRed50
val ScheduledBlue = MedicalBlue50
val CompletedGreen = MedicalGreen50
val CancelledRed = ErrorRed50
val PendingOrange = WarningOrange50

// Gradient colors for cards and backgrounds
val GradientStart = MedicalBlue70
val GradientEnd = MedicalTeal70

// Text colors for different states
val TextPrimary = Grey10
val TextSecondary = Grey50
val TextTertiary = Grey70
val TextOnPrimary = Color.White
val TextOnSecondary = Color.White
val TextError = ErrorRed40
val TextSuccess = MedicalGreen40
val TextWarning = WarningOrange40