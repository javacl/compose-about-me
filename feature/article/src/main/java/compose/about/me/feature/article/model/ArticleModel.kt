package compose.about.me.feature.article.model

import androidx.compose.runtime.Immutable

@Immutable
internal data class ArticleModel(
    val id: Int,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
