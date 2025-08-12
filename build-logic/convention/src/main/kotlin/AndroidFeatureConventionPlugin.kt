import project.catalog.projectAndroidCoilPlugin
import project.catalog.projectAndroidComposeLibraryPlugin
import project.catalog.projectAndroidHiltPlugin
import project.catalog.projectAndroidLibraryPlugin
import project.catalog.projectAndroidLifecyclePlugin
import project.catalog.projectAndroidTestPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {

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
            apply(projectAndroidComposeLibraryPlugin)
            apply(projectAndroidCoilPlugin)
            apply(projectAndroidLifecyclePlugin)
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", project(":core:design-system"))
            add("implementation", project(":core:common"))
        }
    }
}
