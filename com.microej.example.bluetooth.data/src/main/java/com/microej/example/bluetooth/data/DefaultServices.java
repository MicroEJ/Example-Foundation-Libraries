/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data;

import ej.bluetooth.gatt.BluetoothDescriptor;
import ej.bluetooth.gatt.BluetoothPermission;

public class DefaultServices {

	public static final String CUD_UUID = "00002901-0000-1000-8000-00805f9b34fb";
	public static final String CCC_UUID = "00002902-0000-1000-8000-00805f9b34fb";

	private DefaultServices() {
		// private constructor
	}

	public static BluetoothDescriptor createCUD(String description) {
		return new BluetoothDescriptor(CUD_UUID, BluetoothPermission.READ);
	}

	public static BluetoothDescriptor createCCC() {
		return new BluetoothDescriptor(CCC_UUID, BluetoothPermission.READ_WRITE);
	}
}
