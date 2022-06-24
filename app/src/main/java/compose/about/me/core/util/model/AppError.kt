package compose.about.me.core.util.model

import androidx.annotation.Keep

@Keep
data class AppError(
    val status: String = "",
    val message: String = ""
)
