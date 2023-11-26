plugins {
    kotlin("multiplatform") version libs.versions.kotlin apply false
    kotlin("plugin.serialization") version libs.versions.kotlin apply false
}

group = "net.lsafer"
version = "1.0.0-snapshot"

tasks.wrapper {
    gradleVersion = "8.2.1"
}

subprojects {
    group = "net.lsafer.identity"

    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

// https://github.com/jitpack/jitpack.io/issues/3853#issuecomment-1683838845
rootProject.plugins.withType(org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootPlugin::class.java) {
    rootProject.the<org.jetbrains.kotlin.gradle.targets.js.nodejs.NodeJsRootExtension>().nodeVersion = "16.0.0"
}
