/*
 * Java
 *
 * Copyright 2014-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package ej.examples.foundation.microui.movableimage;

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
