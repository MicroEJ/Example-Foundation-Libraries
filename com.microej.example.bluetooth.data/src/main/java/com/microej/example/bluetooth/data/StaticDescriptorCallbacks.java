/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.data.BluetoothDescriptor;
import ej.bluetooth.gatt.data.BluetoothStatus;
import ej.bluetooth.gatt.server.BluetoothDescriptorCallbacks;

public class StaticDescriptorCallbacks implements BluetoothDescriptorCallbacks {

	private final byte[] data;

	public StaticDescriptorCallbacks(byte[] data) {
		this.data = data.clone();
	}

	@Override
	public void onReadRequest(BluetoothDescriptor descriptor, BluetoothDevice device) {
		descriptor.sendReadResponse(device, BluetoothStatus.OK, this.data);
	}
}
