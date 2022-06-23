package compose.about.me.features.user.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import compose.about.me.core.preferences.domain.DoUpdateIsDarkThemePrefs
import compose.about.me.core.preferences.domain.GetIsDarkThemePrefs
import compose.about.me.features.user.domain.GetUserProfileLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    getUserProfileLocal: GetUserProfileLocal,
    private val getIsDarkThemePrefs: GetIsDarkThemePrefs,
    private val doUpdateIsDarkThemePrefs: DoUpdateIsDarkThemePrefs
) : ViewModel() {

    val userProfile = getUserProfileLocal()

    val isDarkTheme = getIsDarkThemePrefs()

    fun changeTheme() {
        viewModelScope.launch(Dispatchers.IO) {
            val isDarkTheme = getIsDarkThemePrefs.invoke().first()
            doUpdateIsDarkThemePrefs(!isDarkTheme)
        }
    }
}
