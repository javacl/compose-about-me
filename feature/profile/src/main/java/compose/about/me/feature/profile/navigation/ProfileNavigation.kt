package compose.about.me.feature.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import compose.about.me.feature.profile.ProfileScreen

const val PROFILE_ROUTE = "profile_route"

fun NavController.navigateToProfile(
    navOptions: NavOptions? = null
) = navigate(
    route = PROFILE_ROUTE,
    navOptions = navOptions
)

fun NavGraphBuilder.profileScreen() {
    composable(route = PROFILE_ROUTE) {
        ProfileScreen()
    }
}
