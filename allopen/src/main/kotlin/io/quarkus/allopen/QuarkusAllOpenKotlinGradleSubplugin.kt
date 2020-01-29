package io.quarkus.allopen

import org.gradle.api.Project
import org.gradle.api.tasks.compile.AbstractCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.*

const val groupId = "io.quarkus.allopen"
const val artifactId = "quarkus-allopen"
const val version = "1.0"

class QuarkusAllOpenKotlinGradleSubplugin : KotlinGradleSubplugin<AbstractCompile> {

    override fun apply(
        project: Project,
        kotlinCompile: AbstractCompile,
        javaCompile: AbstractCompile?,
        variantData: Any?,
        androidProjectHandler: Any?,
        kotlinCompilation: KotlinCompilation<KotlinCommonOptions>?
    ): List<SubpluginOption> {
        val extensions = project.extensions.findByType(QuarkusAllOpenExtension::class.java) ?: QuarkusAllOpenExtension()
        val options = mutableListOf<SubpluginOption>()
        for (anno in extensions.defaultAnnotations) {
            options += SubpluginOption("annotation", anno)
        }
        for (anno in extensions.annotations) {
            options += SubpluginOption("annotation", anno)
        }
        return options
    }

    override fun getCompilerPluginId(): String = "org.jetbrains.kotlin.allopen"

    override fun getPluginArtifact(): SubpluginArtifact = JetBrainsSubpluginArtifact("kotlin-allopen")

    override fun isApplicable(project: Project, task: AbstractCompile): Boolean {
        return project.plugins.hasPlugin(QuarkusAllOpenPlugin::class.java)
    }


}