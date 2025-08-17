package compose.about.me.design.system.component

import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ProjectBottomNavigation(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
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
    labelStyle: TextStyle = MaterialTheme.typography.labelMedium,
    selectedContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    unselectedContentColor: Color = MaterialTheme.colorScheme.onBackground,
    contentPadding: PaddingValues = PaddingValues(vertical = 12.dp),
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

        Icon(
            modifier = Modifier.size(iconSize),
            painter = if (selected) selectedIcon else unSelectedIcon,
            contentDescription = label,
            tint = if (selected) selectedContentColor else unselectedContentColor
        )

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

@Composable
fun RowScope.ProjectBottomNavigationItem(
    @DrawableRes icon: Int?,
    selected: Boolean,
    enabled: Boolean = true,
    iconSize: Dp = 24.dp,
    highlightShape: Shape = CircleShape,
    highlightPadding: PaddingValues = PaddingValues(10.dp),
    selectedHighlightColor: Color = MaterialTheme.colorScheme.primaryContainer,
    unselectedHighlightColor: Color = Color.Transparent,
    selectedContentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    unselectedContentColor: Color = MaterialTheme.colorScheme.onBackground,
    padding: PaddingValues = PaddingValues(vertical = 12.dp),
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(bounded = false),
                onClick = onClick,
                enabled = enabled
            )
            .padding(padding),
        contentAlignment = Alignment.Center
    ) {
        if (icon == null) return@Box

        Box(
            modifier = Modifier
                .wrapContentSize()
                .clip(highlightShape)
                .background(if (selected) selectedHighlightColor else unselectedHighlightColor)
                .padding(highlightPadding)
        ) {
            Icon(
                modifier = Modifier.size(iconSize),
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = if (selected) selectedContentColor else unselectedContentColor
            )
        }
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
