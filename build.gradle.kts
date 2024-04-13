plugins {
    kotlin("multiplatform") version libs.versions.kotlin apply false
    kotlin("plugin.serialization") version libs.versions.kotlin apply false
}

group = "net.lsafer"
version = "1.0.0"

tasks.wrapper {
    gradleVersion = "8.2.1"
}

subprojects {
    group = "net.lsafer.oidc"

    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
