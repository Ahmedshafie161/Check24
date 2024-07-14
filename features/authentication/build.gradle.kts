plugins {
    id(GradlePluginId.ANDROID_LIB)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.KSP) version Versions.KSP
    id(GradlePluginId.DAGGER_HILT)
}

android {
    namespace = ConfigData.namespaceAuthentication
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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

    implementation(project(":core:commonFeatures:designSystem"))
    implementation(project(":core:commonFeatures:ui"))
    implementation(project(":components:user"))

    //compose - Hilt
    api(Dependencies.hiltNavigationCompose)

    //DI-Hilt
    api(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
    api (Dependencies.HILT_WORKER)
    kapt (Dependencies.HILT_COMPILER)
    api (Dependencies.HILT)}