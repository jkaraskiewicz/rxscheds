import com.android.build.gradle.AppExtension

apply {
  plugin("com.android.application")
  plugin("kotlin-android")
  plugin("kotlin-android-extensions")
  plugin("kotlin-kapt")
}

the<AppExtension>().apply {
  compileSdkVersion(26)
  buildToolsVersion = "26.0.2"

  defaultConfig {
    applicationId = "com.karaskiewicz.rxscheds"
    minSdkVersion(16)
    targetSdkVersion(25)
    versionCode = 1
    versionName = "1.0"
  }

  buildTypes {
    maybeCreate("debug").apply {
      isMinifyEnabled = false
      isDebuggable = true
    }
    maybeCreate("release").apply {
      isMinifyEnabled = true
      setProguardFiles(listOf(getDefaultProguardFile("proguard-android.txt"), "../proguard-rules.pro"))
    }
  }

  sourceSets {
    maybeCreate("main").apply {
      java.srcDir("src/main/kotlin")
    }
  }

  lintOptions {
    isAbortOnError = false
  }
}

dependencies {
  "implementation"("org.jetbrains.kotlin:kotlin-stdlib:1.1.51")

  "implementation"("com.android.support:appcompat-v7:27.0.0")
  "implementation"("com.android.support:support-annotations:27.0.0")

  "implementation"("com.google.dagger:dagger:2.12")
  "kapt"("com.google.dagger:dagger-compiler:2.12")

  "implementation"("com.jakewharton:butterknife:8.8.1")
  "kapt"("com.jakewharton:butterknife-compiler:8.8.1")

  "implementation"("com.jakewharton.timber:timber:4.5.1")

  "implementation"("io.reactivex.rxjava2:rxjava:2.1.5")

  "implementation"("io.reactivex.rxjava2:rxandroid:2.0.1")

  "implementation"("com.jakewharton.rxbinding2:rxbinding:2.0.0")
  "implementation"("com.jakewharton.rxbinding2:rxbinding-support-v4:2.0.0")
  "implementation"("com.jakewharton.rxbinding2:rxbinding-appcompat-v7:2.0.0")
  "implementation"("com.jakewharton.rxbinding2:rxbinding-kotlin:2.0.0")
  "implementation"("com.jakewharton.rxbinding2:rxbinding-support-v4-kotlin:2.0.0")
  "implementation"("com.jakewharton.rxbinding2:rxbinding-appcompat-v7-kotlin:2.0.0")

  "implementation"("javax.inject:javax.inject:1")

  "compileOnly"("javax.annotation:javax.annotation-api:1.3")
}
