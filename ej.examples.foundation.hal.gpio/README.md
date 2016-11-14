# Overview
This example shows how to use gpio.
The pins are configured for a YwroBot Easy Module Shield V1

# Usage
## Run on device
### Build
1. Right Click on [ExampleGPIO.java](ej.examples.foundation.hal.gpio/src/main/java/ej/examples/foundation/hal/gpio/ExampleGPIO.java)
1. Select **Run as -> Run Configuration**
1. Select **MicroEJ Application** configuration kind
1. Click on **New launch configuration** icon
1. In **Execution** tab
	1. In **Target** frame, in **Platform** field, select a relevant platform (but not a virtual device)
	1. In **Execution** frame
		1. Select **Execute on Device**
		2. In **Settings** field, select **Build & Deploy**
1. Press **Apply**
1. Press **Run**
1. Copy the generated `.out` file path shown by the console

### Flash
1. Use the appropriate flashing tool.

# Requirements
* MicroEJ SDK 4.0 or later
* A platform with at least:
	* EDC-1.2 or higher
	* HAL-1.0 or higher

## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.

# Source
N/A

# Restrictions
None.

