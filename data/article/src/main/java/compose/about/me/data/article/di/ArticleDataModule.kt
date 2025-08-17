package compose.about.me.data.article.di

import compose.about.me.data.article.repository.ArticleRepository
import compose.about.me.data.article.repository.ArticleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface ArticleDataModule {

    @Binds
    fun bindArticleRepository(
        articleRepositoryImpl: ArticleRepositoryImpl
    ): ArticleRepository
}
