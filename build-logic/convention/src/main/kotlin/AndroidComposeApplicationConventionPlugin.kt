import project.applicationGradle
import project.catalog.composeCompilerPlugin
import project.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidComposeApplicationConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            applicationGradle {
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
