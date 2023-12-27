plugins {
    id("composenavigationargs.convention.androidfeature")
}

android.namespace = "com.morayl.composenavigationargs.feature.search"

dependencies {
    implementation(projects.core.model)
    implementation(libs.composeHiltNavigtation)
    implementation(libs.composeMaterialIcon)
}
