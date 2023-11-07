plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

@OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
kotlin {
    androidTarget()
    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Logic
                implementation(project(":shared:logic"))

                // Default Compose
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.animation)
                implementation(compose.material)
                implementation(compose.components.resources)

                // Koin
                implementation("io.insert-koin:koin-core:3.5.0")
                implementation("io.insert-koin:koin-compose:1.1.0")

                // Logger
                implementation("io.github.aakira:napier:2.6.1")

                // Image downloader
                implementation("media.kamel:kamel-image:0.8.2")

                // Compose Navigation
                implementation("moe.tlaster:precompose:1.5.5")
                implementation("moe.tlaster:precompose-viewmodel:1.5.5")
                implementation("moe.tlaster:precompose-koin:1.5.5")
            }
        }
        val androidMain by getting {
            dependencies {
                // Default
                api("androidx.activity:activity-compose:1.7.2")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.10.1")

                // ViewModel scope
                implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
            }
        }
        val desktopMain by getting {
            dependencies {
                implementation(compose.desktop.common)
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.valllent.art.shared.ui"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}
