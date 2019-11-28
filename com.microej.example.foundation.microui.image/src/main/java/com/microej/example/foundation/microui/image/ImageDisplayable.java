/*
 * Java
 *
 * Copyright 2009-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.image;

import java.util.Observable;
import java.util.Observer;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.util.EventHandler;

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
		super(display);
		this.model = model;
		setModel(model);
	}

	public ImageDisplayable(Display display) {
		super(display);
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
	public void paint(GraphicsContext g) {
		// Fill view with a white background
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, this.getDisplay().getWidth(), this.getDisplay().getHeight());

		// Load current image from model
		Image i = model.getImage();

		if (i != null) {
			// draw the image to the center of display
			g.drawImage(i, this.getDisplay().getWidth() / 2, this.getDisplay().getHeight() / 2,
					GraphicsContext.HCENTER | GraphicsContext.VCENTER);

		} else {
			// nothing to draw! -> draw a message
			g.setColor(Colors.BLACK);
			g.drawString("Invalid image: " + model.getImagePath(), 5, 5, GraphicsContext.TOP | GraphicsContext.LEFT);
		}
	}

	@Override
	public EventHandler getController() {
		// Not needed here.
		return null;
	}

	@Override
	public void update(Observable observable, Object arg) {
		if (observable == model) {
			repaint();
		}
	}

}
