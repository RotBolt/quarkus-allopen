## Quarkus all open

#### Usage (gradle)

- Building project
    - build the project
    - publish to local maven repository by `./gradlew publishToMavenLocal`

- Adding to your own project
    - add `buildScript {}` to your root level build.gradle
    ```$xslt
        buildscript {
            repositories {
                mavenLocal()
            }
            dependencies {
                classpath "io.quarkus.allopen:quarkus-allopen:1.0"
            }
        }
    ``` 

    - then apply the plugin in your module level build.gradle `apply plugin: quarkus.allopen`
    - use it as 
        ```$xslt
            quarkusAllOpen {
                enabled = true
                annotations = [] // add custom annotations
            }
        ```
      
- If using single build.gradle file in your project. 
  Then please use the legacy method of applying gradle plugin only
    

