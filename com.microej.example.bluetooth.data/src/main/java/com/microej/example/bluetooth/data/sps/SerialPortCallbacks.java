/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps;

import com.microej.example.bluetooth.data.DefaultServices;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.data.BluetoothDescriptor;
import ej.bluetooth.gatt.data.BluetoothStatus;
import ej.bluetooth.gatt.server.BluetoothProfile;
import ej.bluetooth.gatt.server.BluetoothProfileCallbacksDefault;

public class SerialPortCallbacks extends BluetoothProfileCallbacksDefault {

	private static final String TX_CUD = "TX data";
	private static final String RX_CUD = "RX data";

	@Override
	public boolean onReadDescriptorRequest(BluetoothProfile profile, BluetoothDevice device,
			BluetoothDescriptor descriptor) {
		if (descriptor.getUuid().equals(DefaultServices.CUD_UUID)) {
			String charUuid = descriptor.getCharacteristic().getUuid();
			if (charUuid.equals(SerialPortService.TX_UUID)) {
				return profile.sendReadDescriptorResponse(device, descriptor, BluetoothStatus.OK, TX_CUD.getBytes());
			} else if (charUuid.equals(SerialPortService.RX_UUID)) {
				return profile.sendReadDescriptorResponse(device, descriptor, BluetoothStatus.OK, RX_CUD.getBytes());
			}
		}

		return super.onReadDescriptorRequest(profile, device, descriptor);
	}
}
