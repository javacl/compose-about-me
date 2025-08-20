package compose.about.me.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import compose.about.me.common.model.ProjectThemeType
import compose.about.me.design.system.R
import compose.about.me.design.system.base.use
import compose.about.me.feature.profile.model.ThemeModel

@Composable
internal fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val (state, event) = use(viewModel = viewModel)

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfileItem()

        ThemesItem(
            theme = state.theme,
            onThemeClick = { theme -> event(ProfileContract.Event.OnSaveTheme(theme)) }
        )
    }
}

@Composable
private fun ProfileItem() {
    Image(
        painter = painterResource(R.drawable.img_profile),
        contentDescription = null,
        modifier = Modifier
            .size(120.dp)
            .clip(CircleShape)
    )

    Text(
        modifier = Modifier.padding(top = 8.dp),
        text = stringResource(R.string.label_my_name),
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center
    )

    Text(
        modifier = Modifier.padding(top = 8.dp),
        text = stringResource(R.string.txt_about_me),
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
        textAlign = TextAlign.Center
    )

    Spacer(modifier = Modifier.height(32.dp))

    SocialItem(
        painter = painterResource(R.drawable.img_linkedin_logo),
        onClick = {}
    )

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        SocialItem(
            painter = painterResource(R.drawable.img_github_logo),
            onClick = {}
        )

        Spacer(modifier = Modifier.width(80.dp))

        SocialItem(
            painter = painterResource(R.drawable.img_gitlab_logo),
            onClick = {}
        )
    }

    SocialItem(
        painter = painterResource(R.drawable.img_telegram_logo),
        onClick = {}
    )
}

@Composable
private fun SocialItem(
    painter: Painter,
    onClick: () -> Unit
) = Image(
    modifier = Modifier
        .size(48.dp)
        .clip(CircleShape)
        .clickable(onClick = onClick),
    painter = painter,
    contentDescription = null
)

@Composable
private fun ThemesItem(
    theme: ProjectThemeType?,
    onThemeClick: (ProjectThemeType) -> Unit
) {
    val themes = listOf(
        ThemeModel(
            text = stringResource(R.string.label_default),
            theme = ProjectThemeType.Default
        ),
        ThemeModel(
            text = stringResource(R.string.label_light),
            theme = ProjectThemeType.Light
        ),
        ThemeModel(
            text = stringResource(R.string.label_dark),
            theme = ProjectThemeType.Dark
        )
    )

    Text(
        modifier = Modifier.padding(top = 48.dp),
        text = stringResource(R.string.label_application_theme),
        style = MaterialTheme.typography.titleSmall,
        color = MaterialTheme.colorScheme.onSurface
    )

    Row(
        modifier = Modifier
            .padding(top = 8.dp)
            .wrapContentSize()
            .clip(MaterialTheme.shapes.large)
            .background(MaterialTheme.colorScheme.surfaceContainerLow)
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        themes.forEach { item ->
            ThemeItem(
                item = item,
                selected = item.theme == theme,
                onClick = { onThemeClick(item.theme) }
            )
        }
    }
}

@Composable
private fun ThemeItem(
    item: ThemeModel,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .width(80.dp)
            .height(32.dp)
            .clip(MaterialTheme.shapes.large)
            .clickable(onClick = onClick)
            .background(if (selected) MaterialTheme.colorScheme.surfaceContainer else Color.Unspecified),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = item.text,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onSurface,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}
