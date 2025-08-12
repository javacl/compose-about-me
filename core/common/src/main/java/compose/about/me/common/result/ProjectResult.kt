package compose.about.me.common.result

sealed interface ProjectResult<out T> {
    data class Success<T>(val data: T) : ProjectResult<T>
    data class Error(val exception: ProjectException) : ProjectResult<Nothing>
}
