/*
 * Java
 *
 * Copyright 2009-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.examples.foundation.microui.image;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;
import ej.microui.display.transform.ImageDeformation;
import ej.microui.display.transform.ImageFlip;
import ej.microui.display.transform.ImageFlip.Action;
import ej.microui.display.transform.ImageRotation;
import ej.microui.display.transform.ImageScale;
import ej.microui.util.EventHandler;

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
		super(display);
		this.controller = controller;

	}

	@Override
	public EventHandler getController() {
		return controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();

	}

	@Override
	public void paint(GraphicsContext g) {
		String title = "";

		int width = getDisplay().getWidth();
		int height = getDisplay().getHeight();
		int halfHeight = height >> 1;
		int halfWidth = width >> 1;

		// Draw the background
		g.setColor(0xAAFFAA);
		g.fillRect(0, 0, halfWidth, halfHeight);
		g.setColor(0xAAAAFF);
		g.fillRect(halfWidth, 0, width, halfHeight);
		g.setColor(0xFFAAAA);
		g.fillRect(0, halfHeight, width, height);


		TransformModel model = controller.getModel();
		float percent = model.getPercent();
		Image image = model.getImage();
		int centerAnchor = GraphicsContext.HCENTER | GraphicsContext.VCENTER;
		int xCenter = width / 2;
		int yCenter = height / 2;

		switch (model.getCurrentTransform()) {
		case Deformation:
			title = "Random Deformation";
			Random random = new Random();
			//               x1, y1, x2, y2, x3, y3, x4, y4
			int[] deformation = {0, 0, 0, 0, 0, 0, 0, 0};
			for(int i = 0; i<deformation.length; i++){
				if ((i & 1) != 1) { // x
					int imageWidth = image.getWidth();
					deformation[i] = random.nextInt(imageWidth*2) - imageWidth;
				} else { // y
					int imageHeight = image.getHeight();
					deformation[i] = random.nextInt(imageHeight*2) - imageHeight;
				}
			}
			ImageDeformation.Singleton.draw(g, image, deformation, xCenter, yCenter, centerAnchor);
			break;
		case Flip:
			Action selectAction = selectAction(percent);
			title = "Flip " + selectAction;
			ImageFlip.Singleton.setAction(selectAction(percent));
			ImageFlip.Singleton.draw(g, image, xCenter, yCenter, centerAnchor);
			break;
		case Rotation:
			int angle = (int) (percent * 360);
			title = "Rotation " + angle + "°";
			ImageRotation.Singleton.setAngle(angle);
			ImageRotation.Singleton.setRotationCenter(xCenter, yCenter);
			if(percent>0.5) {
				title += " using Bilinear algorithm.";
				ImageRotation.Singleton.drawBilinear(g, image, xCenter, yCenter, centerAnchor);
			} else {
				title += " using Nearest Neighbor algorithm (fast rendering).";
				ImageRotation.Singleton.drawNearestNeighbor(g, image, xCenter, yCenter, centerAnchor);
			}
			break;
		case Scale:
			title = "Scale " + percent * 2 + "%";
			if (percent > 0) {
				ImageScale.Singleton.setFactor(percent * 2);
				ImageScale.Singleton.draw(g, image, xCenter, yCenter, centerAnchor);
			}
			break;
		case Alpha:
			title = "Alpha " + percent + "%";
			if (percent > 0) {
				g.drawImage(image, xCenter, yCenter, centerAnchor, (int) (percent * 100));
			}
			break;
		default:
			break;
		}
		g.setColor(Colors.BLACK);
		g.drawChars(title.toCharArray(), 0, title.length(), 10, 10, GraphicsContext.TOP | GraphicsContext.LEFT);
	}

	/**
	 * @param percent
	 * @return
	 */
	private Action selectAction(float percent) {
		Action[] actions = Action.values();
		if (percent == 0) {
			return actions[0];
		}

		int step = (int) (actions.length * percent);
		if (step == actions.length) {
			return actions[step - 1];
		}
		return actions[step];
	}

}
