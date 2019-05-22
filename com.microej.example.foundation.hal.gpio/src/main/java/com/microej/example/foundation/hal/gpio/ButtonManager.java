/*
 * Java
 *
 * Copyright 2016-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.hal.gpio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class ButtonManager implements Runnable {

	public static final int SLEEP = 150;

	private static final int[] MULTI_FUNCTION_SHIELD_DIGITAL_BUTTONS = { Shield.PIN_DIGITAL_BTN1, Shield.PIN_DIGITAL_BTN2 };

	// All the buttons
	private final List<GPIODigitalInput> buttons;

	public ButtonManager() {
		super();
		buttons = new ArrayList<GPIODigitalInput>();

		for (int button : MULTI_FUNCTION_SHIELD_DIGITAL_BUTTONS) {
			buttons.add(new GPIODigitalInput(button));
		}

		new Thread(this).start();
	}
	

	private void sleep() {
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		do
		{
			for (GPIODigitalInput button : buttons) {

				if ( ! button.isUp() )
				{
					System.out.println("Button " + button.getPin() + " down");
				};
			}
			sleep();
		} while(true);
	}

}