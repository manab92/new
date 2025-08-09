package com.medinova.app.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.medinova.app.presentation.navigation.MedinovaNavigation
import com.medinova.app.presentation.theme.MedinovaTheme
import com.medinova.app.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        
        enableEdgeToEdge()
        
        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            val uiState by viewModel.uiState.collectAsState()
            
            // Keep splash screen visible while checking auth state
            splashScreen.setKeepOnScreenCondition {
                uiState.isLoading
            }
            
            MedinovaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MedinovaApp(
                        isLoggedIn = uiState.isLoggedIn,
                        isFirstLaunch = uiState.isFirstLaunch
                    )
                }
            }
        }
    }
}

@Composable
fun MedinovaApp(
    isLoggedIn: Boolean,
    isFirstLaunch: Boolean
) {
    val navController = rememberNavController()
    
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        MedinovaNavigation(
            navController = navController,
            startDestination = when {
                isFirstLaunch -> "onboarding"
                !isLoggedIn -> "auth"
                else -> "main"
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}