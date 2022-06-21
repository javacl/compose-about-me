package com.compose.navigation.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.compose.navigation.features.article.data.ArticleDao
import com.compose.navigation.features.article.data.entities.ArticleEntity

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
