# Overview
This project gathers some basic examples of the foundation libraries. Those examples are developed as standalone applications and as such can be run by following the associated instructions (see **README.md** file of each example).

Note that to run them on board:

* If you are using MicroEJ SDK:
 * You need a supported board (see http://developer.microej.com/index.php?resource=JPF for a list of supported boards using MicroEJ SDK evaluation version)
 * And the associated platform binary .jpf file (retrieve it from the previous link and import it into MicroEJ SDK)

* If you are using MicroEJ Studio:
 * You need to convert them from standalone applications to sandboxed applications.
 * Follow the [How-To convert a standalone app into a sandboxed app](https://github.com/MicroEJ/How-To/tree/master/StandaloneToSandboxed) guide.

# Details
## Core
### EDC
EDC contains the minimal standard runtime environment for embedded devices.

**Available Example**:
* [com.microej.examples.foundation.edc.helloworld](com.microej.examples.foundation.edc.helloworld): Prints Hello World on the standard output stream.

### BON
BON focuses on devices with non-volatile and volatile memories. This library allows to fully control memory usage and start-up sequences on devices with limited memory resources.

**Available Examples**:

* [com.microej.examples.foundation.bon.immortals](com.microej.examples.foundation.bon.immortals): Shows how to manipulate the immortals.
* [com.microej.examples.foundation.bon.immutables](com.microej.examples.foundation.bon.immutables): Shows how to manipulate the immutables.


## Communicate with other hardwares

### ECOM
ECOM libraries provides a standard communication over UART.

**Available Examples**:
* [com.microej.examples.foundation.ecom.hotplug](com.microej.examples.foundation.ecom.hotplug): Shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.
* [com.microej.examples.foundation.ecom.writer](com.microej.examples.foundation.ecom.writer): Shows how to write some bytes to a CommConnection.
* [com.microej.examples.foundation.ecom.reader](com.microej.examples.foundation.ecom.reader): Shows how to read some bytes from a CommConnection.

### HAL
HAL libraries presents an abstraction of the communication with the hardware.

**Available Example**:
* [com.microej.examples.foundation.hal.gpio](com.microej.examples.foundation.hal.gpio): Shows how to use gpio.


## Design a user interface

### MicroUI
MicroUI provides the minimal cornerstone for quick construction of advanced, portable and user-friendly applications for a wide and heterogeneous range of devices with just-what-is-needed resources.

**Available Examples**:
* [com.microej.examples.foundation.microui.antialiased](com.microej.examples.foundation.microui.antialiased): Shows how to use anti-aliased shapes.
* [com.microej.examples.foundation.microui.font](com.microej.examples.foundation.microui.font): Shows how to create and use a font.
* [com.microej.examples.foundation.microui.helloworld](com.microej.examples.foundation.microui.helloworld): Shows how to print a string on a display.
* [com.microej.examples.foundation.microui.image](com.microej.examples.foundation.microui.image): Shows how to create and use images.
* [com.microej.examples.foundation.microui.input](com.microej.examples.foundation.microui.input): Shows how to listen the MicroUI input events.
* [com.microej.examples.foundation.microui.led](com.microej.examples.foundation.microui.led): Shows how to use the LEDs.
* [com.microej.examples.foundation.microui.movableimage](com.microej.examples.foundation.microui.movableimage): Shows how to create and use a movable image.
* [com.microej.examples.foundation.microui.mvc](com.microej.examples.foundation.microui.mvc): Shows how to create and use a MVC design pattern.
* [com.microej.examples.foundation.microui.out](com.microej.examples.foundation.microui.out): Shows how to redirect the standard SystemOut to the display.
* [com.microej.examples.foundation.microui.transform](com.microej.examples.foundation.microui.transform): Shows how to use MicroUI transform.

### MWT
MWT is a widget toolkit designed for a wide range of devices, including embedded devices with limited processing power.

**Available Examples**:
* [com.microej.examples.foundation.mwt.helloworld](com.microej.examples.foundation.mwt.helloworld): Shows a simple hello world using MWT.
* [com.microej.examples.foundation.mwt.mvc](com.microej.examples.foundation.mwt.mvc): Shows how to create and use a MVC design pattern.

### NLS
NLS provides tools to use localized strings.

**Available Example**:
* [com.microej.examples.foundation.nls.helloworld](com.microej.examples.foundation.nls.helloworld): Shows how to print a localized string on a display.


## Communicate with the world

### NET
NET is a lightweight Java library dedicated to networking applications. It supports stream (TCP/IP) and datagram (UDP) socket connection APIs.

**Available Examples**:
* [com.microej.examples.foundation.net.echo](com.microej.examples.foundation.net.echo): Shows a simple echo server.
* [com.microej.examples.foundation.net.helloworld](com.microej.examples.foundation.net.helloworld): Shows a simple helloworld using NET.

## Store data

### FS
FS is a library to access multiple storage devices (in and out data streams) through a simple file system API.

**Available Example**:
* [com.microej.examples.foundation.fs.helloworld](com.microej.examples.foundation.fs.helloworld): Creates a list of folders, adds some files and deletes them all.
