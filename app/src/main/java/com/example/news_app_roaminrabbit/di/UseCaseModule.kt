package com.example.news_app_roaminrabbit.di

import com.example.news_app_roaminrabbit.domain.repository.AuthRepository
import com.example.news_app_roaminrabbit.domain.repository.NewsRepository
import com.example.news_app_roaminrabbit.domain.usecase.auth.CheckLoginStatusUseCase
import com.example.news_app_roaminrabbit.domain.usecase.auth.LoginUseCase
import com.example.news_app_roaminrabbit.domain.usecase.auth.LogoutUseCase
import com.example.news_app_roaminrabbit.domain.usecase.auth.UsernameUseCase
import com.example.news_app_roaminrabbit.domain.usecase.news.DeleteNewsUseCase
import com.example.news_app_roaminrabbit.domain.usecase.news.GetNewsListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCheckLoginStatusUseCase(
        authRepository: AuthRepository
    ) = CheckLoginStatusUseCase(authRepository)

    @Provides
    fun provideLoginUseCase(
        authRepository: AuthRepository
    ) = LoginUseCase(authRepository)

    @Provides
    fun provideLogoutUseCase(
        authRepository: AuthRepository
    ) = LogoutUseCase(authRepository)

    @Provides
    fun provideUsernameUseCase(
        authRepository: AuthRepository
    ) = UsernameUseCase(authRepository)

    @Provides
    fun provideGetNewsListUseCase(
        newsRepository: NewsRepository
    ) = GetNewsListUseCase(newsRepository)

    @Provides
    fun provideDeleteNewsUseCase(
        newsRepository: NewsRepository
    ) = DeleteNewsUseCase(newsRepository)
}