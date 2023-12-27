plugins {
    id("composenavigationargs.primitive.android")
    id("composenavigationargs.primitive.android.kotlin")
    id("kotlin-parcelize")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.21"
}

android.namespace = "com.morayl.composenavigationargs.core.model"

dependencies {
    implementation(libs.kotlinSerializationJson)
}