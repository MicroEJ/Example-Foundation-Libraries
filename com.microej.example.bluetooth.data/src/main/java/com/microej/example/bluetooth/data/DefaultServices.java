/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data;

import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothDescriptor;
import ej.bluetooth.gatt.BluetoothPermissions;
import ej.bluetooth.gatt.BluetoothProperties;

public class DefaultServices {

	public static final String CUD_UUID = "00002901-0000-1000-8000-00805f9b34fb";
	public static final String CCC_UUID = "00002902-0000-1000-8000-00805f9b34fb";

	private static final byte NOTIFICATIONS_ENABLED = 0x01;
	private static final byte INDICATIONS_ENABLED = 0x02;

	private DefaultServices() {
		// private constructor
	}

	public static BluetoothDescriptor createCUD() {
		return new BluetoothDescriptor(CUD_UUID, BluetoothPermissions.READ);
	}

	public static BluetoothDescriptor createCCC() {
		return new BluetoothDescriptor(CCC_UUID, BluetoothPermissions.READ_WRITE);
	}

	public static boolean checkNotificationsEnabled(byte[] value) {
		if (value.length != 2) {
			throw new IllegalArgumentException();
		}

		return (value[0] & NOTIFICATIONS_ENABLED) != 0;
	}

	public static boolean enableCharacteristicNotifications(BluetoothCharacteristic characteristic) {
		BluetoothDescriptor descriptor = characteristic.findDescriptor(DefaultServices.CCC_UUID);
		if (descriptor == null) {
			return false;
		}

		int properties = characteristic.getProperties();

		byte flags = 0;
		if ((properties & BluetoothProperties.NOTIFY) != 0) {
			flags |= NOTIFICATIONS_ENABLED;
		} else if ((properties & BluetoothProperties.INDICATE) != 0) {
			flags |= INDICATIONS_ENABLED;
		} else {
			return false;
		}

		byte[] value = new byte[] { flags, 0 };
		descriptor.sendWriteRequest(value);
		return true;
	}

	public static boolean disableCharacteristicNotifications(BluetoothCharacteristic characteristic) {
		BluetoothDescriptor descriptor = characteristic.findDescriptor(DefaultServices.CCC_UUID);
		if (descriptor == null) {
			return false;
		}

		byte[] value = new byte[] { 0, 0 };
		descriptor.sendWriteRequest(value);
		return true;
	}
}
