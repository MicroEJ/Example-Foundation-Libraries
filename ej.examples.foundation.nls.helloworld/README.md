# Overview
This example shows how to print a string on a display.

# Usage
## Run on MicroEJ Simulator
1. Right Click on [ExampleNLS.java](ej.examples.foundation.nls.helloworld/src/main/java/ej/examples/foundation/nls/helloworld/ExampleNLS.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Go to **Execution** tab
	* Select your platform 
1. Go to **Configuration** tab
	* Go to **Libraries -> NLS**
		* Check Use NLS messages
		* Set the **NLS list file** to`${project_loc:ej.examples.foundation.nls.helloworld}/src/main/resources/ej/examples/foundation/nls/helloworld/examples.fonts.list`
1. Press **Apply**
1. Press **Run**


## Run on device
### Build
1. Right Click on [ExampleNLS.java](ej.examples.foundation.nls.helloworld/src/main/java/ej/examples/foundation/nls/helloworld/ExampleNLS.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Select **Execute on Device**
1. Select **Build & Deploy**
1. Go to **Execution** tab
	* Select your platform 
1. Go to **Configuration** tab
	* Go to **Libraries -> NLS**
		* Check Use NLS messages
		* Set the **NLS list file** to`${project_loc:ej.examples.foundation.nls.helloworld}/src/main/resources/ej/examples/foundation/nls/helloworld/examples.fonts.list`
1. Press **Apply**
1. Press **Run**
1. Copy the generated `.out` file path

### Flash
1. Select **Run -> Run Configuration**
1. Select **MicroEJ Tool**
1. Click on **New launch configuration** icon
1. Select your platform 
1. Select **Program with ST Link**
1. Go to **Configuration tab**
	* Set the **Java Application Definition** field to the generated `.out` file path
1. Press **Apply**
1. Press **Run**

# Requirements
* MicroEJ Studio or SDK 4.0 or later
* A platform with at least:
	* EDC-1.2 or higher
	* MICROUI-2.0 or higher
	* NLS-2.0 or higher

## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.