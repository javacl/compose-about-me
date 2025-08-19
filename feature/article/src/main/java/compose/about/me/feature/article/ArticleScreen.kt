package compose.about.me.feature.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import compose.about.me.design.system.R
import compose.about.me.design.system.base.use
import compose.about.me.design.system.component.ProjectBackToolbar
import compose.about.me.design.system.component.article.ProjectArticleItem

@Composable
internal fun ArticleScreen(
    viewModel: ArticleViewModel = hiltViewModel()
) {
    val (state, _) = use(viewModel = viewModel)

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ProjectBackToolbar(
            text = stringResource(R.string.label_article)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            state.article?.let { item ->
                ProjectArticleItem(
                    urlToImage = item.urlToImage,
                    title = item.title,
                    author = item.author,
                    publishedAt = item.publishedAt,
                    enabled = false,
                    onClick = {}
                )

                Text(
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
                    text = item.content ?: "Without content",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}
