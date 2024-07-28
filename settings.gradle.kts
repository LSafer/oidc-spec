pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

rootProject.name = "oidc-spec"

// include directories that starts with "oidc-"
for (file in rootDir.listFiles().orEmpty()) {
    if (file.isDirectory && file.name.startsWith("oidc-")) {
        include(":${file.name}")
    }
}
