/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.mvc;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;

public class BarView extends PercentageView{

	private static final int COLOR_CONTENT = 0xe86337; // orange

	public BarView(PercentageModel percentage) {
		super(percentage);
	}

	@Override
	protected void paintContent(GraphicsContext g) {

		// get value of the percentage
		int percentage = this.percentage.get();

		// compute bar coordinates
		int width = getWidth();
		int height = getHeight();
		int barWidth = width / 2;
		int barHeight = height / 2;
		int barX = (width - barWidth) / 2;
		int barY = (height - barHeight) / 2;

		// compute the height that fits the percentage
		int fillHeight = percentage * (barHeight - 1) / 100;

		// draw bar fill
		g.setColor(COLOR_CONTENT);
		Painter.fillRectangle(g, barX, barY + barHeight - fillHeight - 1, barWidth, fillHeight);

		// draw bar border
		g.setColor(COLOR_DATA_BORDER);
		Painter.drawRectangle(g, barX, barY, barWidth + 1, barHeight);
	}
}
