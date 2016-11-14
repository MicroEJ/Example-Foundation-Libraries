/*
 * Java
 *
 * Copyright 2011-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package ej.examples.foundation.mwt.helloworld;

import ej.microui.display.Colors;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.mwt.Widget;

public class Label extends Widget {

	private static final String DEFAULT_TEXT = "";

	private String text;

	/**
	 * Creates a new label.
	 */
	public Label() {
		setText(DEFAULT_TEXT);
	}

	/**
	 * Sets the text of the label.
	 *
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
		revalidate();
	}

	/**
	 * Gets the text of the label.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	@Override
	public void render(GraphicsContext g) {
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Colors.BLACK);
		g.drawString(getText(), 0, 0, GraphicsContext.TOP | GraphicsContext.LEFT);
	}

	@Override
	public void validate(int widthHint, int heightHint) {
		int stringWidth = Font.getDefaultFont().stringWidth(getText());
		int stringHeight = Font.getDefaultFont().getHeight();
		this.setPreferredSize(stringWidth, stringHeight);
	}

}
