package ej.examples.foundation.microui.mvc;

import java.io.IOException;

import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.microui.display.FlyingImage;
import ej.microui.display.Image;
import ej.microui.event.EventGenerator;
import ej.microui.event.generator.Pointer;

public class ExampleMVC {

	public static void main(String[] args) {

		// start MicroUI framework
		MicroUI.start();

		// get the default display
		Display display = Display.getDefaultDisplay();

		// the MVCDemo needs a pointer -> look for the EventGenerator "Pointer"
		preparePointer(display);

		// create models
		PercentageModel percentage = new PercentageModel();

		// create a displayable on this display
		MVCDisplayable displayable = new MVCDisplayable(display, percentage);

		// create the event generator controller
		MVCController controller = new MVCController(displayable, percentage);
		displayable.setController(controller);

		// show the displayable
		displayable.show();
	}

	private static void preparePointer(Display display) {
		Pointer gen = EventGenerator.get(Pointer.class, 0);
		if (gen != null) {

			// map pointer area on display area
			gen.setScale(display);

			// try to create an image for the cursor
			try {
				Image cursor = Image.createImage("/images/mouse_cursor.png");
				gen.setFlyingImage(new FlyingImage(cursor)) ;
			}
			catch (IOException e) {
				System.out.println("Cannot load cursor image.");
			}
		}
	}
}
