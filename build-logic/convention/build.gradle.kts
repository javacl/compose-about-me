plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.room.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.project.android.application.get().pluginId
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.project.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidComposeApplication") {
            id = libs.plugins.project.android.compose.application.get().pluginId
            implementationClass = "AndroidComposeApplicationConventionPlugin"
        }
        register("androidComposeLibrary") {
            id = libs.plugins.project.android.compose.library.get().pluginId
            implementationClass = "AndroidComposeLibraryConventionPlugin"
        }
        register("androidHilt") {
            id = libs.plugins.project.android.hilt.get().pluginId
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidTest") {
            id = libs.plugins.project.android.test.get().pluginId
            implementationClass = "AndroidTestConventionPlugin"
        }
        register("androidRoom") {
            id = libs.plugins.project.android.room.get().pluginId
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidCoil") {
            id = libs.plugins.project.android.coil.get().pluginId
            implementationClass = "AndroidCoilConventionPlugin"
        }
        register("androidOkhttp") {
            id = libs.plugins.project.android.okhttp.get().pluginId
            implementationClass = "AndroidOkhttpConventionPlugin"
        }
        register("androidRetrofit") {
            id = libs.plugins.project.android.retrofit.get().pluginId
            implementationClass = "AndroidRetrofitConventionPlugin"
        }
        register("androidJson") {
            id = libs.plugins.project.android.json.get().pluginId
            implementationClass = "AndroidJsonConventionPlugin"
        }
        register("androidLifecycle") {
            id = libs.plugins.project.android.lifecycle.get().pluginId
            implementationClass = "AndroidLifecycleConventionPlugin"
        }

        register("androidData") {
            id = libs.plugins.project.android.data.get().pluginId
            implementationClass = "AndroidDataConventionPlugin"
        }
        register("androidDomain") {
            id = libs.plugins.project.android.domain.get().pluginId
            implementationClass = "AndroidDomainConventionPlugin"
        }
        register("androidFeature") {
            id = libs.plugins.project.android.feature.get().pluginId
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}
