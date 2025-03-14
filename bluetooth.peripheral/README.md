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
* IntelliJ IDEA with MicroEJ plugin for IntelliJ IDEA ``1.1.0``.
* [Espressif ESP32-S3 VEE Port 2.3.1.](https://github.com/MicroEJ/VEEPort-Espressif-ESP32-S3-DevKitC-1/tree/2.3.1)

# Usage

No default VEE Port has been configured to run this sample.

It is recommended to start using this sample with the
[Espressif ESP32-S3 VEE Port 2.3.1](https://github.com/MicroEJ/VEEPort-Espressif-ESP32-S3-DevKitC-1/tree/2.3.1).

Refer to the VEE Port README to setup your environment.

Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html) documentation for more information about using a VEE Port in your project.

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

## Run on Simulator

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :bluetooth.peripheral:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Run on Device

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :bluetooth.peripheral:runOnDevice`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

# Dependencies

The dependencies defined in [build.gradle.kts](build.gradle.kts)
are configured in [libs.versions.toml](../gradle/libs.versions.toml).

_All dependencies are retrieved transitively by Gradle_.

# Source

N/A

# Restrictions

None.

---
_Copyright 2018-2025 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
