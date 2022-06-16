package com.compose.navigation.features.main.ui

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.navigation.core.util.navigation.NavigationRoutes
import com.compose.navigation.features.article.ui.ArticleListScreen
import com.compose.navigation.features.article.ui.ArticleListViewModel
import com.compose.navigation.features.user.ui.UserProfileScreen
import com.compose.navigation.features.user.ui.UserProfileViewModel

@Composable
fun HomeScreen(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    mainNavController: NavHostController
) {
    val navController = rememberNavController()
    DisposableEffect(lifecycleOwner) {
        // Create an observer that triggers our remembered callbacks
        // for sending analytics events
        val observer = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_START) {
                Log.d("ComposeLifecycle", "on start")
            } else if (event == Lifecycle.Event.ON_STOP) {
                Log.d("ComposeLifecycle", "on stop")
            }
        }

        // Add the observer to the lifecycle
        lifecycleOwner.lifecycle.addObserver(observer)

        // When the effect leaves the Composition, remove the observer
        onDispose {
            lifecycleOwner.lifecycle.removeObserver(observer)
        }
    }

    val items = listOf(
        NavigationRoutes.ArticleList,
        NavigationRoutes.UserProfile
    )
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                painterResource(id = screen.icon),
                                contentDescription = stringResource(id = screen.title)
                            )
                        },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // re-selecting the same item
                                launchSingleTop = true
                                // Restore state when re-selecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.ArticleList.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavigationRoutes.ArticleList.route) {
                val viewModel = hiltViewModel<ArticleListViewModel>()
                ArticleListScreen(
                    viewModel = viewModel,
                    mainNavController = mainNavController
                )
            }
            composable(NavigationRoutes.UserProfile.route) {
                val viewModel = hiltViewModel<UserProfileViewModel>()
                UserProfileScreen(
                    viewModel = viewModel,
                    mainNavController = mainNavController
                )
            }
        }
    }
}
