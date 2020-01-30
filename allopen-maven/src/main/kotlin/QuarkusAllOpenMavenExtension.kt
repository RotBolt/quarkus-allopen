package io.quarkus.allopen

import org.apache.maven.plugin.MojoExecution
import org.apache.maven.project.MavenProject
import org.codehaus.plexus.component.annotations.Component
import org.jetbrains.kotlin.maven.KotlinMavenPluginExtension
import org.jetbrains.kotlin.maven.PluginOption

const val groupId = "io.quarkus.allopen"
const val artifactId = "quarkus-allopen"

@Component(role = KotlinMavenPluginExtension::class, hint = "quarkus-allopen")
class QuarkusAllOpenMavenExtension : KotlinMavenPluginExtension {
    override fun getCompilerPluginId(): String = "$groupId.$artifactId"

    override fun isApplicable(project: MavenProject, execution: MojoExecution): Boolean = true

    override fun getPluginOptions(project: MavenProject, execution: MojoExecution): List<PluginOption> {
        return emptyList()
    }
}