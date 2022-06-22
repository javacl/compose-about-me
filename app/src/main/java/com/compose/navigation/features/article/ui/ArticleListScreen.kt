package com.compose.navigation.features.article.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
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
            items(items = articleList ?: emptyList()) {
                ArticleListItem(item = it) {
                    mainNavController.navigate(NavigationRoutes.Article.route)
                }
            }

            if (networkViewState.showProgressMore) {
                item {
                    CircularProgressIndicator()
                }
            }
        }
    }
}
