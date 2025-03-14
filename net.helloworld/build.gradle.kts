/*
 * Kotlin
 *
 * Copyright 2023-2025 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */

group = "com.microej.example.foundation.net"
version = "3.2.0"

plugins {
    id("com.microej.gradle.application") version libs.versions.microej.sdk
}

microej {
    applicationEntryPoint = providers.systemProperty("customApplicationEntryPoint").getOrElse("com.microej.example.foundation.net.helloworld.ExampleClient")
    skippedCheckers = "nullanalysis"
}

dependencies {
    /*
    * Put your project dependencies here. An example of project dependency declaration is provided below:
    *
    * implementation("[org]:[otherArtifact]:[M.m.p]")
    * e.g.: implementation("ej.library.runtime:basictool:1.7.0")
    */
    implementation(libs.api.edc)
    implementation(libs.api.bon)
    implementation(libs.api.net)
    implementation(libs.library.logging)

    /*
    * Put your test dependencies here. An example of test dependency declaration is provided below:
    *
    * testImplementation("[org]:[otherArtifact]:[M.m.p]")
    * e.g.: testImplementation("ej.library.test:junit:1.7.1")
    */

    /*
    * To use a VEE Port published in an artifact repository use this VEE Port dependency.
    */
    microejVee(libs.vee.port.nxp.mimxrt1170)

    /*
    * To use a local VEE Port, uncomment the property below, set the path of the platform to use and comment the published microejVee dependency (see above).
    * To use an Archived VEE Port, point the path directly to the Archive instead of a source folder: "C:\\path\\to\\my\\veePort\\file.zip".
    */
    // microejVee(files("C:\\path\\to\\my\\veePort\\source"))
}

tasks.register<GradleBuild>("runOnSimulator-Server") {
    group = "microej"
    tasks = listOf("runOnSimulator")
    System.setProperty("customApplicationEntryPoint", "com.microej.example.foundation.net.helloworld.ExampleServer")

}

tasks.register<GradleBuild>("runOnDevice-Server") {
    group = "microej"
    tasks = listOf("runOnDevice")
    System.setProperty("customApplicationEntryPoint", "com.microej.example.foundation.net.helloworld.ExampleServer")

}