/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.microui.mvc;

import ej.microui.display.GraphicsContext;


public class TextView extends PercentageView {
	
	public TextView(PercentageModel percentage) {
		super(percentage);
	}

	protected void paintContent(GraphicsContext g) {
		
		// build message to print
		String message = new StringBuffer()
		.append("Value: ")
		.append(percentage.get())
		.append("%")
		.toString();

		// draw message to the middle of the view
		g.drawString(message, getWidth() / 2, getHeight() / 2, GraphicsContext.VCENTER | GraphicsContext.HCENTER);
		
	}

}
