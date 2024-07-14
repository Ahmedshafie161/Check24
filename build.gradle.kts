// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ( "com.android.tools:r8:8.2.47" )
        classpath (ClassPaths.gradle)
        classpath (ClassPaths.kotlinGradlePlugin)
        classpath (ClassPaths.daggerHiltGradlePlugin)
        classpath ("com.google.gms:google-services:4.3.14")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.9")
//        classpath (ClassPaths.crashAnalyticsPlugin)
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.0")
//        classpath (ClassPaths.zohoPlugin)
        classpath (ClassPaths.PROTO_BUF)
    }
}
plugins{
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id(GradlePluginId.KSP) version Versions.KSP apply false
    id("com.android.test") version "7.4.0" apply false
//    id("com.android.library") version "7.4.0" apply false
//    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    /* id("com.google.gms.google-services") version "4.4.1" apply false
     id("com.google.firebase.crashlytics") version "2.9.9" apply false*/
}
subprojects {
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            if (project.findProperty("composeCompilerReports") == "true") {
                freeCompilerArgs += listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:reportsDestination=${project.buildDir.absolutePath}/compose_compiler"
                )
            }
            if (project.findProperty("composeCompilerMetrics") == "true") {
                freeCompilerArgs += listOf(
                    "-P",
                    "plugin:androidx.compose.compiler.plugins.kotlin:metricsDestination=${project.buildDir.absolutePath}/compose_compiler"
                )
            }
        }
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
        compilerOptions.freeCompilerArgs.addAll(
            "-P",
            "plugin:androidx.compose.compiler.plugins.kotlin:experimentalStrongSkipping=true",
        )
    }

}

