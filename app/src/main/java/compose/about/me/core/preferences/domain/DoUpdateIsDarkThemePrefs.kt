package compose.about.me.core.preferences.domain

import compose.about.me.core.preferences.PreferencesDataStore
import javax.inject.Inject

class DoUpdateIsDarkThemePrefs @Inject constructor(
    private val preferencesDataStore: PreferencesDataStore
) {
    suspend operator fun invoke(value: Boolean) = preferencesDataStore.updateIsDarkTheme(value)
}
