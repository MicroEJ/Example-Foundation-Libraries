/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.hal.gpio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AnalogInputManager implements Runnable {

	private static final int SAMPLING_PERIOD = 20;
	private static final int ONE_PERCENT_ANALOG_RANGE = ( Shield.ANALOG_MAX_VALUE - Shield.ANALOG_MIN_VALUE ) / 100;
	
	private static final int[] MULTI_FUNCTION_ANALOG_INPUT = { Shield.PIN_ANALOG_POT };

	// All the analog inputs
	private final List<GPIOAnalogInput> analogInputs;

	public AnalogInputManager() {
		super();
		analogInputs = new ArrayList<GPIOAnalogInput>();

 
		for (int analogInput : MULTI_FUNCTION_ANALOG_INPUT) {
			analogInputs.add(new GPIOAnalogInput(analogInput,ONE_PERCENT_ANALOG_RANGE));
		}

		new Thread(this).start();
	}
	

	private void sleep() {
		try {
			Thread.sleep(SAMPLING_PERIOD);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		do
		{
			for (GPIOAnalogInput analogInput : analogInputs) {
				analogInput.updateValue();
				if ( true == analogInput.hasChangedValue() )
				{
					System.out.println("Value changed for sensor " + analogInput.getPin() + " : " + analogInput.getValue());
				}
			}
			sleep();
		} while(true);
	}

}