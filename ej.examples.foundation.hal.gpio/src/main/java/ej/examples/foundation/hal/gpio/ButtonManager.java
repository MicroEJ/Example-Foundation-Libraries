/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.examples.foundation.hal.gpio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class ButtonManager implements Runnable {

	public static final int SLEEP = 150;

	private final int[] MULTI_FUNCTION_BUTTONS = { Shield.PIN_DIGITAL_BTN1, Shield.PIN_DIGITAL_BTN2 };

	// All the buttons
	private final List<GPIOButton> buttons;

	public ButtonManager() {
		super();
		buttons = new ArrayList<GPIOButton>();

		for (int button : MULTI_FUNCTION_BUTTONS) {
			buttons.add(new GPIOButton(button));
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
			for (int i = 0; i < buttons.size(); i++) {

				if ( ! buttons.get(i).isUp() )
				{
					System.out.println("Button " + i + " down");
				};
			}
			sleep();
		} while(true);
	}

}