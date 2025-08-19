package compose.about.me.feature.articles.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import compose.about.me.feature.articles.ArticlesScreen

const val ARTICLES_ROUTE = "articles_route"

fun NavController.navigateToArticles(
    navOptions: NavOptions? = null
) = navigate(
    route = ARTICLES_ROUTE,
    navOptions = navOptions
)

fun NavGraphBuilder.articlesScreen(
    onArticleClick: (id: Int) -> Unit
) {
    composable(route = ARTICLES_ROUTE) {
        ArticlesScreen(
            onArticleClick = onArticleClick
        )
    }
}
