/*
 * Copyright 2014-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.movableimage;

import ej.microui.display.Image;

public class MovableImage extends ImageContainer{

	private static final int DIRECTION_TOP = -1;
	private static final int DIRECTION_BOTTOM = 1;

	private static final int DIRECTION_LEFT = -1;
	private static final int DIRECTION_RIGHT = 1;

	private final int areaWidth;
	private final int areaHeight;
	private int step;
	private int xDirection;
	private int yDirection;

	public MovableImage(Image image, int areaWidth, int areaHeight) {
		super(image);
		this.areaWidth = areaWidth;
		this.areaHeight = areaHeight;
	}

	public void setDirection(boolean top, boolean left) {
		this.xDirection = left ? DIRECTION_LEFT : DIRECTION_RIGHT;
		this.yDirection = top ? DIRECTION_TOP : DIRECTION_BOTTOM;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public void move() {

		int x = getX();
		int y = getY();
		int xDirection = this.xDirection;
		int yDirection = this.yDirection;
		int width = getImage().getWidth();
		int height = getImage().getHeight();

		x += xDirection * step;

		if (x < 0) {
			x = 0;
			xDirection = DIRECTION_RIGHT;
		}
		else if (x + width > areaWidth) {
			x = areaWidth - width;
			xDirection = DIRECTION_LEFT;
		}

		y += yDirection * step;

		if (y < 0) {
			y = 0;
			yDirection = DIRECTION_BOTTOM;
		}
		else if (y + height > areaHeight) {
			y = areaHeight - height;
			yDirection = DIRECTION_TOP;
		}

		setPosition(x, y);
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}
}
