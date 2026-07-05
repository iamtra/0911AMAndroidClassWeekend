plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "kh.com.pheaktra.developer.android.network"
    compileSdk = 37

    defaultConfig {
        minSdk = 29

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    flavorDimensions += "environment"
    productFlavors {
        create("dev") {
            dimension = "environment"

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
        }

        create("prod") {
            dimension = "environment"
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
        }
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
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    // Di
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation.compose)

    // Retrofit
    implementation(libs.retrofit.client)
    implementation(libs.retrofit.converter.kotlinx.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.logging.interceptor)

    implementation(project(":core:model"))
    implementation(project(":core:common"))

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}