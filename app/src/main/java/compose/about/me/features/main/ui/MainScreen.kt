package compose.about.me.features.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import compose.about.me.R
import compose.about.me.core.theme.divider
import compose.about.me.core.theme.textPrimary
import compose.about.me.core.theme.textPrimaryLight
import compose.about.me.core.theme.x3_bold
import compose.about.me.core.util.navigation.NavigationRoutes
import compose.about.me.features.article.ui.*
import compose.about.me.features.user.ui.UserProfileScreen
import compose.about.me.features.user.ui.UserProfileViewModel

@ExperimentalMaterialApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )
    val scaffoldState = rememberScaffoldState()
    val showBottomBar = remember { mutableStateOf(false) }

    val items = listOf(
        NavigationRoutes.ArticleList,
        NavigationRoutes.UserProfile
    )

    navController.addOnDestinationChangedListener { _, destination, _ ->
        showBottomBar.value = when (destination.route) {
            NavigationRoutes.ArticleList.route, NavigationRoutes.UserProfile.route -> true
            else -> false
        }
    }

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
                if (showBottomBar.value) {
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
                                            popUpTo(screen.route) { inclusive = true }
                                        }
                                    },
                                    selectedContentColor = MaterialTheme.colors.textPrimary,
                                    unselectedContentColor = MaterialTheme.colors.textPrimaryLight
                                )
                            }
                        }
                    }
                }
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = NavigationRoutes.Splash.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(
                    route = NavigationRoutes.Splash.route
                ) {
                    SplashScreen(
                        navController = navController
                    )
                }
                composable(
                    route = NavigationRoutes.ArticleList.route
                ) {
                    val viewModel = hiltViewModel<ArticleListViewModel>(it)
                    ArticleListScreen(
                        viewModel = viewModel,
                        navController = navController
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
    }
}
