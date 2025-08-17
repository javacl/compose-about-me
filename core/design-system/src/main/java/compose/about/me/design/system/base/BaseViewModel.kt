package compose.about.me.design.system.base

import androidx.lifecycle.ViewModel
import compose.about.me.common.network.dispatcher.DispatcherProvider
import kotlinx.coroutines.withContext

open class BaseViewModel(
    protected val dispatcherProvider: DispatcherProvider,
) : ViewModel() {

    protected suspend inline fun <T> onUI(crossinline action: suspend () -> T): T {
        return withContext(dispatcherProvider.ui) {
            action()
        }
    }

    protected suspend inline fun <T> onBg(crossinline action: suspend () -> T): T {
        return withContext(dispatcherProvider.bg) {
            action()
        }
    }

    protected suspend inline fun <T> onIO(crossinline action: suspend () -> T): T {
        return withContext(dispatcherProvider.io) {
            action()
        }
    }
}
