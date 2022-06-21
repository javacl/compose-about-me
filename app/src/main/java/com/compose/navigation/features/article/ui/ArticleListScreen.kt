package com.compose.navigation.features.article.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import com.compose.navigation.core.util.OnBottomReached
import com.compose.navigation.core.util.collectAsStateLifecycleAware
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
        state = swipeRefreshState,
        onRefresh = { viewModel.refresh() }
    ) {
        LazyColumn(state = lazyListState) {
            items(items = articleList ?: emptyList()) {
                ArticleListItem(item = it) {
                }
            }

            if (networkViewState.showProgressMore){
                item {
                    CircularProgressIndicator()
                }
            }
        }
    }

    lazyListState.OnBottomReached {
        viewModel.getNextPage()
    }
}
