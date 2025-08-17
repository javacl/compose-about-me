package compose.about.me.design.system.utils

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.filter

@Composable
fun LazyListState.OnBottomReached(
    loading: Boolean,
    onLoadMore: () -> Unit
) {
    val bottomReachNumber = 5
    val loadMore by remember {
        derivedStateOf {
            val totalItemsNumber = layoutInfo.totalItemsCount
            val lastVisibleItemIndex = (layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: 0)
            lastVisibleItemIndex >= ((totalItemsNumber - 1) - bottomReachNumber) && totalItemsNumber > bottomReachNumber
        }
    }

    LaunchedEffect(loadMore) {
        snapshotFlow { loadMore }
            .filter { it && !loading }
            .collect {
                onLoadMore()
            }
    }
}
