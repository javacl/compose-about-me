package compose.about.me.features.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import compose.about.me.R
import compose.about.me.core.theme.divider
import compose.about.me.core.theme.textPrimary
import compose.about.me.core.theme.textPrimaryLight
import compose.about.me.core.theme.x3_bold
import compose.about.me.core.util.navigation.NavigationRoutes
import compose.about.me.features.article.ui.ArticleListScreen
import compose.about.me.features.article.ui.ArticleListViewModel
import compose.about.me.features.user.ui.UserProfileScreen
import compose.about.me.features.user.ui.UserProfileViewModel

@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    mainNavController: NavHostController
) {
    val navController = rememberNavController()
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scaffoldState = rememberScaffoldState()

    val items = listOf(
        NavigationRoutes.ArticleList,
        NavigationRoutes.UserProfile
    )

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.txt_about_me),
                    style = MaterialTheme.typography.x3_bold,
                    color = MaterialTheme.colors.textPrimary
                )
            }
        },
        sheetBackgroundColor = MaterialTheme.colors.background,
        scrimColor = MaterialTheme.colors.primary.copy(alpha = 0.2f)
    ) {
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = {
                Column {
                    Divider(
                        color = MaterialTheme.colors.divider,
                        thickness = 1.dp
                    )
                    BottomNavigation(
                        backgroundColor = MaterialTheme.colors.background,
                        elevation = 0.dp
                    ) {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        items.forEach { screen ->
                            BottomNavigationItem(
                                icon = {
                                    Icon(
                                        painter = painterResource(id = screen.icon),
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
                                },
                                selectedContentColor = MaterialTheme.colors.textPrimary,
                                unselectedContentColor = MaterialTheme.colors.textPrimaryLight
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NavigationRoutes.ArticleList.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(
                    route = NavigationRoutes.ArticleList.route
                ) {
                    val viewModel = hiltViewModel<ArticleListViewModel>(it)
                    ArticleListScreen(
                        viewModel = viewModel,
                        mainNavController = mainNavController
                    )
                }
                composable(
                    route = NavigationRoutes.UserProfile.route
                ) {
                    val viewModel = hiltViewModel<UserProfileViewModel>(it)
                    UserProfileScreen(
                        viewModel = viewModel,
                        bottomSheetState = bottomSheetState
                    )
                }
            }
        }
    }
}
