/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.example.foundation.mwt.mvc.view;

import ej.microui.display.GraphicsContext;
import ej.mwt.Composite;

/**
 *
 */
public class CompositeView extends Composite {
	// private static final int MINIMUM_SIZE = 20;
	// private static final int TOLERANCE = 10;

	private int xCross;
	private int yCross;
	private final TextWidget textWidget;
	private final PieWidget pieWidget;
	private final BarWidget barWidget;
	// private boolean pressed;

	/**
	 * @param textWidget
	 * @param pieWidget
	 * @param barWidget
	 */
	public CompositeView(TextWidget textWidget, PieWidget pieWidget, BarWidget barWidget) {
		super();
		this.textWidget = textWidget;
		this.pieWidget = pieWidget;
		this.barWidget = barWidget;
		add(textWidget);
		add(pieWidget);
		add(barWidget);
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);

		// Does the positioning
		textWidget.setBounds(0, 0, xCross, yCross);
		barWidget.setBounds(0, yCross, xCross, height - yCross);
		pieWidget.setBounds(xCross, 0, width - xCross, height);
	}


	@Override
	public void validate(int widthHint, int heightHint) {
		setPreferredSize(widthHint, heightHint);
		// Validate widgets
		textWidget.validate(xCross, yCross);
		barWidget.validate(xCross, heightHint - yCross);
		pieWidget.validate(widthHint - xCross, heightHint);
	}

	@Override
	public void render(GraphicsContext g) {
		// nothing to do
	}

	/**
	 * Gets the xCross.
	 *
	 * @return the xCross.
	 */
	public int getXCross() {
		return xCross;
	}

	/**
	 * Sets the xCross.
	 *
	 * @param xCross
	 *            the xCross to set.
	 */
	public void setXCross(int xCross) {
		this.xCross = xCross;
	}

	/**
	 * Gets the yCross.
	 *
	 * @return the yCross.
	 */
	public int getYCross() {
		return yCross;
	}

	/**
	 * Sets the yCross.
	 *
	 * @param yCross
	 *            the yCross to set.
	 */
	public void setYCross(int yCross) {
		this.yCross = yCross;
	}

	// @Override
	// public boolean handleEvent(int event) {
	// // receive an event
	//
	// // get the type of the event
	// int type = Event.getType(event);
	//
	// if (type == Event.COMMAND) {
	// // it is a command
	//
	// // get command
	// int cmd = Event.getData(event);
	//
	// switch (cmd) {
	// case Command.UP:
	// // command up -> increment model value
	// // model.incrementValue();
	// break;
	// case Command.DOWN:
	// // command down -> decrement model value
	// // model.decrementValue();
	// break;
	// case Command.LEFT:
	// // command left -> page decrement model value
	// // model.pageDecrementValue();
	// break;
	// case Command.RIGHT:
	// // command right -> page increment model value
	// // model.pageIncrementValue();
	// break;
	// default:
	// // other commands -> random model value
	// // model.random();
	// }
	//
	// // The event has been managed
	// return true;
	//
	// } else if (type == Event.POINTER) {
	// Pointer pointer = (Pointer) Event.getGenerator(event);
	// receiveMouseEvent(type, event, pointer);
	// // The event has been managed
	// return true;
	// } else {
	// System.out.println("PercentageController.handleEvent()");
	// // model.random();
	// }
	//
	// // The event has not been managed
	// return false;
	// }

	// private void receiveMouseEvent(int type, int value, Pointer pointer) {
	// if (Buttons.isPressed(value)) {
	// // check pointer is over the cross (plus or minus TOLERANCE)
	// int px = pointer.getX();
	// int py = pointer.getY();
	// if (over(px, py, getXCross(), getYCross())) {
	// pressed = true;
	// }
	// } else if (Buttons.isReleased(value)) {
	// pressed = false;
	// } else if (pressed) {
	// // use locals
	// int width = getWidth();
	// int height = getHeight();
	// int px = pointer.getX();
	// int py = pointer.getY();
	//
	// // crop to a minimum size
	// if (px < MINIMUM_SIZE) {
	// px = MINIMUM_SIZE;
	// } else if (px > width - MINIMUM_SIZE) {
	// px = width - MINIMUM_SIZE;
	// }
	// if (py < MINIMUM_SIZE) {
	// py = MINIMUM_SIZE;
	// } else if (py > height - MINIMUM_SIZE) {
	// py = height - MINIMUM_SIZE;
	// }
	//
	// // set cross coordinates
	// setXCross(px);
	// setYCross(py);
	// setBounds(0, 0, width, height);
	//
	// // refresh screen
	// repaint();
	// }
	// }
	//
	// private static boolean over(int px, int py, int x, int y) {
	// return (px >= x - TOLERANCE && px <= x + TOLERANCE && py >= y - TOLERANCE
	// && py <= y + TOLERANCE);
	// }
}
