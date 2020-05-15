# Overview

This application is an example of a Bluetooth central device using the MicroEJ Bluetooth API.
It shows how to implement a central device that exposes a current time service and uses a serial port service.

This example is divided into 3 files:
  - [Main.java](src/main/java/com/microej/example/bluetooth/central/Main.java) is the entry point of the application.
  - [CentralConnectionManager.java](src/main/java/com/microej/example/bluetooth/central/CentralConnectionManager.java) implements the flow of the application:
    1. The `start` method enables the Bluetooth stack, sets up services and listeners, and starts scanning for nearby Bluetooth devices.
    2. The `onScanResult` callback is executed upon new scan events. This implementation prints the scanned device information and connects to the device if its name is "Example".
    3. The `onConnected` implementation starts discovering the services provided by the remote device.
    4. The `onDiscoveryResult` implementation prints the service structure and attempts to send a "Hello World" message through the serial port service.
  - [HelloWorldSerialPortClient.java](src/main/java/com/microej/example/bluetooth/central/HelloWorldSerialPortClient.java) is a serial port client that sends a "Hello World" and prints each receive messages.

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
