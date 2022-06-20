package com.compose.navigation.features.main.ui

import androidx.lifecycle.ViewModel
import com.compose.navigation.core.preferences.domain.GetIsDarkThemePrefs
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getIsDarkThemePrefs: GetIsDarkThemePrefs
) : ViewModel() {

    val isDarkTheme = getIsDarkThemePrefs()
}
