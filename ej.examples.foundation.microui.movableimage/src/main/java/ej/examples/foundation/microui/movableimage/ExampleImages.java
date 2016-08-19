/*
 * Java
 *
 * Copyright 2014-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.microui.movableimage;

import java.io.IOException;
import java.util.Timer;

import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Image;

public class ExampleImages {

	private static final int ANIMATION_TIME = 20;	// in ms
	private static final int ANIMATION_STEP = 6;	// in pixels
	private static final int MOVABLE_LAYERS_ALPHA = 0x80;	// 0 to 0xff

	public static void main(String[] args) throws IOException {

		// start MicroUI framework
		MicroUI.start();

		// get the default display
		Display display = Display.getDefaultDisplay();

		int width = display.getWidth();
		int height = display.getHeight();

		// create images
		ImageContainer background = createBackgroundImage(display, "bubbles.png");
		MovableImage movableImage1 = createMovableImage(display, "logo.png", width / 5, height / 5, false, false);	// top-left
		MovableImage movableImage2 = createMovableImage(display, "robot.png", width - width / 5, height / 5, false, true);	// top-right

		// create displayable and populate it
		ImagesDisplayable displayable = new ImagesDisplayable(display, 3);
		displayable.addImage(background);
		displayable.addImage(movableImage1);
		displayable.addImage(movableImage2);

		// create controller and populate it
		ImagesAnimation controller = new ImagesAnimation(displayable, 2);
		controller.addMovableImage(movableImage1);
		controller.addMovableImage(movableImage2);

		// start the animation
		displayable.show();
		Timer animationTimer = new Timer();
		animationTimer.scheduleAtFixedRate(controller, ANIMATION_TIME, ANIMATION_TIME);
	}

	private static MovableImage createMovableImage(Display display, String name, int x, int y, boolean top, boolean left) throws IOException {
		MovableImage movableimage = new MovableImage(createImage(name), display.getWidth(), display.getHeight());
		movableimage.setPosition(x, y);
		movableimage.setDirection(top, left);
		movableimage.setStep(ANIMATION_STEP);
		movableimage.setAlpha(MOVABLE_LAYERS_ALPHA);
		return movableimage;
	}

	private static ImageContainer createBackgroundImage(Display display, String name) throws IOException {

		// create an image with the same size as display
		int width = display.getWidth();
		int height = display.getHeight();
		Image background = Image.createImage(display, width, height);

		// load image pattern
		Image pattern = createImage(name);
		int patternWidth = pattern.getWidth();
		int nbPatterns = (width + patternWidth - 1) / patternWidth;

		// draw pattern into the image
		GraphicsContext gc = background.getGraphicsContext();
		int x = 0;
		for(int i = nbPatterns; --i>=0;) {
			gc.drawImage(pattern, x, height - 1, GraphicsContext.LEFT | GraphicsContext.BOTTOM);
			x += patternWidth;
		}

		// return the new image which targets the image
		return new ImageContainer(background);
	}

	private static Image createImage(String name) throws IOException {
		return Image.createImage("/images/" + name);
	}
}
