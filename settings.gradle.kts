pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        mavenLocal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        maven {
            url = uri("https://jitpack.io")
        }
        maven {
            url = uri("https://maven.zohodl.com/")
        }
    }
}

rootProject.name = "Check24"
include(":app")

include(":features")
include(":components")
include(":core:commonComponents")
include(":core:commonFeatures")
include(":core:commonFeatures:ui")
include(":core:commonFeatures:designSystem")
include(":core:commonComponents:network")
include(":core:commonComponents:database")
include(":benchmark")
include(":features:authentication")
include(":components:user")
