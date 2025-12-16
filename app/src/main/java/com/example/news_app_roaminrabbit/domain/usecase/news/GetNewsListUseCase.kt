package com.example.news_app_roaminrabbit.domain.usecase.news

import com.example.news_app_roaminrabbit.domain.model.NewsItem
import com.example.news_app_roaminrabbit.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNewsListUseCase(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(): Flow<Result<List<NewsItem>>> {
        return newsRepository.getNewsList()
    }
}