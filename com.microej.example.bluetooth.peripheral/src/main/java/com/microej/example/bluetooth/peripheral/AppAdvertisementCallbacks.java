/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.callbacks.AdvertisementCallbacks;

public class AppAdvertisementCallbacks implements AdvertisementCallbacks {

	@Override
	public void onAdvertiseCompleted(BluetoothAdapter adapter) {
		System.out.println("Advertise complete");
	}
}
