/*
 * Copyright 2018-2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.BluetoothServiceDefinition;
import ej.bluetooth.util.SecurityLevels;
import ej.bluetooth.util.services.sps.SerialPortConstants;

/**
 * Provides the entry point of the application.
 */
public class Main {

	/**
	 * Entry point of the application.
	 *
	 * @param args
	 *            the arguments of the application.
	 */
	public static void main(String[] args) {
		// Enable adapter
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();

		// Add serial port service
		BluetoothServiceDefinition serialPortDefinition = SerialPortConstants.getServiceDefinition(SecurityLevels.NONE);
		BluetoothService serialPortService = adapter.addService(serialPortDefinition);
		if (serialPortService == null) {
			throw new RuntimeException("Could not add serial port service");
		}

		// Start connection manager
		PeripheralConnectionManager listener = new PeripheralConnectionManager(serialPortService);
		listener.start();
	}
}
