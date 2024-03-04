# Overview

This application provides an implementation example of a Peripheral device using the Bluetooth API.

It is designed to be used with a mobile acting as the Central device.

## Flow

Here's the flow of the example:
  1. The example is configured to provide the serial port service.
  2. The example starts advertising.
  3. The mobile start scanning.
  4. The mobile connects to the device.
  5. The mobile subscribes to the TX characteristic by sending a write request on its CCC descriptor.
  6. The mobile sends a write request on the RX characteristic.
  7. When the example receives a write request on the RX characteristic, it prints its data and sends a notification on the TX characteristic.
  8. When the mobile receives a notification on the TX characteristic, it prints its data.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * BON-1.4 or higher.
    * BLUETOOTH-2.2 or higher.

This example has been tested on:

* Android Studio with MicroEJ plugin for Android Studio 0.1.2.
* [Espressif ESP32-S3 VEE Port 2.3.1.](https://github.com/MicroEJ/VEEPort-Espressif-ESP32-S3-DevKitC-1/tree/2.3.1)

# Usage

By default, the sample does not load VEE Port and thus it cannot be built for a device nor ran on the simulator.

Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html) documentation for more information.

## Mobile App

We recommend using the [nRF Connect](https://play.google.com/store/apps/details?id=no.nordicsemi.android.mcp) app on Android to act as the Central device.
Here are the instructions to complete the mobile-side steps of the flow with this app:
  - For step 3:
    - Make sure that Bluetooth is enabled and that the necessary permissions are granted to the mobile app.
    - Open the `SCANNER` tab and click on `SCAN`.
  - For step 4:
    - Find the device named `Example` in the scanned devices list and click on `CONNECT`.
  - For step 5:
    - Select the service named `Unknown Service`.
    - Click on the subscribe button (3 down arrows) next to the first characteristic.
  - For step 6:
    - Click on the write button (up arrow) next to the second characteristic.
    - Type any value and click on `SEND`.
  - For step 8:
    - This is done automatically by the mobile app. The data can be seen in the `Value` field of the first characteristic.

## Run on simulator

In Android Studio:
- Open the Gradle tool window by clicking on the elephant icon on the right side,
- Expand the `Tasks` list,
- From the `Tasks` list, expand the `microej` list,
- Double-click on `runOnSimulator`,
- The application starts, the traces are visible in the Run view.

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

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

_All dependencies are retrieved transitively by Gradle_.

# Source

N/A

# Restrictions

None.

---
_Copyright 2018-2024 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
