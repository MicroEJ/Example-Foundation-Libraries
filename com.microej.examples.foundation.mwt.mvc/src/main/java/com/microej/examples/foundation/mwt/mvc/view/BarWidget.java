/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.mwt.mvc.view;

import com.microej.examples.foundation.mwt.mvc.model.PercentageModel;
import ej.microui.display.GraphicsContext;

public class BarWidget extends PercentageWidget {

	public static final int COLOR_CONTENT = 0xe86337; // orange

	/**
	 * @param display
	 * @param model
	 */
	public BarWidget(PercentageModel model) {
		super(model);
	}

	/**
	 */
	public BarWidget() {
		super();
	}

	@Override
	public void render(GraphicsContext g) {

		super.render(g);

		// get value of the percentage
		int percentage = percentage().getValue();

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
		g.fillRect(barX, barY + barHeight - fillHeight - 1,
				barWidth, fillHeight);

		// draw bar border
		g.setColor(COLOR_DATA_BORDER);
		g.drawRect(barX, barY, barWidth - 1, barHeight - 1);
	}
}
