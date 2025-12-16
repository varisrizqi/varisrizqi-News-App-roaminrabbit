package com.example.news_app_roaminrabbit.ui.feature.main.profile

data class ProfileUiState(
    val username: String = "",
    val isLoading: Boolean = true
)

sealed interface ProfileUiEvent {
    data object Logout : ProfileUiEvent
}
