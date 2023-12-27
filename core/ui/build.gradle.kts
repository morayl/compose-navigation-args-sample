plugins {
    id("composenavigationargs.primitive.android")
    id("composenavigationargs.primitive.android.kotlin")
    id("composenavigationargs.primitive.android.compose")
    id("kotlin-parcelize")
}

android.namespace = "com.morayl.composenavigationargs.core.ui"

dependencies {
    implementation(libs.composeNavigation)
}