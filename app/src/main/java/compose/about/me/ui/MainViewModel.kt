package compose.about.me.ui

import androidx.lifecycle.viewModelScope
import compose.about.me.common.network.dispatcher.DispatcherProvider
import compose.about.me.design.system.base.BaseViewModel
import compose.about.me.domain.main.use_case.GetThemePreferencesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    getThemePreferencesUseCase: GetThemePreferencesUseCase
) : BaseViewModel(dispatcherProvider), MainContract {

    private val mutableState = MutableStateFlow(MainContract.State())
    override val state: StateFlow<MainContract.State> = mutableState.asStateFlow()

    override fun event(event: MainContract.Event) {}

    init {
        getThemePreferencesUseCase()
            .onEach { theme ->
                mutableState.update { state ->
                    state.copy(
                        theme = theme
                    )
                }
            }
            .catch {}
            .launchIn(viewModelScope)
    }
}
