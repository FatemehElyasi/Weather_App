plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "ir.fatemelyasii.weather"
    compileSdk = 34

    defaultConfig {
        applicationId = "ir.fatemelyasii.weather"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    // shimmer:
    implementation(libs.compose.shimmer)

    //Navigation Component
    implementation(libs.androidx.navigation.compose)

    //LiveData-State
    implementation(libs.androidx.runtime.livedata)

    //Coil
    implementation(libs.coil.compose)
    implementation(libs.coil.svg)

    // glide:
    implementation(libs.compose)

    //Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    //Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.fragment)

    // Koin
    implementation (libs.koin.android)
    implementation (libs.koin.androidx.compose)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //Room
    implementation (libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    // Coil
    implementation(libs.coil.compose.v240)

    //System Ui Controller
    implementation(libs.accompanist.systemuicontroller)

    //Lottie
    implementation(libs.lottie.compose)

    //material.icons
    implementation (libs.androidx.material.icons.extended)


}