/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package ej.examples.foundation.microui.helloworld;

import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 * Shows three messages on the display using different fonts.
 */
public class ExampleHelloWorld {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Starts MicroUI
		MicroUI.start();

		// Gets the default display instance
		Display d = Display.getDefaultDisplay();

		// Creates a HelloWorldDisplayable
		HelloWorldDisplayable displayable = new HelloWorldDisplayable(d);

		// Shows the HelloWorldDisplayable
		displayable.show();
	}

}
