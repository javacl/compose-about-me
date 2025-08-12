import project.catalog.projectAndroidHiltPlugin
import project.catalog.projectAndroidLibraryPlugin
import project.catalog.projectAndroidTestPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidDomainConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyPlugins()
            applyDependencies()
        }
    }

    private fun Project.applyPlugins() {
        pluginManager.apply {
            apply(projectAndroidLibraryPlugin)
            apply(projectAndroidTestPlugin)
            apply(projectAndroidHiltPlugin)
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", project(":core:common"))
        }
    }
}
