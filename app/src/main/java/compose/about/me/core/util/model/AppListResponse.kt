package compose.about.me.core.util.model

data class AppListResponse<out T>(
    override val status: String = "",
    val data: List<T> = ArrayList()
) : AppResponse()
