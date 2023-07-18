/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.mvc;

import ej.microui.event.Event;
import ej.microui.event.EventGenerator;
import ej.microui.event.EventHandler;
import ej.microui.event.generator.Command;
import ej.microui.event.generator.Pointer;

public class MVCController implements EventHandler {

	private static final int MINIMUM_SIZE = 20;
	private static final int TOLERANCE = 10;

	private final MVCDisplayable displayable;
	private final PercentageModel percentage;

	private boolean pressed;

	public MVCController(MVCDisplayable displayable, PercentageModel percentage) {
		this.displayable = displayable;
		this.percentage = percentage;
	}

	@Override
	public boolean handleEvent(int event) {
		// get the EventGenerator from the event
		EventGenerator gen = Event.getGenerator(event);

		int data = Event.getData(event);
		switch (Event.getType(event)) {
		case Command.EVENT_TYPE:
			return onCommand(data);
		case Pointer.EVENT_TYPE:
			return onPointerEvent(gen, data);
		default:
			return false;
		}
	}

	private boolean onCommand(int command) {

		switch(command) {
		case Command.UP:
			//command up -> increment model value
			percentage.incrementValue();
			break;
		case Command.DOWN:
			//command down -> decrement model value
			percentage.decrementValue();
			break;
		case Command.LEFT:
			//command left -> page decrement model value
			percentage.pageDecrementValue();
			break;
		case Command.RIGHT:
			//command right -> page increment model value
			percentage.pageIncrementValue();
			break;
		default:
			//other commands -> random model value
			percentage.random();
		}

		return false;
	}

	private boolean onPointerEvent(EventGenerator gen, int event) {
		Pointer pointer = (Pointer) gen;
		switch (Pointer.getAction(event)) {
		case Pointer.PRESSED:
			return onPointerPressed(pointer);
		case Pointer.RELEASED:
			return onPointerReleased(pointer);
		case Pointer.DRAGGED:
			return onPointerDragged(pointer);
		default:
			return false;
		}
	}

	private boolean onPointerPressed(Pointer pointer) {
		//check pointer is over the cross (plus or minus TOLERANCE)
		int px = pointer.getX();
		int py = pointer.getY();
		if(over(px, py, displayable.getCrossX(), displayable.getCrossY())) {
			pressed = true;
		}
		return true;
	}

	private boolean onPointerReleased(Pointer pointer) {
		pressed = false;
		return true;
	}

	private boolean onPointerDragged(Pointer pointer) {

		if (!pressed) {
			return false;
		}

		//use locals
		int displayWidth = pointer.getWidth();
		int displayHeight = pointer.getHeight();
		int px = pointer.getX();
		int py = pointer.getY();

		//crop to a minimum size
		if(px < MINIMUM_SIZE) {
			px = MINIMUM_SIZE;
		} else if(px > displayWidth - MINIMUM_SIZE) {
			px = displayWidth - MINIMUM_SIZE;
		}
		if(py < MINIMUM_SIZE) {
			py = MINIMUM_SIZE;
		} else if(py > displayHeight - MINIMUM_SIZE) {
			py = displayHeight - MINIMUM_SIZE;
		}

		//set cross coordinates
		displayable.updateViews(px, py);
		return true;
	}

	private boolean over(int px, int py, int x, int y) {
		return(px >= x - TOLERANCE && px <= x + TOLERANCE
				&& py >= y - TOLERANCE && py <= y + TOLERANCE);
	}
}
