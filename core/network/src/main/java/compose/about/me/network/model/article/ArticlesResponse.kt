package compose.about.me.network.model.article

import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    val articles: List<ArticleResponse>? = null
)
