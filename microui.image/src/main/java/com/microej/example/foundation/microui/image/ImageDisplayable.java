/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.image;

import java.util.Observable;
import java.util.Observer;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.display.Painter;

public class ImageDisplayable extends Displayable implements Observer {

	/**
	 * Message to print
	 */
	public static final String MESSAGE = "Hello World! + * / = { ] |";
	/**
	 * Message color
	 */
	public static final int MESSAGE_COLOR = Colors.BLACK;
	private ImageModel model;

	public ImageDisplayable(Display display, ImageModel model) {
		super();
		this.model = model;
		setModel(model);
	}

	public ImageDisplayable(Display display) {
		super();
	}

	public ImageModel getModel() {
		return model;
	}

	/**
	 * @param model
	 */
	public void setModel(ImageModel model) {
		if (this.model != null) {
			model.deleteObserver(this);
		}
		this.model = model;
		if (this.model != null) {
			model.addObserver(this);
		}
	}

	@Override
	public void render(GraphicsContext g) {
		// Fill view with a white background
		g.setColor(Colors.WHITE);
		Painter.fillRectangle(g, 0, 0, Display.getDisplay().getWidth(), Display.getDisplay().getHeight());

		// Load current image from model
		Image i = model.getImage();

		if (i != null) {
			// draw the image to the center of display
			Painter.drawImage(g, i, (Display.getDisplay().getWidth() - i.getWidth()) / 2,
					(Display.getDisplay().getHeight() - i.getHeight()) / 2);

		} else {
			// nothing to draw! -> draw a message
			g.setColor(Colors.BLACK);
			Painter.drawString(g, "Invalid image: " + model.getImagePath(), Font.getDefaultFont(), 5, 5);
		}
	}


	@Override
	public void update(Observable observable, Object arg) {
		if (observable == model) {
			requestRender();
		}
	}

	@Override
	public boolean handleEvent(int event) {
		return false;
	}

}
