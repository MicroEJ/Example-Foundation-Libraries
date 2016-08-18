# Overview
This project gathers all the basic examples of the foundation libraries. They are developped as standalone examples but can be converted into sandboxed examples using [How-To convert a standalone app into a sandboxed app](https://github.com/MicroEJ/How-To/tree/master/StandaloneToSandboxed)

# Details
## Core
### EDC
EDC contains the minimal standard runtime environment for embedded devices

**Available Example**:
* [ej.examples.foundation.edc.helloworld](ej.examples.foundation.edc.helloworld): Prints Hello World on the standard output stream.

### BON
BON focuses on devices with non-volatile and volatile memories. This library allows to fully control memory usage and start-up sequences on devices with limited memory resources.

**Available Examples**:

* [ej.examples.foundation.bon.immortals](ej.examples.foundation.bon.immortals): Shows how to manipulate the immortals.
* [ej.examples.foundation.bon.immutables](ej.examples.foundation.bon.immutables): Shows how to manipulate the immutables.


## Communicate with other hardwares

### ECOM
ECOM libraries provides a standard communication over UART

**Available Examples**:
* [ej.examples.foundation.ecom.hotplug](ej.examples.foundation.ecom.hotplug): Shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.
* [ej.examples.foundation.ecom.writer](ej.examples.foundation.ecom.writer): Shows how to write some bytes to a CommConnection.
* [ej.examples.foundation.ecom.reader](ej.examples.foundation.ecom.reader): Shows how to read some bytes from a CommConnection.

### HAL
HAL libraries presents an abstraction of the communication with the hardware

**Available Example**:
* [ej.examples.foundation.hal.gpio](ej.examples.foundation.hal.gpio): Shows how to use gpio.


## Design a user interface

### MicroUI
MicroUI provides the minimal cornerstone for quick construction of advanced, portable and user-friendly applications for a wide and heterogeneous range of devices with just-what-is-needed resources.

**Available Examples**:
* [ej.examples.foundation.microui.antialiased](ej.examples.foundation.microui.antialiased): Shows how to use anti-aliased shapes.
* [ej.examples.foundation.microui.font](ej.examples.foundation.microui.font): Shows how to create and use a font.
* [ej.examples.foundation.microui.helloworld](ej.examples.foundation.microui.helloworld): Shows how to print a string on a display.
* [ej.examples.foundation.microui.image](ej.examples.foundation.microui.image): Shows how to create and use images.
* [ej.examples.foundation.microui.input](ej.examples.foundation.microui.input): Shows how to listen the MicroUI input events.
* [ej.examples.foundation.microui.led](ej.examples.foundation.microui.led): Shows how to use the LEDs.
* [ej.examples.foundation.microui.movableimage](ej.examples.foundation.microui.movableimage): Shows how to create and use a movable image.
* [ej.examples.foundation.microui.mvc](ej.examples.foundation.microui.mvc): Shows how to create and use a MVC design pattern.
* [ej.examples.foundation.microui.out](ej.examples.foundation.microui.out): Shows how to do the redirection of the standard SystemOut to the display.
* [ej.examples.foundation.microui.transform](ej.examples.foundation.microui.transform): Shows how to use MicroUI transform.

### MWT
MWT is a widget toolkit designed for a wide range of devices, including embedded devices with limited processing power.

**Available Examples**:
* [ej.examples.foundation.mwt.helloworld](ej.examples.foundation.mwt.helloworld): Shows a simple hello world using MWT.
* [ej.examples.foundation.mwt.mvc](ej.examples.foundation.mwt.mvc): Shows how to create and use a MVC design pattern.

### NLS
NLS provides tools to use localized strings.

**Available Example**:
* [ej.examples.foundation.nls.helloworld](ej.examples.foundation.nls.helloworld): Shows how to print a localized string on a display.


## Communicate with the world

### NET
NET is a lightweight Java library dedicated to networking application. It supports stream (TCP/IP) and datagram (UDP) socket connection API.

**Available Examples**:
* [ej.examples.foundation.net.echo](ej.examples.foundation.net.echo): Shows a simple echo server.
* [ej.examples.foundation.net.helloworld](ej.examples.foundation.net.helloworld): Shows a simple helloworld using NET.

## Store data

### FS
FS is a library to access multiple storage devices (in and out data streams) through a simple file system API.

**Available Example**:
* [ej.examples.foundation.fs.helloworld](ej.examples.foundation.fs.helloworld): Create a list of folders, add some files and delete them all.
