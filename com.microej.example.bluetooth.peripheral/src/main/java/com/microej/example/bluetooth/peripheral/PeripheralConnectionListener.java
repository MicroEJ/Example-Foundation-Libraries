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
import ej.bluetooth.util.AdvertisementData;
import ej.bluetooth.util.services.cts.CurrentTimeConstants;

public class PeripheralConnectionListener extends DefaultConnectionListener {

	private static final String DEVICE_NAME = "Example";

	public void start() {
		// Enable adapter
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();
		adapter.setConnectionListener(this);

		// Add the serial port service
		EchoSerialPortServer echoSerialPort = new EchoSerialPortServer();
		adapter.addService(echoSerialPort.getService());

		// Start advertising
		startAdvertising();
	}

	public void stop() {
		BluetoothAdapter.getAdapter().disable();
	}

	@Override
	public void onConnected(BluetoothConnection connection) {
		System.out.println("Connected");

		connection.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothConnection connection) {
		System.out.println("Disconnected");

		startAdvertising();
	}

	@Override
	public void onDiscoveryResult(BluetoothConnection connection, BluetoothService service) {
		printService(service);

		if (service.getUuid().equals(CurrentTimeConstants.SERVICE_UUID)) {
			try {
				PrintCurrentTimeClient client = new PrintCurrentTimeClient(connection, service);
				client.requestTime();
			} catch (BluetoothObjectNotFoundException e) {
				// The remote device doesn't support the current time service
				e.printStackTrace();
			}
		}
	}

	private void startAdvertising() {
		System.out.println("Start advertising");
		AdvertisementData data = new AdvertisementData();
		data.setDeviceName(DEVICE_NAME);
		BluetoothAdapter.getAdapter().startAdvertising(data.serialize());
	}

	private static void printService(BluetoothService service) {
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
