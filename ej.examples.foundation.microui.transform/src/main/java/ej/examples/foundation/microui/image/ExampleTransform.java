/*
 * Java
 *
 * Copyright 2009-2016 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.microui.image;

import java.io.IOException;

import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.microui.display.Image;

/**
 * Use different image transformation
 */
public class ExampleTransform {

	private static final String IMAGE = "/images/microej_logo.png"; // image

	public static void main(String[] args) throws IOException {
		// Starts microUI
		MicroUI.start();

		// Gets the default display instance
		Display d = Display.getDefaultDisplay();

		// Creates the model
		TransformModel model = new TransformModel(Image.createImage(IMAGE));

		// Creates the controller
		TransformEventHandler controller = new TransformEventHandler(d.getWidth(), d.getHeight());

		// Creates an ImageView (using all display area)
		TransformDisplayable vue = new TransformDisplayable(d, controller);

		// Set the links between the MVC
		model.addObserver(vue);
		controller.setModel(model);
		controller.setVue(vue);

		vue.show();
	}
}
