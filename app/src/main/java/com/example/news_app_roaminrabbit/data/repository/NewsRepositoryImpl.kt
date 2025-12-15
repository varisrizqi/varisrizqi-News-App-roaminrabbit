package com.example.news_app_roaminrabbit.data.repository

import com.example.news_app_roaminrabbit.data.datasource.DummyNewsDataSource
import com.example.news_app_roaminrabbit.domain.model.News
import com.example.news_app_roaminrabbit.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val dummyNewsDataSource: DummyNewsDataSource
) : NewsRepository {

    override fun getNewsList(): Flow<List<News>> {
        return dummyNewsDataSource.newsFlow
    }

    override suspend fun deleteNews(newsId: String) {
        dummyNewsDataSource.deleteNews(newsId)
    }
}