package com.example.news_app_roaminrabbit.ui.feature.news

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.news_app_roaminrabbit.domain.model.NewsItem
import com.example.news_app_roaminrabbit.ui.theme.NewsApproaminrabbitTheme

@Composable
fun NewsScreen(
    viewModel: NewsViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    NewsScreenContent(
        state = state,
        onEvent = viewModel::onEvent)
}

@Composable
private fun NewsScreenContent(
    state: NewsUiState,
    onEvent: (NewsUiEvent) -> Unit = {},
) {
    when {
        state.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        state.errorMessage != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(state.errorMessage)
            }
        }

        else -> {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    items = state.news,
                    key = { it.id }
                ) { news ->
                    NewsItemCard(
                        news = news,
                        onDeleteClick = {
                            onEvent(NewsUiEvent.DeleteNews(news.id))
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun NewsItemCard(
    news: NewsItem,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = news.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = news.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            IconButton(onClick = onDeleteClick) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete"
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsApproaminrabbitTheme {
        NewsScreenContent(
            state = NewsUiState(
                news = listOf(
                    NewsItem(
                        id = "1",
                        title = "Breaking News",
                        description = "This is a dummy news description"
                    ),
                    NewsItem(
                        id = "2",
                        title = "Tech Update",
                        description = "Latest update from tech world"
                    )
                )
            ),
        )
    }
}


