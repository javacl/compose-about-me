package com.compose.navigation.features.article.data

import com.compose.navigation.core.db.AppDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ArticleModule {

    @Singleton
    @Provides
    fun provideArticleService(retrofit: Retrofit): ArticleService {
        return retrofit.create(ArticleService::class.java)
    }

    @Singleton
    @Provides
    fun provideArticleDao(appDb: AppDb): ArticleDao {
        return appDb.articleDao()
    }
}
