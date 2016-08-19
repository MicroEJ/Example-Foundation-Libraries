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
public class GPIOAnalogInput extends GPIOInputOutput {
	private static int ANALOG_PORT = 31;

	private boolean hasChangedValue;
	private int currentValue;
	private int noiseThreshold;
	
	/**
	 *
	 * @param pin
	 */
	public GPIOAnalogInput(int pin, int noiseThreshold) {
		super(ANALOG_PORT,pin,Mode.ANALOG_INPUT);

		this.noiseThreshold = noiseThreshold;
		//first reading to set initial value
		this.currentValue = GPIO.getAnalogValue(ANALOG_PORT, pin);
		this.hasChangedValue = false;
	}


	/**
	 * Gets the value.
	 *
	 * @return the value.
	 */
	public int getValue() {
		return currentValue;
	}

	public void updateValue() {
		final int readValue = GPIO.getAnalogValue(ANALOG_PORT, pin);

		final int absoluteDiff = Math.abs(readValue - this.currentValue); 
		if ( absoluteDiff > this.noiseThreshold )
		{
			this.hasChangedValue = true;
			this.currentValue = readValue;
		}
		else
		{
			this.hasChangedValue = false;
		}
	}
	
	public boolean hasChangedValue()
	{
		boolean result = this.hasChangedValue;
		if ( this.hasChangedValue )
		{
			this.hasChangedValue = false;
		}

		return result;
	}

	public static void setAnalogPort(int port) {
		ANALOG_PORT = port;
	}

	public static int getAnalogPort() {
		return ANALOG_PORT;
	}
}
