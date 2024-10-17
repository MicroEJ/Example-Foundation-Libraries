# Overview

This example shows how to record audio.

# Requirements

* MICROEJ SDK 6.
* A VEE Port that contains:
    * EDC-1.3 or higher.
    * BON-1.4 or higher.
    * FS-2.1 or higher.
    * AUDIO-1.0 or higher.

# Usage

The sample records 5 seconds of audio data and saves it to a file (in `build/output/filesystem` folder on simulator).
The file can be played with an audio software to check that the audio data is valid.
For example with [Audacity](https://www.audacityteam.org/), the file can be imported by selecting `File` > `Import` > `Raw Data...`, selecting the `record.raw` file and selecting the correct audio format (16-bit PCM, 1 channel, 16000 Hz).
If the VEE Port does not provide FS, the example can be changed to use an other way to log the recorded audio data.

By default, the sample does not load VEE Port and thus it cannot be built for a device nor ran on the simulator.

Refer to the [Select a VEE Port](https://docs.microej.com/en/latest/SDK6UserGuide/selectVeePort.html) documentation for more information.

# Dependencies

_All dependencies are retrieved transitively by Gradle_.

# Source

N/A

# Restrictions

None.

---
_Copyright 2024 MicroEJ Corp. All rights reserved._  
_Use of this source code is governed by a BSD-style license that can be found with this software._  
