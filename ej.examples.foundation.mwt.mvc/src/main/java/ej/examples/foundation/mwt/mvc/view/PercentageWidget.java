/**
 * Java
 *
 * Copyright 2009-2014 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package ej.examples.foundation.mwt.mvc.view;

import java.util.Observable;
import java.util.Observer;

import ej.examples.foundation.mwt.mvc.model.PercentageModel;
import ej.microui.display.Colors;
import ej.microui.display.GraphicsContext;
import ej.mwt.Widget;

public abstract class PercentageWidget extends Widget implements Observer {

	public static final int COLOR_BACKGROUND = Colors.WHITE;
	public static final int COLOR_VIEW_BORDER = Colors.BLACK;
	public static final int COLOR_DATA_BORDER = 0x506a96;	// blue
	protected PercentageModel model;

	public PercentageWidget() {
		super();
	}

	public PercentageWidget(PercentageModel model) {
		this();
		setModel(model);
	}

	public PercentageModel percentage(){
		// the cast is valid for sure
		return getModel();
	}

	@Override
	public void render(GraphicsContext g) {
		int width = getWidth();
		int height = getHeight();

		// clear view
		g.setColor(COLOR_BACKGROUND);
		g.fillRect(0, 0, width, height);

		// draw view borders
		g.setColor(COLOR_VIEW_BORDER);
		g.drawRect(0, 0, width - 1, height - 1);

	}

	@Override
	public void validate(int widthHint, int heightHint) {
		setPreferredSize(widthHint, heightHint);

	}

	/**
	 * Gets the model.
	 *
	 * @return the model.
	 */
	public PercentageModel getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *            the model to set.
	 */
	public void setModel(PercentageModel model) {
		if (this.model != null) {
			this.model.deleteObserver(this);
		}
		this.model = model;
		if (this.model != null) {
			this.model.addObserver(this);
		}

	}

	@Override
	// Called when the model has changed
	public void update(Observable o, Object arg) {
		repaint();
	}
}
