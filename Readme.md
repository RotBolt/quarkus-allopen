## Quarkus all open

#### Usage (gradle)

- Building project
    - build the project
    - install into local repo `./gradlew :allopen:install`
    - publish to local maven repository by `./gradlew publishToMavenLocal`

###### MultiModule Project
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
                annotations = [] // add custom annotations
            }
        ```
###### Single Module (Single build.gradle file)     
- If using single build.gradle file in your project. 
  - In `settings.gradle`
  ```$xslt
    pluginManagement {
        repositories {
            mavenLocal()
        }
        plugins {
            id 'quarkus.allopen' version "1.0"
        }
    }
  ``` 
  - In `build.gradle` file
  
  ```$xslt
    plugins {
        id 'quarkus.allopen'
    }
  ```

  

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
               <dependency>
                   <groupId>org.jetbrains.kotlin</groupId>
                   <artifactId>kotlin-maven-allopen</artifactId>
                   <version>${kotlin.version}</version>
               </dependency>
            </dependencies>
            <configuration>
                 <compilerPlugins>
                   <plugin>quarkus-allopen</plugin>
                 </compilerPlugins>
            </configuration>
           </plugin>
    ```

