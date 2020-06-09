import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackOutput.Target.COMMONJS

object Version {
    val toastr = "^2.1.4"
    val jquery = "^3.2.0-0"
    val datatablesNetBs4 = "^1.10.19"
    val qrcode = "^1.4.1"
}

buildscript {
    val kotlinVersion = "1.3.72"

    repositories {
        jcenter()
        mavenCentral()
        maven ("https://dl.bintray.com/kotlin/kotlin-eap")
    }

    dependencies {
        classpath("org.jetbrains.kotlin", "kotlin-gradle-plugin", kotlinVersion)
    }
}

allprojects {
    group = "io.usoamic"
    version = "1.0.1"
}

plugins {
    val kotlinVersion = "1.3.72"
    id("org.jetbrains.kotlin.js") version kotlinVersion
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-js"))
}

dependencies {
    implementation(kotlin("stdlib-js"))

    implementation(npm("toastr", Version.toastr))
    implementation(npm("jquery", Version.jquery))
    implementation(npm("datatables.net-bs4", Version.datatablesNetBs4))
    implementation(npm("qrcode", Version.qrcode))
}

kotlin {
    target {
        browser {
            webpackTask {
                output.libraryTarget = COMMONJS
                //output.libraryTarget = "commonjs" // alternative
            }
        }
    }
}