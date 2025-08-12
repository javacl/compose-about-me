import project.applicationGradle
import project.catalog.androidApplicationPlugin
import project.catalog.kotlinAndroidPlugin
import project.catalog.projectApplicationId
import project.catalog.projectTargetSdk
import project.catalog.projectVersionCode
import project.catalog.projectVersionName
import project.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            applicationGradle {
                configureKotlinAndroid(this)
                defaultConfig {
                    applicationId = projectApplicationId
                    targetSdk = projectTargetSdk
                    versionCode = projectVersionCode
                    versionName = projectVersionName
                }
            }
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(androidApplicationPlugin)
            apply(kotlinAndroidPlugin)
        }
    }
}
