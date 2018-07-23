package com.microej.example.bluetooth.data;

import ej.bluetooth.gatt.data.BluetoothDescriptor;
import ej.bluetooth.gatt.data.BluetoothPermission;

public class DefaultServices {

	public static final String CCC_UUID = null;
	public static final String CUD_UUID = null;

	private DefaultServices() {
		// private constructor
	}

	public static BluetoothDescriptor createCCC() {
		return new BluetoothDescriptor(CCC_UUID, BluetoothPermission.READ_WRITE);
	}

	public static BluetoothDescriptor createCUD() {
		return new BluetoothDescriptor(CUD_UUID, BluetoothPermission.READ);
	}
}
