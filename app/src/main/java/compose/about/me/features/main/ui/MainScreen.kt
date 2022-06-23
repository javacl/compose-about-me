package compose.about.me.features.main.ui

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import compose.about.me.core.util.navigation.NavigationRoutes
import compose.about.me.features.article.ui.ArticleScreen
import compose.about.me.features.article.ui.ArticleViewModel
import compose.about.me.features.article.ui.KEY_ARTICLE_ID

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Splash.route
    ) {
        composable(
            route = NavigationRoutes.Splash.route
        ) {
            SplashScreen(
                navController = navController
            )
        }
        composable(
            route = NavigationRoutes.Home.route
        ) {
            HomeScreen(
                mainNavController = navController
            )
        }
        composable(
            route = NavigationRoutes.Article.route + "/{$KEY_ARTICLE_ID}",
            arguments = listOf(navArgument(KEY_ARTICLE_ID) { type = NavType.StringType })
        ) {
            val viewModel = hiltViewModel<ArticleViewModel>(it)
            ArticleScreen(
                viewModel = viewModel,
                mainNavController = navController
            )
        }
    }
}
