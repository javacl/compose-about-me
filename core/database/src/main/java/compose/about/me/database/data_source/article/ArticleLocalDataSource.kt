package compose.about.me.database.data_source.article

import compose.about.me.database.model.article.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface ArticleLocalDataSource {
    fun getArticles(): Flow<List<ArticleEntity>>
    fun getArticle(id: Int): Flow<ArticleEntity?>
    suspend fun insertOrReplaceArticles(
        clear: Boolean,
        articles: List<ArticleEntity>
    )
}
