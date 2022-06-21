package com.compose.navigation.features.article.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.navigation.core.theme.textPrimary
import com.compose.navigation.core.theme.x6_extra_bold
import com.compose.navigation.features.article.data.entities.ArticleEntity

@Composable
fun ArticleListItem(
    item: ArticleEntity,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(
            text = item.title,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            style = MaterialTheme.typography.x6_extra_bold,
            color = MaterialTheme.colors.textPrimary
        )
    }
}
