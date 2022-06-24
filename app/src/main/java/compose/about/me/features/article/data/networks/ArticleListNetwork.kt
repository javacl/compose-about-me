package compose.about.me.features.article.data.networks

import androidx.annotation.Keep
import compose.about.me.features.article.data.entities.ArticleEntity

@Keep
data class ArticleListNetwork(
    val articles: List<ArticleEntity> = listOf()
)
