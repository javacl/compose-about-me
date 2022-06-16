package com.compose.navigation.features.main.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.navigation.core.util.navigation.NavigationRoutes
import com.compose.navigation.features.article.ui.ArticleViewModel
import com.compose.navigation.features.article.ui.ArticleScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Splash.route
    ) {
        composable(NavigationRoutes.Splash.route) {
            SplashScreen(
                navController = navController
            )
        }
        composable(NavigationRoutes.Home.route) {
            HomeScreen(
                mainNavController = navController
            )
        }
        composable(NavigationRoutes.Article.route) {
            val viewModel = hiltViewModel<ArticleViewModel>()
            ArticleScreen(
                viewModel = viewModel
            )
        }
    }
}
