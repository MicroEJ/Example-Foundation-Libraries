/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import com.microej.example.bluetooth.data.BluetoothPayload;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothDevice;
import ej.bluetooth.callbacks.ScanCallbacks;

public class AppScanCallbacks implements ScanCallbacks {

	private final String peripheralName;
	private boolean deviceFound;

	public AppScanCallbacks(String peripheralName) {
		this.peripheralName = peripheralName;
		this.deviceFound = false;
	}

	@Override
	public void onScanResult(BluetoothAdapter adapter, BluetoothDevice device, byte[] payload, int rssi) {
		String deviceAddr = device.getAddress();
		System.out.println("Scanned device: address=" + deviceAddr + " RSSI=" + rssi);

		String localName = BluetoothPayload.parseString(payload, BluetoothPayload.COMPLETE_LOCAL_NAME);
		if (localName == null) {
			localName = BluetoothPayload.parseString(payload, BluetoothPayload.SHORTENED_LOCAL_NAME);
		}
		if (localName != null) {
			System.out.println("\tLocal name: '" + localName + "'");
		}

		Byte txPowerLevel = BluetoothPayload.parseByte(payload, BluetoothPayload.TX_POWER_LEVEL);
		if (txPowerLevel != null) {
			System.out.println("\tTX power level: " + txPowerLevel);
		}

		if (!this.deviceFound && localName != null && localName.equals(this.peripheralName)) {
			this.deviceFound = true;
			System.out.println("Connecting...");
			device.connect(new AppConnectionCallbacks());
		}
	}

	@Override
	public void onScanCompleted(BluetoothAdapter adapter) {
		System.out.println("Scan complete");
	}
}
