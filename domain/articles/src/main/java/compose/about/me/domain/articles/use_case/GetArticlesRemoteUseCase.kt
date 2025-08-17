package compose.about.me.domain.articles.use_case

import compose.about.me.data.article.repository.ArticleRepository
import javax.inject.Inject

class GetArticlesRemoteUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    operator fun invoke(page: Int) = articleRepository.getArticlesRemote(page = page)
}
