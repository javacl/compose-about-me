package compose.about.me.data.article.repository

import compose.about.me.common.result.ProjectResult
import compose.about.me.data.article.mapper.toArticleDataModel
import compose.about.me.data.article.mapper.toArticleEntity
import compose.about.me.data.article.model.ArticleDataModel
import compose.about.me.database.data_source.article.ArticleLocalDataSource
import compose.about.me.network.data_source.article.ArticleRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class ArticleRepositoryImpl @Inject constructor(
    private val articleRemoteDataSource: ArticleRemoteDataSource,
    private val articleLocalDataSource: ArticleLocalDataSource
) : ArticleRepository {

    override fun getArticlesLocal(): Flow<List<ArticleDataModel>> =
        articleLocalDataSource.getArticles().map { list ->
            list.map { it.toArticleDataModel() }
        }

    override fun getArticleLocal(
        id: Int
    ): Flow<ArticleDataModel?> = articleLocalDataSource.getArticle(id).map {
        it?.toArticleDataModel()
    }

    override fun getArticlesRemote(
        page: Int
    ): Flow<ProjectResult<Unit?>> = articleRemoteDataSource.getArticles(
        page = page
    ).map { result ->
        when (result) {
            is ProjectResult.Error -> result
            is ProjectResult.Success -> ProjectResult.Success(
                result.data.articles?.let { articles ->
                    articleLocalDataSource.insertOrReplaceArticles(
                        clear = page == 1,
                        articles = articles.map { it.toArticleEntity() }
                    )
                }

            )
        }
    }
}
