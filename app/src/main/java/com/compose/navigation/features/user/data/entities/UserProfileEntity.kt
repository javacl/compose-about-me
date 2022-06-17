package com.compose.navigation.features.user.data.entities

data class UserProfileEntity(
    val image: Int? = null,
    val fullName: Int? = null,
    val socialNetwork: List<UserProfileSocialNetworkEntity>? = null
)
