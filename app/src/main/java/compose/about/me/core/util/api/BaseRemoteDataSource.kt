package compose.about.me.core.util.api

import compose.about.me.core.util.Exceptions
import compose.about.me.core.util.model.ApiResult
import retrofit2.Response

open class BaseRemoteDataSource {

    protected fun <T> checkApiResult(response: Response<T>): ApiResult<T> {
        if (response.isSuccessful) {
            val body = response.body()
            if (body != null)
                return ApiResult.Success(body)
        }
        val error = errorParser(response.errorBody()?.string())
        return ApiResult.Error(
            Exceptions.RemoteDataSourceException(
                error.status,
                error.message,
                response.code()
            )
        )
    }
}
