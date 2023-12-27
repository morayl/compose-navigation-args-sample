plugins {
    id("composenavigationargs.primitive.androidapplication")
    id("composenavigationargs.primitive.android.kotlin")
    id("composenavigationargs.primitive.android.compose")
    id("composenavigationargs.primitive.android.hilt")
    id("composenavigationargs.primitive.detekt")
}

android {
    namespace = "com.morayl.composenavigationargs"

    defaultConfig {
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(projects.feature.search)
    implementation(projects.core.model)
    implementation(projects.core.ui)
    implementation(libs.composeNavigation)
    implementation(libs.composeHiltNavigtation)
    implementation(libs.composeMaterialWindowSize)
    implementation(libs.androidxBrowser)
    implementation(libs.androidxWindow)
    implementation(libs.kermit)
    implementation(libs.androidxSplashScreen)
    testImplementation(libs.junit)
}