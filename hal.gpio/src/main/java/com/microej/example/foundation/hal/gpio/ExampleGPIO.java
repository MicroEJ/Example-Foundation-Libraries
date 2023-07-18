/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.hal.gpio;

/**
 *
 */
public class ExampleGPIO  {


	public static void main(String[] args) {
		// Set the port for digital input and output
		GPIODigitalOutput.setDigitalPort(Shield.DIGITAL_PORT);
		GPIODigitalInput.setDigitalPort(Shield.DIGITAL_PORT);
		// Set the port for analog input.
		GPIOAnalogInput.setAnalogPort(Shield.ANALOG_PORT);

		new LedManager();
		new ButtonManager();
		new AnalogInputManager();

	}

}
