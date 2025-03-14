# Overview

This example shows a simple helloworld using the NET Foundation Library.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * BON-1.4 or higher.
    * NET-1.1 or higher.

This example has been tested on:

- IntelliJ IDEA with MicroEJ plugin for IntelliJ IDEA ``1.1.0``.
- [NXP i.MX RT1170 VEE Port 3.0.0](https://github.com/MicroEJ/nxp-vee-imxrt1170-evk/tree/NXPVEE-MIMXRT1170-EVK-3.0.0).

# Usage

Follow [MICROEJ SDK 6 Installation Guide](https://docs.microej.com/en/latest/SDK6UserGuide/install.html) to setup the SDK.

By default, the sample will use the
[NXP i.MX RT1170 VEE Port 3.0.0](https://github.com/MicroEJ/nxp-vee-imxrt1170-evk/tree/NXPVEE-MIMXRT1170-EVK-3.0.0).
The sample retrieves the VEE Port as a [module](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html#using-a-module-dependency).

Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html) 
documentation to use another VEE Port in your project.

This sample is providing 2 entry points:
- Server: [ExampleServer](src/main/java/com/microej/example/foundation/net/helloworld/ExampleServer.java).
- Client: [ExampleClient](src/main/java/com/microej/example/foundation/net/helloworld/ExampleClient.java).

The Server application must be launched before the Client.

By default, the Gradle tasks will use the [ExampleClient](src/main/java/com/microej/example/foundation/net/helloworld/ExampleClient.java) class as entrypoint.
Run the Gradle tasks with the ``-Server`` suffix to run the Server code.

## Configuration

1. Set the `HOST` in [HelloWorldConstants.java](src/main/java/com/microej/example/foundation/net/helloworld/HelloWorldConstants.java)

## Run on simulator


Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):


Run ``ExampleClient`` on Simulator:
- `./gradlew :net.helloworld:runOnSimulator`

Run ``ExampleServer`` on Simulator:
- `./gradlew :net.helloworld:runOnSimulator-Server`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Run on device

Complete the [Getting Started for NXP i.MX RT1170 Evaluation Kit](https://docs.microej.com/en/latest/SDK6UserGuide/gettingStartedIMXRT1170.html)
to make sure your environment is fully setup.

If you are using another VEE Port, make sure to properly setup the VEE Port environment
before going further. Refer to the dedicated VEE Port README or Getting Started for more information.

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

Run ``ExampleClient`` on Device:
- `./gradlew :net.helloworld:runOnDevice`

Run ``ExampleServer`` on Device:
- `./gradlew :net.helloworld:runOnDevice-Server`

Alternative ways to run on device are described in the [Run on Device](https://docs.microej.com/en/latest/SDK6UserGuide/runOnDevice.html) documentation.

## Expected Behavior

The following traces should be observed in the console when the server and the client applications are running:

- ``ExampleServer`` traces:
  
  ```
  exampleserver INFO: Waiting for connection to be setup...
  exampleserver INFO: server initialization...
  exampleserver INFO: server initialized. Waiting for connection..
  
  
  exampleserver INFO: client connected.
  exampleserver INFO: client say "Hello World!".
  exampleserver INFO: server stopped.
  ```

- ``ExampleClient`` traces:
  
  ```
  exampleclient INFO: Waiting for connection to be setup...
  exampleclient INFO: trying to connect to 127.0.0.1:1234...
  exampleclient INFO: client connected to remote host.
  exampleclient INFO: "Hello World!" message sent.
  exampleclient INFO: remote connection closed.
  ```


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