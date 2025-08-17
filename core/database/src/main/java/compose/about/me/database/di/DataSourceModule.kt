package compose.about.me.database.di

import compose.about.me.database.data_source.article.ArticleLocalDataSource
import compose.about.me.database.data_source.article.ArticleLocalDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {

    @Binds
    fun bindArticleLocalDataSource(
        articleLocalDataSourceImpl: ArticleLocalDataSourceImpl
    ): ArticleLocalDataSource
}
