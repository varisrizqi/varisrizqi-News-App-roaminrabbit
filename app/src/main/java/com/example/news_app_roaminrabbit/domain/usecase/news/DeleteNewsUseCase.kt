package com.example.news_app_roaminrabbit.domain.usecase.news

import com.example.news_app_roaminrabbit.domain.repository.NewsRepository

class DeleteNewsUseCase(
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(newsId: String) {
        newsRepository.deleteNews(newsId)
    }
}