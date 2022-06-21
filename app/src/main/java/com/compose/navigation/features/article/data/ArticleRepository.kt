package com.compose.navigation.features.article.data

import com.compose.navigation.core.util.Exceptions
import com.compose.navigation.core.util.NetworkHandler
import com.compose.navigation.core.util.model.ApiResult
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(
    private val articleLocalDataSource: ArticleLocalDataSource,
    private val articleRemoteDataSource: ArticleRemoteDataSource,
    private val networkHandler: NetworkHandler
) {
    fun getArticleListLocal() = articleLocalDataSource.getArticleList()

    fun getArticleLocal(articleId: Int) = articleLocalDataSource.getArticle(articleId)

    suspend fun getArticleListRemote(page: Int): ApiResult<Unit> {
        return if (networkHandler.hasNetworkConnection()) {
            when (val result = articleRemoteDataSource.getArticleList(page = page)) {
                is ApiResult.Success -> {
                    ApiResult.Success(
                        articleLocalDataSource.insertArticleList(
                            page = page,
                            articleList = result.data.articles
                        )
                    )
                }
                is ApiResult.Error -> ApiResult.Error(result.exception)
            }
        } else ApiResult.Error(Exceptions.NetworkConnectionException())
    }
}
