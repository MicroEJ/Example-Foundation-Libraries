/**
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.microui.out;

import java.io.IOException;
import java.io.OutputStream;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Font;

/**
 * Redirection of the {@link System#out}.
 * This class is set as "Java output stream" in the MicroEJ launcher
 */
public class OutputStreamRedirection extends OutputStream {

	/**
	 * Rendering data
	 */
	public static final int COLOR_FONT = Colors.BLACK;
	public static final int COLOR_BACK = Colors.WHITE;
	public static final int TEXT_OFFSET = 5;	// in pixels

	private DisplayableOutputStream displayable;
	private Line[] lines;
	private int linesIndex;

	@Override
	public void write(int b) throws IOException {

		if (b == '\n') {
			// force a repaint and wait the result
			displayable.repaint();
			displayable.getDisplay().waitForEvent();

			updateLineIndex();

			// character added
			return;
		}

		try {
			if (!lines[linesIndex].add(b)) {
				// no enough room on current line,
				// -> go to next line
				updateLineIndex();

				// re-add the data (new line so character has been added for sure)
				lines[linesIndex].add(b);
			}
		} catch (NullPointerException e) {

			// force to initialize the buffer
			initialize();	// can throw an exception if test can not run

			// re-add the data (new line so character has been added for sure)
			lines[linesIndex].add(b);
		}
	}

	private void updateLineIndex() {

		Line[] lines = this.lines;
		int length = lines.length;

		if (++linesIndex == length) {
			// no more line
			// -> have to switch up all lines

			// reuse the first line
			Line line0 = lines[0];

			// switch up all lines
			for(int i = 0; ++i < length;) {
				lines[i-1] = lines[i];
			}

			// last line is free now.
			line0.reset();
			lines[length-1] = line0;

			// do not update the index
			--linesIndex;
		}
	}

	/**
	 * Initialize all rendering data
	 */
	private void initialize() {

		// ensure test can run
		Display display = Display.getDefaultDisplay();
		if (display == null) {
			throw new RuntimeException("Displayable output stream cannot be initialized on this platform configuration.");
		}

		// fill lines array
		Font font = Font.getDefaultFont(); // can fix another font here
		int fontHeight = font.getHeight();
		int lineWidth = display.getWidth() - TEXT_OFFSET;
		int displayHeight = display.getHeight();
		int nbLines = displayHeight / fontHeight;
		Line[] lines = new Line[nbLines];
		for(int i = nbLines; --i>=0;) {
			lines[i] = new Line(lineWidth, font);
		}

		// initialize fields
		this.displayable = new DisplayableOutputStream(display, this);
		this.lines = lines;
		this.linesIndex = 0;

		// show displayable
		displayable.show();
	}

	public Line[] getLines() {
		return lines;
	}

	public int getLength() {
		return linesIndex + 1;
	}
}
