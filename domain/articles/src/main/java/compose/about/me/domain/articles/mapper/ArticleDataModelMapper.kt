package compose.about.me.domain.articles.mapper

import compose.about.me.data.article.model.ArticleDataModel
import compose.about.me.domain.articles.model.ArticleDomainModel

internal fun ArticleDataModel.toArticleDomainModel() = ArticleDomainModel(
    id = id,
    author = author,
    title = title,
    description = description,
    url = url,
    urlToImage = urlToImage,
    publishedAt = publishedAt,
    content = content
)
