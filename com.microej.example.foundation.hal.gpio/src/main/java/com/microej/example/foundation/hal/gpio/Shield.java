/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.example.foundation.hal.gpio;

/**
 *
 */
public interface Shield {

	int DIGITAL_PORT = 30;
	int ANALOG_PORT = 31;

	/**
	 * 'ON' digital value.
	 */
	boolean DIGITAL_HIGH = false;
	/**
	 * 'OFF' digital value.
	 */
	boolean DIGITAL_LOW = true;

	/**
	 * Minimal analog value.
	 */
	int ANALOG_MIN_VALUE = 0;
	/**
	 * Maximal analog value.
	 */
	int ANALOG_MAX_VALUE = 4095;

	float MCU_VOLTAGE = 3.3f;
	// D 0 1 14 15
	// A 4 5

	// free D 7 8
	// free A 3

	/**
	 * Pin of the first button (named SW1 on board).
	 */
	int PIN_DIGITAL_BTN1 = 2;
	/**
	 * Pin of the second button (named SW2 on board).
	 */
	int PIN_DIGITAL_BTN2 = 3;
	/**
	 * Pin of the DHT11 temperature sensor.
	 */
	int PIN_DIGITAL_TEMPERATURE_SENSOR_DHT11 = 4;
	/**
	 * Pin of the Buzzer component.
	 */
	int PIN_DIGITAL_BUZZER = 5;
	/**
	 * Pin of the Infra-Red receiver.
	 */
	int PIN_DIGITAL_IR_RECEIVER = 6;
	/**
	 * Pin red of the RGB LED.
	 */
	int PIN_DIGITAL_LED_RGB_R = 9;
	/**
	 * Pin green of the RGB LED.
	 */
	int PIN_DIGITAL_LED_RGB_G = 10;
	/**
	 * Pin blue of the RGB LED.
	 */
	int PIN_DIGITAL_LED_RGB_B = 11;
	/**
	 * Pin of the second LED.
	 */
	int PIN_DIGITAL_LED2 = 12;
	/**
	 * Pin of the first LED.
	 */
	int PIN_DIGITAL_LED1 = 13;

	/**
	 * Pin of the pot.
	 */
	int PIN_ANALOG_POT = 0;
	/**
	 * Pin of the light sensor.
	 */
	int PIN_ANALOG_LIGHT_SENSOR = 1;
	/**
	 * Pin of the LM35 temperature sensor.
	 */
	int PIN_ANALOG_TEMPERATURE_SENSOR_LM35 = 2;

}
