import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent

repositories {
    google()
    mavenCentral()
}

plugins {
    kotlin("multiplatform") version "1.8.0" apply false
    kotlin("native.cocoapods") version "1.8.0" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
    }
}

val targetSdkVersion by extra(32)
val minSdkVersion by extra(19)

subprojects {

    group = "uk.co.andrewreed"

    repositories {
        mavenLocal()
        google()
        mavenCentral()
    }

    tasks.withType<Sign>().configureEach {
        onlyIf { !project.gradle.startParameter.taskNames.contains("publishToMavenLocal") }
    }


    apply(plugin="maven-publish")
}
