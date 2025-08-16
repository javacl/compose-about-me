package compose.about.me.network.model.error

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val message: String? = null
)
