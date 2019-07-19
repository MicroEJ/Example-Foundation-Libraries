/*
 * Java
 *
 * Copyright 2018-2020 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.util.AdvertisementData;
import ej.bluetooth.util.services.sps.SerialPortListener;
import ej.bluetooth.util.services.sps.SerialPortServer;

public class Main implements SerialPortListener {

	private static final String DEVICE_NAME = "Example";

	private final SerialPortServer serialPortServer;

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

	public Main() {
		this.serialPortServer = new SerialPortServer(this);
	}

	public void start() {
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();
		adapter.addService(this.serialPortServer.getService());

		adapter.setConnectionListener(new PeripheralConnectionListener());
		adapter.setAdvertisementData(createAdvertisementData());
		adapter.startAdvertising();

		System.out.println("Start advertising");
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

	private byte[] createAdvertisementData() {
		AdvertisementData data = new AdvertisementData();
		data.setDeviceName(DEVICE_NAME);
		return data.serialize();
	}
}
