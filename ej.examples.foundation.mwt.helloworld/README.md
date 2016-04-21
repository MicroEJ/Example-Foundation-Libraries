This example shows a simple hello world using MWT.

# Run on the Simulator
1. Right Click on the project
1. Select **Run as -> MicroEJ Application**
1. Select your jpf 
1. Press **Ok**

# Run on the board
## Build
1. Right Click on [ExampleHelloWorld.java](ej.examples.foundation.mwt.helloworld/src/main/java/ej/examples/foundation/mwt/helloworld/ExampleHelloWorld.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Select **Execute on EmbJPF**
1. Select **Build & Deploy**
1. Go to **Execution tab**
	* Select your jpf 
1. Press **Apply**
1. Press **Run**
1. Copy the generated .out file path

## Flash
1. Select **Run -> Run Configuration**
1. Select **MicroEJ Tool**
1. Click on **New launch configuration** icon
1. Select your jpf 
1. Select **Program with St link**
1. Go to **Configuration tab**
	* Set the **Java application definition** field to the generated .out file path
1. Press **Apply**
1. Press **Run**

