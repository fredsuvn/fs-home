plugins {
  `java-platform`
  `maven-publish`
  signing
  id("fsh")
}

description = "Dependencies management of Fs Home."

javaPlatform {
  allowDependencies()
}

dependencies {
  constraints {

    // fs
    api("space.sunqian.fs:fs-all:0.0.0-SNAPSHOT")

    //lombok
    api("org.projectlombok:lombok:1.18.30")

    //test
    api("org.junit.jupiter:junit-jupiter-api:5.14.0")
    api("org.junit.jupiter:junit-jupiter-engine:5.14.0")
    api("org.junit.platform:junit-platform-launcher:1.14.0")
    api("org.testng:testng:7.5.1")
    api("org.openjdk.jmh:jmh-core:1.37")
    api("org.openjdk.jmh:jmh-generator-annprocess:1.37")
    api("org.mockito:mockito-core:5.5.0")

    //security
    api("org.bouncycastle:bcprov-jdk18on:1.76")
    api("org.bouncycastle:bcpkix-jdk18on:1.79")

    //kotlin
    api("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.10")
    api("org.jetbrains.kotlin:kotlin-test-testng:1.9.10")

    //template
    api("org.apache.velocity:velocity-engine-core:2.3")

    // web
    api("jakarta.annotation:jakarta.annotation-api:3.0.0")
    api("org.apache.tomcat:tomcat-servlet-api:11.0.14")
    api("org.apache.tomcat.embed:tomcat-embed-core:11.0.14")
  }
}

publishing {
  publications {
    create<MavenPublication>("main") {
      from(components["javaPlatform"])
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