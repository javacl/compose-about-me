import project.catalog.coilComposeLibrary
import project.catalog.coilGifLibrary
import project.catalog.coilSvgLibrary
import project.catalog.coilBaseLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidCoilConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyDependencies()
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", coilComposeLibrary)
            add("implementation", coilGifLibrary)
            add("implementation", coilSvgLibrary)
            add("implementation", coilBaseLibrary)
        }
    }
}
