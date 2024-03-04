/*
 * Copyright 2018-2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.bluetooth.peripheral;

import java.util.Arrays;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.listeners.impl.DefaultConnectionListener;
import ej.bluetooth.util.AdvertisementData;
import ej.bluetooth.util.services.sps.SerialPortServer;

/**
 * Manages the Bluetooth connection.
 */
public class PeripheralConnectionManager extends DefaultConnectionListener {

	private static final String DEVICE_NAME = "Example";

	private final SerialPortServer serialPortServer;

	/**
	 * Creates a peripheral connection manager.
	 *
	 * @param serialPortService
	 *            the local serial port service.
	 */
	public PeripheralConnectionManager(BluetoothService serialPortService) {
		this.serialPortServer = createSerialPortServer(serialPortService);
	}

	/**
	 * Starts this peripheral connection manager.
	 */
	public void start() {
		BluetoothAdapter.getAdapter().setConnectionListener(this);

		this.serialPortServer.start();

		startAdvertising();
	}

	@Override
	public void onConnected(BluetoothConnection connection) {
		System.out.println("Connected");
	}

	@Override
	public void onDisconnected(BluetoothConnection connection) {
		System.out.println("Disconnected");

		startAdvertising();
	}

	private void startAdvertising() {
		System.out.println("Start advertising");
		AdvertisementData data = new AdvertisementData();
		data.setDeviceName(DEVICE_NAME);
		BluetoothAdapter.getAdapter().startAdvertising(data.serialize());
	}

	private static SerialPortServer createSerialPortServer(BluetoothService service) {
		return new SerialPortServer(service) {
			@Override
			protected void onDataSent(BluetoothConnection connection, boolean success) {
				System.out.println("Data sent");
			}

			@Override
			protected void onDataReceived(BluetoothConnection connection, byte[] data) {
				System.out.println("Data received: " + Arrays.toString(data));
				sendData(connection, data); // echo data
			}
		};
	}
}
