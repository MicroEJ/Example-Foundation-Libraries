# Overview

This application is an example of a Bluetooth peripheral device using the MicroEJ Bluetooth API.
It shows how to implement a peripheral device that exposes a serial port service and uses a current time service.

This example is divided into 4 files:
  - [Main.java](src/main/java/com/microej/example/bluetooth/peripheral/Main.java) initializes the example, it shows how to enable the Bluetooth stack, setup services and listeners and start advertising.
  - [PeripheralConnectionListener.java](src/main/java/com/microej/example/bluetooth/peripheral/PeripheralConnectionListener.java) implements the flow of the application:
    1. `onConnected`: Upon connection, the application requests for the services discovery.
    2. `onServicesDiscovered`: This implementation prints the services UUID and characteristics and attempts to request the time through a current time standard Bluetooth service.
  - [PrintCurrentTimeClient.java](src/main/java/com/microej/example/bluetooth/peripheral/PrintCurrentTimeClient.java) is a current time client that prints the current and local time.
  - [EchoSerialPortServer.java](src/main/java/com/microej/example/bluetooth/peripheral/EchoSerialPortServer.java) is a serial port implementation that prints and echoes received messages.

---
_Copyright 2018-2020 MicroEJ Corp. All rights reserved._  
_This library is provided in source code for use, modification and test, subject to license terms._  
_Any modification of the source code will break MicroEJ Corp. warranties on the whole library._  
