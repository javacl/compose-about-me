package compose.about.me.core.util.navigation

import compose.about.me.R

sealed class NavigationRoutes(
    val route: String,
    val icon: Int = 0,
    val title: Int = 0
) {
    object Splash : NavigationRoutes("splash")
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

    object AboutMe : NavigationRoutes("about_me")
}
