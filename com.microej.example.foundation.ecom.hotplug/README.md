# Overview

This example shows how to listen on plug/unplug of dynamic ComConnections and shows their properties.

# Usage

## Run on device

Note that this must not be a virtual device

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
    1. Go to **Libraries -> ECOM**
        1. Check **Enable registration event notifications**
    1. Go to **Libraries -> ECOM -> Comm Connection**
        1. Check **Enable comm connections**
        2. Map the UART com port (available on your platform documentation) to the application port `42`
        3. Check **Enable dynamic comm ports registration**
7. Press **Apply**
8. Press **Run**
9. The application file (`.o` or `.out`) has been generated

### Flash

1. Use the appropriate MicroEJ tool.

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