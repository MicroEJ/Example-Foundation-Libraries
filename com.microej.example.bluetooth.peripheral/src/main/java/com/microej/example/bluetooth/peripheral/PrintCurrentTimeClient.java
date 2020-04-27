/*
 * Java
 *
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothObjectNotFoundException;
import ej.bluetooth.util.services.cts.CurrentTimeClient;
import ej.bluetooth.util.services.cts.CurrentTimeListener;

public class PrintCurrentTimeClient implements CurrentTimeListener {

	public static void printTime(BluetoothConnection connection) {
		CurrentTimeClient currentTimeClient;
		try {
			currentTimeClient = new CurrentTimeClient(connection, new PrintCurrentTimeClient());
		} catch (BluetoothObjectNotFoundException e) { // The remote device doesn't support the current time service
			e.printStackTrace();
			return;
		}
		currentTimeClient.requestTime();
	}

	@Override
	public void onCurrentTimeUpdate(long currentTime) {
		System.out.println("onCurrentTimeUpdate() currentTime=" + currentTime);
	}

	@Override
	public void onLocalTimeUpdate(long localTimeOffset) {
		System.out.println("onCurrentTimeUpdate() localTimeOffset=" + localTimeOffset);
	}

}
