/*
 * Java
 *
 * Copyright 2016-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.hal.gpio;

import ej.hal.gpio.GPIO;
import ej.hal.gpio.GPIO.Mode;

/**
 *
 */
public abstract class GPIOInputOutput {

	protected final int pin;

	/**
	 *
	 * @param pin
	 */
	protected GPIOInputOutput(int port, int pin, Mode mode) {
		super();
		this.pin = pin;
		GPIO.setMode(port, pin, mode);
	}


	public int getPin() {
		return this.pin;
	}

}
