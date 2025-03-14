/*
 * Kotlin
 *
 * Copyright 2023-2025 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
rootProject.name = "foundation"
include("audio.record")
include("audio.track")
include("bluetooth.central")
include("bluetooth.peripheral")
include("bon.immortals")
include("bon.immutables")
include("drawing.antialiased")
include("drawing.transform")
include("ecom.hotplug")
include("ecom.reader")
include("ecom.writer")
include("edc.helloworld")
include("fs.helloworld")
include("hal.gpio")
include("microui.font")
include("microui.helloworld")
include("microui.gradient")
include("microui.image")
include("microui.input")
include("microui.led")
include("microui.movableimage")
include("microui.mvc")
include("microui.out")
include("net.echo")
include("net.helloworld")

// Include VEE Port for SIM
include("sim-vee-port", "sim-vee-port:front-panel")

project(":sim-vee-port:front-panel").projectDir = file("sim-vee-port/vee-port/extensions/front-panel")
project(":sim-vee-port").projectDir = file("sim-vee-port/vee-port")
