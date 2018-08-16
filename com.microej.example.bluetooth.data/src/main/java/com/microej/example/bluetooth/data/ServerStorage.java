/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data;

import java.util.HashMap;
import java.util.Map;

import ej.bluetooth.BluetoothDevice;

public class ServerStorage {

	private static final Map<BluetoothDevice, Map<Object, byte[]>> Devices = new HashMap<>();

	public static byte[] get(BluetoothDevice device, Object attribute) {
		Map<Object, byte[]> deviceStorage = Devices.get(device);
		if (deviceStorage == null) {
			return null;
		}

		return deviceStorage.get(attribute);
	}

	public static void set(BluetoothDevice device, Object attribute, byte[] value) {
		Map<Object, byte[]> deviceStorage = Devices.get(device);
		if (deviceStorage == null) {
			deviceStorage = new HashMap<>();
			Devices.put(device, deviceStorage);
		}

		deviceStorage.put(attribute, value);
	}
}
