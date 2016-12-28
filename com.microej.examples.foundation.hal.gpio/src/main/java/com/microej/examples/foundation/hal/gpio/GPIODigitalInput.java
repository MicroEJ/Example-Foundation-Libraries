/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.hal.gpio;

import ej.hal.gpio.GPIO;
import ej.hal.gpio.GPIO.Mode;

/**
 *
 */
public class GPIODigitalInput extends GPIOInputOutput {
	private static int DIGITAL_PORT = 30;

	/**
	 *
	 * @param pin
	 */
	public GPIODigitalInput(int pin) {
		super(DIGITAL_PORT,pin, Mode.DIGITAL_INPUT);
	}


	/**
	 * Gets the on.
	 *
	 * @return the on.
	 */
	public boolean isUp() {
		return GPIO.getDigitalValue(DIGITAL_PORT, pin);
	}

	public static void setDigitalPort(int port) {
		DIGITAL_PORT = port;
	}

	public static int getDigitalPort() {
		return DIGITAL_PORT;
	}
}
