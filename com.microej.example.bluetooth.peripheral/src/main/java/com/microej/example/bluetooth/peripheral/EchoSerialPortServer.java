/*
 * Java
 *
 * Copyright 2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothService;
import ej.bluetooth.util.services.sps.SerialPortListener;
import ej.bluetooth.util.services.sps.SerialPortServer;

public class EchoSerialPortServer implements SerialPortListener {

	private final SerialPortServer serialPortServer;

	public EchoSerialPortServer() {
		this.serialPortServer = new SerialPortServer(this);
	}

	@Override
	public void onDataSent(boolean success) {
		System.out.println("Data sent");
	}

	@Override
	public void onDataReceived(byte[] data) {
		System.out.println("Data received: " + new String(data));
		this.serialPortServer.sendData(data); // echo data
	}

	public BluetoothService getService() {
		return serialPortServer.getService();
	}

}
