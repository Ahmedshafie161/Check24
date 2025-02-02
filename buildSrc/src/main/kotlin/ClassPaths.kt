@file:Suppress("PackageDirectoryMismatch")

import java.net.URI
import org.gradle.api.artifacts.dsl.RepositoryHandler

object ClassPaths {

    const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val daggerHiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.daggerHiltVersion}"
    const val googleServices="com.google.gms:google-services:${Versions.googleServicesVersion}"
    const val crashAnalyticsPlugin =
        "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashAnalyticsPlugin}"
    const val zohoPlugin = "com.zoho.apptics:apptics-plugin:${Versions.zohoPlugin}"
    const val PROTO_BUF = "com.google.protobuf:protobuf-gradle-plugin:${Versions.PROTO_BUF}"
}

fun RepositoryHandler.addRepos() {
    this.google()
    this.mavenCentral()
    this.maven { url = URI.create("https://jitpack.io") }
    flatDir {
        dirs("libs")
    }
}
