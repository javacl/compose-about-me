package com.compose.navigation.core.ui.util

import com.compose.navigation.R

sealed class BottomNavigationScreen(
    val route: String,
    val icon: Int,
    val title: String
) {
    object Store : BottomNavigationScreen("store", R.drawable.ic_store, "Store")
    object Cart : BottomNavigationScreen("cart", R.drawable.ic_cart, "Cart")
    object Profile : BottomNavigationScreen("profile", R.drawable.ic_profile, "Profile")
}
