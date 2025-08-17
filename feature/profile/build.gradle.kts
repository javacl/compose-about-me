plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "compose.about.me.feature.profile"
}

dependencies {
    implementation(projects.domain.profile)
}
