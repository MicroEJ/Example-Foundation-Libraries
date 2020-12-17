/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.mvc;

import java.util.Observable;
import java.util.Observer;

import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.event.EventHandler;

public class MVCDisplayable extends Displayable implements Observer{

	private final PercentageView textView;
	private final PercentageView barView;
	private final PercentageView pieView;

	private int xCross;
	private int yCross;
	private EventHandler controller;

	public MVCDisplayable(Display display, PercentageModel percentage) {
		super();

		// create the views
		this.textView = new TextView(percentage);
		this.barView = new BarView(percentage);
		this.pieView = new PieView(percentage);

		// this displayable listens the views
		this.textView.addObserver(this);
		this.barView.addObserver(this);
		this.pieView.addObserver(this);

		// compute views default size
		updateViews(display.getWidth() / 3, display.getHeight() / 3);
	}

	@Override
	public void render(GraphicsContext gc) {
		textView.paint(gc);
		barView.paint(gc);
		pieView.paint(gc);
	}

	@Override
	public void update(Observable o, Object arg) {
		requestRender();
	}

	public void setController(EventHandler controller) {
		this.controller = controller;
	}

	public void updateViews(int px, int py) {

		this.xCross = px;
		this.yCross = py;

		Display display = Display.getDisplay();
		int displayWidth = display.getWidth();
		int displayHeight = display.getHeight();

		// update views size
		textView.setBounds(0, 0, px, py);
		barView.setBounds(0, py, px, displayHeight - py);
		pieView.setBounds(px, 0, displayWidth - px, displayHeight);
	}

	public int getCrossX() {
		return xCross;
	}

	public int getCrossY() {
		return yCross;
	}

	@Override
	public boolean handleEvent(int event) {
		return this.controller.handleEvent(event);
	}

}
