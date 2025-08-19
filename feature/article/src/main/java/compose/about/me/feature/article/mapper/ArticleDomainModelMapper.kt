package compose.about.me.feature.article.mapper

import compose.about.me.domain.article.model.ArticleDomainModel
import compose.about.me.feature.article.model.ArticleModel

internal fun ArticleDomainModel.toArticleModel() = ArticleModel(
    id = id,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)
