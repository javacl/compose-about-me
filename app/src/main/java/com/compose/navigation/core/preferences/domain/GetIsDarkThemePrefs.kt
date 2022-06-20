package com.compose.navigation.core.preferences.domain

import com.compose.navigation.core.preferences.PreferencesDataStore
import javax.inject.Inject

class GetIsDarkThemePrefs @Inject constructor(
    private val preferencesDataStore: PreferencesDataStore
) {
    operator fun invoke() = preferencesDataStore.getIsDarkTheme
}
