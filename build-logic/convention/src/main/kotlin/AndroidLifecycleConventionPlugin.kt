import project.catalog.lifecycleProcessLibrary
import project.catalog.lifecycleRuntimeKtxLibrary
import project.catalog.lifecycleServiceLibrary
import project.catalog.lifecycleViewModelKtxLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidLifecycleConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyDependencies()
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", lifecycleRuntimeKtxLibrary)
            add("implementation", lifecycleViewModelKtxLibrary)
            add("implementation", lifecycleServiceLibrary)
            add("implementation", lifecycleProcessLibrary)
        }
    }
}
