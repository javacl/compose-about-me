package com.compose.navigation.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Blue3861FB,
    primaryVariant = Black,
    secondary = Black,
    background = Black,
    surface = Gray323546
)

private val LightColorPalette = lightColors(
    primary = Blue3861FB,
    primaryVariant = White,
    secondary = White,
    background = White,
    surface = GrayEEF2F5
)

val Colors.textPrimary: Color
    get() = if (isLight) Black else White

val Colors.textPrimaryLight: Color
    get() = if (isLight) Gray818A9B else Gray818A9B

val Colors.textPrimaryHighLight: Color
    get() = if (isLight) GrayA4B1C2 else Gray323546

val Colors.textSecondary: Color
    get() = if (isLight) White else White

val Colors.divider: Color
    get() = if (isLight) GrayEEF2F5 else Gray323546

val Colors.ripple: Color
    get() = if (isLight) Blue3861FB else Blue3861FB

val Colors.onRipple: Color
    get() = if (isLight) White else White

val Colors.green: Color
    get() = if (isLight) Green00DAA2 else Green00DAA2

val Colors.red: Color
    get() = if (isLight) RedE64274 else RedE64274

@Composable
fun ComposeNavigationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes
    ) {
        CompositionLocalProvider(
            LocalRippleTheme provides CustomRippleTheme,
            content = content
        )
    }
}
