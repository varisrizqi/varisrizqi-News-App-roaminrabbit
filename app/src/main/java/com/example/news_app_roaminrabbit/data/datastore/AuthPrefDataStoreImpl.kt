package com.example.news_app_roaminrabbit.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthPrefDataStoreImpl(
    private val dataStore: DataStore<Preferences>
) : AuthPrefDataStore {

    override suspend fun setIsLogin(value: Boolean) {
        dataStore.edit { pref ->
            pref[AuthPreferenceKeys.IS_LOGIN] = value
        }
    }

    override fun getIsLogin(): Flow<Boolean> {
        return dataStore.data.map { pref ->
            pref[AuthPreferenceKeys.IS_LOGIN] ?: false
        }
    }

    override suspend fun setUsername(value: String) {
        dataStore.edit { pref ->
            pref[AuthPreferenceKeys.USERNAME] = value
        }
    }

    override fun getUsername(): Flow<String> {
        return dataStore.data.map { pref ->
            pref[AuthPreferenceKeys.USERNAME] ?: ""
        }
    }

    override suspend fun clearSession() {
        dataStore.edit { pref ->
            pref.clear()
        }
    }
}