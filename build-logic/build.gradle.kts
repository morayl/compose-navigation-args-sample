import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "com.morayl.composenavigationargs.buildlogic"

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

// If we use jvmToolchain, we need to install JDK 11
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = "11"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    implementation(libs.bundles.plugins)
    // https://github.com/google/dagger/issues/3068#issuecomment-1470534930
    implementation(libs.javaPoet)
}

gradlePlugin {
    plugins {
        // Primitives
        register("androidApplication") {
            id = "composenavigationargs.primitive.androidapplication"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidApplicationPlugin"
        }
        register("android") {
            id = "composenavigationargs.primitive.android"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidPlugin"
        }
        register("androidKotlin") {
            id = "composenavigationargs.primitive.android.kotlin"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidKotlinPlugin"
        }
        register("androidCompose") {
            id = "composenavigationargs.primitive.android.compose"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidComposePlugin"
        }
        register("androidHilt") {
            id = "composenavigationargs.primitive.android.hilt"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidHiltPlugin"
        }
        register("androidCrashlytics") {
            id = "composenavigationargs.primitive.android.crashlytics"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidCrashlyticsPlugin"
        }
        register("androidFirebase") {
            id = "composenavigationargs.primitive.android.firebase"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidFirebasePlugin"
        }
        register("androidRoborazzi") {
            id = "composenavigationargs.primitive.android.roborazzi"
            implementationClass = "com.morayl.composenavigationargs.primitive.AndroidRoborazziPlugin"
        }
        register("detekt") {
            id = "composenavigationargs.primitive.detekt"
            implementationClass = "com.morayl.composenavigationargs.primitive.DetektPlugin"
        }
        register("oss-licenses") {
            id = "composenavigationargs.primitive.android.osslicenses"
            implementationClass = "com.morayl.composenavigationargs.primitive.OssLicensesPlugin"
        }

        // Conventions
        register("androidFeature") {
            id = "composenavigationargs.convention.androidfeature"
            implementationClass = "com.morayl.composenavigationargs.convention.AndroidFeaturePlugin"
        }
    }
}
