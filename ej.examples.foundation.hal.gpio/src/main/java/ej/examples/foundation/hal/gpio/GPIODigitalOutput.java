/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.hal.gpio;

import ej.hal.gpio.GPIO;
import ej.hal.gpio.GPIO.Mode;

/**
 *
 */
public class GPIODigitalOutput extends GPIOInputOutput {
	private static int DIGITAL_PORT = 30;

	private static final boolean DIGITAL_LOW = true;
	private static final boolean DIGITAL_HIGH = false;

	private boolean on;

	/**
	 *
	 * @param pin
	 */
	public GPIODigitalOutput(int pin) {
		super(DIGITAL_PORT, pin, Mode.DIGITAL_OUTPUT);
	}

	public int getPin() {
		return this.pin;
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
