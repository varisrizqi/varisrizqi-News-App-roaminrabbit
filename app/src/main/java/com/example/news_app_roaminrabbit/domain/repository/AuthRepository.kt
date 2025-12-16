package com.example.news_app_roaminrabbit.domain.repository

import com.example.news_app_roaminrabbit.domain.model.AuthState
import com.example.news_app_roaminrabbit.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    fun getAuthState(): Flow<AuthState>

    suspend fun login(
        username: String,
        password: String
    ): User

    suspend fun logout()
    suspend fun getUserName() : Flow<String>
}