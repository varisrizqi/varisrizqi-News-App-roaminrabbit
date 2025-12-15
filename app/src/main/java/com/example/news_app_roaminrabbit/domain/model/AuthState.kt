package com.example.news_app_roaminrabbit.domain.model

data class AuthState(
    val isLoggedIn: Boolean,
    val user: User? = null
)