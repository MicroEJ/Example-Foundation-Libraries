/**
 * Java
 *
 * Copyright 2009-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.led;

import java.util.Random;

import ej.microui.MicroUI;
import ej.microui.led.Leds;

/**
 * Demo for LEDs management
 */
public class ExampleLeds implements Runnable {

	public static final int SLEEP = 150;
	public static final int MODES_COUNT = 5;
	public static final int COUNT = 3;

	public static void main(String[] args) {
		new Thread(new ExampleLeds()).start();
	}

	@Override
	public void run() {
		int ledsCount = Leds.getNumberOfLeds();

		if (ledsCount == 0) {
			System.out.println("There is no led on this platform.");
			System.out.println("The application cannot run.");
			MicroUI.stop();
			return;
		}

		int mode = 3;
		int count = COUNT;

		while(true) { //stop with the application
			switch (mode) {
			case 0: // loop 0->1->2
				caterpillar(ledsCount);
				break;

			case 1: // bounce 0->1->2->1->0
				bounce(ledsCount);
				break;

			case 2: // kit 0->01->012->01->0
				kit(ledsCount);
				break;

			case 3: // kit 012->
				strobe(ledsCount);
				break;

			case 4: // random
				random(ledsCount);
				break;

			}

			if(--count <= 0) {
				count = COUNT;

				//change mode
				mode++;
				if(mode >= MODES_COUNT) {
					mode = 0;
				}
				//switch of alls leds off
				for(int i = ledsCount; --i >= 0;) {
					Leds.setLedOff(i);
				}
			}

		}
	}

	private void caterpillar(int ledsCount) {
		int currentLed = -1;
		while(true) {
			if(currentLed != -1) {
				Leds.setLedOff(currentLed);
			}
			//step next
			currentLed++;
			if(currentLed == ledsCount) {
				break;
			}
			Leds.setLedOn(currentLed);
			sleep();
		}
	}

	private void bounce(int ledsCount) {
		int currentLed = -1;
		int shift = 1;
		while(true) {
			if(currentLed != -1) {
				Leds.setLedOff(currentLed);
			}
			//step next
			currentLed += shift;
			if(currentLed == ledsCount - 1) {
				shift = -1;
			} else if(currentLed == 0 && shift == -1) {
				break;
			}
			Leds.setLedOn(currentLed);
			sleep();
		}
	}

	private void kit(int ledsCount) {
		int currentLed = 0;
		boolean switchOn = true;
		while(true) {
			if(switchOn) {
				Leds.setLedOn(currentLed);
			} else {
				Leds.setLedOff(currentLed);
			}
			//step next
			currentLed += switchOn ? +1 : -1;
			if(currentLed == ledsCount) {
				switchOn = false;
				currentLed--;
			}
			else if(currentLed == 0) {
				break;
			}
			sleep();
		}
	}

	private void strobe(int ledsCount) {
		//switch of alls leds on
		for(int i = ledsCount; --i >= 0;) {
			Leds.setLedOn(i);
		}
		sleep();
		//switch of alls leds off
		for(int i = ledsCount; --i >= 0;) {
			Leds.setLedOff(i);
		}
		sleep();
	}

	private void random(int ledsCount) {
		Random random = new Random();
		int last = 0;
		for(int i = ledsCount; --i >= 0;) {
			Leds.setLedOff(last);
			//choose new
			last = random.nextInt(ledsCount);
			Leds.setLedOn(last);
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {}
	}

}
