package com.example.news_app_roaminrabbit.domain.usecase.auth

import com.example.news_app_roaminrabbit.domain.model.User
import com.example.news_app_roaminrabbit.domain.repository.AuthRepository

class LoginUseCase(
    private val authRepository: AuthRepository
) {

    suspend operator fun invoke(
        username: String,
        password: String
    ): User {
        require(username.isNotBlank()) { "Username cannot be empty" }
        require(password.isNotBlank()) { "Password cannot be empty" }

        return authRepository.login(username, password)
    }
}