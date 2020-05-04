/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.peripheral;

public class Main {

	public static void main(String[] args) {
		// Start connection manager
		PeripheralConnectionManager listener = new PeripheralConnectionManager();
		listener.start();
	}
}
