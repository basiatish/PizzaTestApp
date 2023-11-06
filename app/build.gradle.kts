plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.basiatish.hammersystemstestapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.basiatish.hammersystemstestapp"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "BASE_API","\"https://menu-test-app-default-rtdb.firebaseio.com/\"")
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
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("com.google.dagger:dagger:2.42")
    kapt("com.google.dagger:dagger-compiler:2.42")

    implementation(platform("com.google.firebase:firebase-bom:32.3.1"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-storage-ktx:20.3.0")
    implementation("com.firebaseui:firebase-ui-storage:8.0.2")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

    implementation("com.github.bumptech.glide:glide:4.13.0")
    kapt("com.github.bumptech.glide:compiler:4.13.0")
}