/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;
import com.microej.example.bluetooth.data.sps.SerialPortService;

import ej.bluetooth.gap.BluetoothAdapter;

public class Main {

	private static final String PERIPHERAL_ADDR = "80:EA:22:65:DB:CD";

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

		// adapter.setAddress("80:EA:00:00:00:02");
		// adapter.setName("BluetoothCentral");
		// adapter.setAppearance(BluetoothAppearance.GENERIC_PHONE);
		// adapter.setIOCapability(BluetoothIOCapability.KEYBOARD_DISPLAY);

		adapter.addService(CurrentTimeService.createService());
		adapter.addService(SerialPortService.createService());

		// adapter.startScanning(new ScanCallbacks(PERIPHERAL_ADDR));
		adapter.startAdvertising(new AdvertiseCallbacks(), new DeviceCallbacks(), null);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (adapter.isScanning()) {
			adapter.stopScanning();
		} else if (adapter.isAdvertising()) {
			adapter.stopAdvertising();
		}
	}
}
