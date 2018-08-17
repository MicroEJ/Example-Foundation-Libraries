/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.server;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothDevice;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.BluetoothStatus;
import ej.bluetooth.callbacks.impl.DefaultServerCallbacks;

public class CurrentTimeServer extends DefaultServerCallbacks {

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
