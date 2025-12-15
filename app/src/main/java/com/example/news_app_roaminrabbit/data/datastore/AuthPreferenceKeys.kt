package com.example.news_app_roaminrabbit.data.datastore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object AuthPreferenceKeys {

    val IS_LOGIN = booleanPreferencesKey("is_login")
    val USERNAME = stringPreferencesKey("username")
}