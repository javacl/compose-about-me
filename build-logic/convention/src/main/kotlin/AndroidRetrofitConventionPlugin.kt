import project.catalog.retrofitCoreLibrary
import project.catalog.retrofitKotlinSerializationLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidRetrofitConventionPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.run {
            applyDependencies()
        }
    }

    private fun Project.applyDependencies() {
        dependencies {
            add("implementation", retrofitCoreLibrary)
            add("implementation", retrofitKotlinSerializationLibrary)
        }
    }
}
