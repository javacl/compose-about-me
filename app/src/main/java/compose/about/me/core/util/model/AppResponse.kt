package compose.about.me.core.util.model

import androidx.annotation.Keep

@Keep
abstract class AppResponse {
    abstract val status: String
}
