plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.dagger.hilt.android)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.sindrenm.testing.jvmtoolchain"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.sindrenm.testing.jvmtoolchain"

        minSdk = 23
        targetSdk = 33

        versionCode = 1
        versionName = "0.1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
}

kapt {
    correctErrorTypes = true
}

kotlin {
    jvmToolchain {
        vendor.set(JvmVendorSpec.AZUL)
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}

dependencies {
    kapt(libs.dagger.hilt.compiler)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.google.material)

    implementation(libs.dagger.hilt.runtime)

    testImplementation(libs.junit4)

    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.dagger.hilt.testing)
}
