/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.helloworld;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;

/**
 * This class displays the HelloWorld message.
 */
public class HelloWorldDisplayable extends Displayable {

	/**
	 * The message to print
	 */
	private static final String HELLO_WORLD = "Hello World !!!";

	public HelloWorldDisplayable(Display display) {
		super();
	}

	@Override
	public void render(GraphicsContext g) {
		// get working area size
		int width = g.getClipWidth();
		int height = g.getClipHeight();

		// erase background
		g.setColor(Colors.WHITE);
		Painter.fillRectangle(g, 0, 0, width, height);
		// draw the string in the middle of the display
		g.setColor(Colors.BLACK);
		int stringWidth = Font.getDefaultFont().stringWidth(HELLO_WORLD);
		int stringHeight = Font.getDefaultFont().getHeight();
		Painter.drawString(g, HELLO_WORLD, Font.getDefaultFont(),
				(width - stringWidth) / 2,
				(height - stringHeight) / 2);
	}

	@Override
	public boolean handleEvent(int event) {
		return false;
	}

}
