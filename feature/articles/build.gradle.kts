plugins {
    alias(libs.plugins.project.android.feature)
}

android {
    namespace = "compose.about.me.feature.articles"
}

dependencies {
    implementation(projects.domain.articles)
}
