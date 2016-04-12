/*
 * Java
 *
 * Copyright 2014 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.microui.antialiased;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.display.shape.AntiAliasedShapes;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.microui.util.EventHandler;

public class ExampleAntialiased extends Displayable {

	private final int MAX_FADE = 10;
	private final int MAX_THICKNESS = 10;

	private enum Drawing {
		Line, Circle, Ellipse,
	}

	private final int displayWidth;
	private final int displayHeight;
	private final EventHandler eventHandler;

	private Drawing drawing;
	private int fade = 3;
	private int thickness = 3;


	public ExampleAntialiased(Display display) {
		super(display);
		displayWidth = display.getWidth();
		displayHeight = display.getHeight();
		drawing = Drawing.Line;
		eventHandler = new EventHandlerImplementation();

	}

	public void drawLine(GraphicsContext g) {
		// simple drawing
		g.drawLine(0, 0, displayWidth / 2, displayHeight);

		// Antialiased drawing
		AntiAliasedShapes.Singleton.drawLine(g, displayWidth / 2, 0, displayWidth, displayHeight);
	}

	public void drawCircle(GraphicsContext g) {
		int padding = 20;
		int circleDiameter = displayWidth / 2 - 2 * padding;

		// simple drawing
		g.drawCircle(padding, padding, circleDiameter);

		// Antialiased drawing
		AntiAliasedShapes.Singleton.drawCircle(g, padding + displayWidth / 2,
				padding, circleDiameter);
	}

	public void drawEllipse(GraphicsContext g) {
		int padding = 20;
		int ellipseWidth = displayWidth / 2 - 2 * padding;
		int ellipseHeight = displayHeight - 2 * padding;

		// simple drawing
		g.drawEllipse(padding, padding, ellipseWidth, ellipseHeight);

		// Antialiased drawing
		AntiAliasedShapes.Singleton.drawEllipse(g, padding + displayWidth / 2, padding, ellipseWidth, ellipseHeight);
	}

	@Override
	public void paint(GraphicsContext g) {
		g.setColor(Colors.WHITE);
		g.fillRect(0, 0, displayWidth, displayHeight);
		g.setColor(Colors.BLACK);

		AntiAliasedShapes.Singleton.setFade(fade);
		AntiAliasedShapes.Singleton.setThickness(thickness);
		switch (drawing) {
		case Line:
			drawLine(g);
			break;
		case Circle:
			drawCircle(g);
			break;
		case Ellipse:
			drawEllipse(g);
			break;
		}
	}

	private void changeDrawing() {
		switch (drawing) {
		case Line:
			drawing = Drawing.Circle;
			break;
		case Circle:
			drawing = Drawing.Ellipse;
			break;
		case Ellipse:
			drawing = Drawing.Line;
			break;
		}
		repaint();
	}

	@Override
	public EventHandler getController() {
		return eventHandler;
	}

	private final class EventHandlerImplementation implements EventHandler {
		@Override
		public boolean handleEvent(int event) {
			// Get event type
			int type = Event.getType(event);
			if (type == Event.POINTER) {
				if (Pointer.isPressed(event)) {
					// Get pointer
					Pointer pointer = (Pointer) Event.getGenerator(event);
					if (pointer.getAbsoluteX() > displayWidth / 2) {
						if (pointer.getAbsoluteY() > displayHeight / 2) {
							fade++;
							if (fade > MAX_FADE) {
								fade = 1;
							}
						} else {
							thickness++;
							if (thickness > MAX_THICKNESS) {
								thickness = 1;
							}
						}
						repaint();
					} else {
						changeDrawing();
					}
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		// Start MicroUI
		MicroUI.start();

		// Get display
		Display display = Display.getDefaultDisplay();

		// Creates displayable
		ExampleAntialiased strokeDrawings = new ExampleAntialiased(display);

		// Shows
		strokeDrawings.show();
	}

}
