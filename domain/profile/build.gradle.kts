plugins {
    alias(libs.plugins.project.android.domain)
}

android {
    namespace = "compose.about.me.domain.profile"
}

dependencies {
    implementation(projects.data.setting)
}
