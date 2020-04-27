# Overview

This application is an example of a Bluetooth central device using the MicroEJ Bluetooth API.
It shows how to implement a central device that exposes a current time service and uses a serial port service.

This example is divided into 3 files:
  - [Main.java](src/main/java/com/microej/example/bluetooth/central/Main.java) initializes the example, it shows how to enable the Bluetooth stack, setup services and listeners and start scanning for other Bluetooth devices.
  - [CentralConnectionListener.java](src/main/java/com/microej/example/bluetooth/central/CentralConnectionListener.java) implements the flow of the application:
    1. `onScanResult`: The scan calls this method upon new scan events. This implementation prints the scanned device information and connects to it in case its name is "Example".
    2. `onConnected`: Upon connection, the application requests for the services discovery.
    3. `onServicesDiscovered`: This implementation prints the services UUID and characteristics and attempts to send a "Hello World" through a serial port standard Bluetooth service.
  - [HelloWorldSerialPortClient.java](src/main/java/com/microej/example/bluetooth/central/HelloWorldSerialPortClient.java) is a serial port client that sends a "Hello World" and prints received messages.

---
_Copyright 2018-2020 MicroEJ Corp. All rights reserved._  
_This library is provided in source code for use, modification and test, subject to license terms._  
_Any modification of the source code will break MicroEJ Corp. warranties on the whole library._  
