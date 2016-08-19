/**
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.microui.out;

import ej.microui.display.Font;

/**
 * Represents a line on the display
 */
public class Line {

	private final Font font; // font used to render the line
	private final int spaceWidth;	// line width in pixels
	private int remainingSpace;		// free space width on the line
	private char[] content;			// line content
	private int contentIndex;		// line content index

	/**
	 * Create the line giving its size in pixels and the
	 * font to use
	 * @param width size in pixels
	 * @param font font to use to render the line
	 */
	public Line(int width, Font font) {
		this.font = font;
		this.spaceWidth = width;
		this.content = new char[50];	// 50: why not?
		reset();
	}

	/**
	 * Add the character in the line
	 * @param b the character to add
	 * @return <code>true</code> if the character has been added, <code>false</code>
	 * when the line is full
	 */
	public boolean add(int b) {

		// get character width in pixels
		Font font = this.font;
		int charWidth = font.charWidth((char)b);

		// check if there is enough room to print the character
		if (remainingSpace < charWidth) {
			// cannot add the character
			return false;
		}

		// update the remaining room
		remainingSpace -= charWidth;

		try {
			// add character
			content[contentIndex] = (char)b;

		} catch (ArrayIndexOutOfBoundsException e) {

			// no more room in the content array
			// -> have to grow the array
			System.arraycopy(content, 0, content = new char[contentIndex*2], 0, contentIndex);

			// add character
			content[contentIndex] = (char)b;
		}

		// update index
		++contentIndex;

		// character added
		return true;
	}

	/**
	 * Reset the line fields
	 */
	public void reset() {
		this.contentIndex = 0;
		this.remainingSpace = spaceWidth;
	}

	/**
	 * Retrieve the line content
	 * @return the line characters
	 */
	public char[] getChars() {
		return content;
	}

	/**
	 * Return the line length
	 * @return the line length
	 */
	public int getLength() {
		return contentIndex;
	}

	/**
	 * Return the font used to render the font
	 * @return the line font
	 */
	public Font getFont() {
		return font;
	}
}
