package com.example.news_app_roaminrabbit.domain.repository

import com.example.news_app_roaminrabbit.domain.model.News
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNewsList(): Flow<List<News>>

    suspend fun deleteNews(newsId: String)
}