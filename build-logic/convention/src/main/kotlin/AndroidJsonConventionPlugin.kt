import project.catalog.kotlinxSerializationJsonLibrary
import project.catalog.kotlinxSerializationPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidJsonConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            applyDependencies()
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(kotlinxSerializationPlugin)
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            val json = kotlinxSerializationJsonLibrary
            add("implementation", json)
            add("testImplementation", json)
        }
    }
}
