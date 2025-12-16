package com.example.news_app_roaminrabbit.ui.feature.login


data class LoginState(
    val username: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val errorMessage: String? = null,
    val isPasswordVisible: Boolean = false
)

sealed class LoginUiEvent {
    data class OnUsernameChange(val value: String) : LoginUiEvent()
    data class OnPasswordChange(val value: String) : LoginUiEvent()
    object OnTogglePasswordVisibility : LoginUiEvent()
    object OnLoginClick : LoginUiEvent()
}