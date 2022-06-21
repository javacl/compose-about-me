package com.compose.navigation.features.article.domain

import com.compose.navigation.features.article.data.ArticleRepository
import javax.inject.Inject

class GetArticleListRemote @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(page: Int) =
        articleRepository.getArticleListRemote(page = page)
}
