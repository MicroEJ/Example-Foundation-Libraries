# Overview

This sample shows how to use gpio.
The pins are configured for a ``YwroBot Easy Module Shield V1``.
However, the sample can be used without this shield.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * HAL-1.0 or higher.

This example has been tested on:

* IntelliJ IDEA with MicroEJ plugin for IntelliJ IDEA ``1.1.0``.
* [STM32F7508-DK VEE Port 2.2.0.](https://github.com/MicroEJ/VEEPort-STMicroelectronics-STM32F7508-DK/tree/2.2.0)

# Usage


By default, the sample will use the
[STM32F7508-DK VEE Port 2.2.0](https://github.com/MicroEJ/VEEPort-STMicroelectronics-STM32F7508-DK/tree/2.2.0).
The sample retrieves the VEE Port as a [module](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html#using-a-module-dependency).

Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html) documentation for more information.

This sample only runs on device.

## Run on Device

Complete the [Getting Started for STM32F7508-DK Evaluation Kit](https://docs.microej.com/en/latest/SDK6UserGuide/gettingStartedSTM32F7508.html)
to make sure your environment is fully setup.

If you are using another VEE Port, make sure to properly setup the VEE Port environment
before going further. Refer to the dedicated VEE Port README or Getting Started for more information.

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :hal.gpio:runOnDevice`

Alternative ways to run on device are described in the [Run on Device](https://docs.microej.com/en/latest/SDK6UserGuide/runOnDevice.html) documentation.

## Expected Behavior

The following traces should be observed in the console:

```
MicroEJ START
Value changed for sensor 0 : 904
Value changed for sensor 0 : 948
Value changed for sensor 0 : 907
Value changed for sensor 0 : 952
Value changed for sensor 0 : 909
```

Also, the ``LD1`` LED should blink.

# Dependencies

The dependencies defined in [build.gradle.kts](build.gradle.kts)
are configured in [libs.versions.toml](../gradle/libs.versions.toml).

_All dependencies are retrieved transitively by Ivy resolver_.

# Source

N/A

# Restrictions

None.
 
---  
_Markdown_   
_Copyright 2016-2025 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._
