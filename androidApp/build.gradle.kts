plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared:logic"))
                implementation(project(":shared:ui"))

                // Logger (for initialization)
                implementation("io.github.aakira:napier:2.6.1")

                // Koin
                implementation("io.insert-koin:koin-android:3.5.0")
                implementation("io.insert-koin:koin-androidx-compose:3.5.0")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.valllent.art"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "com.valllent.art.MyApplication"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    packaging {
        resources.merges.add("META-INF/INDEX.LIST") // Fix Napier
    }
    kotlin {
        jvmToolchain(17)
    }
}
