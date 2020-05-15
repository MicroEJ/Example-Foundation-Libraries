# Overview

This application is an example of a Bluetooth peripheral device using the MicroEJ Bluetooth API.
It shows how to implement a peripheral device that exposes a serial port service and uses a current time service.

This example is divided into 4 files:
  - [Main.java](src/main/java/com/microej/example/bluetooth/peripheral/Main.java) is the entry point of the application.
  - [PeripheralConnectionManager.java](src/main/java/com/microej/example/bluetooth/peripheral/PeripheralConnectionManager.java) implements the flow of the application:
    1. The `start` method enables the Bluetooth stack, sets up services and listeners, and starts advertising to nearby Bluetooth devices.
    2. The `onConnected` implementation starts discovering the services provided by the remote device.
    3. The `onDiscoveryResult` implementation prints the service structure and requests the time through the standard current time service.
  - [PrintCurrentTimeClient.java](src/main/java/com/microej/example/bluetooth/peripheral/PrintCurrentTimeClient.java) is a current time client that prints the current and local time.
  - [EchoSerialPortServer.java](src/main/java/com/microej/example/bluetooth/peripheral/EchoSerialPortServer.java) is a serial port implementation that prints and echoes received messages.

# Usage

Add the following line to your `module.ivy`:

    @MMM_DEPENDENCY_DECLARATION@

# Requirements

This library requires the following Foundation Libraries:

    @FOUNDATION_LIBRARIES_LIST@

# Dependencies

_All dependencies are retrieved transitively by MicroEJ Module Manager_.

# Source

N/A

# Restrictions

None.

---
_Copyright 2018-2020 MicroEJ Corp. All rights reserved._  
_This library is provided in source code for use, modification and test, subject to license terms._  
_Any modification of the source code will break MicroEJ Corp. warranties on the whole library._  
