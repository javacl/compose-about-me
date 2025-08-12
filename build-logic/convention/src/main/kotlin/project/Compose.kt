package project

import com.android.build.api.dsl.CommonExtension
import project.catalog.composeActivityLibrary
import project.catalog.composeBomLibrary
import project.catalog.composeHiltNavigationLibrary
import project.catalog.composeLifecycleRuntimeLibrary
import project.catalog.composeLifecycleViewModelLibrary
import project.catalog.composeNavigationLibrary
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {

        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = composeBomLibrary
            add("implementation", platform(bom))
            add("implementation", "androidx.compose.ui:ui")
            add("implementation", "androidx.compose.ui:ui-android")
            add("implementation", "androidx.compose.ui:ui-tooling-preview")
            add("implementation", "androidx.compose.ui:ui-tooling")
            add("implementation", "androidx.compose.ui:ui-util")
            add("implementation", "androidx.compose.runtime:runtime")
            add("implementation", "androidx.compose.foundation:foundation")
            add("implementation", "androidx.compose.material3:material3")

            add("androidTestImplementation", platform(bom))
            add("androidTestImplementation", "androidx.compose.ui:ui-test-junit4")
            add("debugImplementation", "androidx.compose.ui:ui-tooling")
            add("debugImplementation", "androidx.compose.ui:ui-test-manifest")

            add("implementation", composeActivityLibrary)
            add("implementation", composeNavigationLibrary)
            add("implementation", composeLifecycleRuntimeLibrary)
            add("implementation", composeLifecycleViewModelLibrary)
            add("implementation", composeHiltNavigationLibrary)
        }
    }
}
