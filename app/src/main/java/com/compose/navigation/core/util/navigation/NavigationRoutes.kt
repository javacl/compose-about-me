package com.compose.navigation.core.util.navigation

import com.compose.navigation.R

sealed class NavigationRoutes(
    val route: String,
    val icon: Int = 0,
    val title: Int = 0
) {
    object Splash : NavigationRoutes("splash")
    object Home : NavigationRoutes("home")
    object ArticleList : NavigationRoutes(
        "article_list",
        R.drawable.ic_article,
        R.string.label_article_list
    )

    object Article : NavigationRoutes("article")
    object UserProfile : NavigationRoutes(
        "user",
        R.drawable.ic_user,
        R.string.label_user_profile
    )
}
