/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.client;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothStatus;
import ej.bluetooth.gatt.callbacks.BluetoothClientCallbacksDefault;

public class CurrentTimeClient extends BluetoothClientCallbacksDefault {

	private final BluetoothService service;
	private final BluetoothCharacteristic currentTimeChar;
	private final BluetoothCharacteristic localTimeInfoChar;

	private final CurrentTimeListener listener;

	public CurrentTimeClient(BluetoothService service, CurrentTimeListener listener) {
		this.service = service;
		this.currentTimeChar = service.findCharacteristic(CurrentTimeService.CURRENT_TIME_UUID);
		this.localTimeInfoChar = service.findCharacteristic(CurrentTimeService.LOCAL_TIME_INFO_UUID);

		if (this.currentTimeChar == null || this.localTimeInfoChar == null) {
			throw new IllegalArgumentException();
		}

		this.listener = listener;

		service.setClientCallbacks(this);
	}

	public void requestTime() {
		this.service.readCharacteristic(this.currentTimeChar);
		this.service.readCharacteristic(this.localTimeInfoChar);
	}

	@Override
	public void onReadResponse(BluetoothCharacteristic characteristic, BluetoothStatus status, byte[] value) {
		if (characteristic == this.currentTimeChar) {
			System.out.println("currentTimeChar");
			this.listener.onTimeUpdate(1, 0);
		} else if (characteristic == this.localTimeInfoChar) {
			System.out.println("localTimeInfoChar");
			this.listener.onTimeUpdate(0, 1);
		}
	}
}
