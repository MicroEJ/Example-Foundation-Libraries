/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.mvc;

import ej.bon.Timer;
import ej.bon.TimerTask;
import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 * This example shows how to create and use a MVC design pattern to display and
 * animate drawings on the screen.
 */

public class ExampleMVC {

	public static void main(String[] args) {

		// start MicroUI framework
		MicroUI.start();

		// get the default display
		Display display = Display.getDisplay();

		// create models
		final PercentageModel percentage = new PercentageModel();

		// create a displayable on this display
		MVCDisplayable displayable = new MVCDisplayable(display, percentage);

		// create the event generator controller
		MVCController controller = new MVCController(displayable, percentage);
		displayable.setController(controller);

		// show the displayable
		display.requestShow(displayable);

		// mock
		TimerTask task = new  TimerTask() {

			@Override
			public void run() {
				double percent = (Math.random() * 100.);
				percentage.set((int)Math.floor(percent));
			}
		};
		new Timer().schedule(task, 1000L, 1000L);
	}

}
