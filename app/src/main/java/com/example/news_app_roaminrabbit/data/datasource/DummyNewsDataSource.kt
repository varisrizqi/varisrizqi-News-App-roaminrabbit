package com.example.news_app_roaminrabbit.data.datasource

import com.example.news_app_roaminrabbit.data.dummy.DummyNewsProvider
import com.example.news_app_roaminrabbit.domain.model.NewsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class DummyNewsDataSource {

    private val _newsFlow = MutableStateFlow(
        DummyNewsProvider.initialNews
    )

    val newsFlow: StateFlow<List<NewsItem>> = _newsFlow

    fun deleteNews(newsId: String) {
        _newsFlow.update { currentList ->
            currentList.filterNot { it.id == newsId }
        }
    }
}