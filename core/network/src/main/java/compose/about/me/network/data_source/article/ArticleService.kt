package compose.about.me.network.data_source.article

import compose.about.me.network.model.article.ArticlesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ArticleService {

    @GET("everything")
    suspend fun getArticles(
        @Query(value = "apiKey", encoded = true) apiKey: String,
        @Query(value = "domains", encoded = true) domains: String,
        @Query(value = "page", encoded = true) page: Int
    ): Response<ArticlesResponse>
}
