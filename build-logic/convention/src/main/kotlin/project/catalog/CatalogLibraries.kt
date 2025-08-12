package project.catalog

import project.libs
import org.gradle.api.Project

val Project.coreKtxLibrary
    get() = libs.findLibrary("core-ktx").get()

val Project.coroutinesAndroidLibrary
    get() = libs.findLibrary("coroutines-android").get()


// Lifecycle
val Project.lifecycleRuntimeKtxLibrary
    get() = libs.findLibrary("lifecycle-runtime-ktx").get()

val Project.lifecycleViewModelKtxLibrary
    get() = libs.findLibrary("lifecycle-viewmodel-ktx").get()

val Project.lifecycleServiceLibrary
    get() = libs.findLibrary("lifecycle-service").get()

val Project.lifecycleProcessLibrary
    get() = libs.findLibrary("lifecycle-process").get()


// Compose
val Project.composeBomLibrary
    get() = libs.findLibrary("compose-bom").get()

val Project.composeActivityLibrary
    get() = libs.findLibrary("compose-activity").get()

val Project.composeNavigationLibrary
    get() = libs.findLibrary("compose-navigation").get()

val Project.composeLifecycleRuntimeLibrary
    get() = libs.findLibrary("compose-lifecycle-runtime").get()

val Project.composeLifecycleViewModelLibrary
    get() = libs.findLibrary("compose-lifecycle-viewModel").get()

val Project.composeHiltNavigationLibrary
    get() = libs.findLibrary("compose-hilt-navigation").get()


// Hilt
val Project.hiltAndroidLibrary
    get() = libs.findLibrary("hilt.android").get()

val Project.hiltCompilerLibrary
    get() = libs.findLibrary("hilt.compiler").get()


// Test
val Project.junitLibrary
    get() = libs.findLibrary("junit").get()

val Project.androidxJunitLibrary
    get() = libs.findLibrary("androidx-test-ext-junit").get()

val Project.espressoCoreLibrary
    get() = libs.findLibrary("espresso-core").get()


// Room
val Project.roomRuntimeLibrary
    get() = libs.findLibrary("room.runtime").get()

val Project.roomKtxLibrary
    get() = libs.findLibrary("room.ktx").get()

val Project.roomCompilerLibrary
    get() = libs.findLibrary("room.compiler").get()


// Coil
val Project.coilComposeLibrary
    get() = libs.findLibrary("coil-compose").get()

val Project.coilGifLibrary
    get() = libs.findLibrary("coil-gif").get()

val Project.coilSvgLibrary
    get() = libs.findLibrary("coil-svg").get()

val Project.coilBaseLibrary
    get() = libs.findLibrary("coil-base").get()


// Okhttp
val Project.okhttpLoggingLibrary
    get() = libs.findLibrary("okhttp-logging").get()


// Retrofit
val Project.retrofitCoreLibrary
    get() = libs.findLibrary("retrofit-core").get()

val Project.retrofitKotlinSerializationLibrary
    get() = libs.findLibrary("retrofit-kotlin-serialization").get()


// Json
val Project.kotlinxSerializationJsonLibrary
    get() = libs.findLibrary("kotlinx-serialization-json").get()
