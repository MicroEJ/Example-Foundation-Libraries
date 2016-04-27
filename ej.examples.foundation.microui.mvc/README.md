# Overview
This example shows how to create and use a MVC design pattern.

# Usage
## Run on MicroEJ Simulator
1. Right Click on the project
1. Select **Run as -> MicroEJ Application**
1. Select your platform 
1. Press **Ok**


## Run on device
### Build
1. Right Click on [ExampleMVC.java](ej.examples.foundation.microui.mvc/src/main/java/ej/examples/foundation/microui/mvc/ExampleMVC.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Select **Execute on Device**
1. Select **Build & Deploy**
1. Go to **Execution** tab
	* Select your platform 
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