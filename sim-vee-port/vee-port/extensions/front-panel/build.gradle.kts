/*
 * Kotlin
 *
 * Copyright 2025 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
 
 plugins {
    id("com.microej.gradle.mock-frontpanel")
}

microej {
    skippedCheckers = "readme,changelog,license"
}

dependencies {
    implementation(libs.frontpanel.framework)
    // Remove this dependency if you remove the UI pack
    implementation(libs.frontpanel.ui.widget)
}
