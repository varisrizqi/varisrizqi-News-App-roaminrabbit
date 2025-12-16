package com.example.news_app_roaminrabbit.data.repository

import com.example.news_app_roaminrabbit.data.datasource.DummyNewsDataSource
import com.example.news_app_roaminrabbit.domain.model.NewsItem
import com.example.news_app_roaminrabbit.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

class NewsRepositoryImpl(
    private val dummyNewsDataSource: DummyNewsDataSource
) : NewsRepository {

    override fun getNewsList(): Flow<Result<List<NewsItem>>> {
        return dummyNewsDataSource.newsFlow
            .map { Result.success(it) }
            .catch { emit(Result.failure(it)) }
    }

    override suspend fun deleteNews(newsId: String) {
        dummyNewsDataSource.deleteNews(newsId)
    }
}