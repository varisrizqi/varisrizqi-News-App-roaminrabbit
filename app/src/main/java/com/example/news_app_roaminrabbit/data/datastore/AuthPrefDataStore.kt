package com.example.news_app_roaminrabbit.data.datastore

import kotlinx.coroutines.flow.Flow

interface AuthPrefDataStore {
    suspend fun setIsLogin(value: Boolean)
    fun getIsLogin(): Flow<Boolean>

    suspend fun setUsername(value: String)
    fun getUsername(): Flow<String>

    suspend fun clearSession()
}