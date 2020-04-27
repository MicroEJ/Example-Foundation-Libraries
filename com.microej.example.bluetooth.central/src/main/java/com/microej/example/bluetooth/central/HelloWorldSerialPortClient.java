/*
 * Java
 *
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothObjectNotFoundException;
import ej.bluetooth.util.services.sps.SerialPortClient;
import ej.bluetooth.util.services.sps.SerialPortListener;

public class HelloWorldSerialPortClient implements SerialPortListener {

	private static final byte[] INITIAL_DATA = "Hello world".getBytes();

	public static void sendHelloWorld(BluetoothConnection connection) {
		SerialPortClient serialPortClient;
		try {
			serialPortClient = new SerialPortClient(connection, new HelloWorldSerialPortClient());
		} catch (BluetoothObjectNotFoundException e) { // The remote device doesn't support the serial port service
			e.printStackTrace();
			return;
		}
		serialPortClient.sendData(INITIAL_DATA);
	}

	@Override
	public void onDataSent(boolean success) {
		System.out.println("Data sent");
	}

	@Override
	public void onDataReceived(byte[] data) {
		System.out.println("Data received: " + new String(data));
	}

}
