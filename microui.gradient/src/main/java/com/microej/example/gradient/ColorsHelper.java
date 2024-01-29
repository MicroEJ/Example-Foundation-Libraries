/*
 * Copyright 2014-2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */

package com.microej.example.gradient;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.GraphicsContext;

/**
 * This class helps for the drawing of the gradient.
 */
public class ColorsHelper {

	// private static final int ALPHA_SHIFT = 24;
	private static final int RED_SHIFT = 16;
	private static final int GREEN_SHIFT = 8;
	private static final int BLUE_SHIFT = 0;

	// private static final int ALPHA_MASK = 0xff << ALPHA_SHIFT;
	private static final int RED_MASK = 0xff << RED_SHIFT;
	private static final int GREEN_MASK = 0xff << GREEN_SHIFT;
	private static final int BLUE_MASK = 0xff << BLUE_SHIFT;

	private static final int LIGHT_FACTOR = 0x10;

	public static int invertColor(int color) {
		int red = getRed(color);
		int green = getGreen(color);
		int blue = getBlue(color);

		red = 0xff - red;
		green = 0xff - green;
		blue = 0xff - blue;

		return getColor(red, green, blue);
	}

	public static int darkenColor(int color, int factor) {
		int red = getRed(color);
		int green = getGreen(color);
		int blue = getBlue(color);

		factor = Math.abs(factor) * LIGHT_FACTOR;

		red = Math.max(0x0, red - factor);
		green = Math.max(0x0, green - factor);
		blue = Math.max(0x0, blue - factor);

		return getColor(red, green, blue);
	}

	public static int lightenColor(int color, int factor) {
		int red = getRed(color);
		int green = getGreen(color);
		int blue = getBlue(color);

		factor = Math.abs(factor) * LIGHT_FACTOR;

		red = Math.min(0xff, red + factor);
		green = Math.min(0xff, green + factor);
		blue = Math.min(0xff, blue + factor);

		return getColor(red, green, blue);
	}

	public static int getForegroundColor(int backgroundColor) {
		int red = getRed(backgroundColor);
		int green = getGreen(backgroundColor);
		int blue = getBlue(backgroundColor);
		int light = (int) (red * 0.299 + green * 0.587 + blue * 0.114);
		return light > 0xba ? Colors.BLACK : Colors.WHITE;
	}

	public static int getDisableColor(int normalColor, int disableFactor) {
		if (getForegroundColor(normalColor) == Colors.BLACK) {
			return darkenColor(normalColor, disableFactor & 0xf);
		} else {
			return lightenColor(normalColor, disableFactor & 0xf);
		}
	}

	public static int getRed(int color) {
		return (color & RED_MASK) >>> RED_SHIFT;
	}

	public static int getGreen(int color) {
		return (color & GREEN_MASK) >>> GREEN_SHIFT;
	}

	public static int getBlue(int color) {
		return (color & BLUE_MASK) >>> BLUE_SHIFT;
	}

	public static int getColor(int red, int green, int blue) {
		return (red << RED_SHIFT) & RED_MASK | (green << GREEN_SHIFT) & GREEN_MASK | (blue << BLUE_SHIFT) & BLUE_MASK;
	}

	public static int[] getGradient(int startColor, int endColor) {
		GraphicsContext g = Display.getDisplay().getGraphicsContext();
		return getGradient(g, startColor, endColor);
	}

	public static int[] getGradient(GraphicsContext g, int startColor, int endColor) {
		// get color components
		float currentRed = ColorsHelper.getRed(startColor);
		float currentGreen = ColorsHelper.getGreen(startColor);
		float currentBlue = ColorsHelper.getBlue(startColor);
		int endRed = ColorsHelper.getRed(endColor);
		int endGreen = ColorsHelper.getGreen(endColor);
		int endBlue = ColorsHelper.getBlue(endColor);

		// compute the max number of steps for the array and for the progress factor
		int stepsRed = (int) (endRed - currentRed);
		int stepsGreen = (int) (endGreen - currentGreen);
		int stepsBlue = (int) (endBlue - currentBlue);
		int maxSteps = Math.max(Math.abs(stepsRed), Math.max(Math.abs(stepsGreen), Math.abs(stepsBlue))) + 1;

		int[] colors = new int[maxSteps];
		int length = 0;

		// compute the components progress step
		float stepRed = (float) stepsRed / maxSteps;
		float stepGreen = (float) stepsGreen / maxSteps;
		float stepBlue = (float) stepsBlue / maxSteps;

		int lastColor = -1;
		while (--maxSteps >= 0) {
			// compute color and save it if different than the previous one
			int color = getColor((int) currentRed, (int) currentGreen, (int) currentBlue);
			Display d = Display.getDisplay();
			int displayColor = d.getDisplayColor(color);
			if (displayColor != lastColor) {
				try {
					colors[length++] = displayColor;
				} catch (Exception e) {
					e.printStackTrace();
				}
				lastColor = displayColor;
			}
			// step
			currentRed += stepRed;
			currentGreen += stepGreen;
			currentBlue += stepBlue;
		}

		// crop result array to real height
		int[] result = new int[length];
		System.arraycopy(colors, 0, result, 0, length);
		return result;
	}

	public static int getMixColor(int color1, int color2, float level) {
		int red1 = ColorsHelper.getRed(color1);
		int green1 = ColorsHelper.getGreen(color1);
		int blue1 = ColorsHelper.getBlue(color1);
		int red2 = ColorsHelper.getRed(color2);
		int green2 = ColorsHelper.getGreen(color2);
		int blue2 = ColorsHelper.getBlue(color2);

		float invLevel = 1.0f - level;
		int red = (int) (red1 * invLevel + red2 * level);
		int green = (int) (green1 * invLevel + green2 * level);
		int blue = (int) (blue1 * invLevel + blue2 * level);
		return getColor(red, green, blue);
	}

}
