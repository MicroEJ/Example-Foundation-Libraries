/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.mvc;

import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;


public class TextView extends PercentageView {

	public TextView(PercentageModel percentage) {
		super(percentage);
	}

	@Override
	protected void paintContent(GraphicsContext g) {

		// build message to print
		String message = new StringBuffer()
				.append("Value: ")
				.append(percentage.get())
				.append("%")
				.toString();

		// draw message to the middle of the view
		int messageWidth = Font.getDefaultFont().stringWidth(message);
		int messageHeight = Font.getDefaultFont().getHeight();
		Painter.drawString(g, message, Font.getDefaultFont(), (getWidth() - messageWidth) / 2,
				(getHeight() - messageHeight) / 2);
	}

}
