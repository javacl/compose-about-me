package compose.about.me.feature.article

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun ArticleScreen(
    viewModel: ArticleViewModel = hiltViewModel()
) {
}
