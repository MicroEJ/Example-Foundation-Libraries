/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.mvc;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;

public class PieView extends PercentageView {

	public static final int COLOR_CONTENT = 0x2fc19c;	// green

	public PieView(PercentageModel percentage) {
		super(percentage);
	}

	@Override
	protected void paintContent(GraphicsContext g) {

		// get value of the percentage
		int percentage = this.percentage.get();

		// compute pie coordinates
		int width = getWidth();
		int height = getHeight();
		int pieDiameter = Math.min(width, height) / 2;
		int pieXCenter = (width - pieDiameter) / 2;
		int pieYCenter = (height - pieDiameter) / 2;

		// compute angle that fits the percentage
		int fillAngle = percentage * 360 / 100;

		// draw pie fill
		g.setColor(COLOR_CONTENT);
		Painter.fillCircleArc(g, pieXCenter, pieYCenter, pieDiameter, 0, fillAngle);
		// draw pie border
		g.setColor(COLOR_DATA_BORDER);
		Painter.drawCircle(g, pieXCenter, pieYCenter, pieDiameter);
	}
}
