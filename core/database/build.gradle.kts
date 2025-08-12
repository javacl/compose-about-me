plugins {
    alias(libs.plugins.project.android.library)
    alias(libs.plugins.project.android.test)
    alias(libs.plugins.project.android.hilt)
    alias(libs.plugins.project.android.room)
    alias(libs.plugins.project.android.json)
}

android {
    namespace = "compose.about.me.database"
}
