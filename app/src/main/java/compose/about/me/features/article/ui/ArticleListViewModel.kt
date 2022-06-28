package compose.about.me.features.article.ui

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.viewModelScope
import compose.about.me.core.util.viewModel.BaseViewModel
import compose.about.me.features.article.domain.GetArticleListLocal
import compose.about.me.features.article.domain.GetArticleListRemote
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleListViewModel @Inject constructor(
    getArticleListLocal: GetArticleListLocal,
    private val getArticleListRemote: GetArticleListRemote
) : BaseViewModel(), DefaultLifecycleObserver {

    private var currentPage = 1

    val articleList = getArticleListLocal()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            if (currentPage > 1)
                networkMoreLoading(ArticleRequestTag.GetArticleList.name)
            else networkLoading(ArticleRequestTag.GetArticleList.name)
            observeNetworkState(
                getArticleListRemote(page = currentPage),
                ArticleRequestTag.GetArticleList.name
            )
        }
    }

    fun refresh() {
        currentPage = 1
        getData()
    }

    fun getNextPage() {
        currentPage++
        getData()
    }
}
