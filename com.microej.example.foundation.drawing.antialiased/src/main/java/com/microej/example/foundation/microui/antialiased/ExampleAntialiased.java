/*
 * Copyright 2014-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.antialiased;

import ej.drawing.ShapePainter;
import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.Displayable;
import ej.microui.display.GraphicsContext;
import ej.microui.display.Painter;
import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;

/**
 * This page shows how to use anti-aliased shapes.
 *
 * Press the LEFT part of the screen to switch between shapes
 *
 * Press the TOP RIGHT part of the screen to change the thickness
 *
 * Press the BOTTOM RIGHT part of the screen to change the fading level
 */

public class ExampleAntialiased extends Displayable {

	private final int MAX_FADE = 10;
	private final int MAX_THICKNESS = 10;

	private enum Drawing {
		Line, Circle, Ellipse,
	}

	private final int displayWidth;
	private final int displayHeight;

	private Drawing drawing;
	private int fade = 3;
	private int thickness = 3;


	public ExampleAntialiased(Display display) {
		super();
		displayWidth = display.getWidth();
		displayHeight = display.getHeight();
		drawing = Drawing.Line;
	}

	public void drawLine(GraphicsContext g) {
		// simple drawing
		Painter.drawLine(g, 0, 0, displayWidth / 2, displayHeight);

		// Antialiased drawing
		ShapePainter.drawThickFadedLine(g, displayWidth / 2, 0, displayWidth, displayHeight, thickness, fade,
				ShapePainter.Cap.ROUNDED, ShapePainter.Cap.ROUNDED);
	}

	public void drawCircle(GraphicsContext g) {
		int padding = 20;
		int circleDiameter = displayWidth / 2 - 2 * padding;

		// simple drawing
		Painter.drawCircle(g, padding, padding, circleDiameter);

		// Antialiased drawing
		ShapePainter.drawThickFadedCircle(g, padding + displayWidth / 2, padding, circleDiameter, thickness, fade);
	}

	public void drawEllipse(GraphicsContext g) {
		int padding = 20;
		int ellipseWidth = displayWidth / 2 - 2 * padding;
		int ellipseHeight = displayHeight - 2 * padding;

		// simple drawing
		Painter.drawEllipse(g, padding, padding, ellipseWidth, ellipseHeight);

		// Antialiased drawing
		ShapePainter.drawThickFadedEllipse(g, padding + displayWidth / 2, padding, ellipseWidth, ellipseHeight,
				thickness, fade);
	}

	@Override
	public void render(GraphicsContext g) {
		g.setColor(Colors.WHITE);

		Painter.fillRectangle(g, 0, 0, displayWidth, displayHeight);
		g.setColor(Colors.BLACK);

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
		requestRender();
	}

	public static void main(String[] args) {
		// Start MicroUI
		MicroUI.start();

		// Get display
		Display display = Display.getDisplay();

		// Creates displayable
		ExampleAntialiased strokeDrawings = new ExampleAntialiased(display);

		// Shows
		display.requestShow(strokeDrawings);
	}

	@Override
	public boolean handleEvent(int event) {

		// Get event type
		int type = Event.getType(event);
		if (type == Pointer.EVENT_TYPE) {
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
					requestRender();
				} else {
					changeDrawing();
				}
			}
		}
		return false;
	}

}
