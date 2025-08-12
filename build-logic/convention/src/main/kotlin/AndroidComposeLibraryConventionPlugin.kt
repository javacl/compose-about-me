import project.androidGradle
import project.catalog.composeCompilerPlugin
import project.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeLibraryConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            androidGradle {
                configureAndroidCompose(this)
            }
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(composeCompilerPlugin)
        }
    }
}
