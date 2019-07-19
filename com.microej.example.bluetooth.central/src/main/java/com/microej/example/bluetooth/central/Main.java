/*
 * Java
 *
 * Copyright 2018-2020 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothDataTypes;
import ej.bluetooth.BluetoothScanFilter;
import ej.bluetooth.util.services.cts.CurrentTimeServer;
import ej.bon.Util;

public class Main {

	private final CurrentTimeServer currentTimeServer;

	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

	public Main() {
		this.currentTimeServer = new CurrentTimeServer();
	}

	public void start() {
		Util.setCurrentTimeMillis(778932000 * 1000L);

		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();
		adapter.addService(this.currentTimeServer.getService());

		adapter.setConnectionListener(new CentralConnectionListener());
		adapter.setScanFilter(BluetoothScanFilter.fieldExists(BluetoothDataTypes.COMPLETE_LOCAL_NAME));
		adapter.startScanning();

		System.out.println("Start scanning");
	}
}
