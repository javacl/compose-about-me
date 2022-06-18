package com.compose.navigation.features.user.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.compose.navigation.core.util.collectAsStateLifecycleAware
import com.compose.navigation.core.util.ui.theme.textPrimary
import com.compose.navigation.core.util.ui.theme.x6_bold
import com.compose.navigation.features.user.data.entities.UserProfileEntity

@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel,
    mainNavController: NavHostController
) {
    val userProfile by viewModel.userProfile.collectAsStateLifecycleAware(initial = UserProfileEntity())
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        userProfile.image?.let { painterResource(id = it) }?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = it,
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
            )
        }
        userProfile.fullName?.let {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(id = it),
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = MaterialTheme.typography.x6_bold,
                color = MaterialTheme.colors.textPrimary
            )
        }
        userProfile.socialNetwork?.let {
            LazyColumn {
                items(it) { item ->
                }
            }
        }
    }
}
