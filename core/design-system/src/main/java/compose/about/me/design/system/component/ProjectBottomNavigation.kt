package compose.about.me.design.system.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProjectBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceContainer,
    shape: Shape = ProjectBottomNavigationDefaults.shape(),
    content: @Composable RowScope.() -> Unit
) = Row(
    modifier
        .fillMaxWidth()
        .clip(shape)
        .background(backgroundColor)
        .selectableGroup(),
    horizontalArrangement = Arrangement.SpaceBetween,
    content = content
)

@Composable
fun RowScope.ProjectBottomNavigationItem(
    selectedIcon: Painter?,
    unSelectedIcon: Painter?,
    label: String?,
    selected: Boolean,
    enabled: Boolean = true,
    iconSize: Dp = 24.dp,
    labelStyle: TextStyle = MaterialTheme.typography.labelSmall,
    selectedContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    unselectedContentColor: Color = MaterialTheme.colorScheme.onSurface,
    selectedIconBackgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    unSelectedIconBackgroundColor: Color = Color.Unspecified,
    contentPadding: PaddingValues = PaddingValues(vertical = 16.dp),
    betweenSpacing: Dp = 4.dp,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = false),
                onClick = onClick,
                enabled = enabled
            )
            .padding(contentPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (selectedIcon == null || unSelectedIcon == null || label == null) return@Column

        Box(
            modifier = Modifier
                .wrapContentSize()
                .clip(MaterialTheme.shapes.extraLarge)
                .background(if (selected) selectedIconBackgroundColor else unSelectedIconBackgroundColor)
                .padding(vertical = 4.dp, horizontal = 16.dp)
        ) {
            Icon(
                modifier = Modifier.size(iconSize),
                painter = if (selected) selectedIcon else unSelectedIcon,
                contentDescription = label,
                tint = if (selected) selectedContentColor else unselectedContentColor
            )
        }

        Spacer(modifier = Modifier.height(betweenSpacing))

        Text(
            text = label,
            style = labelStyle,
            color = if (selected) selectedContentColor else unselectedContentColor,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

object ProjectBottomNavigationDefaults {

    fun shape(
        topStart: Dp = 0.dp,
        topEnd: Dp = 0.dp,
        bottomEnd: Dp = 0.dp,
        bottomStart: Dp = 0.dp
    ) = RoundedCornerShape(
        topStart = topStart,
        topEnd = topEnd,
        bottomEnd = bottomEnd,
        bottomStart = bottomStart
    )
}
