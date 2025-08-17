plugins {
    alias(libs.plugins.project.android.domain)
}

android {
    namespace = "compose.about.me.domain.main"
}

dependencies {
    implementation(projects.data.setting)
}
