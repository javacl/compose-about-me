package compose.about.me.core.util

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import kotlinx.coroutines.flow.filter

@Composable
fun LazyListState.OnBottomReached(
    onLoadMore: () -> Unit
) {
    val loadMore = remember {
        derivedStateOf {
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0)
            lastVisibleItemIndex == totalItemsNumber - 1 && totalItemsNumber != 0
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore.value }
            .filter { it }
            .collect {
                onLoadMore()
            }
    }
}
