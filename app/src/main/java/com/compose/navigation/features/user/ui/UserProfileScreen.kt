package com.compose.navigation.features.user.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.compose.navigation.core.util.rememberFlow
import com.compose.navigation.features.user.data.entities.UserProfileEntity

@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel,
    mainNavController: NavHostController
) {
    val userProfile by rememberFlow(flow = viewModel.userProfile).collectAsState(initial = UserProfileEntity())
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        userProfile.image?.let { painterResource(id = it) }?.let {
            Image(
                painter = it,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
            )
        }
    }
}
