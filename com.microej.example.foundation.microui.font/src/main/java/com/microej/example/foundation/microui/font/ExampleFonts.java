/**
 * Java
 *
 * Copyright 2009-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.font;

import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 * Shows three messages on the display using different fonts.
 */
public class ExampleFonts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Starts MicroUI
		MicroUI.start();

		// Gets the default display instance
		Display d = Display.getDefaultDisplay();

		// Creates a FontsDisplayable
		FontsDisplayable displayable = new FontsDisplayable(d);

		// Shows the fontsDisplayable
		displayable.show();
	}

}
