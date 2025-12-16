package com.example.news_app_roaminrabbit.domain.repository

import com.example.news_app_roaminrabbit.domain.model.NewsItem
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNewsList(): Flow<Result<List<NewsItem>>>
    suspend fun deleteNews(newsId: String)
}