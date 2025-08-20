package compose.about.me.feature.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.about.me.design.system.R

@Composable
internal fun ProfileScreen() {

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        ProfileItem()
    }
}

@Composable
private fun ProfileItem() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img_profile),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .size(120.dp)
                .clip(CircleShape)
        )

        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
            text = stringResource(R.string.label_my_name),
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
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
