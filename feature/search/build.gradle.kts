plugins {
    id("composenavigationargs.convention.androidfeature")
}

android.namespace = "com.morayl.composenavigationargs.feature.search"

dependencies {
    implementation(libs.composeHiltNavigtation)
    implementation(libs.composeMaterialIcon)
}
