# Overview

This example shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * ECOM-1.1 or higher.
    * ECOM-COMM-1.1 or higher.

This example has been tested on:

* Android Studio with MicroEJ plugin for Android Studio 0.1.2.
* [STM32F7508-DK VEE Port 2.2.0.](https://github.com/MicroEJ/VEEPort-STMicroelectronics-STM32F7508-DK/tree/2.2.0)

# Usage

By default, the sample will use the STM32F7508-DK VEE Port.

Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html) documentation for more information.

This sample only runs on device.

## Configuration

- Make sure the configuration option `com.is2t.ecom.eventpump.enabled` is set to `true`.
- Make sure the configuration option `use.comm.connection` is set to `true`.
- Make sure the configuration option `ej.ecom.com.0` is set to `42`.
- Make sure the configuration option `com.is2t.ecom.comm.registryPump.enabled` is set to `true`.

Configuration options can be found in: `configuration/common.properties`.

## Run on device

Make sure to properly setup the VEE Port environment before going further.
Refer to the VEE Port README for more information.

In Android Studio:
- Open the Gradle tool window by clicking on the elephant on the right side,
- Expand the `Tasks` list,
- From the `Tasks` list, expand the `microej` list,
- Double-Click on `runOnDevice`.
- The device is flashed. Use the appropriate tool to retrieve the execution traces.

Alternative ways to run on device are described in the [Run on Device](https://docs.microej.com/en/latest/SDK6UserGuide/runOnDevice.html) documentation.

# Dependencies

_All dependencies are retrieved transitively by Ivy resolver_.

# Source

N/A

# Restrictions

None.

 
---  
_Markdown_   
_Copyright 2016-2024 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._