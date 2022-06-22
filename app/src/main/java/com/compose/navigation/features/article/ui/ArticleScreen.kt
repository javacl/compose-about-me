package com.compose.navigation.features.article.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.compose.navigation.R
import com.compose.navigation.core.theme.textPrimary
import com.compose.navigation.core.theme.x6_bold
import com.compose.navigation.core.util.collectAsStateLifecycleAware
import com.compose.navigation.features.article.data.entities.ArticleEntity

@Composable
fun ArticleScreen(
    viewModel: ArticleViewModel
) {
    val article by viewModel.article.collectAsStateLifecycleAware(initial = ArticleEntity())
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                modifier = Modifier
                    .size(52.dp)
                    .padding(16.dp),
                onClick = {
                }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_left),
                    contentDescription = null,
                    tint = MaterialTheme.colors.textPrimary,
                )
            }
            article?.let {
                Text(
                    text = it.author,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(end = 16.dp),
                    style = MaterialTheme.typography.x6_bold,
                    color = MaterialTheme.colors.textPrimary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

const val KEY_ARTICLE_ID = "article_id"
