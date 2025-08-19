package compose.about.me.feature.articles

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun ArticlesScreen(
    viewModel: ArticlesViewModel = hiltViewModel(),
    onArticleClick: (id: Int) -> Unit
) {
}
