package com.compose.navigation.features.article.data.networks

import com.compose.navigation.features.article.data.entities.ArticleEntity

data class ArticleListNetwork(
    val articles: List<ArticleEntity> = listOf()
)
