package compose.about.me.data.article.model

data class ArticleDataModel(
    val id: Int,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
)
