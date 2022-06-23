package compose.about.me.features.main.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import compose.about.me.R
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import compose.about.me.core.util.navigation.NavigationRoutes
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_logo
            ),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.8f)
                .aspectRatio(1f)
        )
    }

    LaunchedEffect(coroutineScope) {
        delay(1000)
        navController.navigate(NavigationRoutes.Home.route) {
            popUpTo(NavigationRoutes.Splash.route) { inclusive = true }
        }
    }
}
