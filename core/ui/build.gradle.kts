plugins {
    id("composenavigationargs.primitive.android")
    id("composenavigationargs.primitive.android.kotlin")
    id("composenavigationargs.primitive.android.compose")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.21"
}

android.namespace = "com.morayl.composenavigationargs.core.ui"

dependencies {
    implementation(projects.core.model)
    implementation(libs.composeNavigation)
    implementation(libs.kotlinSerializationJson)
}