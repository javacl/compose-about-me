package compose.about.me.features.article.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import compose.about.me.core.theme.textPrimary
import compose.about.me.core.theme.textPrimaryLight
import compose.about.me.core.theme.x3_bold
import compose.about.me.core.theme.x4_bold
import compose.about.me.features.article.data.entities.ArticleEntity

@Composable
fun ArticleListItem(
    item: ArticleEntity,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClick.invoke()
            }
            .padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context)
                .data(item.urlToImage)
                .crossfade(true)
                .build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(21f / 9f)
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colors.surface),
            contentScale = ContentScale.Crop
        )
        Text(
            modifier = Modifier
                .padding(top = 8.dp),
            text = item.title,
            style = MaterialTheme.typography.x4_bold,
            color = MaterialTheme.colors.textPrimary,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 16.dp),
                text = item.author,
                style = MaterialTheme.typography.x3_bold,
                color = MaterialTheme.colors.textPrimaryLight,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = item.publishedAt,
                style = MaterialTheme.typography.x3_bold,
                color = MaterialTheme.colors.textPrimaryLight,
                maxLines = 1
            )
        }
    }
}
