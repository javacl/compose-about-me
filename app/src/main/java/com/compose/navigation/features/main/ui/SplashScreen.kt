package com.compose.navigation.features.main.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.compose.navigation.core.util.navigation.NavigationRoutes
import com.compose.navigation.core.util.ui.theme.x6_extra_bold
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Splash",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.x6_extra_bold
        )
    }

    LaunchedEffect(coroutineScope) {
        delay(3000)
        navController.navigate(NavigationRoutes.Home.route) {
            popUpTo(NavigationRoutes.Splash.route) { inclusive = true }
        }
    }
}