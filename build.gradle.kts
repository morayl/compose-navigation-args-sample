import org.gradle.api.tasks.Delete

plugins {
    alias(libs.plugins.androidGradlePlugin) apply false
    alias(libs.plugins.androidGradleLibraryPlugin) apply false
    alias(libs.plugins.kotlinGradlePlugin) apply false
    alias(libs.plugins.kotlinxKover) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
