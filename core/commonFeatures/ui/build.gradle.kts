plugins {
    id(GradlePluginId.ANDROID_LIB)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.KSP) version Versions.KSP
}

android {
    namespace = ConfigData.namespaceUi
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = ConfigData.isMinify
            isShrinkResources = ConfigData.isShrink
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
}

dependencies {
    api(project(":core:commonFeatures:designSystem"))
    api(project(":core:commonComponents:network"))

    api (Dependencies.KOTLIN_EXTENTION_CORE)
    api (Dependencies.COLLECTION)
    api (Dependencies.DATE_TIME)
    api(platform("org.jetbrains.kotlin:kotlin-bom:1.9.0"))
    api("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.7")

    //UI
    api(Dependencies.material)
    api(Dependencies.constraintLayout)
    api(Dependencies.swipeRefreshLayout)
//    api (Dependencies.ACTIVITY_EXTENTION)
//    api (Dependencies.ACTIVITY)
    api (Dependencies.FRAGMENT)
    api (Dependencies.PALETTE)


    //Lifecycle
    api(Dependencies.lifecycle_viewmodel)
    api(Dependencies.lifecycle_liveData)
    api(Dependencies.lifecycle_runtime)

    //Navigation Component
    api (Dependencies.navigationComponent)
    api (Dependencies.navigationComponentFrag)

    //UI background
//    implementation (Dependencies.WORKER)

    //UI Backward Compatibility
//    api(Dependencies.appCompat)
    api (Dependencies.legacy)

    // compose

    api (Dependencies.COMPOSE_NAVIGATION)
    api (Dependencies.composeActivity)
    api (Dependencies.COMPOSE_UI)
    api (Dependencies.COMPOSE_UI_UTIL)
    api (Dependencies.COMPOSE_MATERIAL3)
    api (Dependencies.CONSTRAINT_LAYOUT_Compose)
    api (Dependencies.ACTIVITY_COMPOSE)
    api (Dependencies.COMPOSE_MATERIAL)
    api (Dependencies.COMPOSE_MATERIAL_ICONS_EXTENDED)
    api (Dependencies.COMPOSE_UI_TOOLING)
    api (Dependencies.COMPOSE_UI_TOOLING_PREVIEW)
    api (Dependencies.COMPOSE_VIEW_MODEL)
    api (Dependencies.lottieCompose)
    api (Dependencies.googleMapCompose)
    api (Dependencies.googleMapComposeUtils)
    api(Dependencies.lifecycle_compose)
    api(platform("androidx.compose:compose-bom:2024.01.00"))

    // compose accompanist
    api (Dependencies.PAGER)
    api (Dependencies.PAGER_INDICATORS)
    api (Dependencies.SYSTEM_UI_CONTROLLER)
    api(Dependencies.accompanistSwipeRefresh)

    // compose destination
    ksp (Dependencies.COMPOSE_DESTINATION_KSP)
    api (Dependencies.COMPOSE_DESTINATION)
    api (Dependencies.DESTINATIONS_ANIM)

    // compose debug
    api("io.github.theapache64:rebugger:1.0.0-rc02")

    //compose - Hilt
    api(Dependencies.hiltNavigationCompose)

    //DI-Hilt
    api(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
    api (Dependencies.HILT_WORKER)
    kapt (Dependencies.HILT_COMPILER)
    api (Dependencies.HILT)

    // ExoPlayer


    // For media playback using ExoPlayer
    api("androidx.media3:media3-exoplayer:${Versions.media3_version}")

    // For DASH playback support with ExoPlayer
    api("androidx.media3:media3-exoplayer-dash:${Versions.media3_version}")
    // For HLS playback support with ExoPlayer
    api("androidx.media3:media3-exoplayer-hls:${Versions.media3_version}")
    // For RTSP playback support with ExoPlayer
    api("androidx.media3:media3-exoplayer-rtsp:${Versions.media3_version}")
    // For ad insertion using the Interactive Media Ads SDK with ExoPlayer
    api("androidx.media3:media3-exoplayer-ima:${Versions.media3_version}")

    // For loading data using the Cronet network stack
    api("androidx.media3:media3-datasource-cronet:${Versions.media3_version}")
    // For loading data using the OkHttp network stack
    api("androidx.media3:media3-datasource-okhttp:${Versions.media3_version}")
    // For loading data using librtmp
    api("androidx.media3:media3-datasource-rtmp:${Versions.media3_version}")

    // For building media playback UIs
    api("androidx.media3:media3-ui:${Versions.media3_version}")
    // For building media playback UIs for Android TV using the Jetpack Leanback library
    api("androidx.media3:media3-ui-leanback:${Versions.media3_version}")

    // For exposing and controlling media sessions
    api("androidx.media3:media3-session:${Versions.media3_version}")

    // For extracting data from media containers
    api("androidx.media3:media3-extractor:${Versions.media3_version}")

    // For integrating with Cast
    api("androidx.media3:media3-cast:${Versions.media3_version}")

    // For scheduling background operations using Jetpack Work's WorkManager with ExoPlayer
    api("androidx.media3:media3-exoplayer-workmanager:${Versions.media3_version}")

    // For transforming media files
    api("androidx.media3:media3-transformer:${Versions.media3_version}")

    // Utilities for testing media components (including ExoPlayer components)
    api("androidx.media3:media3-test-utils:${Versions.media3_version}")
    // Utilities for testing media components (including ExoPlayer components) via Robolectric
//    api("androidx.media3:media3-test-utils-robolectric:${Versions.media3_version}")

    // Common functionality for media database components
    api("androidx.media3:media3-database:${Versions.media3_version}")
    // Common functionality for media decoders
    api("androidx.media3:media3-decoder:${Versions.media3_version}")
    // Common functionality for loading data
    api("androidx.media3:media3-datasource:${Versions.media3_version}")
    // Common functionality used across multiple media libraries
    api("androidx.media3:media3-common:${Versions.media3_version}")


    // image loader
    api (Dependencies.COIL)
    api ("com.github.bumptech.glide:compose:1.0.0-alpha.1")


    // capture camera
    val cameraxVersion = "1.2.0-beta01"

    api("androidx.camera:camera-core:$cameraxVersion")
    api("androidx.camera:camera-camera2:$cameraxVersion")
    api("androidx.camera:camera-lifecycle:$cameraxVersion")
    api("androidx.camera:camera-video:$cameraxVersion")

    api("androidx.camera:camera-view:$cameraxVersion")
    api("androidx.camera:camera-extensions:$cameraxVersion")
    api(Dependencies.ACCOMPANIST_PERMISSION)

    // edge to edge
    api(Dependencies.ACTIVITY_X)
}