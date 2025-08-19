package compose.about.me.feature.articles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import compose.about.me.design.system.base.use
import compose.about.me.design.system.component.ProjectErrorView
import compose.about.me.design.system.component.ProjectHorizontalDivider
import compose.about.me.design.system.component.ProjectLazyColumnLoadingMore
import compose.about.me.design.system.component.ProjectPullRefresh
import compose.about.me.design.system.component.article.ProjectArticleItem
import compose.about.me.design.system.utils.OnBottomReached

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ArticlesScreen(
    viewModel: ArticlesViewModel = hiltViewModel(),
    onArticleClick: (id: Int) -> Unit
) {
    val (state, event) = use(viewModel = viewModel)

    val lazyListState = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ProjectErrorView(
            errorException = state.errorException,
            onRetry = { event(ArticlesContract.Event.OnGetData) }
        )

        ProjectPullRefresh(
            modifier = Modifier.fillMaxSize(),
            isRefreshing = state.loading,
            onRefresh = { event(ArticlesContract.Event.OnRefresh) }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = lazyListState
            ) {
                state.articles?.let { articles ->
                    itemsIndexed(
                        items = articles
                    ) { index, item ->
                        ProjectArticleItem(
                            urlToImage = item.urlToImage,
                            title = item.title,
                            author = item.author,
                            publishedAt = item.publishedAt,
                            enabled = true,
                            onClick = { onArticleClick(item.id) }
                        )

                        if (index < articles.lastIndex) {
                            ProjectHorizontalDivider(
                                horizontal = 16.dp
                            )
                        }
                    }

                    if (state.loadingMore) {
                        item {
                            ProjectLazyColumnLoadingMore()
                        }
                    }
                }
            }
        }
    }

    lazyListState.OnBottomReached(
        loading = state.loading || state.loadingMore,
        onLoadMore = { event(ArticlesContract.Event.OnGetData) }
    )
}
