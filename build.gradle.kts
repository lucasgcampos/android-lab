buildscript {

    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(ClassPath.gradle)
        classpath(ClassPath.kotlin)
    }
}

plugins {
    id("io.gitlab.arturbosch.detekt") version "1.0.0-RC14"
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    apply(from = "$rootDir/tools/jacoco/jacoco-task.gradle")
}

tasks.register("clean",Delete::class) {
    delete(rootProject.buildDir)
}

apply(from = "$rootDir/tools/detekt/detekt-config.gradle")
apply(from = "$rootDir/tools/jacoco/merge-report-task.gradle")
