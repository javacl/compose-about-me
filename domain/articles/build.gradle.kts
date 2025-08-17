plugins {
    alias(libs.plugins.project.android.domain)
}

android {
    namespace = "compose.about.me.domain.articles"
}

dependencies {
    implementation(projects.data.article)
}
