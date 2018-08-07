/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothDeviceCallbacksDefault;

public class DeviceCallbacks extends BluetoothDeviceCallbacksDefault {

	@Override
	public void onConnected(final BluetoothDevice device) {
		System.out.println("Connected");

		device.discoverServices(new ClientCallbacks());
	}

	@Override
	public void onDisconnected(BluetoothDevice device) {
		System.out.println("Disconnected");
	}
}
