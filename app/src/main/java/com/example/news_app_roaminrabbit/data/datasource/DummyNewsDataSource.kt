package com.example.news_app_roaminrabbit.data.datasource

import com.example.news_app_roaminrabbit.data.dummy.DummyNewsProvider
import com.example.news_app_roaminrabbit.domain.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class DummyNewsDataSource {

    private val _newsFlow = MutableStateFlow(
        DummyNewsProvider.initialNews
    )

    val newsFlow: StateFlow<List<News>> = _newsFlow

    fun deleteNews(newsId: String) {
        _newsFlow.update { currentList ->
            currentList.filterNot { it.id == newsId }
        }
    }
}