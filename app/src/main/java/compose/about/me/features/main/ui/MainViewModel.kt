package compose.about.me.features.main.ui

import androidx.lifecycle.ViewModel
import compose.about.me.core.preferences.domain.GetIsDarkThemePrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getIsDarkThemePrefs: GetIsDarkThemePrefs
) : ViewModel() {

    val isDarkTheme = getIsDarkThemePrefs()
}
