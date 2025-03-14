# Overview

This example shows a simple echo server.

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

## Run on Simulator

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :net.echo:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Run on Device

Complete the [Getting Started for NXP i.MX RT1170 Evaluation Kit](https://docs.microej.com/en/latest/SDK6UserGuide/gettingStartedIMXRT1170.html)
to make sure your environment is fully setup.

If you are using another VEE Port, make sure to properly setup the VEE Port environment
before going further. Refer to the dedicated VEE Port README or Getting Started for more information.

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :net.echo:runOnDevice`

Alternative ways to run on device are described in the [Run on Device](https://docs.microej.com/en/latest/SDK6UserGuide/runOnDevice.html) documentation.

## Expected Behavior

The following traces should be observed in the console when joining the server from a web browser
(e.g ``http://<YOUR SERVER IP>:<PORT>/``):

```
exampleechoserver INFO: Wainting for connection to be setup...
exampleechoserver INFO: server initialization...
exampleechoserver INFO: server initialized. Waiting for connection on port 1234...
> Task :net.echo:runOnSimulator

exampleechoserver INFO: client connected. Echo client message start
exampleechoserver INFO: client said "GET / HTTP/1.1
Host: 192.168.2.99:1234
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:135.0) Gecko/20100101 Firefox/135.0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8
Accept-Language: en-US,en;q=0.5
Accept-Encoding: gzip, deflate
DNT: 1
Connection: keep-alive
Upgrade-Insecure-Requests: 1
Priority: u=0, i
".
exampleechoserver INFO: server stopped.
```

Note: if the web browser is take a long time to load, stop it in order to see the traces in the console.

## Troubleshooting

Change the ``PORT`` constant defined in [NetEchoConstants.java](src/main/java/com/microej/example/foundation/net/echo/NetEchoConstants.java)
if the following error shows up:

```
exampleechoserver SEVERE: NET-1.1: Address already in use
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