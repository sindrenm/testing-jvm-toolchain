plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
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

kotlin {
    jvmToolchain {
        vendor.set(JvmVendorSpec.AZUL)
        languageVersion.set(JavaLanguageVersion.of(19))
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core)
    implementation(libs.google.material)

    testImplementation(libs.junit4)

    androidTestImplementation(libs.androidx.test.espresso)
    androidTestImplementation(libs.androidx.test.junit)
}
