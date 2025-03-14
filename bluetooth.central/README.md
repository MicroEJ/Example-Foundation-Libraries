# Overview

This application provides an implementation example of a Central device using the Bluetooth API.

It is designed to be used with a mobile acting as the Peripheral device.

## Flow

Here's the flow of the example:
  1. The mobile is configured to provide the current time service.
  2. The mobile starts advertising.
  3. The example starts scanning.
  4. When the example receives an advertisement, if the advertised name matches the expected one, then it connects to the device.
  5. When the example is connected to the mobile, it discovers the services that the mobile provides.
  6. When the example discovers a service, if the service UUID matches the current time service UUID, then it sends a read request on the current time characteristic.
  7. When the mobile receives a read request on the current time characteristic, it sends back a read response.
  8. When the example receives a read response on the current time characteristic, it prints the time provided by the mobile.

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

We recommend using the [nRF Connect](https://play.google.com/store/apps/details?id=no.nordicsemi.android.mcp) app on Android to act as the Peripheral device.
Here are the instructions to complete the mobile-side steps of the flow with this app:
  - For step 1:
    - Make sure that Bluetooth is enabled and that the necessary permissions are granted to the mobile app.
    - Click on the hamburger button and select `Configure GATT server`.
    - In the list of configurations, click on the `+` button.
    - Type anything as configuration name and click on `OK`.
    - Click on `ADD SERVICE`.
    - Select `Current Time service` as server configuration and click on `OK`.
  - For step 2:
    - Open the `ADVERTISER` tab and click on the pencil button.
    - Type `Example` as device name and click on `RENAME`.
    - Click on the `+` button.
    - Click on `ADD RECORD` and select `Complete Local Name`.
    - Select `Connectable` and click on `OK`.
    - Turn on the new advertiser configuration and click on `OK`.
  - For step 7:
    - This is done automatically by the mobile app.

## Run on Simulator

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :bluetooth.central:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Run on Device

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :bluetooth.central:runOnDevice`

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
