package compose.about.me.feature.profile.model

import androidx.compose.runtime.Immutable
import compose.about.me.common.model.ProjectThemeType

@Immutable
internal data class ThemeModel(
    val text: String,
    val theme: ProjectThemeType
)
