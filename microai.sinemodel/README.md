# Overview

This example shows how to run an inference on a basic sine model.

This sine model has been trained to return the sine value of an input float.

More information about MicroAI Foundation Library can be found in the [ApplicationDeveloperGuide](https://docs.microej.com/en/latest/ApplicationDeveloperGuide/microai.html).

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * BON-1.4 or higher.
    * MICROAI-2.0 or higher.

This example has been tested on:

- IntelliJ IDEA with MicroEJ plugin for IntelliJ IDEA ``1.2.0``.
- [sim-vee-port](../sim-vee-port) VEE Port project (Simulator only).

# Usage

Follow [MICROEJ SDK 6 Installation Guide](https://docs.microej.com/en/latest/SDK6UserGuide/install.html) to set up the SDK.

## Run on Simulator

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :microai.sinemodel:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Expected Behavior

The sample will print the characteristics of the model, then run inferences on a set of input values.
```
[microai sine sample] INFO: MicroAI Sample on Sine model
[microai sine sample] INFO: Input:
[microai sine sample] INFO:     Tensor Count: 1
[microai sine sample] INFO:     Tensor Dimensions: 2
[microai sine sample] INFO:     Tensor Shape: [1, 1]
[microai sine sample] INFO:     Data Type: 3
[microai sine sample] INFO:     Tensor Elements: 1
[microai sine sample] INFO:     data length: 4
[microai sine sample] INFO:      quantized: false
[microai sine sample] INFO:         Scale: 0.0
[microai sine sample] INFO:         Zero : 0
[microai sine sample] INFO: Output:
[microai sine sample] INFO:     Tensor Count: 1
[microai sine sample] INFO:     Tensor Dimensions: 2
[microai sine sample] INFO:     Tensor Shape: [1, 1]
[microai sine sample] INFO:     Data Type: 3
[microai sine sample] INFO:     Tensor Elements: 1
[microai sine sample] INFO:     data length: 4
[microai sine sample] INFO:     quantized: false
[microai sine sample] INFO:         Scale: 0.0
[microai sine sample] INFO:         Zero : 0
```

The results of the interpreter are logged into the console.

```
[microai sine sample] INFO: ============================
[microai sine sample] INFO: Run inferences on sine model:
[microai sine sample] INFO: ============================
[microai sine sample] INFO: sinus(0) = 0.040830173
[microai sine sample] INFO: sinus(PI/4) = 0.7149629
[microai sine sample] INFO: sinus(PI/2) = 1.0046204
[microai sine sample] INFO: sinus(3*PI/4) = 0.7130069
[microai sine sample] INFO: sinus(PI) = 0.014684498
[microai sine sample] INFO: sinus(5*PI/4) = -0.70124036
[microai sine sample] INFO: sinus(3*PI/2) = -1.0006135
[microai sine sample] INFO: sinus(7*PI/4) = -0.71546686
[microai sine sample] INFO: sinus(2*PI) = -0.08672099
```

# Dependencies

The dependencies defined in [build.gradle.kts](build.gradle.kts)
are configured in [libs.versions.toml](../gradle/libs.versions.toml).

_All dependencies are retrieved transitively by Gradle_.

# Source

N/A

# Restrictions

None.

---
_Copyright 2025 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
