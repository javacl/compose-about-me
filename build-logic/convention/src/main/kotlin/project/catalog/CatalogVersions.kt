package project.catalog

import project.libs
import org.gradle.api.Project

val Project.projectApplicationId
    get() = libs.findVersion("projectApplicationId").get().toString()

val Project.projectGooglePlayApplicationId
    get() = libs.findVersion("projectGooglePlayApplicationId").get().toString()

val Project.projectMinSdk
    get() = Integer.parseInt(libs.findVersion("projectMinSdkVersion").get().toString())

val Project.projectTargetSdk
    get() = Integer.parseInt(libs.findVersion("projectTargetSdkVersion").get().toString())

val Project.projectCompileSdk
    get() = Integer.parseInt(libs.findVersion("projectCompileSdkVersion").get().toString())

val Project.projectVersionCode
    get() = Integer.parseInt(libs.findVersion("projectVersionCode").get().toString())

val Project.projectVersionName
    get() = libs.findVersion("projectVersionName").get().toString()
