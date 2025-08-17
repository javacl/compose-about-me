package compose.about.me.data.article.mapper

import compose.about.me.database.model.article.ArticleEntity
import compose.about.me.network.model.article.ArticleResponse

internal fun ArticleResponse.toArticleEntity() = ArticleEntity(
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)
