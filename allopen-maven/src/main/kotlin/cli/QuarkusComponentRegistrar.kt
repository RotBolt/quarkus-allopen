package cli


import com.intellij.mock.MockProject
import io.quarkus.allopen.cli.QuarkusAttributeAltererExtension
import org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.extensions.DeclarationAttributeAltererExtension

class QuarkusComponentRegistrar : ComponentRegistrar {

    private val defAnnotations: List<String> = listOf(
        "javax.ws.rs.Path",
        "javax.enterprise.context.ApplicationScoped",
        "javax.enterprise.context.RequestScoped"
    )

    override fun registerProjectComponents(project: MockProject, configuration: CompilerConfiguration) {
        val annotations = configuration.get(ANNOTATION)?.toMutableList() ?: mutableListOf()
        annotations += defAnnotations
        DeclarationAttributeAltererExtension.registerExtension(project,
            QuarkusAttributeAltererExtension(annotations)
        )
    }
}