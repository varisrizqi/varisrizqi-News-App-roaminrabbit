package com.example.news_app_roaminrabbit.ui.feature.main.news

import com.example.news_app_roaminrabbit.domain.model.NewsItem

data class NewsUiState(
    val isLoading: Boolean = false,
    val news: List<NewsItem> = emptyList(),
    val errorMessage: String? = null
)

sealed interface NewsUiEvent {
    data object LoadNews : NewsUiEvent
    data class DeleteNews(val newsId: String) : NewsUiEvent
}

