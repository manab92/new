package com.medinova.app.presentation.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = MedicalBlue80,
    onPrimary = MedicalBlue20,
    primaryContainer = MedicalBlue30,
    onPrimaryContainer = MedicalBlue90,
    secondary = MedicalGreen80,
    onSecondary = MedicalGreen20,
    secondaryContainer = MedicalGreen30,
    onSecondaryContainer = MedicalGreen90,
    tertiary = MedicalTeal80,
    onTertiary = MedicalTeal20,
    tertiaryContainer = MedicalTeal30,
    onTertiaryContainer = MedicalTeal90,
    error = ErrorRed80,
    errorContainer = ErrorRed30,
    onError = ErrorRed20,
    onErrorContainer = ErrorRed90,
    background = Grey10,
    onBackground = Grey90,
    surface = Grey10,
    onSurface = Grey90,
    surfaceVariant = BlueGrey30,
    onSurfaceVariant = BlueGrey80,
    outline = BlueGrey60
)

private val LightColorScheme = lightColorScheme(
    primary = MedicalBlue40,
    onPrimary = Color.White,
    primaryContainer = MedicalBlue90,
    onPrimaryContainer = MedicalBlue10,
    secondary = MedicalGreen40,
    onSecondary = Color.White,
    secondaryContainer = MedicalGreen90,
    onSecondaryContainer = MedicalGreen10,
    tertiary = MedicalTeal40,
    onTertiary = Color.White,
    tertiaryContainer = MedicalTeal90,
    onTertiaryContainer = MedicalTeal10,
    error = ErrorRed40,
    errorContainer = ErrorRed90,
    onError = Color.White,
    onErrorContainer = ErrorRed10,
    background = Grey99,
    onBackground = Grey10,
    surface = Grey99,
    onSurface = Grey10,
    surfaceVariant = BlueGrey90,
    onSurfaceVariant = BlueGrey30,
    outline = BlueGrey50
)

@Composable
fun MedinovaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}