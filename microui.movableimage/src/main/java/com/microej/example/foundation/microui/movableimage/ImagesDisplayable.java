/*
 * Copyright 2014-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.movableimage;

import java.io.IOException;
import java.util.Vector;

import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;

public class ImagesDisplayable extends Displayable {

	private final Vector<ImageContainer> images;

	public ImagesDisplayable(Display display, int initialCapacity) throws IOException {
		super();
		this.images = new Vector<ImageContainer>(initialCapacity);
	}

	public void addImage(ImageContainer image) {
		images.add(image);
	}

	@Override
	public void render(GraphicsContext gc) {
		// add images respecting the vector order
		Vector<ImageContainer> images = this.images;
		int length = images.size();
		for(int i = -1; ++i<length;) {
			images.get(i).paint(gc);
		}
	}

	@Override
	public boolean handleEvent(int event) {
		return false;
	}
}
