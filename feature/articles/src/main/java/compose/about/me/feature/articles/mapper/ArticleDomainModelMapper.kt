package compose.about.me.feature.articles.mapper

import compose.about.me.domain.articles.model.ArticleDomainModel
import compose.about.me.feature.articles.model.ArticleModel

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
