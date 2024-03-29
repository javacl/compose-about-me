package compose.about.me.features.article.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import compose.about.me.R
import compose.about.me.core.theme.*
import compose.about.me.core.util.collectAsStateLifecycleAware
import compose.about.me.features.article.data.entities.ArticleEntity

@Composable
fun ArticleScreen(
    viewModel: ArticleViewModel,
    navController: NavHostController
) {
    val context = LocalContext.current
    val article by viewModel.article.collectAsStateLifecycleAware(initial = ArticleEntity())
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                modifier = Modifier
                    .size(52.dp)
                    .padding(16.dp),
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = null,
                    tint = MaterialTheme.colors.textPrimary,
                )
            }
            Text(
                text = stringResource(id = R.string.label_article),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(end = 16.dp),
                style = MaterialTheme.typography.x6_bold,
                color = MaterialTheme.colors.textPrimary
            )
        }
        Divider(
            color = MaterialTheme.colors.divider,
            thickness = 1.dp
        )
        article?.let {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(it.urlToImage)
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
                    text = it.title,
                    style = MaterialTheme.typography.x4_bold,
                    color = MaterialTheme.colors.textPrimary
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
                        text = it.author,
                        style = MaterialTheme.typography.x3_bold,
                        color = MaterialTheme.colors.textPrimaryLight
                    )
                    Text(
                        text = it.publishedAt,
                        style = MaterialTheme.typography.x3_bold,
                        color = MaterialTheme.colors.textPrimaryLight,
                        maxLines = 1
                    )
                }
                Text(
                    modifier = Modifier
                        .padding(
                            top = 16.dp
                        ),
                    text = it.content,
                    style = MaterialTheme.typography.x3_normal,
                    color = MaterialTheme.colors.textPrimary
                )
            }
        }
    }
}

const val KEY_ARTICLE_ID = "article_id"
