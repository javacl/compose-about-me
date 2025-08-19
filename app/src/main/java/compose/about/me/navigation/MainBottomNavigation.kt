package compose.about.me.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.navOptions
import compose.about.me.design.system.component.ProjectBottomNavigation
import compose.about.me.design.system.component.ProjectBottomNavigationItem
import compose.about.me.feature.articles.navigation.ARTICLES_ROUTE
import compose.about.me.feature.articles.navigation.navigateToArticles
import compose.about.me.feature.profile.navigation.PROFILE_ROUTE
import compose.about.me.feature.profile.navigation.navigateToProfile
import compose.about.me.model.MainBottomNavigationDestination

@Composable
fun MainBottomNavigation(
    navController: NavHostController,
    destinations: List<MainBottomNavigationDestination>,
    currentDestinationRoute: String?
) {
    ProjectBottomNavigation {

        destinations.forEach { destination ->

            ProjectBottomNavigationItem(
                selectedIcon = destination.selectedIcon,
                unSelectedIcon = destination.unSelectedIcon,
                label = destination.label,
                selected = destination.route == currentDestinationRoute,
                onClick = {
                    val navOptions = navOptions {
                        popUpTo(ARTICLES_ROUTE) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                    when (destination.route) {
                        ARTICLES_ROUTE -> navController.navigateToArticles(navOptions)
                        PROFILE_ROUTE -> navController.navigateToProfile(navOptions)
                    }
                }
            )
        }
    }
}
