package compose.about.me.core.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object CustomRippleTheme : RippleTheme {

    @Composable
    override fun defaultColor(): Color = MaterialTheme.colors.ripple

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        contentColor = White,
        lightTheme = !isSystemInDarkTheme()
    )
}
