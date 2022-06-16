package com.compose.navigation.features.user.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.compose.navigation.core.util.navigation.NavigationRoutes

@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel,
    mainNavController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Button(
            onClick = { mainNavController.navigate(NavigationRoutes.Article.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = "UserProfile",
                style = MaterialTheme.typography.h6
            )
        }
    }
}
