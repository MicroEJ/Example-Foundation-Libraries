/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.microui.image;

import ej.microui.MicroUI;
import ej.microui.display.Display;

/**
 * Shows three messages on the display using different fonts.
 */
public class ExampleImages {

	/**
	 * Images pre-generated during the application build
	 */
	public static final String IMAGE_COMPILETIME_A = "/images/flower_A.png"; // image
	// without
	// transparency
	public static final String IMAGE_COMPILETIME_B = "/images/flower_B.png"; // image
	// with
	// transparency

	/**
	 * Images decoded at runtime (using the runtime PNG decoder)
	 */
	public static final String IMAGE_RUNTIME_A = "/images/angkor.png"; // image
																		// without
																		// transparency
	public static final String IMAGE_RUNTIME_B = "/images/plane.png"; // image
																		// with
																		// transparency

	public static final int SLEEP = 1000; // in ms

	public static void main(String[] args) {
		// Starts microUI
		MicroUI.start();

		// Gets the default display instance
		Display d = Display.getDefaultDisplay();

		// Creates an ImageView (using all display area)
		ImageDisplayable displayable = new ImageDisplayable(d);

		// Creates an ExampleModel
		ImageModel exampleModel = new ImageModel();


		// Defines model as view's model
		displayable.setModel(exampleModel);

		displayable.show();

		// Does an infinite loop that change the model
		// Modifying model leads to repaint the view (MVC design pattern)
		while (true) {
			setDisplayedImage(exampleModel, IMAGE_COMPILETIME_A);
			setDisplayedImage(exampleModel, IMAGE_COMPILETIME_B);
			setDisplayedImage(exampleModel, IMAGE_RUNTIME_A);
			setDisplayedImage(exampleModel, IMAGE_RUNTIME_B);
		}
	}

	public static void setDisplayedImage(ImageModel model, String imagePath) {
		model.setImage(imagePath);
		try {
			Thread.sleep(SLEEP);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
