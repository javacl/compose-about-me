package compose.about.me.feature.article.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import compose.about.me.feature.article.ArticleScreen

const val ARTICLE_ROUTE = "article_route"

fun NavController.navigateToArticle(
    navOptions: NavOptions? = null
) = navigate(
    route = ARTICLE_ROUTE,
    navOptions = navOptions
)

fun NavGraphBuilder.articleScreen() {
    composable(route = ARTICLE_ROUTE) {
        ArticleScreen()
    }
}
