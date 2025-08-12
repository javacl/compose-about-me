plugins {
    alias(libs.plugins.project.android.library)
    alias(libs.plugins.project.android.test)
    alias(libs.plugins.project.android.hilt)
    alias(libs.plugins.project.android.okhttp)
    alias(libs.plugins.project.android.retrofit)
    alias(libs.plugins.project.android.json)
}

android {
    namespace = "compose.about.me.network"
}
