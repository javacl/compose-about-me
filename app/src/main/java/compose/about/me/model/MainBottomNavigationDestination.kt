package compose.about.me.model

import androidx.compose.ui.graphics.painter.Painter

data class MainBottomNavigationDestination(
    val route: String,
    val selectedIcon: Painter,
    val unSelectedIcon: Painter,
    val label: String
)
