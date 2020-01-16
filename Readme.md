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
  

#### Usage (maven)

-   package and install the allopen-maven
-   use it in the project like this (in plugin section of pom.xml)
    ```
           <plugin>
            <groupId>org.jetbrains.kotlin</groupId>
            <artifactId>kotlin-maven-plugin</artifactId>
            <version>${kotlin.version}</version>
            <executions>
              <execution>
                <id>compile</id>
                <goals>
                  <goal>compile</goal>
                </goals>
              </execution>
              <execution>
                <id>test-compile</id>
                <goals>
                  <goal>test-compile</goal>
                </goals>
              </execution>
            </executions>
            <dependencies>
              <dependency>
                <groupId>io.quarkus.allopen</groupId>
                <artifactId>quarkus-maven-allopen</artifactId>
                <version>1.0</version>
              </dependency>
            </dependencies>
            <configuration>
              <javaParameters>true</javaParameters>
              <compilerPlugins>
                <plugin>quarkus-allopen</plugin>
              </compilerPlugins>
            </configuration>
          </plugin>
    ```

