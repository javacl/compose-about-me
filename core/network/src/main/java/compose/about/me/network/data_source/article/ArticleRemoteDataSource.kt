package compose.about.me.network.data_source.article

import compose.about.me.common.result.ProjectResult
import compose.about.me.network.model.article.ArticlesResponse
import kotlinx.coroutines.flow.Flow

interface ArticleRemoteDataSource {
    fun getArticles(page: Int): Flow<ProjectResult<ArticlesResponse>>
}
