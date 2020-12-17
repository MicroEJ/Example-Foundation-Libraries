/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.out;

import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;

/**
 * Used to render all {@link Line}s in the {@link Display}.
 */
public class DisplayableOutputStream extends Displayable{

	private final OutputStreamRedirection outputStreamRedirection;

	public DisplayableOutputStream(Display display, OutputStreamRedirection outputStreamRedirection) {
		super();
		this.outputStreamRedirection = outputStreamRedirection;
	}

	@Override
	public void render(GraphicsContext g) {
		Line[] lines = outputStreamRedirection.getLines();
		int lenght = outputStreamRedirection.getLength();

		// erase background
		g.setColor(OutputStreamRedirection.COLOR_BACK);
		Painter.fillRectangle(g, 0, 0, g.getClipWidth(), g.getClipHeight());

		// draw lines
		int y = 0;
		g.setColor(OutputStreamRedirection.COLOR_FONT);
		for(int i = -1; ++i<lenght;) {
			Line line = lines[i];
			String lineStr = new String(line.getChars(), 0, line.getLength());
			Painter.drawString(g, lineStr, Font.getDefaultFont(), OutputStreamRedirection.TEXT_OFFSET, y);
			y += line.getFont().getHeight();
		}
	}

	@Override
	public boolean handleEvent(int event) {
		return false;
	}
}
