package com.compose.navigation.features.article.data

import com.compose.navigation.core.util.api.ApiUrlHelper
import com.compose.navigation.core.util.api.BaseRemoteDataSource
import com.compose.navigation.core.util.api.safeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRemoteDataSource @Inject constructor(
    private val articleService: ArticleService
) : BaseRemoteDataSource() {

    suspend fun getArticleList(page: Int) = safeApiCall(
        call = { requestGetArticleList(page = page) },
        errorMessage = "Error get article list"
    )

    private suspend fun requestGetArticleList(page: Int) = checkApiResult(
        articleService.getArticleList(
            url = ApiUrlHelper.GET_ARTICLE_LIST_API_URL,
            apiKey = "10307e6f365542929dd5d0a9ed2395bb",
            domains = "wsj.com",
            page = page
        )
    )
}
