package compose.about.me.design.system.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.StateFlow

data class StateDispatch<EVENT, STATE>(
    val state: STATE,
    val dispatch: (EVENT) -> Unit,
)

@Composable
inline fun <reified EVENT, STATE> use(
    viewModel: UnidirectionalViewModel<EVENT, STATE>,
): StateDispatch<EVENT, STATE> {
    val state by viewModel.state.collectAsState()

    val dispatch: (EVENT) -> Unit = { event ->
        viewModel.event(event)
    }
    return StateDispatch(
        state = state,
        dispatch = dispatch,
    )
}

interface UnidirectionalViewModel<EVENT, STATE> {
    val state: StateFlow<STATE>
    fun event(event: EVENT)
}
