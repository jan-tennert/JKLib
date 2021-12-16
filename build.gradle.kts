plugins {
    kotlin("multiplatform") version "1.6.10"
    kotlin("plugin.serialization") version "1.6.10"
}

group = "io.github.jan.jklib"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
    }
    js(IR)
    mingwX64()
    sourceSets {
        val commonMain by getting {
            dependencies {
                // https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-coroutines-core
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-RC2")
            }
        }
        val jvmMain by getting
        val jsMain by getting
    }
}
