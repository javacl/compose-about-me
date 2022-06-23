package compose.about.me.features.article.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import compose.about.me.features.article.domain.GetArticleLocal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getArticleLocal: GetArticleLocal
) : ViewModel() {

    val article = getArticleLocal(savedStateHandle.get<String>(KEY_ARTICLE_ID)?.toInt() ?: 0)
}
