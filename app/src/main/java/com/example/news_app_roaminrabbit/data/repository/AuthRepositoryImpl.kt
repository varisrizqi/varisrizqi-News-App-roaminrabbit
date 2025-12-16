package com.example.news_app_roaminrabbit.data.repository

import com.example.news_app_roaminrabbit.data.datasource.LocalAuthDataSource
import com.example.news_app_roaminrabbit.domain.model.AuthState
import com.example.news_app_roaminrabbit.domain.model.User
import com.example.news_app_roaminrabbit.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AuthRepositoryImpl(
    private val localAuthDataSource: LocalAuthDataSource
) : AuthRepository {

    override fun getAuthState(): Flow<AuthState> = flow {
        localAuthDataSource.getIsLogin().collect { isLogin ->
            if (isLogin) {
                emit(AuthState(isLoggedIn = true))
            } else {
                emit(AuthState(isLoggedIn = false))
            }
        }
    }

    override suspend fun getUserName(): Flow<String> {
        return localAuthDataSource.getUsername()
    }

    override suspend fun login(
        username: String,
        password: String
    ): User {
        localAuthDataSource.setUsername(username)
        localAuthDataSource.setIsLogin(true)
        return User(username)
    }

    override suspend fun logout() {
        localAuthDataSource.clearSession()
    }
}