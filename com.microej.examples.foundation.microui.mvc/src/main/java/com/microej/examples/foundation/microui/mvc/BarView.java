/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.example.foundation.microui.mvc;

import ej.microui.display.GraphicsContext;

public class BarView extends PercentageView{

	private static final int COLOR_CONTENT = 0xe86337; // orange
	
	public BarView(PercentageModel percentage) {
		super(percentage);
	}

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
		g.fillRect(barX, barY + barHeight - fillHeight - 1, barWidth, fillHeight);

		// draw bar border
		g.setColor(COLOR_DATA_BORDER);
		g.drawRect(barX, barY, barWidth - 1, barHeight - 1);
	}
}
