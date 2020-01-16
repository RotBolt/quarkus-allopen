package io.quarkus.allopen

open class QuarkusAllOpenExtension {
    /** FQ names of annotations that should count as debuglog annotations */
    var annotations: List<String> = listOf(
        "javax.enterprise.context.ApplicationScoped",
        "javax.enterprise.context.RequestScoped"
    )
}