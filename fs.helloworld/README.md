# Overview

This example creates a list of folders, add some files and delete them all.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * FS-2.1 or higher.

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

`./gradlew :fs.helloworld:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Run on Device

Complete the [Getting Started for NXP i.MX RT1170 Evaluation Kit](https://docs.microej.com/en/latest/SDK6UserGuide/gettingStartedIMXRT1170.html)
to make sure your environment is fully setup.

If you are using another VEE Port, make sure to properly setup the VEE Port environment
before going further. Refer to the dedicated VEE Port README or Getting Started for more information.

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :fs.helloworld:runOnDevice`

Alternative ways to run on device are described in the [Run on Device](https://docs.microej.com/en/latest/SDK6UserGuide/runOnDevice.html) documentation.

## Expected Behavior

The following traces should be observed in the console:

```
Creating folder hierarchy: /usr/letters
for
/usr/letters/W/William successfully created.
Writing content to /usr/letters/W/William
	-> content=Fri Feb 28 14:55:01 GMT 2025
/usr/letters/B/Bob successfully created.
Writing content to /usr/letters/B/Bob
	-> content=Fri Feb 28 14:55:01 GMT 2025
/usr/letters/J/John successfully created.
Writing content to /usr/letters/J/John
	-> content=Fri Feb 28 14:55:01 GMT 2025
/usr/letters/M/Michael successfully created.
Writing content to /usr/letters/M/Michael
	-> content=Fri Feb 28 14:55:01 GMT 2025
/usr/letters/J/Joe successfully created.
Writing content to /usr/letters/J/Joe
	-> content=Fri Feb 28 14:55:01 GMT 2025
[DIR] letters
	[DIR] Z
	[DIR] Y
	[DIR] X
	[DIR] W
		[FILE] William
	[DIR] V
	[DIR] U
	[DIR] T
	[DIR] S
	[DIR] R
	[DIR] Q
	[DIR] P
	[DIR] O
	[DIR] N
	[DIR] M
		[FILE] Michael
	[DIR] L
	[DIR] K
	[DIR] J
		[FILE] John
		[FILE] Joe
	[DIR] I
	[DIR] H
	[DIR] G
	[DIR] F
	[DIR] E
	[DIR] D
	[DIR] C
	[DIR] B
		[FILE] Bob
	[DIR] A
letters/Z has been deleted
letters/Y has been deleted
letters/X has been deleted
letters/W/William has been deleted
letters/W has been deleted
letters/V has been deleted
letters/U has been deleted
letters/T has been deleted
letters/S has been deleted
letters/R has been deleted
letters/Q has been deleted
letters/P has been deleted
letters/O has been deleted
letters/N has been deleted
letters/M/Michael has been deleted
letters/M has been deleted
letters/L has been deleted
letters/K has been deleted
letters/J/John has been deleted
letters/J/Joe has been deleted
letters/J has been deleted
letters/I has been deleted
letters/H has been deleted
letters/G has been deleted
letters/F has been deleted
letters/E has been deleted
letters/D has been deleted
letters/C has been deleted
letters/B/Bob has been deleted
letters/B has been deleted
letters/A has been deleted
letters has been deleted
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