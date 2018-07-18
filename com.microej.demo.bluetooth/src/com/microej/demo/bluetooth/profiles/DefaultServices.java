package com.microej.demo.bluetooth.profiles;

import ej.bluetooth.gatt.data.BluetoothDescriptor;
import ej.bluetooth.gatt.data.BluetoothPermission;

public class DefaultServices {

	public static final String CCC = null;
	public static final String CUD = null;

	private DefaultServices() {
		// private constructor
	}

	public static BluetoothDescriptor createCCC() {
		return new BluetoothDescriptor.Builder(CCC, BluetoothPermission.READ_WRITE).build();
	}

	public static BluetoothDescriptor createCUD() {
		return new BluetoothDescriptor.Builder(CUD, BluetoothPermission.READ).build();
	}
}
