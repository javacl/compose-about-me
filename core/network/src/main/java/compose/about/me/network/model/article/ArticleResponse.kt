package compose.about.me.network.model.article

import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponse(
    val author: String? = null,
    val title: String? = null,
    val description: String? = null,
    val url: String? = null,
    val urlToImage: String? = null,
    val publishedAt: String? = null,
    val content: String? = null
)
