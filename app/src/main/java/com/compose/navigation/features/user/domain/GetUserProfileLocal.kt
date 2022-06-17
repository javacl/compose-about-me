package com.compose.navigation.features.user.domain

import com.compose.navigation.features.user.data.UserRepository
import javax.inject.Inject

class GetUserProfileLocal @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getUserProfileLocal()
}
