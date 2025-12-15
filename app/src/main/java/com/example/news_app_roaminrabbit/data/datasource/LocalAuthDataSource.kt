package com.example.news_app_roaminrabbit.data.datasource

import com.example.news_app_roaminrabbit.data.datastore.AuthPrefDataStore
import kotlinx.coroutines.flow.Flow

class LocalAuthDataSource(
    private val prefDataStore: AuthPrefDataStore
){
    suspend fun setIsLogin(value: Boolean) = prefDataStore.setIsLogin(value)
    fun getIsLogin(): Flow<Boolean> {
        return prefDataStore.getIsLogin()
    }

    suspend fun setUsername(value: String) = prefDataStore.setUsername(value)
    fun getUsername(): Flow<String> {
        return prefDataStore.getUsername()
    }

    suspend fun clearSession() = prefDataStore.clearSession()


}