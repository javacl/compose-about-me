plugins {
    alias(libs.plugins.project.android.library)
    alias(libs.plugins.project.android.test)
    alias(libs.plugins.project.android.compose.library)
    alias(libs.plugins.project.android.coil)
}

android {
    namespace = "compose.about.me.design.system"
}

dependencies {

    libs.apply {
        implementation(splash.screen)
        implementation(google.material)
    }
}
