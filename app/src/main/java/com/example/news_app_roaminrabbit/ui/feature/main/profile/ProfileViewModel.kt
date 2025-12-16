package com.example.news_app_roaminrabbit.ui.feature.main.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_roaminrabbit.domain.usecase.auth.LogoutUseCase
import com.example.news_app_roaminrabbit.domain.usecase.auth.UsernameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val usernameUseCase: UsernameUseCase,
    private val logoutUseCase: LogoutUseCase

) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        observeUsername()
    }

    private fun observeUsername() {
        viewModelScope.launch {
            usernameUseCase.invoke()
                .collect { username ->
                    _uiState.value = ProfileUiState(
                        username = username,
                        isLoading = false
                    )
                }
        }
    }


    fun onEvent(event: ProfileUiEvent) {
        when (event) {
            ProfileUiEvent.Logout -> logout()
        }
    }

    private fun logout() {
        viewModelScope.launch {
            logoutUseCase.invoke()
        }
    }
}
