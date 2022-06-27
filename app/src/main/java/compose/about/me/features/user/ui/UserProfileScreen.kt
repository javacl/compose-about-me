package compose.about.me.features.user.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import compose.about.me.R
import compose.about.me.core.util.collectAsStateLifecycleAware
import compose.about.me.core.theme.*
import compose.about.me.features.user.data.entity.UserProfileEntity
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun UserProfileScreen(
    viewModel: UserProfileViewModel,
    bottomSheetState: ModalBottomSheetState
) {
    val userProfile by viewModel.userProfile.collectAsStateLifecycleAware(initial = UserProfileEntity())
    val isDarkTheme by viewModel.isDarkTheme.collectAsStateLifecycleAware(initial = false)
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
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
                    Spacer(modifier = Modifier.height(16.dp))
                }
                IconButton(
                    modifier = Modifier
                        .size(52.dp)
                        .padding(16.dp)
                        .align(Alignment.TopStart),
                    onClick = {
                        viewModel.changeTheme()
                    }
                ) {
                    Icon(
                        painter = painterResource(id = if (isDarkTheme) R.drawable.ic_sun else R.drawable.ic_moon),
                        contentDescription = null,
                        tint = MaterialTheme.colors.textPrimary,
                    )
                }
            }
        }
        items(items = userProfile.socialNetwork) { item ->
            UserProfileSocialNetworkItem(item = item) {
                item.link?.let {
                    uriHandler.openUri(context.getString(it))
                }
            }
            Divider(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                color = MaterialTheme.colors.divider,
                thickness = 1.dp
            )
        }
        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.primary,
                    contentColor = MaterialTheme.colors.onRipple
                ),
                shape = MaterialTheme.shapes.medium,
                onClick = {
                    coroutineScope.launch {
                        bottomSheetState.show()
                    }
                }
            ) {
                Text(
                    text = stringResource(id = R.string.label_about_me),
                    style = MaterialTheme.typography.x3_bold,
                    color = MaterialTheme.colors.textSecondary
                )
            }
        }
    }
}
