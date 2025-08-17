package compose.about.me.database.data_source.article

import androidx.room.withTransaction
import compose.about.me.database.ProjectDatabase
import compose.about.me.database.model.article.ArticleEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ArticleLocalDataSourceImpl @Inject constructor(
    private val database: ProjectDatabase
) : ArticleLocalDataSource {

    private val articleDao = database.articleDao()

    override fun getArticles(): Flow<List<ArticleEntity>> = articleDao.getArticles()

    override fun getArticle(id: Int): Flow<ArticleEntity?> = articleDao.getArticle(id)

    override suspend fun insertOrReplaceArticles(
        clear: Boolean,
        articles: List<ArticleEntity>
    ) {
        database.withTransaction {
            if (clear) {
                articleDao.clearArticles()
            }
            articleDao.insertOrReplaceArticles(articles)
        }
    }
}
