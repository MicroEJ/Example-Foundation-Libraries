/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;
import com.microej.example.bluetooth.data.cts.client.CurrentTimeClient;
import com.microej.example.bluetooth.data.cts.client.CurrentTimeListener;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothDescriptor;
import ej.bluetooth.BluetoothDevice;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.callbacks.BluetoothDeviceCallbacksDefault;

public class DeviceCallbacks extends BluetoothDeviceCallbacksDefault implements CurrentTimeListener {

	private CurrentTimeClient currentTimeClient;

	@Override
	public void onConnected(BluetoothDevice device) {
		System.out.println("Connected");

		device.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothDevice device) {
		System.out.println("Disconnected");
	}

	@Override
	public void onPairRequest(BluetoothDevice device, boolean createBond) {
		device.pairReply(true, createBond);
	}

	@Override
	public void onPairCompleted(BluetoothDevice device, boolean success) {
		System.out.println("Pair completed: " + success);
	}

	@Override
	public void onPasskeyGenerated(BluetoothDevice device, int passkey) {
		System.out.println("Passkey generated: " + passkey);
	}

	@Override
	public void onServicesDiscovered(BluetoothDevice device) {
		for (BluetoothService service : device.getServices()) {
			System.out.println("[SERVICE] " + service.getUuid());
			for (BluetoothCharacteristic characteristic : service.getCharacteristics()) {
				System.out.println("\t[CHAR] " + characteristic.getUuid());
				for (BluetoothDescriptor descriptor : characteristic.getDescriptors()) {
					System.out.println("\t\t[DESC] " + descriptor.getUuid());
				}
			}
		}

		BluetoothService ctsService = device.findService(CurrentTimeService.SERVICE_UUID);
		if (ctsService == null) {
			System.out.println("Error: could not find CTS service");
		} else {
			this.currentTimeClient = new CurrentTimeClient(ctsService, this);
			this.currentTimeClient.requestTime();
		}
	}

	@Override
	public void onTimeUpdate(long timestamp, long offset) {
		System.out.println("DeviceCallbacks.onTimeUpdate() timestamp=" + timestamp + " offset=" + offset);
	}
}
