package com.example.news_app_roaminrabbit.di

import com.example.news_app_roaminrabbit.data.datasource.DummyNewsDataSource
import com.example.news_app_roaminrabbit.data.datasource.LocalAuthDataSource
import com.example.news_app_roaminrabbit.data.datastore.AuthPrefDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun provideLocalAuthDataSource(
        authPrefDataStore: AuthPrefDataStore
    ): LocalAuthDataSource =
        LocalAuthDataSource(authPrefDataStore)

    @Provides
    @Singleton
    fun provideDummyNewsDataSource(): DummyNewsDataSource =
        DummyNewsDataSource()
}