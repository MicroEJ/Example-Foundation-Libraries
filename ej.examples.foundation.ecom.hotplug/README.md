# Overview
This example shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.

# Usage
## Run on device
### Build
1. Right Click on [ExampleHotPlug.java](ej.examples.foundation.ecom.hotplug/src/main/java/ej/examples/foundation/ecom/hotplug/ExampleHotPlug.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Select **Execute on Device**
1. Select **Build & Deploy**
1. Go to **Execution** tab
	* Select your platform 
1. Go to **Configuration** tab
	* Go to **Libraries -> ECOM -> Comm Connection**
		* Check **Enable comm connections**
		* Map the UART com port (available on your platform documentation) to the application port `42`
	* Go to **Target  -> Deploy -> Means**
		* Put No deployment
1. Press **Apply**
1. Press **Run**
1. Copy the generated `.out` file path

### Flash
1. Use the appropriate MicroEJ tool.

# Requirements
* MicroEJ Studio or SDK 4.0 or later
* A platform with at least:
	* EDC-1.2 or higher
	* ECOM-1.1 or higher
	* ECOM-COMM-1.1 or higher


## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.
