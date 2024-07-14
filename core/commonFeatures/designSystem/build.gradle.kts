plugins {
    id(GradlePluginId.ANDROID_LIB)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.KSP) version Versions.KSP
}

android {
    namespace = ConfigData.namespaceDesignSystem
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = ConfigData.isMinify
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
    // compose
    // Timber
    api(Dependencies.timber)
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
//    implementation("io.github.theapache64:rebugger:1.0.0-rc03")
    //Json
    api(Dependencies.moshi)
    kapt(Dependencies.moshiCodegen)
    api("com.squareup.moshi:moshi-kotlin:1.14.0")
    api(Dependencies.gson)
    api(Dependencies.retrofitGson)
}