package compose.about.me.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import compose.about.me.feature.article.navigation.articleScreen
import compose.about.me.feature.article.navigation.navigateToArticle
import compose.about.me.feature.articles.navigation.ARTICLES_ROUTE
import compose.about.me.feature.articles.navigation.articlesScreen
import compose.about.me.feature.profile.navigation.profileScreen

@Composable
fun MainNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = ARTICLES_ROUTE,
        modifier = Modifier.fillMaxSize(),
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None }
    ) {
        articlesScreen(
            onArticleClick = navController::navigateToArticle
        )
        articleScreen()
        profileScreen()
    }
}
