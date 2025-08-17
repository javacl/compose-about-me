package compose.about.me.database.data_source.article

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import compose.about.me.database.model.article.ArticleEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface ArticleDao {

    @Query("SELECT * FROM ArticleEntity")
    fun getArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM ArticleEntity WHERE id = :id")
    fun getArticle(id: Int): Flow<ArticleEntity?>

    @Upsert
    suspend fun insertOrReplaceArticles(articles: List<ArticleEntity>)

    @Query("DELETE FROM ArticleEntity")
    suspend fun clearArticles()
}
