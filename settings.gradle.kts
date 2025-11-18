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

rootProject.name = "fs"

file(rootDir).listFiles()
  ?.filter { it.isDirectory }
  ?.filter { it.name.matches(Regex("fs-(?!(recycle|draft)).*")) }
  ?.forEach { include(":${it.name}") }
// include ":docs"
// include ":tests"