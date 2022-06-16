package com.compose.navigation.features.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.navigation.core.ui.util.Screen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) { SplashScreen(navController = navController) }
        composable(Screen.Home.route) { HomeScreen(mainNavController = navController) }
        composable(Screen.Detail.route) { DetailScreen() }
    }
}
