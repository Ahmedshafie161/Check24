plugins {
    id(GradlePluginId.ANDROID_LIB)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
}

android {
    namespace = ConfigData.namespaceDB
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

/*
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
*/
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

//    implementation (Dependencies.KOTLIN_EXTENTION_CORE)
//    api(project(":core:commonComponents:network"))
    api (Dependencies.COLLECTION)
    api (Dependencies.DATE_TIME)
    api("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.7")

    // EncryptedSharedPreferences dependencies
    api ("androidx.security:security-crypto:1.1.0-alpha06")

//    DI-Hilt
    api(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
//    api(Dependencies.HILT_WORKER)
//    kapt(Dependencies.HILT_COMPILER)
//    api(Dependencies.HILT)
    api(Dependencies.AZURE)

    //Json
    api(Dependencies.moshi)
    kapt(Dependencies.moshiCodegen)
    api("com.squareup.moshi:moshi-kotlin:1.14.0")
    api(Dependencies.gson)
    api(Dependencies.retrofitGson)
}