package compose.about.me.design.system.component

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import compose.about.me.design.system.R

@Composable
fun ProjectToolbarIcon(
    @DrawableRes icon: Int,
    color: Color = MaterialTheme.colorScheme.onSurface,
    onClick: () -> Unit
) = Box(
    modifier = Modifier
        .clickable(
            onClick = onClick,
            interactionSource = remember { MutableInteractionSource() },
            indication = ripple(bounded = false)
        )
        .padding(8.dp)
) {
    Icon(
        modifier = Modifier.size(24.dp),
        painter = painterResource(id = icon),
        contentDescription = null,
        tint = color
    )
}

@Composable
fun ProjectBackToolbar(
    text: String?,
    modifier: Modifier = Modifier,
    onBackClick: (() -> Unit)? = null,
    iconColor: Color = MaterialTheme.colorScheme.onSurface,
    contentColor: Color = MaterialTheme.colorScheme.onSurface,
    fixContentToEnd: Boolean = true,
    content: (@Composable RowScope.() -> Unit)? = null
) {
    val onBackPressDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ProjectToolbarIcon(
            icon = R.drawable.ic_rounded_arrow_back_ios_new_w300,
            onClick = {
                if (onBackClick == null) {
                    onBackPressDispatcher?.onBackPressed()
                } else {
                    onBackClick.invoke()
                }
            },
            color = iconColor
        )

        if (text != null) {
            Text(
                text = text,
                style = MaterialTheme.typography.labelLarge,
                color = contentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        if (fixContentToEnd) {
            Spacer(modifier = Modifier.weight(1f))
        }

        if (content != null) {
            content()
        }
    }
}
