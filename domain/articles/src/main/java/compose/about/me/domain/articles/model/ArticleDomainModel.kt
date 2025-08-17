package compose.about.me.domain.articles.model

data class ArticleDomainModel(
    val id: Int,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
