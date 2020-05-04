/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothDataTypes;
import ej.bluetooth.BluetoothScanFilter;
import ej.bluetooth.listeners.ConnectionListener;
import ej.bluetooth.util.services.cts.CurrentTimeServer;
import ej.bon.Util;

public class Main {

	public static void main(String[] args) {
		// Enable the Bluetooth stack
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();

		// Add the current time service
		Util.setCurrentTimeMillis(778932000 * 1000L);
		CurrentTimeServer currentTimeServer = new CurrentTimeServer();
		adapter.addService(currentTimeServer.getService());

		// Listen for connection events : connected device will be discovered and if a
		// serial port service is available, sends a "Hello World" and dumps the
		// response
		ConnectionListener connectionListener = new CentralConnectionListener();
		adapter.setConnectionListener(connectionListener);

		// Start scanning for named Bluetooth devices
		adapter.setScanFilter(BluetoothScanFilter.fieldExists(BluetoothDataTypes.COMPLETE_LOCAL_NAME));
		adapter.startScanning();
		System.out.println("Start scanning");
	}
}
