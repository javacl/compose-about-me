package project.catalog

import project.libs
import org.gradle.api.Project

val Project.androidApplicationPlugin
    get() = libs.findPlugin("android-application").get().get().pluginId.toString()

val Project.androidLibraryPlugin
    get() = libs.findPlugin("android-library").get().get().pluginId.toString()

val Project.kotlinAndroidPlugin
    get() = libs.findPlugin("kotlin-android").get().get().pluginId.toString()

val Project.hiltAndroidPlugin
    get() = libs.findPlugin("hilt-android").get().get().pluginId.toString()

val Project.kspPlugin
    get() = libs.findPlugin("ksp").get().get().pluginId.toString()

val Project.roomPlugin
    get() = libs.findPlugin("room").get().get().pluginId.toString()

val Project.composeCompilerPlugin
    get() = libs.findPlugin("compose-compiler").get().get().pluginId.toString()

val Project.kotlinxSerializationPlugin
    get() = libs.findPlugin("kotlinx-serialization").get().get().pluginId.toString()


// Plugins defined by this project
val Project.projectAndroidLibraryPlugin
    get() = libs.findPlugin("project-android-library").get().get().pluginId.toString()

val Project.projectAndroidComposeLibraryPlugin
    get() = libs.findPlugin("project-android-compose-library").get().get().pluginId.toString()

val Project.projectAndroidHiltPlugin
    get() = libs.findPlugin("project-android-hilt").get().get().pluginId.toString()

val Project.projectAndroidTestPlugin
    get() = libs.findPlugin("project-android-test").get().get().pluginId.toString()

val Project.projectAndroidCoilPlugin
    get() = libs.findPlugin("project-android-coil").get().get().pluginId.toString()

val Project.projectAndroidLifecyclePlugin
    get() = libs.findPlugin("project-android-lifecycle").get().get().pluginId.toString()
