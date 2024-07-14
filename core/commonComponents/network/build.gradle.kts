import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc


plugins {
    id(GradlePluginId.ANDROID_LIB)
    id(GradlePluginId.KOTLIN_ANDROID)
    id(GradlePluginId.KOTLIN_KAPT)
    id(GradlePluginId.PROTO_BUF)
}

android {
    namespace = ConfigData.namespaceNetwork
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
    packagingOptions {
        resources.excludes.add("META-INF/*")
    }
}

dependencies {

//    api(project(":core:commonFeatures:designSystem"))
    api(project(":core:commonComponents:database"))
    api(Dependencies.timber)
    api(Dependencies.COLLECTION)
    api(Dependencies.DATE_TIME)
    //Json
    api(Dependencies.moshi)
    kapt(Dependencies.moshiCodegen)
    api("com.squareup.moshi:moshi-kotlin:1.14.0")
    api(Dependencies.gson)
    api(Dependencies.retrofitGson)

    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9")
    api( "com.squareup.okhttp3:logging-interceptor:4.11.0")

    //Threading-Coroutines
    api(Dependencies.coroutinesCore)
    api(Dependencies.coroutinesCoreAndroid)

    // network
    api(Dependencies.retrofit)
    api(Dependencies.okHttp)


    //DI-Hilt
//    api(Dependencies.daggerHilt)
/*    kapt(Dependencies.daggerHiltCompiler)
    api(Dependencies.HILT_WORKER)
    kapt(Dependencies.HILT_COMPILER)
    api(Dependencies.HILT)
    api(Dependencies.AZURE)*/

    // pagination

    api(Dependencies.PAGINATION)
    api(Dependencies.PAGINATION_COMPOSE)

    // protoBuf
    api("io.grpc:grpc-okhttp:1.61.1")
    api("io.grpc:grpc-protobuf-lite:1.61.1")
    api("io.grpc:grpc-stub:1.61.1")
    compileOnly("org.apache.tomcat:annotations-api:6.0.53")
}
protobuf {
//    generatedFilesBaseDir = "$projectDir/generated"
    protoc {
        if (osdetector.os == "osx") {
            artifact = "com.google.protobuf:protoc:3.25.1:osx-x86_64"
        } else {
            artifact = "com.google.protobuf:protoc:3.25.1"
        }
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.61.1"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                create("java") {
                    option("lite")
                }
                task.plugins {
                    create("grpc") {
                        option("lite")
                    }
                }
            }
        }
    }
}
