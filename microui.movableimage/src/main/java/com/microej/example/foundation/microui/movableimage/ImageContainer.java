/*
 * Copyright 2014-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.movableimage;

import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.display.Painter;

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
		Painter.drawImage(gc, image, x, y, alpha);
	}

	public Image getImage() {
		return image;
	}

}
