package compose.about.me.design.system.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import compose.about.me.common.result.ProjectException
import compose.about.me.design.system.R
import compose.about.me.design.system.utils.error.toError

@Composable
fun ProjectErrorView(
    errorException: ProjectException?,
    onRetry: () -> Unit
) {
    if (errorException == null) return
    val error = errorException.toError() ?: return
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.errorContainer),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            text = error.message,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onErrorContainer
        )

        Text(
            modifier = Modifier
                .wrapContentSize()
                .clickable(onClick = onRetry)
                .padding(16.dp),
            text = stringResource(R.string.label_retry),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}
