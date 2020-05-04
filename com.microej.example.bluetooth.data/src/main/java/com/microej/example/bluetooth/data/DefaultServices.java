/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data;

import ej.bluetooth.BluetoothDescriptor;
import ej.bluetooth.BluetoothPermissions;
import ej.bluetooth.BluetoothUuid;

public class DefaultServices {

	public static final BluetoothUuid CUD_UUID = new BluetoothUuid(0x2901);
	public static final BluetoothUuid CCC_UUID = new BluetoothUuid(0x2902);

	public static final int EXTENDED_RELIABLE_WRITE = 0x01;
	public static final int EXTENDED_WRITABLE_AUXILIARIES = 0x02;

	private static final byte NOTIFICATIONS_ENABLED = 0x01;
	private static final byte INDICATIONS_ENABLED = 0x02;

	private DefaultServices() {
		// private constructor
	}

	public static BluetoothDescriptor createCUD() {
		return new BluetoothDescriptor(CUD_UUID, BluetoothPermissions.READ);
	}

	public static BluetoothDescriptor createCCC() {
		return new BluetoothDescriptor(CCC_UUID, BluetoothPermissions.RW);
	}

	public static boolean checkCccNotifications(byte[] value) {
		if (value.length != 2) {
			throw new IllegalArgumentException();
		}

		return (value[0] & NOTIFICATIONS_ENABLED) != 0;
	}

	public static byte[] makeCccValue(boolean notifications, boolean indications) {
		byte flags = 0;
		if (notifications) {
			flags |= NOTIFICATIONS_ENABLED;
		} else if (indications) {
			flags |= INDICATIONS_ENABLED;
		}

		return new byte[] { flags, 0 };
	}
}
