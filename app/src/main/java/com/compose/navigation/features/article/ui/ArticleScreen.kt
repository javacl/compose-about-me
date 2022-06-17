package com.compose.navigation.features.article.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.compose.navigation.core.util.ui.theme.textPrimary
import com.compose.navigation.core.util.ui.theme.x6_extra_bold

@Composable
fun ArticleScreen(
    viewModel: ArticleViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Article",
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.x6_extra_bold,
            color = MaterialTheme.colors.textPrimary
        )
    }
}
