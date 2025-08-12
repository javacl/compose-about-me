package compose.about.me.common.network.dispatcher

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

internal class DispatcherProviderImpl @Inject constructor() : DispatcherProvider {
    override val ui: CoroutineDispatcher = Dispatchers.Main
    override val io: CoroutineDispatcher = Dispatchers.IO
    override val bg: CoroutineDispatcher = Dispatchers.Default
}
