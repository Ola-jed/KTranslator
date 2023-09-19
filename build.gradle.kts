import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version "1.9.0"
}

group = "bj.ola"
version = "1.0-SNAPSHOT"
val decomposeVersion = "2.0.1"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("com.arkivanov.decompose:decompose:${decomposeVersion}")
    implementation("com.arkivanov.decompose:extensions-compose-jetbrains:${decomposeVersion}")
}

compose.desktop {
    application {
        mainClass = "MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "KTranslator"
            packageVersion = "1.0.0"
        }
    }
}
