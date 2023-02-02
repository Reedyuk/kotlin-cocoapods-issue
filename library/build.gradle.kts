plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
}

group = "com.myunidays"
version = "1.0-SNAPSHOT"

kotlin {
    ios {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    iosSimulatorArm64 {
        binaries {
            framework {
                baseName = "library"
            }
        }
    }
    cocoapods {
        ios.deploymentTarget = "11.0"
        framework {
            isStatic = true
        }
        noPodspec()
        pod("FirebaseCore") {
            version = "10.4.0"
        }
        pod("FirebaseFirestore") {
            version = "10.4.0"
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:1.4.1")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val iosMain by getting
        val iosSimulatorArm64Main by getting
        iosSimulatorArm64Main.dependsOn(iosMain)
        val iosTest by sourceSets.getting
        val iosSimulatorArm64Test by getting
        iosSimulatorArm64Test.dependsOn(iosTest)
    }
}
