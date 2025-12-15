package com.example.news_app_roaminrabbit.domain.usecase.news

import com.example.news_app_roaminrabbit.domain.repository.NewsRepository

class GetNewsListUseCase(
    private val newsRepository: NewsRepository
) {

     fun invoke() =
        newsRepository.getNewsList()
}