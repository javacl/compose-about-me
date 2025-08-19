package compose.about.me.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import compose.about.me.common.model.ProjectThemeType
import compose.about.me.design.system.base.BaseActivity
import compose.about.me.design.system.base.use
import compose.about.me.design.system.theme.ComposeAboutMeTheme
import compose.about.me.design.system.utils.setSystemBarsColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        enableEdgeToEdge()

        setContent {

            val (state, _) = use(viewModel = viewModel)

            val darkTheme = when (state.theme) {
                ProjectThemeType.Light -> false
                ProjectThemeType.Dark -> true
                else -> isSystemInDarkTheme()
            }

            ComposeAboutMeTheme(
                darkTheme = darkTheme
            ) {
                val surfaceColor = MaterialTheme.colorScheme.surface

                LaunchedEffect(darkTheme) {
                    setSystemBarsColor(
                        color = surfaceColor
                    )
                }

                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .systemBarsPadding()
                        .imePadding(),
                    color = surfaceColor
                ) {
                    MainScreen()
                }
            }
        }
    }
}
