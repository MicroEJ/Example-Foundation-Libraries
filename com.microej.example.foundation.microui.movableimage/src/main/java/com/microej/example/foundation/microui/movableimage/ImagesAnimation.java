/*
 * Java
 *
 * Copyright 2014-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.movableimage;

import java.util.TimerTask;
import java.util.Vector;

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
		displayable.repaint();
	}
}
