package com.compose.navigation.features.article.domain

import com.compose.navigation.features.article.data.ArticleRepository
import javax.inject.Inject

class GetArticleListLocal @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    operator fun invoke() = articleRepository.getArticleListLocal()
}
