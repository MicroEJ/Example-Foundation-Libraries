/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothDevice;
import ej.bluetooth.callbacks.ScanCallbacks;

public class AppScanCallbacks implements ScanCallbacks {

	private final String peripheralAddr;
	private BluetoothDevice device;

	public AppScanCallbacks(String peripheralAddr) {
		this.peripheralAddr = peripheralAddr;
		this.device = null;
	}

	@Override
	public void onScanResult(BluetoothAdapter adapter, BluetoothDevice device, byte[] payload) {
		String deviceAddr = device.getAddress();
		System.out.println("Scanned device addr: " + deviceAddr);

		if (this.device == null && deviceAddr.equals(this.peripheralAddr)) {
			this.device = device;
			adapter.stopScanning();
		}
	}

	@Override
	public void onScanCompleted(BluetoothAdapter adapter) {
		System.out.println("Scan complete");

		if (this.device != null) {
			if (this.device.connect(new AppConnectionCallbacks())) {
				System.out.println("Connecting...");
			}
		}
	}
}
