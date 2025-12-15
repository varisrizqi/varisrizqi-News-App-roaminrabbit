package com.example.news_app_roaminrabbit.di

import com.example.news_app_roaminrabbit.data.datasource.DummyNewsDataSource
import com.example.news_app_roaminrabbit.data.datasource.LocalAuthDataSource
import com.example.news_app_roaminrabbit.data.repository.AuthRepositoryImpl
import com.example.news_app_roaminrabbit.data.repository.NewsRepositoryImpl
import com.example.news_app_roaminrabbit.domain.repository.AuthRepository
import com.example.news_app_roaminrabbit.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        localAuthDataSource: LocalAuthDataSource
    ): AuthRepository =
        AuthRepositoryImpl(localAuthDataSource)

    @Provides
    @Singleton
    fun provideNewsRepository(
        dummyNewsDataSource: DummyNewsDataSource
    ): NewsRepository =
        NewsRepositoryImpl(dummyNewsDataSource)
}