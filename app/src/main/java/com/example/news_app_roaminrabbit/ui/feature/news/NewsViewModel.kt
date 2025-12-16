package com.example.news_app_roaminrabbit.ui.feature.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news_app_roaminrabbit.domain.usecase.news.DeleteNewsUseCase
import com.example.news_app_roaminrabbit.domain.usecase.news.GetNewsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val getNewsUseCase: GetNewsListUseCase,
    private val deleteNewsUseCase: DeleteNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NewsUiState(isLoading = true))
    val uiState: StateFlow<NewsUiState> = _uiState.asStateFlow()

    init {
        onEvent(NewsUiEvent.LoadNews)
    }

    fun onEvent(event: NewsUiEvent) {
        when (event) {
            NewsUiEvent.LoadNews -> loadNews()
            is NewsUiEvent.DeleteNews -> deleteNews(event.newsId)
        }
    }

    private fun loadNews() {
        viewModelScope.launch {
            getNewsUseCase()
                .collect { result ->
                    result
                        .onSuccess { news ->
                            _uiState.value = NewsUiState(
                                isLoading = false,
                                news = news
                            )
                        }
                        .onFailure {
                            _uiState.value = NewsUiState(
                                isLoading = false,
                                errorMessage = "Failed to load news"
                            )
                        }
                }
        }
    }

    private fun deleteNews(newsId: String) {
        viewModelScope.launch {
            deleteNewsUseCase(newsId)
        }
    }
}
