package compose.about.me.features.user.data.entity

data class UserProfileEntity(
    val image: Int? = null,
    val fullName: Int? = null,
    val socialNetwork: List<UserProfileSocialNetworkEntity> = emptyList()
)
