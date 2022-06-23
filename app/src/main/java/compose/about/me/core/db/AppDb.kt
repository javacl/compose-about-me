package compose.about.me.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import compose.about.me.features.article.data.ArticleDao
import compose.about.me.features.article.data.entities.ArticleEntity

@Database(
    entities = [
        ArticleEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {

    abstract fun articleDao(): ArticleDao
}
