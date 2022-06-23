package com.compose.navigation.features.article.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.compose.navigation.core.theme.divider
import com.compose.navigation.core.util.collectAsStateLifecycleAware
import com.compose.navigation.core.util.navigation.NavigationRoutes
import com.compose.navigation.core.util.viewModel.BaseViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun ArticleListScreen(
    viewModel: ArticleListViewModel,
    mainNavController: NavHostController
) {
    val networkViewState by viewModel.networkViewState.collectAsStateLifecycleAware(initial = BaseViewModel.NetworkViewState())
    val articleList by viewModel.articleList.collectAsStateLifecycleAware(initial = emptyList())

    val swipeRefreshState = rememberSwipeRefreshState(networkViewState.showProgress)
    val lazyListState = rememberLazyListState()

    SwipeRefresh(
        modifier = Modifier.fillMaxSize(),
        state = swipeRefreshState,
        onRefresh = { viewModel.refresh() }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = lazyListState
        ) {
            items(items = articleList ?: emptyList()) { item ->
                ArticleListItem(item = item) {
                    val route = NavigationRoutes.Article.route + "/${item.id}"
                    mainNavController.navigate(route)
                }
                Divider(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                    color = MaterialTheme.colors.divider,
                    thickness = 1.dp
                )
            }
            if (networkViewState.showProgressMore) {
                item {
                    CircularProgressIndicator()
                }
            }
        }
    }
}
