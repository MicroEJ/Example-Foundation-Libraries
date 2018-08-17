/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.client;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.callbacks.impl.DefaultClientCallbacks;

public class CurrentTimeClient extends DefaultClientCallbacks {

	private final BluetoothCharacteristic currentTimeChar;
	private final BluetoothCharacteristic localTimeInfoChar;

	private final CurrentTimeListener listener;

	public CurrentTimeClient(BluetoothService service, CurrentTimeListener listener) {
		this.currentTimeChar = service.findCharacteristic(CurrentTimeService.CURRENT_TIME_UUID);
		this.localTimeInfoChar = service.findCharacteristic(CurrentTimeService.LOCAL_TIME_INFO_UUID);

		if (this.currentTimeChar == null || this.localTimeInfoChar == null) {
			throw new IllegalArgumentException();
		}

		this.listener = listener;

		service.setClientCallbacks(this);
	}

	public void requestTime() {
		this.currentTimeChar.sendReadRequest();
		this.localTimeInfoChar.sendReadRequest();
	}

	@Override
	public void onReadCompleted(BluetoothCharacteristic characteristic, int status, byte[] value) {
		if (characteristic == this.currentTimeChar) {
			this.listener.onTimeUpdate(1, 0);
		} else if (characteristic == this.localTimeInfoChar) {
			this.listener.onTimeUpdate(0, 1);
		}
	}
}
