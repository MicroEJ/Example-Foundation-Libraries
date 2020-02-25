/*
 * Java
 *
 * Copyright 2018-2020 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothDescriptor;
import ej.bluetooth.BluetoothDevice;
import ej.bluetooth.BluetoothObjectNotFoundException;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.listeners.impl.DefaultConnectionListener;
import ej.bluetooth.util.services.cts.CurrentTimeClient;
import ej.bluetooth.util.services.cts.CurrentTimeListener;

public class PeripheralConnectionListener extends DefaultConnectionListener implements CurrentTimeListener {

	@Override
	public void onAdvertisementCompleted() {
		System.out.println("Advertisement complete");
	}

	@Override
	public void onConnected(BluetoothDevice device) {
		System.out.println("Connected");

		device.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothDevice device) {
		System.out.println("Disconnected");

		BluetoothAdapter.getAdapter().startAdvertising();
	}

	@Override
	public void onServicesDiscovered(BluetoothDevice device) {
		printDeviceServices(device);

		try {
			CurrentTimeClient currentTimeClient = new CurrentTimeClient(device, this);
			currentTimeClient.requestTime();
		} catch (BluetoothObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onCurrentTimeUpdate(long currentTime) {
		System.out.println("onCurrentTimeUpdate() currentTime=" + currentTime);
	}

	@Override
	public void onLocalTimeUpdate(long localTimeOffset) {
		System.out.println("onCurrentTimeUpdate() localTimeOffset=" + localTimeOffset);
	}

	private static void printDeviceServices(BluetoothDevice device) {
		for (BluetoothService service : device.getServices()) {
			System.out.println("[SERVICE] " + service.getUuid());
			for (BluetoothCharacteristic characteristic : service.getCharacteristics()) {
				String propertiesString = Integer.toHexString(characteristic.getProperties());
				System.out.println("\t[CHAR] " + characteristic.getUuid() + " P=0x" + propertiesString);
				for (BluetoothDescriptor descriptor : characteristic.getDescriptors()) {
					System.out.println("\t\t[DESC] " + descriptor.getUuid());
				}
			}
		}
	}
}
