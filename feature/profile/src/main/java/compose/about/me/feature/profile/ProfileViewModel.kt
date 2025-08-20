package compose.about.me.feature.profile

import androidx.lifecycle.viewModelScope
import compose.about.me.common.model.ProjectThemeType
import compose.about.me.common.network.dispatcher.DispatcherProvider
import compose.about.me.design.system.base.BaseViewModel
import compose.about.me.domain.profile.use_case.GetThemePreferencesUseCase
import compose.about.me.domain.profile.use_case.SaveThemePreferencesUseCase
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
internal class ProfileViewModel @Inject constructor(
    dispatcherProvider: DispatcherProvider,
    getThemePreferencesUseCase: GetThemePreferencesUseCase,
    private val saveThemePreferencesUseCase: SaveThemePreferencesUseCase
) : BaseViewModel(dispatcherProvider), ProfileContract {

    private val mutableState = MutableStateFlow(ProfileContract.State())
    override val state: StateFlow<ProfileContract.State> = mutableState.asStateFlow()

    override fun event(event: ProfileContract.Event) = when (event) {
        is ProfileContract.Event.OnSaveTheme -> saveTheme(theme = event.theme)
    }

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

    private fun saveTheme(theme: ProjectThemeType) {
        saveThemePreferencesUseCase(theme)
            .catch {}
            .launchIn(viewModelScope)
    }
}
