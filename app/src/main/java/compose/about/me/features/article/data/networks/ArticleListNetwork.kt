package compose.about.me.features.article.data.networks

import compose.about.me.features.article.data.entities.ArticleEntity

data class ArticleListNetwork(
    val articles: List<ArticleEntity> = listOf()
)
