package io.quarkus.allopen

open class QuarkusAllOpenExtension {
    /** FQ names of annotations that should count as quarkus annotations */

    companion object{
        val defaultAnnotations = listOf(
            "javax.ws.rs.Path",
            "javax.enterprise.context.ApplicationScoped",
            "javax.enterprise.context.RequestScoped"
        )
    }

    var annotations = mutableListOf<String>()
}