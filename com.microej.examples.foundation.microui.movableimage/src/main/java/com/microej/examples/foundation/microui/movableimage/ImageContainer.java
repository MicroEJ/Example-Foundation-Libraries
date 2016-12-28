/*
 * Java
 *
 * Copyright 2014-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package ej.examples.foundation.microui.movableimage;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;

public class ImageContainer {

	public static final int FULLY_OPAQUE = 0xff;
	public static final int FULLY_TRANSPARENT = 0;

	private final Image image;

	private int x;	// 0 init
	private int y;	// 0 init
	private int alpha;

	public ImageContainer(Image image) {
		this.image = image;
		this.alpha = FULLY_OPAQUE; // by default
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setAlpha(int alpha) {
		this.alpha = alpha;
	}

	public void paint(GraphicsContext gc) {
		gc.drawImage(image, x, y, GraphicsContext.TOP | GraphicsContext.LEFT, alpha);
	}

	public Image getImage() {
		return image;
	}

}
