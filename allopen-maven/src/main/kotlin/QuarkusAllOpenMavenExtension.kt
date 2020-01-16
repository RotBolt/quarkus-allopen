package io.quarkus.allopen

import org.apache.maven.plugin.MojoExecution
import org.apache.maven.project.MavenProject
import org.codehaus.plexus.component.annotations.Component
import org.jetbrains.kotlin.maven.KotlinMavenPluginExtension
import org.jetbrains.kotlin.maven.PluginOption

const val  kotlinCompilerPluginId = "org.jetbrains.kotlin.allopen"

@Component(role = KotlinMavenPluginExtension::class, hint = "quarkus-allopen")
class QuarkusAllOpenMavenExtension : KotlinMavenPluginExtension {
    override fun getCompilerPluginId(): String = kotlinCompilerPluginId

    override fun isApplicable(project: MavenProject, execution: MojoExecution): Boolean = true

    override fun getPluginOptions(project: MavenProject, execution: MojoExecution): MutableList<PluginOption> {
        return QuarkusAllOpenExtension().annotations.map {
            PluginOption(
                "quarkus-allopen",
                kotlinCompilerPluginId,
                "annotation",
                it
            )
        }.toMutableList()
    }
}