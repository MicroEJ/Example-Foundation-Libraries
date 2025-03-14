# Overview

This example shows how to manipulate the immutables.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * BON-1.4 or higher.

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

`./gradlew :bon.immutables:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Run on Device

Complete the [Getting Started for NXP i.MX RT1170 Evaluation Kit](https://docs.microej.com/en/latest/SDK6UserGuide/gettingStartedIMXRT1170.html)
to make sure your environment is fully setup.

If you are using another VEE Port, make sure to properly setup the VEE Port environment
before going further. Refer to the dedicated VEE Port README or Getting Started for more information.

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :bon.immutables:runOnDevice`

Alternative ways to run on device are described in the [Run on Device](https://docs.microej.com/en/latest/SDK6UserGuide/runOnDevice.html) documentation.

## Expected Behavior

The following traces should be observed in the console:

```
==== TABLE ====
cos[0] = 1.0			 sin[0] = 0.0
cos[1] = 0.999848			 sin[1] = 0.017452
cos[2] = 0.9993909996447287			 sin[2] = 0.034899
cos[3] = 0.9986299996447286			 sin[3] = 0.052336
cos[4] = 0.997564			 sin[4] = 0.06975599997157829
cos[5] = 0.9961949996447287			 sin[5] = 0.08715599997157829
cos[6] = 0.994522			 sin[6] = 0.104528
cos[7] = 0.992546			 sin[7] = 0.12186899992894573
cos[8] = 0.990268			 sin[8] = 0.139173
cos[9] = 0.987688			 sin[9] = 0.156434
cos[10] = 0.984808			 sin[10] = 0.173648
cos[11] = 0.9816269996447287			 sin[11] = 0.19080899992894573
cos[12] = 0.9781479996447286			 sin[12] = 0.20791199992894574
cos[13] = 0.97437			 sin[13] = 0.22495099992894574
cos[14] = 0.970296			 sin[14] = 0.24192199985789145
cos[15] = 0.9659259996447286			 sin[15] = 0.258819
cos[16] = 0.9612619996447286			 sin[16] = 0.2756369998578915
cos[17] = 0.9563049996447286			 sin[17] = 0.2923719998578915
cos[18] = 0.951057			 sin[18] = 0.309017
cos[19] = 0.9455189996447286			 sin[19] = 0.325568
cos[20] = 0.939693			 sin[20] = 0.34202
cos[21] = 0.9335799996447286			 sin[21] = 0.358368
cos[22] = 0.927184			 sin[22] = 0.374607
cos[23] = 0.9205049997157829			 sin[23] = 0.390731
cos[24] = 0.913545			 sin[24] = 0.406737
cos[25] = 0.9063079997157829			 sin[25] = 0.422618
cos[26] = 0.8987939997157829			 sin[26] = 0.438371
cos[27] = 0.891007			 sin[27] = 0.45399
cos[28] = 0.882948			 sin[28] = 0.469472
cos[29] = 0.87462			 sin[29] = 0.4848099997157829
cos[30] = 0.866025			 sin[30] = 0.5
cos[31] = 0.857167			 sin[31] = 0.5150379997157829
cos[32] = 0.8480479997157829			 sin[32] = 0.529919
cos[33] = 0.8386709997157829			 sin[33] = 0.544639
cos[34] = 0.829038			 sin[34] = 0.559193
cos[35] = 0.819152			 sin[35] = 0.573576
cos[36] = 0.8090169997157829			 sin[36] = 0.587785
cos[37] = 0.798636			 sin[37] = 0.601815
cos[38] = 0.7880109997157829			 sin[38] = 0.615661
cos[39] = 0.7771459997157829			 sin[39] = 0.62932
cos[40] = 0.7660439997157829			 sin[40] = 0.642788
cos[41] = 0.75471			 sin[41] = 0.6560589997157829
cos[42] = 0.743145			 sin[42] = 0.669131
cos[43] = 0.731354			 sin[43] = 0.681998
cos[44] = 0.71934			 sin[44] = 0.694658
cos[45] = 0.707106999715783			 sin[45] = 0.707106999715783
cos[46] = 0.694658			 sin[46] = 0.71934
cos[47] = 0.681998			 sin[47] = 0.731354
cos[48] = 0.669131			 sin[48] = 0.743145
cos[49] = 0.6560589997157829			 sin[49] = 0.75471
cos[50] = 0.642788			 sin[50] = 0.7660439997157829
cos[51] = 0.62932			 sin[51] = 0.7771459997157829
cos[52] = 0.615661			 sin[52] = 0.7880109997157829
cos[53] = 0.601815			 sin[53] = 0.798636
cos[54] = 0.587785			 sin[54] = 0.8090169997157829
cos[55] = 0.573576			 sin[55] = 0.819152
cos[56] = 0.559193			 sin[56] = 0.829038
cos[57] = 0.544639			 sin[57] = 0.8386709997157829
cos[58] = 0.529919			 sin[58] = 0.8480479997157829
cos[59] = 0.5150379997157829			 sin[59] = 0.857167
cos[60] = 0.5			 sin[60] = 0.866025
cos[61] = 0.4848099997157829			 sin[61] = 0.87462
cos[62] = 0.469472			 sin[62] = 0.882948
cos[63] = 0.45399			 sin[63] = 0.891007
cos[64] = 0.438371			 sin[64] = 0.8987939997157829
cos[65] = 0.422618			 sin[65] = 0.9063079997157829
cos[66] = 0.406737			 sin[66] = 0.913545
cos[67] = 0.390731			 sin[67] = 0.9205049997157829
cos[68] = 0.374607			 sin[68] = 0.927184
cos[69] = 0.358368			 sin[69] = 0.9335799996447286
cos[70] = 0.34202			 sin[70] = 0.939693
cos[71] = 0.325568			 sin[71] = 0.9455189996447286
cos[72] = 0.309017			 sin[72] = 0.951057
cos[73] = 0.2923719998578915			 sin[73] = 0.9563049996447286
cos[74] = 0.2756369998578915			 sin[74] = 0.9612619996447286
cos[75] = 0.258819			 sin[75] = 0.9659259996447286
cos[76] = 0.24192199985789145			 sin[76] = 0.970296
cos[77] = 0.22495099992894574			 sin[77] = 0.97437
cos[78] = 0.20791199992894574			 sin[78] = 0.9781479996447286
cos[79] = 0.19080899992894573			 sin[79] = 0.9816269996447287
cos[80] = 0.173648			 sin[80] = 0.984808
cos[81] = 0.156434			 sin[81] = 0.987688
cos[82] = 0.139173			 sin[82] = 0.990268
cos[83] = 0.12186899992894573			 sin[83] = 0.992546
cos[84] = 0.104528			 sin[84] = 0.994522
cos[85] = 0.08715599997157829			 sin[85] = 0.9961949996447287
cos[86] = 0.06975599997157829			 sin[86] = 0.997564
cos[87] = 0.052336			 sin[87] = 0.9986299996447286
cos[88] = 0.034899			 sin[88] = 0.9993909996447287
cos[89] = 0.017452			 sin[89] = 0.999848
cos[90] = 0.0			 sin[90] = 1.0
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