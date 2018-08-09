/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.server;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothStatus;
import ej.bluetooth.gatt.callbacks.BluetoothServerCallbacksDefault;

public class CurrentTimeServer extends BluetoothServerCallbacksDefault {

	private final BluetoothService service;
	private final BluetoothCharacteristic currentTimeChar;
	private final BluetoothCharacteristic localTimeInfoChar;

	public CurrentTimeServer() {
		this.service = CurrentTimeBuilder.createService();
		this.service.setServerCallbacks(this);

		this.currentTimeChar = this.service.findCharacteristic(CurrentTimeService.CURRENT_TIME_UUID);
		this.localTimeInfoChar = this.service.findCharacteristic(CurrentTimeService.LOCAL_TIME_INFO_UUID);
	}

	public BluetoothService getService() {
		return this.service;
	}

	@Override
	public void onReadRequest(BluetoothCharacteristic characteristic, BluetoothDevice device) {
		if (characteristic == this.currentTimeChar) {
			characteristic.sendReadResponse(device, BluetoothStatus.OK, makeCurrentTime());
		} else if (characteristic == this.localTimeInfoChar) {
			characteristic.sendReadResponse(device, BluetoothStatus.OK, makeLocalTimeInfo());
		} else {
			super.onReadRequest(characteristic, device);
		}
	}

	private static byte[] makeCurrentTime() {
		// TODO: actual implementation
		return "CurrentTime".getBytes();
	}

	private static byte[] makeLocalTimeInfo() {
		// TODO: actual implementation
		return "LocalTimeInfo".getBytes();
	}
}
