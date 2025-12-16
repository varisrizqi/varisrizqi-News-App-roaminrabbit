package com.example.news_app_roaminrabbit.ui.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_roaminrabbit.domain.usecase.auth.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginState())
    val uiState: StateFlow<LoginState> = _uiState.asStateFlow()

    fun onEvent(event: LoginUiEvent) {
        when (event) {
            is LoginUiEvent.OnUsernameChange -> {
                _uiState.value = _uiState.value.copy(username = event.value)
            }
            is LoginUiEvent.OnPasswordChange -> {
                _uiState.value = _uiState.value.copy(password = event.value)
            }
            LoginUiEvent.OnTogglePasswordVisibility ->
                _uiState.value = _uiState.value.copy(
                    isPasswordVisible = !_uiState.value.isPasswordVisible
                )
            LoginUiEvent.OnLoginClick -> login()
        }
    }

    private fun login() {
        viewModelScope.launch {
            val state = _uiState.value

            if (state.username.isBlank() || state.password.isBlank()) {
                _uiState.value = state.copy(
                    errorMessage = "Username dan password wajib diisi"
                )
                return@launch
            }

            _uiState.value = _uiState.value.copy(isLoading = true)

            delay(800)

            loginUseCase.invoke(
                username = state.username,
                password = state.password
            )

            _uiState.value = _uiState.value.copy(
                isLoading = false,
                isLoginSuccess = true
            )
        }
    }
}
