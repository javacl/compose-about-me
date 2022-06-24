package compose.about.me.core.util.model

import androidx.annotation.Keep

@Keep
data class AppListResponse<out T>(
    override val status: String = "",
    val data: List<T> = ArrayList()
) : AppResponse()
