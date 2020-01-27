package io.quarkus.allopen

open class QuarkusAllOpenExtension {
    /** FQ names of annotations that should count as quarkus annotations */

    internal var defaultAnnotations = listOf(
        "javax.enterprise.context.ApplicationScoped",
        "javax.enterprise.context.RequestScoped"
    )
    internal var annotations = mutableListOf<String>()

    open fun annotation(fqName: String) {
        annotations.add(fqName)
    }

    open fun annotations(fqNames: List<String>) {
        annotations.addAll(fqNames)
    }
}