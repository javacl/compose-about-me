package compose.about.me.features.article.domain

import compose.about.me.features.article.data.ArticleRepository
import javax.inject.Inject

class GetArticleListRemote @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    suspend operator fun invoke(page: Int) =
        articleRepository.getArticleListRemote(page = page)
}
