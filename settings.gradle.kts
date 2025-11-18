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

rootProject.name = "fs-home"

file(rootDir).listFiles()
  ?.filter { it.isDirectory }
  ?.filter { it.name.matches(Regex("fs-(?!(recycle|draft|starters)).*")) }
  ?.forEach { include(":${it.name}") }
file(file("${rootDir.path}/fs-starters")).listFiles()
  ?.filter { it.isDirectory }
  ?.filter { it.name.matches(Regex("starter-.*")) }
  ?.forEach { include(":fs-starters:${it.name}") }