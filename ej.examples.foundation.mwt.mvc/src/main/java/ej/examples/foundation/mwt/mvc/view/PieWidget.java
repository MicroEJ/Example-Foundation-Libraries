/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.mwt.mvc.view;

import ej.examples.foundation.mwt.mvc.model.PercentageModel;
import ej.microui.display.GraphicsContext;

public class PieWidget extends PercentageWidget {

	public static final int COLOR_CONTENT = 0x2fc19c; // green

	/**
	 * @param display
	 */
	public PieWidget() {
		super();
	}

	/**
	 * @param model
	 */
	public PieWidget(PercentageModel model) {
		super(model);
	}

	@Override
	public void render(GraphicsContext g) {
		super.render(g);

		// get value of the percentage
		int percentage = percentage().getValue();

		// compute pie coordinates
		int width = getWidth();
		int height = getHeight();
		int pieDiameter = Math.min(width, height) / 2;
		int pieXCenter = (width - pieDiameter) / 2;
		int pieYCenter = (height - pieDiameter) / 2;

		// compute angle fit the percentage
		int fillAngle = percentage * 360 / 100;

		// draw pie fill
		g.setColor(COLOR_CONTENT);
		g.fillCircleArc(pieXCenter, pieYCenter, pieDiameter, 0, fillAngle);

		// draw pie border
		g.setColor(COLOR_DATA_BORDER);
		g.drawCircle(pieXCenter, pieYCenter, pieDiameter);

	}
}
