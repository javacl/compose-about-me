package project

import com.android.build.api.dsl.CommonExtension
import project.catalog.coreKtxLibrary
import project.catalog.coroutinesAndroidLibrary
import project.catalog.projectCompileSdk
import project.catalog.projectMinSdk
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {

        compileSdk = projectCompileSdk

        defaultConfig {
            minSdk = projectMinSdk
            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            vectorDrawables {
                useSupportLibrary = true
            }
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        tasks.withType<KotlinJvmCompile>().configureEach {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_17)
                freeCompilerArgs.add("-opt-in=kotlin.RequiresOptIn")
            }
        }

        buildFeatures {
            buildConfig = true
        }

        dependencies {
            add("implementation", coreKtxLibrary)
            add("implementation", coroutinesAndroidLibrary)
        }
    }
}
