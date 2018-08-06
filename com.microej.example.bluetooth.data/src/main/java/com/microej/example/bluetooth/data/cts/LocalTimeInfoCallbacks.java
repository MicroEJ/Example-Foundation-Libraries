/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothStatus;
import ej.bluetooth.gatt.server.BluetoothCharacteristicCallbacks;

public class LocalTimeInfoCallbacks implements BluetoothCharacteristicCallbacks {

	@Override
	public void onReadRequest(BluetoothCharacteristic characteristic, BluetoothDevice device) {
		characteristic.sendReadResponse(device, BluetoothStatus.OK, makeLocalTimeInfo());
	}

	private static byte[] makeLocalTimeInfo() {
		// TODO: actual implementation
		return "LocalTimeInfo".getBytes();
	}
}
