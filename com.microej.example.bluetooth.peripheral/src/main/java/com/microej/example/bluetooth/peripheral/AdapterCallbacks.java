/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.callbacks.impl.DefaultAdapterCallbacks;

public class AdapterCallbacks extends DefaultAdapterCallbacks {

	@Override
	public void onAdvertiseCompleted(BluetoothAdapter adapter) {
		System.out.println("Advertise complete");
	}
}
