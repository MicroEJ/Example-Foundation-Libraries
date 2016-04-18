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
public class GPIOLed {
	private static int DIGITAL_PORT = 30;

	private static final boolean DIGITAL_LOW = true;
	private static final boolean DIGITAL_HIGH = false;

	private final int pin;
	private boolean on;

	/**
	 *
	 * @param pin
	 */
	public GPIOLed(int pin) {
		super();
		this.pin = pin;
		GPIO.setMode(DIGITAL_PORT, pin, Mode.DIGITAL_OUTPUT);
	}

	public void switchOff() {
		GPIO.setDigitalValue(DIGITAL_PORT, pin, DIGITAL_LOW);
		on = false;
	}

	public void switchOn() {
		GPIO.setDigitalValue(DIGITAL_PORT, pin, DIGITAL_HIGH);
		on = true;
	}

	public void toggle() {
		if (on) {
			switchOff();
		} else {
			switchOn();
		}
	}

	/**
	 * Gets the on.
	 *
	 * @return the on.
	 */
	public boolean isOn() {
		return on;
	}


	public static void setDigitalPort(int port) {
		DIGITAL_PORT = port;
	}

	public static int getDigitalPort() {
		return DIGITAL_PORT;
	}
}
