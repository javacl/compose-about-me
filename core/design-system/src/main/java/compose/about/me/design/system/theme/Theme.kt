package compose.about.me.design.system.theme

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RippleConfiguration
import androidx.compose.material3.RippleDefaults
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

val LightColorScheme = lightColorScheme(
    primary = lightPrimary,
    onPrimary = lightOnPrimary,
    primaryContainer = lightPrimaryContainer,
    onPrimaryContainer = lightOnPrimaryContainer,
    secondary = lightSecondary,
    onSecondary = lightOnSecondary,
    secondaryContainer = lightSecondaryContainer,
    onSecondaryContainer = lightOnSecondaryContainer,
    tertiary = lightTertiary,
    onTertiary = lightOnTertiary,
    tertiaryContainer = lightTertiaryContainer,
    onTertiaryContainer = lightOnTertiaryContainer,
    error = lightError,
    onError = lightOnError,
    errorContainer = lightErrorContainer,
    onErrorContainer = lightOnErrorContainer,
    surface = lightSurface,
    onSurface = lightOnSurface,
    onSurfaceVariant = lightOnSurfaceVariant,
    outline = lightOutline,
    outlineVariant = lightOutlineVariant,
    inverseSurface = lightInverseSurface,
    inverseOnSurface = lightOnInverseSurface,
    inversePrimary = lightInversePrimary,
    surfaceTint = lightPrimary,
    scrim = lightScrim,
    surfaceContainer = lightSurfaceContainer,
    surfaceContainerLow = lightSurfaceContainerLow
)

val DarkColorScheme = darkColorScheme(
    primary = darkPrimary,
    onPrimary = darkOnPrimary,
    primaryContainer = darkPrimaryContainer,
    onPrimaryContainer = darkOnPrimaryContainer,
    secondary = darkSecondary,
    onSecondary = darkOnSecondary,
    secondaryContainer = darkSecondaryContainer,
    onSecondaryContainer = darkOnSecondaryContainer,
    tertiary = darkTertiary,
    onTertiary = darkOnTertiary,
    tertiaryContainer = darkTertiaryContainer,
    onTertiaryContainer = darkOnTertiaryContainer,
    error = darkError,
    onError = darkOnError,
    errorContainer = darkErrorContainer,
    onErrorContainer = darkOnErrorContainer,
    surface = darkSurface,
    onSurface = darkOnSurface,
    onSurfaceVariant = darkOnSurfaceVariant,
    outline = darkOutline,
    outlineVariant = darkOutlineVariant,
    inverseSurface = darkInverseSurface,
    inverseOnSurface = darkOnInverseSurface,
    inversePrimary = darkInversePrimary,
    surfaceTint = darkPrimary,
    scrim = darkScrim,
    surfaceContainer = darkSurfaceContainer,
    surfaceContainerLow = darkSurfaceContainerLow
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposeAboutMeTheme(
    darkTheme: Boolean,
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        DarkColorScheme
    } else {
        LightColorScheme
    }

    val rippleConfiguration = RippleConfiguration(
        color = MaterialTheme.colorScheme.primary,
        rippleAlpha = RippleDefaults.RippleAlpha
    )

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = {
            CompositionLocalProvider(
                LocalRippleConfiguration provides rippleConfiguration,
                content = content
            )
        }
    )
}
