package io.quarkus.allopen

open class QuarkusAllOpenExtension {
    /** FQ names of annotations that should count as quarkus annotations */

    internal var defaultAnnotations = listOf(
        "javax.enterprise.context.ApplicationScoped",
        "javax.enterprise.context.RequestScoped"
    )

    var annotations = mutableListOf<String>()
}