plugins {
    id("composenavigationargs.primitive.androidapplication")
    id("composenavigationargs.primitive.android.kotlin")
    id("composenavigationargs.primitive.android.compose")
    id("composenavigationargs.primitive.android.hilt")
    id("composenavigationargs.primitive.android.firebase")
    id("composenavigationargs.primitive.android.crashlytics")
    id("composenavigationargs.primitive.detekt")
    id("composenavigationargs.primitive.kover.entrypoint")
    id("composenavigationargs.primitive.android.osslicenses")
}

android {
    namespace = "com.morayl.composenavigationargs"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.morayl.composenavigationargs"
        minSdk = 26
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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

    implementation(libs.composeNavigation)
    implementation(libs.composeHiltNavigtation)
    implementation(libs.composeMaterialWindowSize)
    implementation(libs.androidxBrowser)
    implementation(libs.androidxWindow)
    implementation(libs.kermit)
    implementation(libs.androidxSplashScreen)
    implementation(libs.firebaseDynamicLinks)
    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.test.ext.junit)
//    androidTestImplementation(libs.espresso.core)
//    androidTestImplementation(platform(libs.compose.bom))
//    androidTestImplementation(libs.ui.test.junit4)
//    debugImplementation(libs.ui.tooling)
//    debugImplementation(libs.ui.test.manifest)
}