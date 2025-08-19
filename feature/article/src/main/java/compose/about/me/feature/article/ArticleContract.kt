package compose.about.me.feature.article

import compose.about.me.design.system.base.UnidirectionalViewModel
import compose.about.me.feature.article.model.ArticleModel

internal interface ArticleContract :
    UnidirectionalViewModel<ArticleContract.Event, ArticleContract.State> {

    data class State(
        val article: ArticleModel? = null
    )

    sealed class Event
}
