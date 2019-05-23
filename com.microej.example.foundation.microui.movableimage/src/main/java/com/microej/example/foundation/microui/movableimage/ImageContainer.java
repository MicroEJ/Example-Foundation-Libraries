/*
 * Java
 *
 * Copyright 2014-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.movableimage;

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
