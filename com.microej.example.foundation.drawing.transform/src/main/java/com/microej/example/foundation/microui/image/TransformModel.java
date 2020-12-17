/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.microui.image;

import java.util.Observable;

import ej.microui.display.Image;

/**
 *
 */
public class TransformModel extends Observable {

	public enum TRANSFORM {
		Flip, Rotation, Scale, Alpha
	};

	private TRANSFORM currentTransform = TRANSFORM.Scale;
	private Image image;
	private float percent = 0.5f;

	/**
	 * @param createImage
	 */
	public TransformModel(Image image) {
		this.image = image;
	}

	/**
	 *
	 */
	public void changeTransform(float value) {
		if (value != 0) {
			percent += value;
			if (percent < 0) {
				percent += 1;
			}
			percent = percent % 1;

			setChanged();
			notifyObservers();
		}
	}

	/**
	 *
	 */
	public void nextTransform() {
		switch (currentTransform) {
		case Flip:
			currentTransform = TRANSFORM.Rotation;
			break;
		case Rotation:
			currentTransform = TRANSFORM.Scale;
			break;
		case Scale:
			currentTransform = TRANSFORM.Alpha;
			break;
		case Alpha:
		default:
			currentTransform = TRANSFORM.Flip;
			break;
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * Gets the currentTransform.
	 *
	 * @return the currentTransform.
	 */
	public TRANSFORM getCurrentTransform() {
		return currentTransform;
	}

	/**
	 * Gets the percent.
	 *
	 * @return the percent.
	 */
	public float getPercent() {
		return percent;
	}

	/**
	 * Gets the image.
	 * @return the image.
	 */
	public Image getImage() {
		return image;
	}

	/**
	 * Sets the image.
	 * @param image the image to set.
	 */
	public void setImage(Image image) {
		this.image = image;
	}
}
