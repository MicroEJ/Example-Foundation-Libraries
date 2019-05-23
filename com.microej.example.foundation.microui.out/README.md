# Overview

This example shows how to do the redirection of the standard SystemOut to the display.

# Usage

## Run on MicroEJ Simulator

1. Right-click on the project
2. Select **Run as -> Run Configuration** 
3. Right-click on **MicroEJ Application** configuration kind
4. Click on **New**
5. Go to **Execution** tab
    * Select your platform 
6. Go to **Configuration** tab
    * Go to **Libraries -> EDC**
        * Check **Use a custom Java output stream**
        * Set the class to `com.microej.example.foundation.microui.out.OutputStreamRedirection`
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
    * Go to **Libraries -> EDC**
        * Check **Use a custom Java output stream**
        * Set the class to `com.microej.example.foundation.microui.out.OutputStreamRedirection`
7. Press **Apply**
8. Press **Run**
9. The application file (`.o` or `.out`) has been generated

### Flash

1. Use the appropriate flashing tool.

# Requirements

This example has been tested on:

* MicroEJ SDK 5.1
* With a platform that contains:
    * EDC-1.2
    * MICROUI-2.0

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