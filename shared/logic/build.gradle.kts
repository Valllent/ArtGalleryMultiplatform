plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("com.android.library")
}

kotlin {
    androidTarget()
    jvm("desktop")

    sourceSets {
        val commonMain by getting {
            dependencies {
                // Ktor
                implementation("io.ktor:ktor-client-core:2.3.3")
                implementation("io.ktor:ktor-client-logging:2.3.3")
                implementation("ch.qos.logback:logback-classic:1.3.11")
                // Ktor Serialization
                implementation("io.ktor:ktor-client-serialization:2.3.3")
                implementation("io.ktor:ktor-client-content-negotiation:2.3.3")
                implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.3")

                // Logger
                implementation("io.github.aakira:napier:2.6.1")

                // Koin
                implementation("io.insert-koin:koin-core:3.1.5")
            }
        }
        val androidMain by getting {
            dependencies {
                // Default
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.10.1")

                // Ktor
                implementation("io.ktor:ktor-client-android:2.3.3")
            }
        }
        val desktopMain by getting {
            dependencies {
                // Ktor
                implementation("io.ktor:ktor-client-okhttp:2.3.3")
            }
        }
        val commonTest by getting {
            dependencies {
                // Koin
                implementation("io.insert-koin:koin-test:3.1.5")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.valllent.art.common.logic"

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
