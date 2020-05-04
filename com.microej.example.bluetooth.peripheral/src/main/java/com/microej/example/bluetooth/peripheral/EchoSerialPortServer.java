/*
 * Java
 *
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.util.services.sps.SerialPortServer;

public class EchoSerialPortServer extends SerialPortServer {

	@Override
	protected void onDataSent(BluetoothConnection connection, boolean success) {
		System.out.println("Data sent");
	}

	@Override
	protected void onDataReceived(BluetoothConnection connection, byte[] data) {
		System.out.println("Data received: " + new String(data));
		sendData(connection, data); // echo data
	}
}
