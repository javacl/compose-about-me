import project.androidGradle
import project.catalog.androidLibraryPlugin
import project.catalog.kotlinAndroidPlugin
import project.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            androidGradle {
                configureKotlinAndroid(this)
            }
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(androidLibraryPlugin)
            apply(kotlinAndroidPlugin)
        }
    }
}
