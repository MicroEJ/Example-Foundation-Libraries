/**
 * Java
 *
 * Copyright 2009-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.helloworld;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.util.EventHandler;

public class HelloWorldDisplayable extends Displayable {

	/**
	 * The message to print
	 */
	private static final String HELLO_WORLD = "Hello World !!!";

	public HelloWorldDisplayable(Display display) {
		super(display);
	}

	@Override
	public void paint(GraphicsContext g) {
		// get workgin area size
		int width = g.getClipWidth();
		int height = g.getClipHeight();

		// erase background
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, width, height);
		// draw the string in the middle of the display
		g.setColor(Colors.BLACK);
		g.drawString(HELLO_WORLD, width / 2, height / 2, GraphicsContext.HCENTER | GraphicsContext.VCENTER);
	}

	@Override
	public EventHandler getController() {
		// Not needed here.
		return null;
	}
}
