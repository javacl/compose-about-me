package compose.about.me.core.util.api

import compose.about.me.core.util.Exceptions
import compose.about.me.core.util.model.ApiResult
import compose.about.me.core.util.model.AppError
import org.json.JSONObject

/**
 * Wrap a suspending API [call] in try/catch. In case an exception is thrown, a [ApiResult.Error] is
 * created based on the [errorMessage].
 */
suspend fun <T : Any> safeApiCall(
    call: suspend () -> ApiResult<T>,
    errorMessage: String
): ApiResult<T> {
    return try {
        call()
    } catch (e: Exception) {
        // An exception was thrown when calling the API so we're converting this to an IOException
        ApiResult.Error(Exceptions.IOException(errorMessage, e))
    }
}

fun errorParser(errorBody: String?): AppError {

    return if (errorBody != null) {

        val errorBodyObject = JSONObject(errorBody)

        val status = errorBodyObject.getString("status")
        val message = errorBodyObject.getString("message").toString()

        AppError(status = status, message = message)

    } else {
        AppError()
    }
}
