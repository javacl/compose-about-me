package compose.about.me.database

import androidx.room.Database
import androidx.room.RoomDatabase
import compose.about.me.database.data_source.article.ArticleDao
import compose.about.me.database.model.article.ArticleEntity

@Database(
    entities = [
        // Article
        ArticleEntity::class
    ],
    version = 1,
    exportSchema = false,
)
internal abstract class ProjectDatabase : RoomDatabase() {
    internal abstract fun articleDao(): ArticleDao
}
