plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "compose.about.me.feature.article"
}

dependencies {
    implementation(projects.domain.article)
}
