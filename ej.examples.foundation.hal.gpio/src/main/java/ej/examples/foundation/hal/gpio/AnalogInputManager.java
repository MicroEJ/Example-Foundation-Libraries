/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.examples.foundation.hal.gpio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AnalogInputManager implements Runnable {

	private static final int SAMPLING_PERIOD = 20;
	private static final int ONE_PERCENT_ANALOG_RANGE = ( Shield.ANALOG_MAX_VALUE - Shield.ANALOG_MIN_VALUE ) / 100;
	
	private final int[] MULTI_FUNCTION_ANALOG_SENSOR = { Shield.PIN_ANALOG_POT };

	// All the buttons
	private final List<GPIOAnalogInput> analogSensors;

	public AnalogInputManager() {
		super();
		analogSensors = new ArrayList<GPIOAnalogInput>();

 
		for (int analogSensor : MULTI_FUNCTION_ANALOG_SENSOR) {
			analogSensors.add(new GPIOAnalogInput(analogSensor,ONE_PERCENT_ANALOG_RANGE));
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
			for (GPIOAnalogInput analogSensor : analogSensors) {
				analogSensor.updateValue();
				if ( true == analogSensor.hasChangedValue() )
				{
					System.out.println("Value changed : " + analogSensor.getValue());
				}
			}
			sleep();
		} while(true);
	}

}