package compose.about.me.network.di

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

@Module
@InstallIn(SingletonComponent::class)
internal object RetrofitModule {

    @Provides
    @Reusable
    fun provideRetrofitBuilder(
        okhttpClient: OkHttpClient,
        json: Json
    ): Retrofit.Builder = retrofitBuilder(
        okhttpClient = okhttpClient,
        json = json
    )

    private fun retrofitBuilder(
        okhttpClient: OkHttpClient,
        json: Json
    ): Retrofit.Builder = Retrofit.Builder()
        .client(okhttpClient)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
}
