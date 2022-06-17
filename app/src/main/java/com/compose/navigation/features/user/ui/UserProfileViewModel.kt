package com.compose.navigation.features.user.ui

import androidx.lifecycle.ViewModel
import com.compose.navigation.features.user.domain.GetUserProfileLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserProfileViewModel @Inject constructor(
    getUserProfileLocal: GetUserProfileLocal
) : ViewModel() {

    val userProfile = getUserProfileLocal()
}
