package compose.about.me.feature.profile

import compose.about.me.common.model.ProjectThemeType
import compose.about.me.design.system.base.UnidirectionalViewModel

internal interface ProfileContract :
    UnidirectionalViewModel<ProfileContract.Event, ProfileContract.State> {

    data class State(
        val theme: ProjectThemeType? = null
    )

    sealed class Event {
        data class OnSaveTheme(val theme: ProjectThemeType) : Event()
    }
}
