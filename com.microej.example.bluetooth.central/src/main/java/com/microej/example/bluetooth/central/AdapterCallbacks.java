/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.gap.BluetoothAdapter;
import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothPayload;
import ej.bluetooth.gap.callbacks.BluetoothAdapterCallbacksDefault;

public class AdapterCallbacks extends BluetoothAdapterCallbacksDefault {

	private final String peripheralAddr;
	private BluetoothDevice device;

	public AdapterCallbacks(String peripheralAddr) {
		this.peripheralAddr = peripheralAddr;
		this.device = null;
	}

	@Override
	public void onScanResult(BluetoothAdapter adapter, BluetoothDevice device, BluetoothPayload payload) {
		System.out.println("Scanned device addr: " + device.getAddress());

		if (this.device == null && device.getAddress().toString().equals(this.peripheralAddr)) {
			this.device = device;
			adapter.stopScanning();
		}
	}

	@Override
	public void onScanComplete(BluetoothAdapter adapter) {
		System.out.println("Scan complete");

		if (this.device != null) {
			if (this.device.connect(new DeviceCallbacks())) {
				System.out.println("Connecting...");
			}
		}
	}
}
