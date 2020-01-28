import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CliOption
import org.jetbrains.kotlin.compiler.plugin.CliOptionProcessingException
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
import org.jetbrains.kotlin.config.CompilerConfiguration
import org.jetbrains.kotlin.config.CompilerConfigurationKey

val ANNOTATION: CompilerConfigurationKey<List<String>> =
    CompilerConfigurationKey.create("annotation qualified name")
const val groupId = "io.quarkus.allopen"
const val artifactId = "quarkus-allopen"

class QuarkusAllOpenCommandLineProcessor : CommandLineProcessor {

    companion object {
        val ANNOTATION_OPTION = CliOption(
            "annotation", "<fqname>", "Annotation qualified names",
            required = false, allowMultipleOccurrences = true
        )
    }

    override val pluginId: String
        get() = "$groupId.$artifactId"
    override val pluginOptions: Collection<AbstractCliOption>
        get() = listOf(ANNOTATION_OPTION)

    override fun processOption(option: AbstractCliOption, value: String, configuration: CompilerConfiguration) {
        when (option) {
            ANNOTATION_OPTION -> configuration.appendList(
                ANNOTATION, value)
            else -> throw CliOptionProcessingException("Unknown option: ${option.optionName}")
        }
    }
}