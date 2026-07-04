plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.com.google.gms.google.services)
}

android {
    namespace = "kh.com.pheaktra.developer.basic.jetpack.compse.weekend"
    compileSdk = 36

    defaultConfig {
        applicationId = "kh.com.pheaktra.developer.basic.jetpack.compse.weekend"
        minSdk = 29
        targetSdk = 36
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    flavorDimensions += "environment"
    buildTypes {
        debug {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    productFlavors {
        create("dev") {
            dimension = "environment"

            applicationIdSuffix = ".dev"
            versionCode = 100
            versionName = "1.0.0"

            resValue("string", "app_name", "[Dev] Master Android")

            buildConfigField(
                "String",
                "BASE_URL",
                "\"http://10.0.2.2\""
            )

            buildConfigField(
                "String",
                "BASE_PORT",
                "\"3500/\""
            )

            buildConfigField(
                "String",
                "ENVIRONMENT",
                "\"DEV\""
            )
        }

        create("uat") {
            dimension = "environment"

            applicationIdSuffix = ".uat"
            versionCode = 100
            versionName = "1.0.0"

            resValue("string", "app_name", "[UAT] Master Android ")

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://uat-api.pheaktra-developer.com/\""
            )

            buildConfigField(
                "String",
                "BASE_PORT",
                "\"8080\""
            )

            buildConfigField(
                "String",
                "ENVIRONMENT",
                "\"UAT\""
            )
        }

        create("prod") {
            dimension = "environment"

            versionCode = 100
            versionName = "1.0.0"

            resValue("string", "app_name", "Master Android")

            buildConfigField(
                "String",
                "BASE_URL",
                "\"https://api.pheaktra-developer.com/\""
            )

            buildConfigField(
                "String",
                "BASE_PORT",
                "\"443\""
            )

            buildConfigField(
                "String",
                "ENVIRONMENT",
                "\"PROD\""
            )
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
        resValues = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
}

kotlin {
    jvmToolchain(21)
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    // jetpack compose navigation3
    implementation(libs.androidx.navigation3.runtime)
    implementation(libs.androidx.navigation3.ui)
    implementation(libs.coil.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.compose.foundation.layout)

    // Retrofit
    implementation(libs.retrofit.client)
    implementation(libs.retrofit.converter.kotlinx.serialization)
//    implementation(libs.converter.gson)
//    implementation(libs.converter.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)
//    implementation(libs.jakewharton.retrofit2.kotlinx.serialization.converter)

    // Coroutines (for suspend functions)
    implementation(libs.kotlinx.coroutines.android)

    // Optional: OkHttp logging interceptor (great for debugging)
    implementation(libs.logging.interceptor)

    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.ui)

    // di
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation.compose)

    // Room database
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)

    // Firebase push notification
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.messaging)


    // Implement local module
    implementation(project(":core"))
    implementation(project(":core:model"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
    implementation(project(":core:network"))
    implementation(project(":core:util"))
    implementation(project(":core:common"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}