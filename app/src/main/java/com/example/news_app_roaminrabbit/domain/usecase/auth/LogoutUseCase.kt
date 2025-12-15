package com.example.news_app_roaminrabbit.domain.usecase.auth

import com.example.news_app_roaminrabbit.domain.repository.AuthRepository

class LogoutUseCase(
    private val authRepository: AuthRepository
) {

    suspend fun invoke() {
        authRepository.logout()
    }
}