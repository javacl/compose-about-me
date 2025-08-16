package compose.about.me.network.utils

import compose.about.me.network.model.error.ErrorResponse
import compose.about.me.common.result.ProjectException
import compose.about.me.common.result.ProjectResult
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.channelFlow
import kotlinx.serialization.json.Json
import retrofit2.Response

internal fun <T> checkNetworkResult(
    call: suspend () -> Response<T>,
    networkConnectivity: NetworkConnectivity,
    errorMessage: String
) = channelFlow {
    if (networkConnectivity.isConnected()) {
        try {
            val response = call()

            if (response.isSuccessful) {
                trySend(ProjectResult.Success(response.body()!!))
            } else {
                val error = errorParser(response.errorBody()?.string())
                trySend(
                    ProjectResult.Error(
                        ProjectException.DataException(
                            error.message,
                            response.code()
                        )
                    )
                )
            }
        } catch (exception: Exception) {
            trySend(
                ProjectResult.Error(
                    ProjectException.IOException(
                        errorMessage,
                        exception
                    )
                )
            )
        }
    } else {
        trySend(
            ProjectResult.Error(
                ProjectException.NetworkConnectionException()
            )
        )
    }
    awaitClose()
}

private fun errorParser(errorBody: String?): ErrorResponse {
    return if (errorBody != null) {
        Json.decodeFromString<ErrorResponse>(errorBody)
    } else {
        ErrorResponse(null)
    }
}
