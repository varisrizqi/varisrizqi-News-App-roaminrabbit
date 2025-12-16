package com.example.news_app_roaminrabbit.domain.usecase.auth

import com.example.news_app_roaminrabbit.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow

class UsernameUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Flow<String> {
        return authRepository.getUserName()
    }
}