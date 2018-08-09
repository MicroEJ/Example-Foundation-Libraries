/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import com.microej.example.bluetooth.data.sps.server.SerialPortServer;

import ej.bluetooth.gap.BluetoothAdapter;

public class Main {

	private static final int STOP_ADVERTISING_DELAY = 15000;

	public static void main(String[] args) {
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

		SerialPortServer serialPortServer = new SerialPortServer();
		adapter.addService(serialPortServer.getService());

		System.out.println("Start advertising");
		adapter.startAdvertising(new AdapterCallbacks(), new DeviceCallbacks(), null);

		try {
			Thread.sleep(STOP_ADVERTISING_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (adapter.isAdvertising()) {
			adapter.stopAdvertising();
		}
	}
}
