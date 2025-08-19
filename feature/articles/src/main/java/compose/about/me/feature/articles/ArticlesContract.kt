package compose.about.me.feature.articles

import compose.about.me.common.result.ProjectException
import compose.about.me.design.system.base.UnidirectionalViewModel
import compose.about.me.feature.articles.model.ArticleModel

internal interface ArticlesContract :
    UnidirectionalViewModel<ArticlesContract.Event, ArticlesContract.State> {

    data class State(
        val articles: List<ArticleModel>? = null,
        val errorException: ProjectException? = null,
        val loading: Boolean = false,
        val loadingMore: Boolean = false
    )

    sealed class Event {
        data object OnRefresh : Event()
        data object OnGetData : Event()
    }
}
