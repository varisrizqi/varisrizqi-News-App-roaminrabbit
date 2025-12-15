package com.example.news_app_roaminrabbit.domain.usecase.auth

import com.example.news_app_roaminrabbit.domain.repository.AuthRepository

class CheckLoginStatusUseCase(
    private val authRepository: AuthRepository
) {

     fun invoke() = authRepository.getAuthState()
}