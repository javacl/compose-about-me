package compose.about.me.ui

import compose.about.me.common.model.ProjectThemeType
import compose.about.me.design.system.base.UnidirectionalViewModel

interface MainContract : UnidirectionalViewModel<MainContract.Event, MainContract.State> {

    data class State(
        val theme: ProjectThemeType? = null
    )

    sealed class Event
}
