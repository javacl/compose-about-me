package compose.about.me.domain.article.use_case

import compose.about.me.data.article.repository.ArticleRepository
import compose.about.me.domain.article.mapper.toArticleDomainModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetArticleLocalUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    operator fun invoke(id: Int) = articleRepository.getArticleLocal(id).map {
        it?.toArticleDomainModel()
    }
}
