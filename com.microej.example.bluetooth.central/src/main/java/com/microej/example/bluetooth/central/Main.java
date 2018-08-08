/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import com.microej.example.bluetooth.data.cts.server.CurrentTimeServer;

import ej.bluetooth.gap.BluetoothAdapter;

public class Main {

	private static final int STOP_SCANNING_DELAY = 15000;

	private static final String PERIPHERAL_ADDR = "80:EA:22:65:DB:CD";

	public static void main(String[] args) {
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

		CurrentTimeServer currentTimeServer = new CurrentTimeServer();
		adapter.addService(currentTimeServer.getService());

		System.out.println("Start scanning");
		adapter.startScanning(new AdapterCallbacks(PERIPHERAL_ADDR));

		try {
			Thread.sleep(STOP_SCANNING_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (adapter.isScanning()) {
			adapter.stopScanning();
		}
	}
}
