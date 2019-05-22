<!--
 Markdown

 Copyright 2016-2019 MicroEJ Corp. All rights reserved.
 For demonstration purpose only.
 MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
-->

# Overview
This project gathers some basic examples of the foundation libraries. Those examples are developed as standalone applications and as such can be run by following the associated instructions (see **README.md** file of each example).

Note that to run them on board:

* If you are using MicroEJ SDK:
 * You need a supported board (see http://developer.microej.com/index.php?resource=JPF for a list of supported boards using MicroEJ SDK evaluation version)
 * And the associated platform binary (.jpf) file or source archive (retrieve it from the previous link and import it into MicroEJ SDK)

* If you are using MicroEJ Studio:
 * You need to convert them from standalone applications to sandboxed applications.
 * Follow the [How-To convert a standalone app into a sandboxed app](https://github.com/MicroEJ/How-To/tree/master/StandaloneToSandboxed) guide.

# Details
## Core
### EDC
EDC contains the minimal standard runtime environment for embedded devices.

**Available Examples**:
* [com.microej.example.foundation.edc.helloworld](com.microej.example.foundation.edc.helloworld): Prints Hello World on the standard output stream.

### BON
BON focuses on devices with non-volatile and volatile memories. This library allows to fully control memory usage and start-up sequences on devices with limited memory resources.

**Available Examples**:

* [com.microej.example.foundation.bon.immortals](com.microej.example.foundation.bon.immortals): Shows how to manipulate the immortals.
* [com.microej.example.foundation.bon.immutables](com.microej.example.foundation.bon.immutables): Shows how to manipulate the immutables.


## Communication with other hardware

### ECOM
ECOM libraries provide a standard communication over UART.

**Available Examples**:
* [com.microej.example.foundation.ecom.hotplug](com.microej.example.foundation.ecom.hotplug): Shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.
* [com.microej.example.foundation.ecom.writer](com.microej.example.foundation.ecom.writer): Shows how to write some bytes to a CommConnection.
* [com.microej.example.foundation.ecom.reader](com.microej.example.foundation.ecom.reader): Shows how to read some bytes from a CommConnection.

### HAL
HAL libraries present an abstraction of the communication with the hardware.

**Available Examples**:
* [com.microej.example.foundation.hal.gpio](com.microej.example.foundation.hal.gpio): Shows how to use gpio.


## Design a user interface

### MicroUI
MicroUI provides the minimal cornerstone for quick construction of advanced, portable and user-friendly applications for a wide and heterogeneous range of devices with just-what-is-needed resources.

**Available Examples**:
* [com.microej.example.foundation.microui.antialiased](com.microej.example.foundation.microui.antialiased): Shows how to use anti-aliased shapes.
* [com.microej.example.foundation.microui.font](com.microej.example.foundation.microui.font): Shows how to create and use a font.
* [com.microej.example.foundation.microui.gradient](com.microej.example.foundation.microui.gradient): This example shows how to draw a gradient on a display.
* [com.microej.example.foundation.microui.helloworld](com.microej.example.foundation.microui.helloworld): Shows how to print a string on a display.
* [com.microej.example.foundation.microui.image](com.microej.example.foundation.microui.image): Shows how to create and use images.
* [com.microej.example.foundation.microui.input](com.microej.example.foundation.microui.input): Shows how to listen the MicroUI input events.
* [com.microej.example.foundation.microui.led](com.microej.example.foundation.microui.led): Shows how to use the LEDs.
* [com.microej.example.foundation.microui.movableimage](com.microej.example.foundation.microui.movableimage): Shows how to create and use a movable image.
* [com.microej.example.foundation.microui.mvc](com.microej.example.foundation.microui.mvc): Shows how to create and use a MVC design pattern.
* [com.microej.example.foundation.microui.out](com.microej.example.foundation.microui.out): Shows how to redirect the standard SystemOut to the display.
* [com.microej.example.foundation.microui.transform](com.microej.example.foundation.microui.transform): Shows how to use MicroUI transform.


## Communication with the world

### NET
NET is a lightweight Java library dedicated to networking applications. It supports stream (TCP/IP) and datagram (UDP) socket connection APIs.

**Available Examples**:
* [com.microej.example.foundation.net.echo](com.microej.example.foundation.net.echo): Shows a simple echo server.
* [com.microej.example.foundation.net.helloworld](com.microej.example.foundation.net.helloworld): Shows a simple helloworld using NET.

## Data storage

### FS
FS is a library to access multiple storage devices (in and out data streams) through a simple file system API.

**Available Examples**:
* [com.microej.example.foundation.fs.helloworld](com.microej.example.foundation.fs.helloworld): Creates a list of folders, adds some files and deletes them all.
