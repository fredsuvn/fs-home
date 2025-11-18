plugins {
  `java-library`
  jacoco
  `maven-publish`
  signing
  id("fs")
}

description = "Base of fs-home."

dependencies {
  implementation(platform(project(":fs-dependencies")))
  api(project(":fs-common"))
  api("org.apache.tomcat.embed:tomcat-embed-core")

  testImplementation(platform(project(":fs-dependencies")))
  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
  include("**/*Test.class", "**/*TestKt.class")
  useJUnitPlatform()
}

publishing {
  publications {
    create<MavenPublication>("main") {
      from(components["java"])
      val projectInfo: ProjectInfo by rootProject.extra
      pom {
        version = projectInfo.version
        group = rootProject.group
        name = project.name
        description = project.description
        url = projectInfo.url
        licenses {
          projectInfo.licenses.forEach {
            license {
              name.set(it.name)
              url.set(it.url)
            }
          }
        }
        developers {
          projectInfo.developers.forEach {
            developer {
              id.set(it.id)
              name.set(it.name)
              email.set(it.email)
              url.set(it.url)
            }
          }
        }
        scm {
          connection = projectInfo.scm.connection
          developerConnection = projectInfo.scm.developerConnection
          url = projectInfo.scm.url
        }
      }
    }
  }
  repositories {
    mavenLocal()
  }
}

signing {
}