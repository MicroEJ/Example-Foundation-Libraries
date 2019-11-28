/*
 * Java
 *
 * Copyright 2016-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.mvc;

import java.util.Observable;
import java.util.Observer;

import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;

public abstract class PercentageView extends Observable implements Observer{

	protected static final int COLOR_BACKGROUND = Colors.WHITE;
	protected static final int COLOR_VIEW_BORDER = Colors.BLACK;
	protected static final int COLOR_DATA_BORDER = 0x506a96;	// blue
	
	protected final PercentageModel percentage;
	private int x, y, width, height;
	private boolean needToRepaint;
	
	public PercentageView(PercentageModel percentage) {
		this.percentage = percentage;
		this.needToRepaint = true;
		
		// this view listens to the percentage model
		percentage.addObserver(this);
	}
	
	public void setBounds(int x, int y, int width, int height) {
		this.x = x;		
		this.y = y;		
		this.width = width;		
		this.height = height;	
		changed();
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public final void paint(GraphicsContext g) {
		
		if (!needToRepaint) {
			// nothing has changed
			return;
		}
		
		// reset
		needToRepaint = false;
		
		// fix point (0,0) of view
		g.translate(x, y);
		
		// clear view
		g.setColor(COLOR_BACKGROUND);
		g.fillRect(0, 0, width, height);
		
		// draw view borders
		g.setColor(COLOR_VIEW_BORDER);
		g.drawRect(0, 0, width - 1, height - 1);
		
		// draw content
		paintContent(g);
		
		// reset translation 
		g.translate(-x, -y);
		
	}
	
	protected abstract void paintContent(GraphicsContext g);
	
	/**
	 * Called when {@link PercentageModel} is updated
	 * @param o the {@link PercentageModel}
	 * @param arg <code>null</code> (never used)s
	 */
	@Override
	public void update(Observable o, Object arg) {
		changed();
	}
	
	private void changed() {
		this.needToRepaint = true;
		setChanged();
		notifyObservers();
	}
}
