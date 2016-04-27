# OverviewThis example shows how to do the redirection of the standard SystemOut to the display.

# Usage
## Run on MicroEJ Simulator
1. Right Click on [ExampleSysOutRedirection.java](ej.examples.foundation.microui.out/src/main/java/ej/examples/foundation/microui/out/ExampleSysOutRedirection.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Go to **Execution** tab
	* Select your platform 
1. Go to **Configuration** tab
	* Go to **Libraries -> EDC**
		* Check **Use a custom Java output stream**
		* Set the class to `ej.examples.foundation.microui.out.OutputStreamRedirection`
1. Press **Apply**
1. Press **Run**


## Run on device
### Build
1. Right Click on [ExampleSysOutRedirection.java](ej.examples.foundation.microui.out/src/main/java/ej/examples/foundation/microui/out/ExampleSysOutRedirection.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Select **Execute on Device**
1. Select **Build & Deploy**
1. Go to **Execution** tab
	* Select your platform 
1. Go to **Configuration** tab
	* Go to **Libraries -> EDC**
		* Check **Use a custom Java output stream**
		* Set the class to `ej.examples.foundation.microui.out.OutputStreamRedirection`
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
* MicroEJ 4 or Higher
	* EDC-1.2 or higher
	* MICROUI-2.0 or higher

## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.