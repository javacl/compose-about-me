package compose.about.me.feature.article.navigation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import compose.about.me.feature.article.ArticleScreen

internal const val ID_ARG = "id"

private const val DEFAULT_ARTICLE_ROUTE = "article_route"
const val ARTICLE_ROUTE = "$DEFAULT_ARTICLE_ROUTE/{$ID_ARG}"

internal class ArticleArgs(
    val id: Int
) {
    constructor(savedStateHandle: SavedStateHandle) :
            this(checkNotNull(savedStateHandle.get<Int>(ID_ARG)))
}

fun NavController.navigateToArticle(
    id: Int,
    navOptions: NavOptions? = null
) = navigate(
    route = "$DEFAULT_ARTICLE_ROUTE/$id",
    navOptions = navOptions
)

fun NavGraphBuilder.articleScreen() {
    composable(
        route = ARTICLE_ROUTE,
        arguments = listOf(
            navArgument(ID_ARG) { type = NavType.IntType }
        )
    ) {
        ArticleScreen()
    }
}
