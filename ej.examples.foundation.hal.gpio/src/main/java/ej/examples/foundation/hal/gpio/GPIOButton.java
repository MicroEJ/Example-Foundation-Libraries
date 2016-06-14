/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.examples.foundation.hal.gpio;

import ej.hal.gpio.GPIO;
import ej.hal.gpio.GPIO.Mode;

/**
 *
 */
public class GPIOButton {
	private static int DIGITAL_PORT = 30;

	private final int pin;

	/**
	 *
	 * @param pin
	 */
	public GPIOButton(int pin) {
		super();
		this.pin = pin;
		GPIO.setMode(DIGITAL_PORT, pin, Mode.DIGITAL_INPUT);
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
