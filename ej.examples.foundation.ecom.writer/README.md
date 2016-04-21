# Overview

This example shows how to write some bytes to a CommConnection.

# Run on the Simulator
1. Right Click on [ExampleUARTWriter.java](ej.examples.foundation.ecom.writer/src/main/java/ej/examples/foundation/ecom/uartwriter/ExampleUARTWriter.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Go to **Execution** tab
	* Select your jpf 
1. Go to **Configuration** tab
	* Go to **Libraries -> ECOM -> Comm Connection**
		* Check **Enable comm connections**
		* Map the UART com port (available on your platform documentation) to the application port `42`
	* Go to **Simulator -> Com Port**
		* Select simulation type UART <-> FILE
		* for the File input mapping choose `${project_loc:ej.examples.foundation.ecom.writer}/sim/filein.txt`
		* for the File output mapping choose `${project_loc:ej.examples.foundation.ecom.writer}/sim/fileout.txt`
1. Press **Apply**
1. Press **Run**

# Run on the board
## Build
1. Right Click on [ExampleUARTWriter.java](ej.examples.foundation.ecom.writer/src/main/java/ej/examples/foundation/ecom/uartwriter/ExampleUARTWriter.java)
1. Select **Run as -> Run Configuration** 
1. Click on **New launch configuration** icon
1. Select **Execute on EmbJPF**
1. Select **Build & Deploy**
1. Go to **Execution tab**
	* Select your jpf 
1. Go to **Configuration** tab
	* Go to **Libraries -> ECOM -> Comm Connection**
		* Check **Enable comm connections**
		* Map the UART com port (available on your platform documentation) to the application port `42`
	* Go to **Target  -> Deploy -> Means**
		* Put No deployment
	* Go to Libraries -> ECOM -> Comm Connection**
1. Press **Apply**
1. Press **Run**
1. Copy the path to the generated .out file
## Flash
1. Select **Run -> Run Configuration**
1. Select **MicroEJ Tool**
1. Click on **New launch configuration** icon
1. Select your jpf 
1. Select **Program with St link**
1. Go to **Configuration tab**
	* Put the path to the generated .out file
1. Press **Apply**
1. Press **Run**

# Troubleshooting
1. When executing I get the error **ECOM-COMM: Invalid connection descriptor.**
	* The port com has not been correctly set, redo the steps **Go to Configuration tab**
