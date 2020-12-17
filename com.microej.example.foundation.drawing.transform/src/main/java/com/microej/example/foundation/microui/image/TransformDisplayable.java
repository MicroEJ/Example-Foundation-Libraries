/*
 * Copyright 2009-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.image;

import java.util.Observable;
import java.util.Observer;

import ej.drawing.TransformPainter;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.display.Painter;

/**
 * A full size display, showing different transformations.
 */
public class TransformDisplayable extends Displayable implements Observer {

	/**
	 * The controller.
	 */
	private final TransformEventHandler controller;

	/**
	 * Creates a full size display, showing different transformations.
	 *
	 * @param display
	 */
	public TransformDisplayable(Display display, TransformEventHandler controller) {
		super();
		this.controller = controller;

	}

	@Override
	public void update(Observable o, Object arg) {
		requestRender();

	}

	@Override
	public void render(GraphicsContext g) {
		String title = "";

		int width = Display.getDisplay().getWidth();
		int height = Display.getDisplay().getHeight();
		int halfHeight = height >> 1;
		int halfWidth = width >> 1;
		int fontHeight = Font.getDefaultFont().getHeight();
		int stringWidth;

		// Draw the background
		g.setColor(0xAAFFAA);
		Painter.fillRectangle(g, 0, 0, halfWidth, halfHeight);
		// Draw the description of the area
		title = "Click here to play with the transformation";
		stringWidth = Font.getDefaultFont().stringWidth(title);
		g.setColor(Colors.BLACK);
		Painter.drawString(g, title, Font.getDefaultFont(), (halfWidth - stringWidth) / 2,
				(halfHeight - fontHeight) / 2);

		// Draw the background
		g.setColor(0xAAAAFF);
		Painter.fillRectangle(g, halfWidth, 0, width, halfHeight);
		// Draw the description of the area
		title = "Click here to play with the transformation";
		stringWidth = Font.getDefaultFont().stringWidth(title);
		g.setColor(Colors.BLACK);
		Painter.drawString(g, title, Font.getDefaultFont(), width - (halfWidth + stringWidth) / 2,
				(halfHeight - fontHeight) / 2);

		// Draw the background
		g.setColor(0xFFAAAA);
		Painter.fillRectangle(g, 0, halfHeight, width, height);
		// Draw the description of the area
		title = "Click here to change the type of transformation";
		stringWidth = Font.getDefaultFont().stringWidth(title);
		g.setColor(Colors.BLACK);
		Painter.drawString(g, title, Font.getDefaultFont(), (width - stringWidth) / 2,
				height - (halfHeight + fontHeight) / 2);

		TransformModel model = controller.getModel();
		float percent = model.getPercent();
		Image image = model.getImage();
		int xCenter = width / 2 - image.getWidth() / 2;
		int yCenter = height / 2 - image.getHeight() / 2;

		switch (model.getCurrentTransform()) {
		case Flip:
			TransformPainter.Flip selectAction = selectAction(percent);
			title = "Flip " + selectAction;
			TransformPainter.drawFlippedImage(g, image, xCenter, yCenter, selectAction);
			break;
		case Rotation:
			int angle = (int) (percent * 360);
			int diameter = Math.min(width, height) / 2;
			int rx = width / 2;
			int ry = height / 2;
			title = "Rotation " + angle + "°";
			if(percent>0.5) {
				title += " using Bilinear algorithm.";
				TransformPainter.drawRotatedImageBilinear(g, image, rx - diameter / 2, ry - diameter / 2, rx, ry,
						angle);
			} else {
				title += " using Nearest Neighbor algorithm (fast rendering).";
				TransformPainter.drawRotatedImageNearestNeighbor(g, image, rx - diameter / 2, ry - diameter / 2, rx, ry,
						angle);
			}
			break;
		case Scale:
			title = "Scale " + percent * 2 + "%";
			if (percent > 0) {
				TransformPainter.drawScaledImageBilinear(g, image, xCenter, yCenter, percent * 2, percent * 2);
			}
			break;
		case Alpha:
			title = "Alpha " + percent + "%";
			if (percent > 0) {
				Painter.drawImage(g, image, xCenter, yCenter, (int) (percent * 100));

			}
			break;
		default:
			break;
		}
		g.setColor(Colors.BLACK);
		Painter.drawString(g, title, Font.getDefaultFont(), 10, 10);
	}

	/**
	 * @param percent
	 * @return
	 */
	private TransformPainter.Flip selectAction(float percent) {
		TransformPainter.Flip[] actions = TransformPainter.Flip.values();
		if (percent == 0) {
			return actions[0];
		}

		int step = (int) (actions.length * percent);
		if (step == actions.length) {
			return actions[step - 1];
		}
		return actions[step];
	}

	@Override
	public boolean handleEvent(int event) {
		return controller.handleEvent(event);
	}

}
