package compose.about.me.design.system.utils

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb

fun ComponentActivity.setSystemBarsColor(
    color: Color,
    darkIcons: Boolean = color.luminance() > 0.5f,
) {
    val barsColor = color.toArgb()
    val systemBarStyle = if (darkIcons) {
        SystemBarStyle.light(barsColor, barsColor)
    } else {
        SystemBarStyle.dark(barsColor)
    }

    enableEdgeToEdge(
        statusBarStyle = systemBarStyle,
        navigationBarStyle = systemBarStyle
    )
}
