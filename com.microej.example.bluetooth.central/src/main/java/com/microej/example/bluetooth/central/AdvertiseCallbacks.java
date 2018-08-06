/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.gap.BluetoothAdapter;
import ej.bluetooth.gap.BluetoothAdapterCallbacksDefault;

public class AdvertiseCallbacks extends BluetoothAdapterCallbacksDefault {

	@Override
	public void onAdvertiseComplete(BluetoothAdapter adapter) {
		System.out.println("Advertise complete");
	}
}
