package compose.about.me.data.article.repository

import compose.about.me.common.result.ProjectResult
import compose.about.me.data.article.model.ArticleDataModel
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun getArticlesLocal(): Flow<List<ArticleDataModel>>

    fun getArticleLocal(id: Int): Flow<ArticleDataModel?>

    fun getArticlesRemote(page: Int): Flow<ProjectResult<Unit?>>
}
