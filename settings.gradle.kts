pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }

    }
}

@Suppress("UnstableApiUsage")
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

gradle.startParameter.excludedTaskNames.addAll(listOf(":build-logic:convention:testClasses"))

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "compose-about-me"

// app
include(":app")

// core
include(":core:common")
include(":core:design-system")
include(":core:datastore")
include(":core:network")
include(":core:database")

// data
include(":data:setting")
include(":data:article")

// domain
include(":domain:main")
include(":domain:articles")
include(":domain:article")
include(":domain:profile")

// feature
include(":feature:articles")
include(":feature:article")
include(":feature:profile")
