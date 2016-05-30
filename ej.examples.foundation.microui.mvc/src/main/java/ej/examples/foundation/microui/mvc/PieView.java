/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.microui.mvc;

import ej.microui.display.GraphicsContext;

public class PieView extends PercentageView {

	public static final int COLOR_CONTENT = 0x2fc19c;	// green

	public PieView(PercentageModel percentage) {
		super(percentage);
	}
	
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
		g.fillCircleArc(pieXCenter, pieYCenter, pieDiameter, 0, fillAngle);
		
		// draw pie border
		g.setColor(COLOR_DATA_BORDER);
		g.drawCircle(pieXCenter, pieYCenter, pieDiameter);
	}
}
