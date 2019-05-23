# Overview

This example shows how to write some bytes to a CommConnection.

# Usage

## Run on MicroEJ Simulator

1. Right-click on the project
2. Select **Run as -> Run Configuration** 
3. Right-click on **MicroEJ Application** configuration kind
4. Click on **New**
5. In **Execution** tab
    1. In **Target** frame, in **Platform** field, select a relevant platform (but not a virtual device)
    2. In **Execution** frame
        1. Select **Execute on Simulator**
6. In **Configuration** tab
    1. Go to **Libraries -> ECOM -> Comm Connection**
        1. Check **Enable comm connections**
        2. Map the UART com port (available on your platform documentation) to the application port `42`
    2. Go to **Simulator -> Com Port**
        1. Select simulation type UART <-> FILE
        2. Set the **File input mapping** field to `${project_loc:com.microej.example.foundation.ecom.writer}/sim/filein.txt`
        3. Set the **File output mapping** field to `${project_loc:com.microej.example.foundation.ecom.writer}/sim/fileout.txt`
7. Press **Apply**
8. Press **Run**

## Run on device

### Build

1. Right-click on the project
2. Select **Run as -> Run Configuration**
3. Right-click on **MicroEJ Application** configuration kind
4. Click on **New**
5. In **Execution** tab
    1. In **Target** frame, in **Platform** field, select a relevant platform (but not a virtual device)
    2. In **Execution** frame
        1. Select **Execute on Device**
        2. In **Settings** field, select **Build & Deploy**
6. In **Configuration** tab
    1. Go to **Libraries -> ECOM -> Comm Connection**
        1. Check **Enable comm connections**
        2. Map the UART com port (available on your platform documentation) to the application port `42`
7. Press **Apply**
8. Press **Run**
9. The application file (`.o` or `.out`) has been generated
10. Use an serial connection to your board's UART with this configuration:
    * baudrate: 9600
    * bitsperchar: 8
    * stopbits: 1
    * parity: none

### Flash

1. Use the appropriate flashing tool.

## Troubleshooting

1. When executing I get the error **ECOM-COMM: Invalid connection descriptor.**
    * The port com has not been correctly set, redo the steps **Go to Configuration tab**

# Requirements

This example has been tested on:

* MicroEJ SDK 5.1
* With a platform that contains:
    * EDC-1.2
    * ECOM-1.1
    * ECOM-COMM-1.1

## Dependencies

_All dependencies are retrieved transitively by Ivy resolver_.

# Source

N/A

# Restrictions

None. 
---  
_Markdown_   
_Copyright 2016-2019 MicroEJ Corp. All rights reserved._   
_For demonstration purpose only._   
_MicroEJ Corp. PROPRIETARY. Use is subject to license terms._  