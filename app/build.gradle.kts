plugins {
    id(GradlePluginId.ANDROID_APP)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.DAGGER_HILT)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.KSP) version Versions.KSP
/*    // Make sure that you have the Google service   zs Gradle plugin
    id("com.google.gms.google-services")
    // Add the Crashlytics Gradle plugin
    id("com.google.firebase.crashlytics")*/
    id(GradlePluginId.KOTLIN_PARCELIZE)
}

android {
    namespace = ConfigData.namespace
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = ConfigData.applicationId
        buildToolsVersion = "33.0.0"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
//        compileSdkPreview = ConfigData.compileSdkPreview

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }
        create("benchmark") {
            initWith(buildTypes.getByName("release"))
            matchingFallbacks += listOf("release")
            isDebuggable = false
            signingConfig = signingConfigs.getByName("debug")
        }
        release {
            isMinifyEnabled = ConfigData.isMinify
            isShrinkResources = ConfigData.isShrink
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    /*
            kotlin {
                jvmToolchain {
                    this.languageVersion.set(JavaLanguageVersion.of(1.8))
                }
            }
    */
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.kotlinCompilerExtensionVersion
    }
    applicationVariants.all {
        kotlin.sourceSets {
            getByName(name) {
                kotlin.srcDir("build/generated/ksp/$name/kotlin")
            }
        }
    }
    packagingOptions {
        resources.excludes.add("META-INF/INDEX.LIST")
    }
}
dependencies {

    api(project(":components:product"))
    //Imported Modules
    api(project(":features:purchase"))
    api(project(":core:commonComponents:database"))
    api(project(":core:commonComponents:network"))
    api(project(":core:commonFeatures:designSystem"))
    api(project(":core:commonFeatures:ui"))

    api(platform("org.jetbrains.kotlin:kotlin-bom:1.9.0"))


    //Utils
    implementation(Dependencies.animationLib)
    implementation(Dependencies.WEB_BROWSER)


    // Zoho
    /*    implementation (platform(Dependencies.zohoBom))
        implementation(Dependencies.zohoAppticsRC)*/

    //Unit Testing
    testImplementation(Dependencies.junit4)
    testImplementation(Dependencies.junitExtensionsKtx)
    testImplementation(Dependencies.truth)
    testImplementation(Dependencies.mockk)
//    testImplementation(Dependencies.robolectric)
    testImplementation(Dependencies.androidArchCoreTest)
    testImplementation(Dependencies.coroutinesTest)

    //UI Testing
    androidTestImplementation(Dependencies.junitExtensions)
    androidTestImplementation(Dependencies.espressoCore)
    androidTestImplementation(Dependencies.composeUiTest)


    implementation(Dependencies.googleMapPlaces)

    //compose - Hilt
    api(Dependencies.hiltNavigationCompose)

    //DI-Hilt
    api(Dependencies.daggerHilt)
    kapt(Dependencies.daggerHiltCompiler)
    api(Dependencies.HILT_WORKER)
    kapt(Dependencies.HILT_COMPILER)
    api(Dependencies.HILT)
    api(Dependencies.SPASH_SCREEN)

    // Leak Canary
    debugImplementation("com.squareup.leakcanary:leakcanary-android:3.0-alpha-1")

    // Import the Firebase BoM
    implementation(platform("com.google.firebase:firebase-bom:32.8.1"))
    implementation("com.google.firebase:firebase-crashlytics-ktx")
    implementation("com.google.firebase:firebase-analytics-ktx")
    implementation("androidx.profileinstaller:profileinstaller:1.3.0-alpha02")

    // ui tracing
    implementation("androidx.compose.runtime:runtime-tracing:1.0.0-beta01")
}
kapt {
    correctErrorTypes = true
}


