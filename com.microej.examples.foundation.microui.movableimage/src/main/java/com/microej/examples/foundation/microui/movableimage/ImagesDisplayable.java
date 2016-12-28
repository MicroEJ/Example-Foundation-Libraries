/*
 * Java
 *
 * Copyright 2014-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.microui.movableimage;

import java.io.IOException;
import java.util.Vector;

import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.util.EventHandler;

public class ImagesDisplayable extends Displayable {

	private final Vector<ImageContainer> images;

	public ImagesDisplayable(Display display, int initialCapacity) throws IOException {
		super(display);
		this.images = new Vector<ImageContainer>(initialCapacity);
	}

	public void addImage(ImageContainer image) {
		images.add(image);
	}

	@Override
	public void paint(GraphicsContext gc) {
		// add images respecting the vector order
		Vector<ImageContainer> images = this.images;
		int length = images.size();
		for(int i = -1; ++i<length;) {
			images.get(i).paint(gc);
		}
	}

	@Override
	public EventHandler getController() {
		// no controller
		return null;
	}
}
