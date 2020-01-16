package io.quarkus.allopen

import com.google.auto.service.AutoService
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.plugin.KotlinGradleSubplugin
import org.gradle.api.tasks.compile.AbstractCompile
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinCompilation
import org.jetbrains.kotlin.gradle.plugin.SubpluginArtifact
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption

const val groupId = "io.quarkus.allopen"
const val artifactId = "quarkus-allopen"
const val version = "1.0"

const val  kotlinCompilerPluginId = "org.jetbrains.kotlin.allopen"

@AutoService(KotlinGradleSubplugin::class)
class QuarkusAllOpenKotlinGradleSubplugin : KotlinGradleSubplugin<AbstractCompile>{

    override fun apply(
        project: Project,
        kotlinCompile: AbstractCompile,
        javaCompile: AbstractCompile?,
        variantData: Any?,
        androidProjectHandler: Any?,
        kotlinCompilation: KotlinCompilation<KotlinCommonOptions>?
    ): List<SubpluginOption> {
        val extensions = project.extensions.findByType(QuarkusAllOpenExtension::class.java) ?: QuarkusAllOpenExtension()
        return extensions.annotations.map { SubpluginOption(key = "annotation",value = it ) }
    }

    override fun getCompilerPluginId(): String  = kotlinCompilerPluginId

    override fun getPluginArtifact(): SubpluginArtifact = SubpluginArtifact(
        groupId,
        artifactId,
        version
    )

    override fun isApplicable(project: Project, task: AbstractCompile): Boolean {
      return  project.plugins.hasPlugin(QuarkusAllOpenPlugin::class.java)
    }


}