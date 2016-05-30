/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.microui.out;

import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.util.EventHandler;

/**
 * Used to render all {@link Line}s in the {@link Display}.
 */
public class DisplayableOutputStream extends Displayable{

	private final OutputStreamRedirection outputStreamRedirection;

	public DisplayableOutputStream(Display display, OutputStreamRedirection outputStreamRedirection) {
		super(display);
		this.outputStreamRedirection = outputStreamRedirection;
	}

	@Override
	public void paint(GraphicsContext g) {
		Line[] lines = outputStreamRedirection.getLines();
		int lenght = outputStreamRedirection.getLength();

		// erase background
		g.setColor(OutputStreamRedirection.COLOR_BACK);
		g.fillRect(0, 0, g.getClipWidth(), g.getClipHeight());

		// draw lines
		int y = 0;
		g.setColor(OutputStreamRedirection.COLOR_FONT);
		for(int i = -1; ++i<lenght;) {
			Line line = lines[i];
			g.drawChars(line.getChars(), 0, line.getLength(), OutputStreamRedirection.TEXT_OFFSET, y, GraphicsContext.TOP | GraphicsContext.LEFT);
			y += line.getFont().getHeight();
		}
	}

	@Override
	public EventHandler getController() {
		// Nothing to do
		return null;
	}
}
