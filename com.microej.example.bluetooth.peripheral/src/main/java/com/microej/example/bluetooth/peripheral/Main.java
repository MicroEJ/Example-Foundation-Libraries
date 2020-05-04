/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.listeners.ConnectionListener;
import ej.bluetooth.util.AdvertisementData;

public class Main {

	private static final String DEVICE_NAME = "Example";

	public static void main(String[] args) {
		// Enable the Bluetooth stack
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();

		// Add the serial port service
		EchoSerialPortServer echoSerialPort = new EchoSerialPortServer();
		adapter.addService(echoSerialPort.getService());

		// Listen for connection events : connected device will be discovered and if a
		// current time service is available, use it to print the current and local
		// times
		ConnectionListener listener = new PeripheralConnectionListener();
		adapter.setConnectionListener(listener);

		// Start advertising
		adapter.setAdvertisementData(createAdvertisementData());
		adapter.startAdvertising();
		System.out.println("Start advertising");
	}

	private static byte[] createAdvertisementData() {
		AdvertisementData data = new AdvertisementData();
		data.setDeviceName(DEVICE_NAME);
		return data.serialize();
	}
}
