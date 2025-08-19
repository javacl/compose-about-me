package compose.about.me.network.data_source.article

import compose.about.me.common.result.ProjectResult
import compose.about.me.network.model.article.ArticlesResponse
import compose.about.me.network.utils.NetworkConnectivity
import compose.about.me.network.utils.checkNetworkResult
import kotlinx.coroutines.flow.Flow
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class ArticleRemoteDataSourceImpl @Inject constructor(
    retrofitBuilder: Retrofit.Builder,
    private val networkConnectivity: NetworkConnectivity
) : ArticleRemoteDataSource {

    private val service = retrofitBuilder
        .baseUrl("https://newsapi.org/v2/")
        .build()
        .create(ArticleService::class.java)

    override fun getArticles(
        page: Int
    ): Flow<ProjectResult<ArticlesResponse>> = checkNetworkResult(
        call = {
            service.getArticles(
                apiKey = "10307e6f365542929dd5d0a9ed2395bb",
                q = "apple",
                page = page
            )
        },
        networkConnectivity = networkConnectivity,
        errorMessage = "Error get articles"
    )
}
