/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.central;

import ej.bon.Util;

public class Main {

	public static void main(String[] args) {
		// Set current time
		Util.setCurrentTimeMillis(778932000 * 1000L);

		// Start connection manager
		CentralConnectionManager listener = new CentralConnectionManager();
		listener.start();
	}
}
