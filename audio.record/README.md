# Overview

This example shows how to record audio.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * BON-1.4 or higher.
    * FS-2.1 or higher.
    * AUDIO-1.0 or higher.

This example has been tested on:

- IntelliJ IDEA with MicroEJ plugin for IntelliJ IDEA ``1.1.0``.
- [sim-vee-port](../sim-vee-port) VEE Port project (Simulator only).

# Usage

Follow [MICROEJ SDK 6 Installation Guide](https://docs.microej.com/en/latest/SDK6UserGuide/install.html) to setup the SDK.

The sample records 5 seconds of audio data and saves it to a file (in `build/output/filesystem` folder on simulator).
The file can be played with an audio software to check that the audio data is valid.
For example with [Audacity](https://www.audacityteam.org/), the file can be imported by selecting `File` > `Import` > `Raw Data...`, selecting the `record.raw` file and selecting the correct audio format (16-bit PCM, 1 channel, 16000 Hz).
If the VEE Port does not provide FS, the example can be changed to use another way to log the recorded audio data.

By default, the sample runs only on simulator, using the [sim-vee-port](../sim-vee-port) VEE Port project.

Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html) documentation for more information.

## Run on Simulator

Run the following command in your IDE
(or click the ``Play`` button next to the line
below when opening this README in IntelliJ IDEA):

`./gradlew :audio.record:runOnSimulator`

Alternative ways to run in simulation are described in the [Run on Simulator](https://docs.microej.com/en/latest/SDK6UserGuide/runOnSimulator.html) documentation.

## Selecting a Recording Device on Simulator

The ``s3.audio.input.device`` option defines the name of the Audio input 
device to use when running the Application on Simulator.

This option is set in [common.properties](configuration/common.properties).

Be default, ``s3.audio.input.device`` is set to ``Primary Sound Capture Driver`` which will
use the default input device selected in Windows' ``Volume Mixer``.

On Windows, the default input device can be changed in:
``Settings > System > Sound > Volume Mixer``.

## Expected Behavior

The `record.raw` file contains the audio data recorded from the input sound device.

# Dependencies

The dependencies defined in [build.gradle.kts](build.gradle.kts)
are configured in [libs.versions.toml](../gradle/libs.versions.toml).

_All dependencies are retrieved transitively by Gradle_.

# Source

N/A

# Restrictions

None.

---
_Copyright 2024-2025 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
