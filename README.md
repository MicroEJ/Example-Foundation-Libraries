# Overview
This project gathers all the basic examples of the foundation libraries. They are developped as standalone examples but can be converted into sandboxed examples using [How-To convert a standalone app into a sandboxed app]{https://github.com/MicroEJ/How-To/tree/master/StandaloneToSandboxed}

# Details
## Core
### EDC
EDC contains the minimal standard runtime environment for embedded devices
**Avaliable Example**:
* [ej.examples.foundation.edc.helloworld]{ej.examples.foundation.edc.helloworld}: This example prints Hello World on the standard output stream.
### BON
BON focuses on devices with non-volatile and volatile memories. This library allows to fully control memory usage and start-up sequences on devices with limited memory resources.
**Avaliable Examples**:
* [ej.examples.foundation.bon.immortals]{ej.examples.foundation.bon.immortals}: This example shows how to manipulate the immortals.
* [ej.examples.foundation.bon.immutables]{ej.examples.foundation.bon.immutables}: This example shows how to manipulate the immutables.


## Communicate with other hardwares
### ECOM
ECOM libraries provides a standard communication over UART
**Avaliable Examples**:
* [ej.examples.foundation.ecom.hotplug]{ej.examples.foundation.ecom.hotplug}: This example shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.
* [ej.examples.foundation.ecom.writer]{ej.examples.foundation.ecom.writer}: This example shows how to write some bytes to a CommConnection.
* [ej.examples.foundation.ecom.reader]{ej.examples.foundation.ecom.reader}: This example shows how to read some bytes from a CommConnection.
### HAL
HAL libraries presents an abstraction of the communication with the hardware
**Avaliable Example**:
* [ej.examples.foundation.hal.gpio]{ej.examples.foundation.hal.gpio}: This example shows how to use gpio.


## Design a user interface
### MicroUI
MicroUI provides the minimal cornerstone for quick construction of advanced, portable and user-friendly applications for a wide and heterogeneous range of devices with just-what-is-needed resources.
**Avaliable Examples**:
* [ej.examples.foundation.microui.antialiased]{ej.examples.foundation.microui.antialiased}: This example shows how to use anti-aliased shapes.
* [ej.examples.foundation.microui.font]{ej.examples.foundation.microui.font}: This example shows how to create and use a font.
* [ej.examples.foundation.microui.helloworld]{ej.examples.foundation.microui.helloworld}: This example shows how to print a string on a display.
* [ej.examples.foundation.microui.image]{ej.examples.foundation.microui.image}: This example shows how to create and use images.
* [ej.examples.foundation.microui.input]{ej.examples.foundation.microui.input}: This example shows how to listen the MicroUI input events.
* [ej.examples.foundation.microui.led]{ej.examples.foundation.microui.led}: This example shows how to use the LEDs.
* [ej.examples.foundation.microui.movableimage]{ej.examples.foundation.microui.movableimage}: This example shows how to create and use a movable image.
* [ej.examples.foundation.microui.mvc]{ej.examples.foundation.microui.mvc}: This example shows how to create and use a MVC design pattern.
* [ej.examples.foundation.microui.out]{ej.examples.foundation.microui.out}: This example shows how to do the redirection of the standard SystemOut to the display.
* [ej.examples.foundation.microui.transform]{ej.examples.foundation.microui.transform}: This example shows how to use MicroUI transform.
### MWT
MWT is a widget toolkit designed for a wide range of devices, including embedded devices with limited processing power.
**Avaliable Examples**:
* [ej.examples.foundation.mwt.helloworld]{ej.examples.foundation.mwt.helloworld}: This example shows a simple hello world using MWT.
* [ej.examples.foundation.mwt.mvc]{ej.examples.foundation.mwt.mvc}: This example shows how to create and use a MVC design pattern.
### NLS
NLS provides tools to use localized strings.
**Avaliable Example**:
* [ej.examples.foundation.nls.helloworld]{ej.examples.foundation.nls.helloworld}: This example shows how to print a localized string on a display.


## Communicate with the world
### NET
NET is a lightweight Java library dedicated to networking application. It supports stream (TCP/IP) and datagram (UDP) socket connection API.
**Avaliable Examples**:
* [ej.examples.foundation.net.echo]{ej.examples.foundation.net.echo}: This example shows a simple echo server.
* [ej.examples.foundation.net.helloworld]{ej.examples.foundation.net.helloworld}: This example shows a simple helloworld using NET.
## Store data
### FS
FS is a library to access multiple storage devices (in and out data streams) through a simple file system API.
**Avaliable Example**:
* [ej.examples.foundation.fs.helloworld]{ej.examples.foundation.fs.helloworld}: This example creates a list of folders, add some files and delete them all.
