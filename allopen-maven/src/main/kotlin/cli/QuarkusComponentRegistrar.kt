package cli


import com.intellij.mock.MockProject
import io.quarkus.allopen.cli.QuarkusAttributeAltererExtension
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension

class QuarkusComponentRegistrar : ComponentRegistrar {
    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        val annotations = configuration.get(ANNOTATION)?.toMutableList() ?: mutableListOf()
        DeclarationAttributeAltererExtension.registerExtension(project,
            QuarkusAttributeAltererExtension(annotations)
        )
    }
}