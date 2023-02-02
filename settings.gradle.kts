include(
    "library"
)
rootProject.name = "Cocoapods-Issue"

pluginManagement {

    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/bootstrap")
        maven("https://oss.sonatype.org/content/repositories/snapshots/")
    }

    plugins {
        kotlin("multiplatform") version "1.8.20-dev-649" apply false
        kotlin("native.cocoapods") version "1.8.20-dev-649" apply false
    }
}
