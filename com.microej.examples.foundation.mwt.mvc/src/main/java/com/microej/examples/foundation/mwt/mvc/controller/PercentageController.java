/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.mwt.mvc.controller;

import com.microej.examples.foundation.mwt.mvc.model.PercentageModel;
import com.microej.examples.foundation.mwt.mvc.view.CompositeView;
import ej.microui.event.Event;
import ej.microui.event.generator.Buttons;
import ej.microui.event.generator.Command;
import ej.microui.event.generator.Pointer;
import ej.microui.util.EventHandler;

public class PercentageController implements EventHandler {

	private final CompositeView view;
	private final PercentageModel model;

	private static final int MINIMUM_SIZE = 20;
	private static final int TOLERANCE = 10;

	private boolean pressed;

	public PercentageController(CompositeView view, PercentageModel model) {
		this.view = view;
		this.model = model;
	}

	@Override
	public boolean handleEvent(int event) {
		// receive an event

		// get the type of the event
		int type = Event.getType(event);

		if (type == Event.COMMAND) {
			// it is a command

			// get command
			int cmd = Event.getData(event);

			switch (cmd) {
			case Command.UP:
				// command up -> increment model value
				model.incrementValue();
				break;
			case Command.DOWN:
				// command down -> decrement model value
				model.decrementValue();
				break;
			case Command.LEFT:
				// command left -> page decrement model value
				model.pageDecrementValue();
				break;
			case Command.RIGHT:
				// command right -> page increment model value
				model.pageIncrementValue();
				break;
			default:
				// other commands -> random model value
				model.random();
			}

			// The event has been managed
			return true;

		} else if (type == Event.POINTER) {
			try {
				Pointer pointer = (Pointer) Event.getGenerator(event);
				receiveMouseEvent(pointer.getX(), pointer.getY(), event);

				// The event has been managed
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			model.random();
		}

		// The event has not been managed
		return false;
	}

	private void receiveMouseEvent(int px, int py, int event) {
		if (Buttons.isPressed(event)) {
			// check pointer is over the cross (plus or minus TOLERANCE)
			if (over(px, py, view.getXCross(), view.getYCross())) {
				pressed = true;
			}
		} else if (Buttons.isReleased(event)) {
			pressed = false;
		} else if (pressed) {
			int width = view.getWidth();
			int height = view.getHeight();

			// crop to a minimum size
			if (px < MINIMUM_SIZE) {
				px = MINIMUM_SIZE;
			} else if (px > width - MINIMUM_SIZE) {
				px = width - MINIMUM_SIZE;
			}
			if (py < MINIMUM_SIZE) {
				py = MINIMUM_SIZE;
			} else if (py > height - MINIMUM_SIZE) {
				py = height - MINIMUM_SIZE;
			}

			// set cross coordinates
			view.setXCross(px);
			view.setYCross(py);
			view.setBounds(0, 0, width, height);

			// refresh screen
			view.repaint();
		}
	}

	private static boolean over(int px, int py, int x, int y) {
		return (px >= x - TOLERANCE && px <= x + TOLERANCE && py >= y - TOLERANCE && py <= y + TOLERANCE);
	}
}
