/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.hal.gpio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 */
public class LedManager implements Runnable {

	public static final int SLEEP = 150;

	private enum MODES {
		caterpillar, bounce, kit, strobe, random
	};

	private final int[] MULTI_FUNCTION_SHIELD_LED = {
			Shield.PIN_DIGITAL_LED1,
			Shield.PIN_DIGITAL_LED2,
			Shield.PIN_DIGITAL_LED_RGB_R,
			Shield.PIN_DIGITAL_LED_RGB_G,
			Shield.PIN_DIGITAL_LED_RGB_B
	};


	// All the leds
	private final List<GPIODigitalOutput> leds;

	/**
	 *
	 */
	public LedManager() {
		super();
		leds = new ArrayList<GPIODigitalOutput>();

		// Init all leds
		for (int led : MULTI_FUNCTION_SHIELD_LED) {
			leds.add(new GPIODigitalOutput(led));
		}

		new Thread(this).start();
	}

	@Override
	public void run() {
		MODES mode = MODES.caterpillar;
		do{
			switch (mode) {
			case caterpillar: // loop 0->1->2
				caterpillar();
				break;
			case bounce: // bounce 0->1->2->1->0
				bounce();
				break;
			case kit: // kit 0->01->012->01->0
				kit();
				break;
			case strobe: // all off -> all on
				strobe();
				break;
			case random: // random
				random();
				break;
			}
			sleep();


			// change mode
			int nextMode = mode.ordinal() + 1;
			mode = MODES.values()[nextMode % MODES.values().length];
		} while (true); // Stop with the system.
	}

	/**
	 * Toggle each led one after the other.
	 * Led 0 : Off, Led 1 : Off, Led 2 : Off
	 * Led 0 : On,  Led 1 : Off, Led 2 : Off
	 * Led 0 : Off, Led 1 : On,  Led 2 : Off
	 * Led 0 : Off, Led 1 : Off, Led 2 : On
	 */
	private void caterpillar() {
		// Init
		switchAllLedsOff();
		sleep();

		GPIODigitalOutput previous = leds.get(0);
		for (int i = 0; i < leds.size(); i++) {
			previous = toggle(previous, leds.get(i));
		}
	}


	/**
	 *
	 * Toggle each led one after the other then back.
	 * Led 0 : Off, Led 1 : Off, Led 2 : Off
	 * Led 0 : On,  Led 1 : Off, Led 2 : Off
	 * Led 0 : Off, Led 1 : On,  Led 2 : Off
	 * Led 0 : Off, Led 1 : Off, Led 2 : On
	 * Led 0 : Off, Led 1 : On,  Led 2 : Off
	 * Led 0 : On,  Led 1 : Off, Led 2 : Off
	 *
	 */
	private void bounce() {
		caterpillar();
		GPIODigitalOutput previous = leds.get(leds.size() - 1);
		for (int i = leds.size() - 1; i >= 0; i--) {
			previous = toggle(previous, leds.get(i));
		}
	}

	/**
	 * toggle one led and the previous.
	 *
	 * @param previous
	 *            Previous led, to switch off
	 * @param current
	 *            Led to switch on
	 * @return The current led
	 */
	private GPIODigitalOutput toggle(GPIODigitalOutput previous, GPIODigitalOutput current) {
		// Switch off previous light
		previous.switchOff();
		// Switch on light
		current.switchOn();
		sleep();
		return current;
	}

	/**
	 *
	 * Toggle switch all leds off then on.
	 * Led 0 : Off, Led 1 : Off, Led 2 : Off
	 * Led 0 : On,  Led 1 : Off, Led 2 : Off
	 * Led 0 : On,  Led 1 : On,  Led 2 : Off
	 * Led 0 : On,  Led 1 : On,  Led 2 : On
	 *
	 */
	private void kit() {
		// Init
		switchAllLedsOff();
		sleep();

		// switch of all leds on
		for (GPIODigitalOutput led : leds) {
			led.switchOn();
		}
	}

	/**
	 *
	 * Toggle switch led on one after the other
	 * Led 0 : Off, Led 1 : Off, Led 2 : Off
	 * Led 0 : On,  Led 1 : On,  Led 2 : On
	 *
	 */
	private void strobe() {
		for (int i = 0; i < leds.size(); i++) {
			// switch of all leds off
			switchAllLedsOff();
			sleep();
			// switch of all leds on
			for (GPIODigitalOutput led : leds) {
				led.switchOn();
			}
			sleep();
		}
	}

	/**
	 *
	 * Toggle led on randomly
	 *
	 */
	private void random() {
		// Init
		switchAllLedsOff();
		sleep();

		Random random = new Random();
		GPIODigitalOutput previous = leds.get(0);
		for (int i = 0; i < leds.size(); i++) {
			GPIODigitalOutput next = leds.get(random.nextInt(leds.size() - 1));
			previous.switchOff();
			next.switchOn();
			previous = next;
		}
	}

	private void switchAllLedsOff() {
		// switch off all leds off
		for (GPIODigitalOutput led : leds) {
			led.switchOff();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {
		}
	}

}
