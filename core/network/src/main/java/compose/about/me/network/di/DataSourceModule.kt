package compose.about.me.network.di

import compose.about.me.network.data_source.article.ArticleRemoteDataSource
import compose.about.me.network.data_source.article.ArticleRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface DataSourceModule {

    @Binds
    fun bindArticleRemoteDataSource(
        articleRemoteDataSourceImpl: ArticleRemoteDataSourceImpl
    ): ArticleRemoteDataSource
}
