package compose.about.me.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import compose.about.me.design.system.R
import compose.about.me.feature.articles.navigation.ARTICLES_ROUTE
import compose.about.me.feature.profile.navigation.PROFILE_ROUTE
import compose.about.me.model.MainBottomNavigationDestination
import compose.about.me.navigation.MainBottomNavigation
import compose.about.me.navigation.MainNavHost

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestinationRoute = backStackEntry?.destination?.route

    val destinations = listOf(
        MainBottomNavigationDestination(
            route = ARTICLES_ROUTE,
            selectedIcon = painterResource(R.drawable.ic_rounded_filled_article_w300),
            unSelectedIcon = painterResource(R.drawable.ic_rounded_outlined_article_w300),
            label = stringResource(R.string.label_articles)
        ),
        MainBottomNavigationDestination(
            route = PROFILE_ROUTE,
            selectedIcon = painterResource(R.drawable.ic_rounded_filled_person_w300),
            unSelectedIcon = painterResource(R.drawable.ic_rounded_outlined_person_w300),
            label = stringResource(R.string.label_profile)
        )
    )

    val bottomNavigationRoutes = destinations.map { it.route }
    val showBottomNavigation = currentDestinationRoute in bottomNavigationRoutes

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        MainNavHost(
            navController = navController
        )

        if (showBottomNavigation) {
            MainBottomNavigation(
                navController = navController,
                destinations = destinations,
                currentDestinationRoute = currentDestinationRoute
            )
        }
    }
}
