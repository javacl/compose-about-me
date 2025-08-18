package compose.about.me.design.system.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProjectLazyColumnLoadingMore() = Box(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 32.dp),
    contentAlignment = Alignment.Center
) {
    ProjectCircularProgressIndicator()
}
