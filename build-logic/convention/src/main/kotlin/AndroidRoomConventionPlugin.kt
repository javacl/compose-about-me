import androidx.room.gradle.RoomExtension
import project.catalog.kspPlugin
import project.catalog.roomCompilerLibrary
import project.catalog.roomKtxLibrary
import project.catalog.roomPlugin
import project.catalog.roomRuntimeLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()

            extensions.configure<RoomExtension> {
                // The schemas directory contains a schema file for each version of the Room database.
                // This is required to enable Room auto migrations.
                // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
                schemaDirectory("$projectDir/schemas")
            }

            applyDependencies()
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(roomPlugin)
            apply(kspPlugin)
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", roomRuntimeLibrary)
            add("implementation", roomKtxLibrary)
            add("ksp", roomCompilerLibrary)
        }
    }
}
