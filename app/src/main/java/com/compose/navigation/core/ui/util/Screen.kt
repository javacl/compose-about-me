package com.compose.navigation.core.ui.util

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Store : Screen("store")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
}
