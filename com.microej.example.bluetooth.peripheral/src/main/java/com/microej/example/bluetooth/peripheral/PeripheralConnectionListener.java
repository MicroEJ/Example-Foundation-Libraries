/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothDescriptor;
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
	public void onConnected(BluetoothConnection connection) {
		System.out.println("Connected");

		connection.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothConnection connection) {
		System.out.println("Disconnected");

		BluetoothAdapter.getAdapter().startAdvertising();
	}

	@Override
	public void onServicesDiscovered(BluetoothConnection connection) {
		printDeviceServices(connection);

		try {
			CurrentTimeClient currentTimeClient = new CurrentTimeClient(connection, this);
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

	private static void printDeviceServices(BluetoothConnection connection) {
		for (BluetoothService service : connection.getServices()) {
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
