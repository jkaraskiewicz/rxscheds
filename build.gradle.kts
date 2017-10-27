buildscript {
  repositories {
    jcenter()
    google()
  }
  dependencies {
    classpath("com.android.tools.build:gradle:3.0.0")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1.51")
  }
}

allprojects {
  repositories {
    jcenter()
    google()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
    maven("https://jitpack.io")
  }
}

tasks {
  "clean"(Delete::class) {
    delete(buildDir)
  }
  "wrapper"(Wrapper::class) {
    gradleVersion = "4.2.1"
  }
}
