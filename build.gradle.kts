import org.jetbrains.kotlin.gradle.frontend.KotlinFrontendExtension
import org.jetbrains.kotlin.gradle.frontend.npm.NpmExtension
import org.jetbrains.kotlin.gradle.frontend.webpack.WebPackExtension

buildscript {
    val kotlinVersion = "1.3.50"

    repositories {
        jcenter()
        mavenCentral()
        maven ("https://dl.bintray.com/kotlin/kotlin-eap")
    }

    dependencies {
        classpath("org.jetbrains.kotlin", "kotlin-gradle-plugin", kotlinVersion)
        classpath("org.jetbrains.kotlin", "kotlin-frontend-plugin", "0.0.45")
    }
}

allprojects {
    group = "io.usoamic"
    version = "1.0.5"
}

plugins {
    id("kotlin2js") version "1.3.50"
    id("kotlin-dce-js") version "1.3.50"
    id("org.jetbrains.kotlin.frontend") version "1.3.50"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    compile(kotlin("stdlib-js"))
}

configure<KotlinFrontendExtension> {
    downloadNodeJsVersion = "latest"
    bundle("webpack", delegateClosureOf<WebPackExtension> {
        bundleName = "main"
    })
}

configure<NpmExtension> {
    dependency("toastr", "^2.1.4")
    dependency("jquery", "^3.2.0-0")
    dependency("datatables.net-bs4", "^1.10.19")
    dependency("qrcode", "^1.4.1")
}

tasks {
    compileKotlin2Js {
        kotlinOptions {
            metaInfo = true
            sourceMap = false
            moduleKind = "commonjs"
            main = "call"
            suppressWarnings = false
        }
    }
}
