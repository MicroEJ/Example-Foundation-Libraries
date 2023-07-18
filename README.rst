
.. image:: https://shields.microej.com/endpoint?url=https://repository.microej.com/packages/badges/sdk_5.8.json
   :alt: sdk_5.8 badge
   :align: left
.. image:: https://shields.microej.com/endpoint?url=https://repository.microej.com/packages/badges/arch_7.17.json
   :alt: arch_7.17 badge
   :align: left

Overview
========

This project gathers basic examples on how to use some of the foundation libraries. Those examples are developed as standalone applications and as such can be run by following the associated instructions (see **README.md** file of each example).

Note that to run them on board:

If you are using MicroEJ SDK:

- You need a supported board (see https://github.com/search?q=org%3AMicroEJ+VEEPort&type=repositories for a list of supported boards using MicroEJ SDK evaluation version)
- And the associated VEE Port sources (retrieve it from the previous link and import it into MicroEJ SDK)

Details
=======

Core
----

EDC
~~~

EDC contains the minimal standard runtime environment for embedded devices.

**Available Examples**:

- `edc.helloworld <edc.helloworld>`_: Prints Hello World on the standard output stream.

BON
~~~

BON focuses on devices with non-volatile and volatile memories. This library allows to fully control memory usage and start-up sequences on devices with limited memory resources.

**Available Examples**:

- `bon.immortals <bon.immortals>`_: Shows how to manipulate the immortals.
- `bon.immutables <bon.immutables>`_: Shows how to manipulate the immutables.

Communication with other hardware
---------------------------------

ECOM
~~~~

ECOM libraries provide a standard communication over UART.

**Available Examples**:

- `ecom.hotplug <ecom.hotplug>`_: Shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.
- `ecom.writer <ecom.writer>`_: Shows how to write some bytes to a CommConnection.
- `ecom.reader <ecom.reader>`_: Shows how to read some bytes from a CommConnection.

HAL
~~~

HAL libraries present an abstraction of the communication with the hardware.

**Available Examples**:

- `hal.gpio <hal.gpio>`_: Shows how to use GPIOs.

Design a user interface
-----------------------

MicroUI
~~~~~~~

MicroUI provides the minimal cornerstone for quick construction of advanced, portable and user-friendly applications for a wide and heterogeneous range of devices with just-what-is-needed resources.

**Available Examples**:

- `microui.font <microui.font>`_: Shows how to create and use a font.
- `microui.gradient <microui.gradient>`_: Shows how to draw a gradient on a display.
- `microui.helloworld <microui.helloworld>`_: Shows how to print a string on a display.
- `microui.image <microui.image>`_: Shows how to create and use images.
- `microui.input <microui.input>`_: Shows how to listen to the MicroUI input events.
- `microui.led <microui.led>`_: Shows how to use the LEDs.
- `microui.movableimage <microui.movableimage>`_: Shows how to create and use movable images.
- `microui.mvc <microui.mvc>`_: Shows how to create and use a MVC design pattern.
- `microui.out <microui.out>`_: Shows how to redirect the standard SystemOut to the display.

Drawing
~~~~~~~

The Drawing Foundation Library extends MicroUI drawing APIs with more complex ones.

**Available Examples**:

- `drawing.transform <drawing.transform>`_: Shows how to use anti-aliased shapes.
- `drawing.antialiased <drawing.antialiased>`_: Shows how to apply transformations on an image.

Communication with the world
----------------------------

NET
~~~

NET is a lightweight Java library dedicated to networking applications. It supports stream (TCP/IP) and datagram (UDP) socket connection APIs.

**Available Examples**:

- `net.echo <net.echo>`_: Shows a simple echo server.
- `net.helloworld <net.helloworld>`_: Shows a simple helloworld using NET.

Data storage
------------

FS
~~

FS is a library to access multiple storage devices (in and out data streams) through a simple file system API.

**Available Examples**:

- `fs.helloworld <fs.helloworld>`_: Creates a list of folders, adds some files and deletes them all.

--------------

.. ReStructuredText
.. Copyright 2020-2023 MicroEJ Corp. All rights reserved.
.. Use of this source code is governed by a BSD-style license that can be found with this software.