package io.quarkus.allopen

open class QuarkusAllOpenExtension {
    /** If [false], this plugin won't actually be applied */
    var enabled: Boolean = true

    /** FQ names of annotations that should count as debuglog annotations */
    var annotations: List<String> = listOf(
        "javax.enterprise.context.ApplicationScoped",
        "javax.enterprise.context.RequestScoped"
    )
}