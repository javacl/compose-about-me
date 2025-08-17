plugins {
    alias(libs.plugins.project.android.domain)
}

android {
    namespace = "compose.about.me.domain.article"
}

dependencies {
    implementation(projects.data.article)
}
