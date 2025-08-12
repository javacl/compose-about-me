package compose.about.me.common.result

sealed interface ProjectException {

    data class IOException(
        val message: String = "IO Exception",
        val cause: Throwable
    ) : ProjectException

    data class NetworkConnectionException(
        val message: String = "Network Connection Error"
    ) : ProjectException

    data class DataException(
        val message: String?,
        val responseCode: Int
    ) : ProjectException

    data class ValidationException<T : Any>(
        val errors: T
    ) : ProjectException
}
