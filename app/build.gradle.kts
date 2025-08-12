plugins {
    alias(libs.plugins.project.android.application)
    alias(libs.plugins.project.android.test)
    alias(libs.plugins.project.android.compose.application)
    alias(libs.plugins.project.android.hilt)
    alias(libs.plugins.project.android.coil)
    alias(libs.plugins.project.android.lifecycle)
}

android {
    namespace = libs.versions.projectApplicationId.get()

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    libs.apply {
        implementation(splash.screen)
        implementation(google.material)
    }

    projects.core.apply {
        implementation(common)
        implementation(designSystem)
    }
}
