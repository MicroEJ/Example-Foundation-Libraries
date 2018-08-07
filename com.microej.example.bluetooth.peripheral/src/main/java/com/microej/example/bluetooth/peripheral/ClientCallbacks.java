/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.gatt.client.BluetoothClient;
import ej.bluetooth.gatt.client.BluetoothClientCallbacksDefault;
import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothDescriptor;
import ej.bluetooth.gatt.data.BluetoothService;

public class ClientCallbacks extends BluetoothClientCallbacksDefault {

	@Override
	public void onServicesDiscovered(BluetoothClient client) {
		for (BluetoothService service : client.getServices()) {
			System.out.println("[SERVICE] " + service.getUuid());
			for (BluetoothCharacteristic characteristic : service.getCharacteristics()) {
				System.out.println("\t[CHAR] " + characteristic.getUuid());
				for (BluetoothDescriptor descriptor : characteristic.getDescriptors()) {
					System.out.println("\t\t[DESC] " + descriptor.getUuid());
				}
			}
		}

		BluetoothService ctsService = client.findService(CurrentTimeService.SERVICE_UUID);
		if (ctsService == null) {
			System.out.println("Error: could not find CTS service");
		} else {
			initializeCts(client, ctsService);
		}
	}

	private void initializeCts(BluetoothClient client, BluetoothService ctsService) {
		// TODO
	}
}