# Overview

This example shows how to run an image classification model on a given dataset.

The model and the data used originate from TensorFlow Lite Micro [MNIST LSTM](https://github.com/tensorflow/tflite-micro/tree/main/tensorflow/lite/micro/examples/mnist_lstm) example.

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

The sample runs through ten 32x32 bitmap images of handwritten digits, taken from the MNIST database.
Each image pixel bitmap will be given as an input to the model which will return the digit prediction.

For simplicity, the original PNG files have been converted to BMP.

## Run on Simulator

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :microai.mnist_lstm:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Expected Behavior

The results of the interpreter are logged into the console.

The ASCII representation of the image is for cosmetics only, it is not the actual data given to the model interpreter.
```
----------------------------
----------------------------
----------------------------
----------------------------
----------------------------
----------------------------
----------------------------
------******----------------
------****************------
------****************------
-----------***********------
------------------****------
-----------------****-------
-----------------****-------
----------------****--------
----------------****--------
---------------****---------
---------------***----------
--------------****----------
-------------****-----------
------------*****-----------
------------****------------
-----------*****------------
-----------****-------------
----------*****-------------
----------*****-------------
----------****--------------
----------------------------
[microai mnist lstm sample] INFO: image: 7 -> prediction: 7 with confidence: 99%
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
