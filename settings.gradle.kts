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
  ?.filter { it.name.matches(Regex("fsh-(?!(recycle|draft|apps)).*")) }
  ?.forEach { include(":${it.name}") }
file(file("${rootDir.path}/fsh-apps")).listFiles()
  ?.filter { it.isDirectory }
  //?.filter { it.name.matches(Regex("starter-.*")) }
  ?.forEach { include(":fsh-apps:${it.name}") }