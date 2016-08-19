/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.microui.font;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.util.EventHandler;

public class FontsDisplayable extends Displayable {

	/**
	 * Message to print
	 */
	public static final String MESSAGE = "Hello World! + * / = { ] |";
	/**
	 * Message color
	 */
	public static final int MESSAGE_COLOR = Colors.BLACK;

	public FontsDisplayable(Display display) {
		super(display);
	}

	@Override
	public void paint(GraphicsContext g) {
		int width = g.getClipWidth();
		int height = g.getClipHeight();
		int areaHeight = height / 5 /* 5 texts to print */;
		int x = 20;
		int y = areaHeight / 2;

		// erase background
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, width, height);

		// draw the message with the "proportional" font
		Font font = getProportionalFont();
		int x1 = drawFontTitle(g, font, x, y);
		drawText(g, MESSAGE, font, x1, y, MESSAGE_COLOR);
		y += areaHeight;

		// draw the message with the "monospace" font
		font = getMonospaceFont();
		x1 = drawFontTitle(g, font, x, y);
		drawText(g, MESSAGE, font, x1, y, MESSAGE_COLOR);
		y += areaHeight;

		// prints the eight first characters of the custom font
		font = getCustomFont();
		x1 = drawFontTitle(g, font, x, y);
		drawCharacters(g, 0, 7, font, x1, y);
		y += areaHeight;

		// draw a message with unknown characters
		font = getProportionalFont();
		x1 = drawTitle(g, "Font with unknown characters", x, y);
		drawCharacters(g, 0, 7, font, x1, y);
		y += areaHeight;

		// draw the message with ellipsis mode
		font = getProportionalFont();
		int clipWidth = font.stringWidth(MESSAGE) / 2;
		x1 = drawTitle(g, "Draw with setEllipsis(true)", x, y);
		g.setEllipsis(true);
		g.setClip(x1, g.getClipY(), clipWidth, g.getClipHeight());
		drawText(g, MESSAGE, font, x1, y, MESSAGE_COLOR);
	}

	/**
	 * Retrieves the proportional {@link Font}
	 *
	 * @return the proportional {@link Font}
	 */
	private Font getProportionalFont() {
		return Font.getFont(Font.LATIN, 15, Font.STYLE_PLAIN);
	}

	/**
	 * Retrieves the monospace {@link Font}
	 *
	 * @return the monospace {@link Font}
	 */
	private Font getMonospaceFont() {
		return Font.getFont(Font.LATIN, 14, Font.STYLE_PLAIN);
	}

	/**
	 * Retrieves the custom {@link Font}
	 *
	 * @return the custom {@link Font}
	 */
	private Font getCustomFont() {
		return Font.getFont(
				99 /* custom font unique identifier (see custom.ejf file) */, 12, Font.STYLE_PLAIN);
	}

	/**
	 * Draws a title which describes the given {@link Font}.
	 *
	 * @param gc
	 *            the {@link GraphicsContext} where draw the text
	 * @param font
	 *            the {@link Font} to describe
	 * @param x
	 *            the text X-position in {@link GraphicsContext}
	 * @param y
	 *            the text Y-position in {@link GraphicsContext}
	 * @return the X-position after the drawn title
	 */
	private int drawFontTitle(GraphicsContext gc, Font font, int x, int y) {
		String header = "\"" + font.getDescriptor() + "\" font";
		x += drawTitle(gc, header, x, y);
		return x;
	}

	/**
	 * Draws a custom title using the default {@link Font} and a fixed colour.
	 *
	 * @param gc
	 *            the {@link GraphicsContext} where draw the text
	 * @param title
	 *            the title to draw
	 * @param x
	 *            the text X-position in {@link GraphicsContext}
	 * @param y
	 *            the text Y-position in {@link GraphicsContext}
	 * @return the X-position after the drawn title
	 */
	private int drawTitle(GraphicsContext gc, String title, int x, int y) {
		return drawText(gc, title + ":\t\t", Font.getDefaultFont(), x, y, Colors.GRAY);
	}

	/**
	 * Draws some characters using the given {@link Font}.
	 *
	 * @param gc
	 *            the {@link GraphicsContext} where draw the text
	 * @param firstCharacterIndex
	 *            first character to draw
	 * @param lastCharacterIndex
	 *            last character to draw
	 * @param font
	 *            font the {@link Font} to use to draw the characters
	 * @param x
	 *            the text X-position in {@link GraphicsContext}
	 * @param y
	 *            the text Y-position in {@link GraphicsContext}
	 * @return the X-position after the drawn text
	 */
	private int drawCharacters(GraphicsContext gc, int firstCharacterIndex, int lastCharacterIndex, Font font, int x,
			int y) {
		StringBuffer buf = new StringBuffer();
		for (int i = firstCharacterIndex; i <= lastCharacterIndex; i++) {
			buf.append((char) i);
		}
		return drawText(gc, buf.toString(), font, x, y, MESSAGE_COLOR);
	}

	/**
	 * Draw a text using the given {@link Font} and colour.
	 *
	 * @param gc
	 *            the {@link GraphicsContext} where draw the text
	 * @param text
	 *            the text to draw
	 * @param font
	 *            the {@link Font} to use to draw the text
	 * @param x
	 *            the text X-position in {@link GraphicsContext}
	 * @param y
	 *            the text Y-position in {@link GraphicsContext}
	 * @param color
	 *            the colour to use to draw the text
	 * @return the X-position after the drawn text
	 */
	private int drawText(GraphicsContext gc, String text, Font font, int x, int y, int color) {
		// print the text
		gc.setColor(color);
		gc.setFont(font);
		gc.drawString(text, x, y, GraphicsContext.LEFT | GraphicsContext.BASELINE);
		x += font.stringWidth(text);
		// return the x offset
		return x;
	}

	@Override
	public EventHandler getController() {
		// Not needed here.
		return null;
	}
}
