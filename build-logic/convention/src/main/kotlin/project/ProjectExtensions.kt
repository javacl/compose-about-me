package project

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

val Project.libs
    get(): VersionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")

inline fun Project.androidGradle(crossinline configure: LibraryExtension.() -> Unit) =
    extensions.configure<LibraryExtension> {
        configure()
    }

inline fun Project.applicationGradle(crossinline configure: ApplicationExtension.() -> Unit) =
    extensions.configure<ApplicationExtension> {
        configure()
    }
