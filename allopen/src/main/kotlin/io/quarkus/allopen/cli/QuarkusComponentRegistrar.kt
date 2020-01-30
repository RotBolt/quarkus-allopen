package io.quarkus.allopen.cli

import io.quarkus.allopen.QuarkusAllOpenExtension
import org.jetbrains.kotlin.com.intellij.mock.MockProject
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension

class QuarkusComponentRegistrar : ComponentRegistrar {
    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        val annotations = configuration.get(ANNOTATION)?.toMutableList() ?: mutableListOf()
        annotations += QuarkusAllOpenExtension.defaultAnnotations
        DeclarationAttributeAltererExtension.registerExtension(project,
            QuarkusAttributeAltererExtension(annotations)
        )
    }
}