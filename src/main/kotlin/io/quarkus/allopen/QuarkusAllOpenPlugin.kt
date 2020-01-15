package io.quarkus.allopen

import org.gradle.api.Plugin
import org.gradle.api.Project

class QuarkusAllOpenPlugin: Plugin<Project> {
    override fun apply(project: Project) {
        project.extensions.create("quarkusAllOpen",QuarkusAllOpenExtension::class.java)
    }
}