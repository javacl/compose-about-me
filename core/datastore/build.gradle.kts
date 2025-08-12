plugins {
    alias(libs.plugins.project.android.library)
    alias(libs.plugins.project.android.test)
    alias(libs.plugins.project.android.hilt)
}

android {
    namespace = "compose.about.me.datastore"
}

dependencies {
    implementation(libs.datastore)
}
