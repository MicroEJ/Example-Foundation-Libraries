/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.helloworld;

import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 * This example shows how to print a HelloWord string on a display.
 */
public class ExampleHelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Starts MicroUI
		MicroUI.start();

		// Gets the default display instance
		Display d = Display.getDisplay();

		// Creates a HelloWorldDisplayable
		HelloWorldDisplayable displayable = new HelloWorldDisplayable(d);

		// Shows the HelloWorldDisplayable
		d.requestShow(displayable);
	}

}