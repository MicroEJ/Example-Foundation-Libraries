/*
 * Java
 *
 * Copyright 2016-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
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
