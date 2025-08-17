package compose.about.me.design.system.utils.error

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import compose.about.me.common.result.ProjectException
import compose.about.me.design.system.R

@Composable
fun ProjectException.toError(): ProjectError? {
    return when (this) {
        is ProjectException.IOException -> {
            ProjectError(
                message = stringResource(R.string.error_server),
                iconResId = null
            )
        }

        is ProjectException.NetworkConnectionException -> {
            ProjectError(
                message = stringResource(R.string.error_connection),
                iconResId = null
            )
        }

        is ProjectException.DataException -> if (this.message.isNullOrEmpty()) {
            ProjectError(
                message = stringResource(R.string.error_general),
                iconResId = null
            )
        } else {
            ProjectError(
                message = this.message.toString(),
                iconResId = null
            )
        }

        is ProjectException.ValidationException<*> -> null
    }
}
