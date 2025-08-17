package compose.about.me.domain.articles.use_case

import compose.about.me.data.article.repository.ArticleRepository
import compose.about.me.domain.articles.mapper.toArticleDomainModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetArticlesLocalUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    operator fun invoke() = articleRepository.getArticlesLocal().map { list ->
        list.map { it.toArticleDomainModel() }
    }
}
