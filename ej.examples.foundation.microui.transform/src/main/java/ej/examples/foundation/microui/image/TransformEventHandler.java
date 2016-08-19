/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.microui.image;

import ej.microui.event.Event;
import ej.microui.event.generator.Pointer;
import ej.microui.util.EventHandler;

/**
 *
 */
public class TransformEventHandler implements EventHandler {

	private final int width;
	private final int height;
	private TransformDisplayable view;
	private TransformModel model;

	/**
	 * @param width
	 * @param height
	 */
	public TransformEventHandler(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean handleEvent(int event) {
		int type = Event.getType(event);
		if (type == Event.POINTER) {
			int genId = Event.getGeneratorID(event);
			Pointer pointer = (Pointer) Pointer.get(genId);

			if (Pointer.isReleased(event)) {
				int x = pointer.getX();
				int y = pointer.getY();
				if (y > (height >> 1)) {
					model.nextTransform();
				} else {
					if (x > (width >> 1)) {
						model.changeTransform(0.1f);
					} else {
						model.changeTransform(-0.1f);
					}
				}
			}
			return true;
		}
		return false;
	}

	/**
	 * Gets the view.
	 *
	 * @return the view.
	 */
	public TransformDisplayable getVue() {
		return view;
	}

	/**
	 * Sets the view.
	 *
	 * @param view
	 *            the view to set.
	 */
	public void setView(TransformDisplayable view) {
		this.view = view;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model.
	 */
	public TransformModel getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the model to set.
	 */
	public void setModel(TransformModel model) {
		this.model = model;
	}
}
