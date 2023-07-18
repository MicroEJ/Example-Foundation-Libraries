/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.input;

import ej.microui.MicroUI;
import ej.microui.event.EventGenerator;

/**
 * Decodes and prints in the console each kind of input event.
 *
 * Note that the events you see - especially for buttons - will depend on the
 * JPF configuration
 */
public class ExampleCheckInput {


	private EventHandlerImpl eventHandler;

	/**
	 * Main entry point:
	 * @param args not used
	 */
	public static void main(String[] args) {
		// Start MicroUI.
		MicroUI.start();

		new ExampleCheckInput().check();
	}

	/**
	 * Launch the test:
	 * 	- get the available EventGenerators
	 * 	- print a description for each
	 * 	- change their default listener
	 * 	- start the test
	 */
	public void check() {
		eventHandler = new EventHandlerImpl();

		initializeEventGenerators();

		// ready to run: remember the start time and print a string
		System.out.println();
		System.out.println("=== Ready to check: send an input event... ===");
		System.out.println();
	}

	/**
	 * Shows all available events generator and changes or sets the default
	 * listener for each.
	 */
	private void initializeEventGenerators() {

		// Get all event generators.
		// Can be specialized as EventGenerator.get(Pointer.class);
		EventGenerator[] generators = EventGenerator.get(EventGenerator.class);
		// set the event handler for each EventGenerator
		for (EventGenerator gen : generators) {
			gen.setEventHandler(eventHandler);
		}
	}
}