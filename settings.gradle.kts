pluginManagement {

  repositories {
    mavenLocal()
    maven {
      val xGradlePluginRepo: String by settings
      url = uri(xGradlePluginRepo)
    }
    mavenCentral()
    gradlePluginPortal()
  }

  plugins {
    val jmhPluginVersion: String by settings
    id("me.champeau.jmh") version jmhPluginVersion
  }
}

rootProject.name = "fsh"

file(rootDir).listFiles()
  ?.filter { it.isDirectory }
  ?.filter { it.name.matches(Regex("fsh-(?!(recycle|draft)).*")) }
  ?.forEach { include(":${it.name}") }
// apps
file(file("${rootDir.path}/fsh-app")).listFiles()
  ?.filter { it.isDirectory }
  ?.filter { it.name.matches(Regex("fsh-app-.*")) }
  ?.forEach { include(":fsh-app:${it.name}") }