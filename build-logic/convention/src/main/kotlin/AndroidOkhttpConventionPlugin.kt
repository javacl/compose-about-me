import project.catalog.okhttpLoggingLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidOkhttpConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyDependencies()
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", okhttpLoggingLibrary)
        }
    }
}
