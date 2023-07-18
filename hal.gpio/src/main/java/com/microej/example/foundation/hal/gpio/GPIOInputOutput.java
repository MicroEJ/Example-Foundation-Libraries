/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
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
