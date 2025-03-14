# Overview

This example shows how to write some bytes to a CommConnection.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * ECOM-1.1 or higher.
    * ECOM-COMM-1.1 or higher.

This example has been tested on:

* IntelliJ IDEA with MicroEJ plugin for IntelliJ IDEA ``1.1.0``.
* [STM32F7508-DK VEE Port 2.2.0.](https://github.com/MicroEJ/VEEPort-STMicroelectronics-STM32F7508-DK/tree/2.2.0)

# Usage

Follow [MICROEJ SDK 6 Installation Guide](https://docs.microej.com/en/latest/SDK6UserGuide/install.html) to setup the SDK.

By default, the sample will use the
[STM32F7508-DK VEE Port 2.2.0](https://github.com/MicroEJ/VEEPort-STMicroelectronics-STM32F7508-DK/tree/2.2.0).
Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html)
documentation to use another VEE Port in your project.

## Configuration

- Make sure the configuration option `com.is2t.ecom.eventpump.enabled` is set to `true`.
- Make sure the configuration option `use.comm.connection` is set to `true`.
- Make sure the configuration option `ej.ecom.com.0` is set to `42`.
- Make sure the configuration option `com.is2t.ecom.comm.registryPump.enabled` is set to `true`.
- Make sure the configuration option `s3.mock.uart.com0.file.input` is set to the absolute path of `sim/filein.txt`.
- Make sure the configuration option `s3.mock.uart.com0.file.output` is set to the absolute path of `sim/fileout.txt`.

Configuration options can be found in: `configuration/common.properties`.

## Run on Simulator

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :ecom.writer:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Run on Device

Complete the [Getting Started for STM32F7508-DK Evaluation Kit](https://docs.microej.com/en/latest/SDK6UserGuide/gettingStartedSTM32F7508.html)
to make sure your environment is fully setup.

If you are using another VEE Port, make sure to properly setup the VEE Port environment
before going further. Refer to the dedicated VEE Port README or Getting Started for more information.

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :ecom.writer:runOnDevice`

- The device is flashed. Use the appropriate tool to retrieve the execution traces.
- Use an serial connection to your board's UART with this configuration:
  * baudrate: 9600
  * bitsperchar: 8
  * stopbits: 1
  * parity: none

Alternative ways to run on device are described in the [Run on Device](https://docs.microej.com/en/latest/SDK6UserGuide/runOnDevice.html) documentation.


## Expected Behavior

The following traces should be observed in the console:

```
[LOG] Comm connection opened.
[LOG] Output stream opened
[LOG] Output stream closed.
[LOG] Comm connection closed.
```

The [fileout.txt](sim/fileout.txt) file should contain multiples ``Hello World !`` messages.

## Troubleshooting

1. When executing I get the error **ECOM-COMM: Invalid connection descriptor.**
  * The port com has not been correctly set, redo the steps **Go to Configuration tab**

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