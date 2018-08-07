/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.gap.BluetoothAdapter;
import ej.bluetooth.gap.BluetoothAdapterCallbacksDefault;
import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothPayload;

public class AdapterCallbacks extends BluetoothAdapterCallbacksDefault {

	private final String peripheralAddr;
	private boolean deviceFound;

	public AdapterCallbacks(String peripheralAddr) {
		this.peripheralAddr = peripheralAddr;
		this.deviceFound = false;
	}

	@Override
	public void onScanResult(BluetoothAdapter adapter, BluetoothDevice device, BluetoothPayload payload) {
		System.out.println("Scanned device addr: " + device.getAddress());

		if (!this.deviceFound && device.getAddress().toString().equals(this.peripheralAddr)) {
			this.deviceFound = true;
			device.getAdapter().stopScanning();
			device.connect(new DeviceCallbacks());
		}
	}

	@Override
	public void onScanComplete(BluetoothAdapter adapter) {
		System.out.println("Scan complete");
	}
}
