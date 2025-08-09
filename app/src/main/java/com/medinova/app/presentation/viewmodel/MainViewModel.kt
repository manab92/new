package com.medinova.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medinova.app.data.local.preferences.PreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val preferencesManager: PreferencesManager
) : ViewModel() {

    data class MainUiState(
        val isLoading: Boolean = true,
        val isLoggedIn: Boolean = false,
        val isFirstLaunch: Boolean = true
    )

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        initializeApp()
    }

    private fun initializeApp() {
        viewModelScope.launch {
            combine(
                preferencesManager.isLoggedIn(),
                preferencesManager.isFirstLaunch()
            ) { isLoggedIn, isFirstLaunch ->
                MainUiState(
                    isLoading = false,
                    isLoggedIn = isLoggedIn,
                    isFirstLaunch = isFirstLaunch
                )
            }.collect { state ->
                _uiState.value = state
            }
        }
    }
}