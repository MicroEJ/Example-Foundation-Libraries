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
