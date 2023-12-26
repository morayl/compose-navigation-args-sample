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
        register("kotlinMpp") {
            id = "composenavigationargs.primitive.kmp"
            implementationClass = "com.morayl.composenavigationargs.primitive.KmpPlugin"
        }
        register("kotlinMppIos") {
            id = "composenavigationargs.primitive.kmp.ios"
            implementationClass = "com.morayl.composenavigationargs.primitive.KmpIosPlugin"
        }
        register("kotlinMppAndroid") {
            id = "composenavigationargs.primitive.kmp.android"
            implementationClass = "com.morayl.composenavigationargs.primitive.KmpAndroidPlugin"
        }
        register("kotlinMppCompose") {
            id = "composenavigationargs.primitive.kmp.compose"
            implementationClass = "com.morayl.composenavigationargs.primitive.KmpComposePlugin"
        }
        register("kotlinMppKtorfit") {
            id = "composenavigationargs.primitive.kmp.ktorfit"
            implementationClass = "com.morayl.composenavigationargs.primitive.KmpKtorfitPlugin"
        }
        register("kotlinMppAndroidHilt") {
            id = "composenavigationargs.primitive.kmp.android.hilt"
            implementationClass = "com.morayl.composenavigationargs.primitive.KmpAndroidHiltPlugin"
        }
        register("kotlinMppAndroidShowkase") {
            id = "composenavigationargs.primitive.kmp.android.showkase"
            implementationClass = "com.morayl.composenavigationargs.primitive.KmpAndroidShowkasePlugin"
        }
        register("kotlinMppKotlinSerialization") {
            id = "composenavigationargs.primitive.kmp.serialization"
            implementationClass = "com.morayl.composenavigationargs.primitive.KotlinSerializationPlugin"
        }
        register("koverEntryPoint") {
            id = "composenavigationargs.primitive.kover.entrypoint"
            implementationClass = "com.morayl.composenavigationargs.primitive.KoverEntryPointPlugin"
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
