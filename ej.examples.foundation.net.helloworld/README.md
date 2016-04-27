# Overview
This example shows a simple helloworld using NET.

# Usage
## Configuration
1. Set the `HOST` in [HelloWorldConstants.java](ej.examples.foundation.net.helloworld/src/main/java/ej/examples/foundation/net/helloworld/HelloWorldConstants.java)

## Run on MicroEJ Simulator
1. Right Click on 
	* [ExampleServer.java](ej.examples.foundation.net.helloworld/src/main/java/ej/examples/foundation/net/helloworld/ExampleServer.java)
	* OR [ExampleClient.java](ej.examples.foundation.net.helloworld/src/main/java/ej/examples/foundation/net/helloworld/ExampleClient.java)
1. Select **Run as -> MicroEJ Application**
1. Select your platform 
1. Press **Ok**


## Run on device
### Build
1. Right Click on 
	* [ExampleServer.java](ej.examples.foundation.net.helloworld/src/main/java/ej/examples/foundation/net/helloworld/ExampleServer.java)
	* OR [ExampleClient.java](ej.examples.foundation.net.helloworld/src/main/java/ej/examples/foundation/net/helloworld/ExampleClient.java)
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
* MicroEJ Studio or SDK 4.0 or later
* A platform with at least:
	* EDC-1.2 or higher
	* NET-1.0 or higher

## Dependencies
_All dependencies are retrieved transitively by Ivy resolver_.