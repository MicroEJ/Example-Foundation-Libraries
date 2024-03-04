/*
 * Copyright 2018-2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.BluetoothAdapter;

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

		// Start connection manager
		CentralConnectionManager listener = new CentralConnectionManager();
		listener.start();
	}
}
