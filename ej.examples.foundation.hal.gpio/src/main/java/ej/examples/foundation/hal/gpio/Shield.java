/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.examples.foundation.hal.gpio;

/**
 *
 */
public final class Shield {
	/**
	 * 'ON' digital value.
	 */
	public final static boolean DIGITAL_HIGH = false;
	/**
	 * 'OFF' digital value.
	 */
	public final static boolean DIGITAL_LOW = true;

	/**
	 * Minimal analog value.
	 */
	public final static int ANALOG_MIN_VALUE = 0;
	/**
	 * Maximal analog value.
	 */
	public final static int ANALOG_MAX_VALUE = 4095;
	private static final int ANALOG_MIDDLE_VALUE = (ANALOG_MAX_VALUE - ANALOG_MIN_VALUE) / 2;

	/**
	 * Array containing value for digit (0-9) than can be displayed on the segment led display.
	 */
	public final static byte[] SEGMENT_LED_VALUE = { (byte) 0xC0, (byte) 0xF9, (byte) 0xA4, (byte) 0xB0, (byte) 0x99, (byte) 0x92, (byte) 0x82, (byte) 0xF8,
			(byte) 0x80, (byte) 0x90 };

	/**
	 * Array containing id of each LED Digit.
	 */
	public final static byte[] SEGMENT_LED_SELECT_DIGIT = { (byte) 0xF1, (byte) 0xF2, (byte) 0xF4, (byte) 0xF8 };

	// 0 1 2 5 6 9 14 15
	/**
	 * Pin of the Buzzer component.
	 */
	public final static int PIN_DIGITAL_BUZZER = 3;
	/**
	 * Pin of the first LED.
	 */
	public final static int PIN_DIGITAL_LED_D1 = 13;
	/**
	 * Pin of the second LED.
	 */
	public final static int PIN_DIGITAL_LED_D2 = 12;
	/**
	 * Pin of the third LED.
	 */
	public final static int PIN_DIGITAL_LED_D3 = 11;
	/**
	 * Pin of the fourth LED.
	 */
	public final static int PIN_DIGITAL_LED_D4 = 10;
	/**
	 * Pin for data sending to digital segment LED.
	 */
	public final static int PIN_DIGITAL_SEGMENT_LED_DATA = 8;
	/**
	 * Pin for clock of digital segment LED.
	 */
	public final static int PIN_DIGITAL_SEGMENT_LED_CLOCK = 7;
	/**
	 * Pin for latch of digital segment LED.
	 */
	public final static int PIN_DIGITAL_SEGMENT_LED_LATCH = 4;

	// 5
	/**
	 * Pin of the pot.
	 */
	public final static int PIN_ANALOG_POT = 0;
	/**
	 * Pin of the first button.
	 */
	public final static int PIN_ANALOG_BTN1 = 1;
	/**
	 * Pin of the second button.
	 */
	public final static int PIN_ANALOG_BTN2 = 2;
	/**
	 * Pin of the third button.
	 */
	public final static int PIN_ANALOG_BTN3 = 3;// not tested
	/**
	 * Pin of the temperature sensor.
	 *
	 * Design for a LM35 sensor not included on the board.
	 */
	public final static int PIN_ANALOG_TEMPERTURE = 4;// not tested

	/**
	 * Convert the analog value given by a button to a digital value.
	 *
	 * @param btnAnalogValue
	 *            the value of the button.
	 *
	 * @return {@code true} if button is pressed, {@code false} otherwise.
	 */
	public static boolean btnAnalog2Digital(int btnAnalogValue) {
		return btnAnalogValue < ANALOG_MIDDLE_VALUE;
	}

	private Shield() {
		// Forbid new instance
	}

}
