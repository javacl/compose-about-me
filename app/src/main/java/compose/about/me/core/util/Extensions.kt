package compose.about.me.core.util

import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
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

@Composable
fun rememberLifecycleEvent(lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current): Lifecycle.Event {
    var state by remember { mutableStateOf(Lifecycle.Event.ON_ANY) }
    DisposableEffect(lifecycleOwner) {
        val observer = LifecycleEventObserver { _, event ->
            state = event
        }
        lifecycleOwner.lifecycle.addObserver(observer)
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }
    return state
}

@Composable
fun <LO : LifecycleObserver> LO.ObserveLifecycle(lifecycle: Lifecycle) {
    DisposableEffect(lifecycle) {
        lifecycle.addObserver(this@ObserveLifecycle)
        onDispose {
            lifecycle.removeObserver(this@ObserveLifecycle)
        }
    }
}
