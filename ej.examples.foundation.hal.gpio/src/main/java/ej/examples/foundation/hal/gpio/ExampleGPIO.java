/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.examples.foundation.hal.gpio;

/**
 *
 */
public class ExampleGPIO  {


	public static void main(String[] args) {
		// Set the port for the leds.
		GPIOLed.setDigitalPort(Shield.DIGITAL_PORT);

		new LedManager();
		new ButtonManager();
	}

}
