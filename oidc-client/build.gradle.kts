plugins {
    `maven-publish`

    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

kotlin {
    jvm {
        withJava()
    }
    js(IR) {
        browser {
            binaries.library()
        }
    }
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":oidc-spec-oauth"))
                implementation(project(":oidc-spec-openid"))
                implementation(project(":oidc-spec-serial"))

                implementation(kotlin("stdlib"))

                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.datetime)

                implementation(libs.ktor.serialization.kotlinx.json)

                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.contentNegotiation)
                implementation(libs.ktor.client.logging)
            }
        }
        commonTest {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}
