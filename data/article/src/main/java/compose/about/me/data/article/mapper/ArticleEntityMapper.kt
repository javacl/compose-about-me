package compose.about.me.data.article.mapper

import compose.about.me.data.article.model.ArticleDataModel
import compose.about.me.database.model.article.ArticleEntity

internal fun ArticleEntity.toArticleDataModel() = ArticleDataModel(
    id = id,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)
