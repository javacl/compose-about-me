package compose.about.me.design.system.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProjectHorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
    thickness: Dp = 1.dp
) = HorizontalDivider(
    modifier = modifier,
    color = color,
    thickness = thickness
)

@Composable
fun ProjectHorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
    thickness: Dp = 1.dp,
    spacing: Dp = 0.dp
) = ProjectHorizontalDivider(
    modifier = modifier.padding(start = spacing, end = spacing),
    color = color,
    thickness = thickness
)

@Composable
fun ProjectHorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
    thickness: Dp = 1.dp,
    top: Dp = 0.dp,
    bottom: Dp = 0.dp,
    end: Dp = 0.dp,
    start: Dp = 0.dp
) = ProjectHorizontalDivider(
    modifier = modifier.padding(top = top, bottom = bottom, start = start, end = end),
    color = color,
    thickness = thickness
)

@Composable
fun ProjectHorizontalDivider(
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.outlineVariant,
    thickness: Dp = 1.dp,
    vertical: Dp = 0.dp,
    horizontal: Dp = 0.dp
) = ProjectHorizontalDivider(
    modifier = modifier.padding(
        top = vertical,
        bottom = vertical,
        start = horizontal,
        end = horizontal
    ),
    color = color,
    thickness = thickness
)
