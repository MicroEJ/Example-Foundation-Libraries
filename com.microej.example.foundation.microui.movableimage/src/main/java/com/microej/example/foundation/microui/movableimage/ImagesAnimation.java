/*
 * Copyright 2014-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.movableimage;

import java.util.Vector;

import ej.bon.TimerTask;

public class ImagesAnimation extends TimerTask {

	private final ImagesDisplayable displayable;
	private final Vector<MovableImage> images;

	public ImagesAnimation(ImagesDisplayable displayable, int initialCapacity) {
		this.displayable = displayable;
		this.images = new Vector<MovableImage>(initialCapacity);
	}

	public void addMovableImage(MovableImage image) {
		images.add(image);
	}

	@Override
	public void run() {
		// move all images
		Vector<MovableImage> images = this.images;
		for(int i = images.size(); --i>=0;) {
			images.get(i).move();
		}

		// show result
		displayable.requestRender();
	}
}
