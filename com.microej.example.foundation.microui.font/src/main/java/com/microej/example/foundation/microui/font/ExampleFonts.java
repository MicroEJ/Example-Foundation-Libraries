/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */

package com.microej.example.foundation.microui.font;

import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 * Shows five messages on the display using different fonts.
 */
public class ExampleFonts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Starts MicroUI
		MicroUI.start();

		// Gets the default display instance
		Display d = Display.getDisplay();

		// Creates a FontsDisplayable
		FontsDisplayable displayable = new FontsDisplayable(d);

		// Shows the fontsDisplayable
		d.requestShow(displayable);
	}

}
