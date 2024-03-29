/*
 * Copyright 2014-2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.gradient;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;

/**
 * This example shows how to draw a gradient on a display and how to draw a
 * button with a gradient background.
 */
public class GradientDisplay extends Displayable {

	/**
	 * Instantiates a GradientDisplay.
	 */
	public GradientDisplay() {
		super();
	}

	public static void main(String[] args) {
		MicroUI.start();
		Display d = Display.getDisplay();
		GradientDisplay displayable = new GradientDisplay();
		d.requestShow(displayable);
	}

	private static int drawGradient(GraphicsContext g, int x, int y, int width, int height, int startColor, int endColor) {
		int[] gradient = ColorsHelper.getGradient(startColor, endColor);
		int length = gradient.length;
		int exceeding = (height - length) / 2;
		float increment;
		if (length < height) {
			// draw remaining top zone
			y = fillRemainingPart(g, x, y, width, startColor, exceeding);
			increment = 1.0f;
		} else if (length > height) {
			increment = (float) length / height;
		} else {
			increment = 1.0f;
		}

		// draw gradient
		float index = 0.0f;
		do {
			int color = gradient[(int) index];
			g.setColor(color);
			Painter.drawHorizontalLine(g, x, y++, width);
			index += increment;
		} while (index < length);

		if (length < height) {
			// draw remaining bottom zone
			int remaining = height - exceeding - length;
			y = fillRemainingPart(g, x, y, width, endColor, remaining);
		}
		return y;
	}

	private static int fillRemainingPart(GraphicsContext g, int x, int y, int width, int color, int exceeding) {
		g.setColor(color);
		Painter.fillRectangle(g, x, y, width, exceeding);
		y += exceeding;
		return y;
	}

	private static int drawButton(GraphicsContext g, int x, int y, int width, int height) {
		int shadowShift = 1;
		int steps = 2;
		int shadowColor = Colors.WHITE;
		int startColor = Colors.SILVER;
		int endColor = Colors.GRAY;

		int buttonWidth = width - shadowShift;
		int buttonHeight = height - shadowShift;
		int yShadow = y;

		yShadow = drawButtonTop(g, x, yShadow, width, shadowColor, steps);
		g.setColor(shadowColor);
		int innerHeight = buttonHeight - 2 * steps;
		Painter.fillRectangle(g, x, yShadow, width, innerHeight + shadowShift);
		yShadow += innerHeight + shadowShift;
		drawButtonBottom(g, x, yShadow, width, shadowColor, steps);

		y += shadowShift;
		y = drawButtonTop(g, x + shadowShift, y, buttonWidth, startColor, steps);
		y = drawGradient(g, x + shadowShift, y, buttonWidth, innerHeight, startColor, endColor);
		y = drawButtonBottom(g, x + shadowShift, y, buttonWidth, endColor, steps);

		return y;
	}

	private static int drawButtonTop(GraphicsContext g, int x, int y, int buttonWidth, int color, int steps) {
		for (int i = steps; --i >= 0;) {
			y = drawLine(g, x, y, buttonWidth, color, i + 1);
		}
		return y;
	}

	private static int drawButtonBottom(GraphicsContext g, int x, int y, int buttonWidth, int color, int steps) {
		g.setColor(color);
		for (int i = -1; ++i < steps;) {
			y = drawLine(g, x, y, buttonWidth, color, i + 1);
		}
		return y;
	}

	private static int drawLine(GraphicsContext g, int x, int y, int buttonWidth, int color, int shift) {
		int lineWidth = buttonWidth - 2 * shift;
		g.setColor(color);
		Painter.drawHorizontalLine(g, x + shift, y, lineWidth);
		drawTransparentPixel(g, x + shift - 1, y, color);
		drawTransparentPixel(g, x + shift + lineWidth, y, color);
		y++;
		return y;
	}

	private static void drawTransparentPixel(GraphicsContext g, int x, int y, int color) {
		int background = g.readPixel(x, y);
		int mixedColor = ColorsHelper.getMixColor(background, color, 0.6f);
		g.setColor(mixedColor);
		Painter.writePixel(g, x, y);
	}

	@Override
	public void render(GraphicsContext g) {

		int displayWidth = Display.getDisplay().getWidth();
		int displayHeight = Display.getDisplay().getHeight();

		int startColor = 0x4697fb;
		int middleColor = Colors.WHITE;
		int endColor = 0xed7d0f;

		int heightIndex = displayHeight / 2;

		int currentY = 0;
		// draw gradient
		currentY = drawGradient(g, 0, currentY, displayWidth, heightIndex, startColor, middleColor);
		currentY = drawGradient(g, 0, currentY, displayWidth, heightIndex, middleColor, endColor);

		// draw gradient button
		drawButton(g, 10, heightIndex - 25, 50, 50);
	}

	@Override
	public boolean handleEvent(int event) {
		return false;
	}

}
