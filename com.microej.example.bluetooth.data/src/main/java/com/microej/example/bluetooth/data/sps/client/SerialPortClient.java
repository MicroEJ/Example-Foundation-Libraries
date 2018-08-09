/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.client;

import com.microej.example.bluetooth.data.DefaultServices;
import com.microej.example.bluetooth.data.sps.SerialPortService;

import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothStatus;
import ej.bluetooth.gatt.callbacks.BluetoothClientCallbacksDefault;

public class SerialPortClient extends BluetoothClientCallbacksDefault {

	private final BluetoothCharacteristic txChar;
	private final BluetoothCharacteristic rxChar;

	private final SerialPortListener listener;

	public SerialPortClient(BluetoothService service, SerialPortListener listener) {
		this.txChar = service.findCharacteristic(SerialPortService.TX_UUID);
		this.rxChar = service.findCharacteristic(SerialPortService.RX_UUID);

		if (this.txChar == null || this.rxChar == null) {
			throw new IllegalArgumentException();
		}

		this.listener = listener;

		service.setClientCallbacks(this);

		DefaultServices.enableCharacteristicNotifications(this.txChar);
	}

	public void sendData(byte[] data) {
		this.rxChar.sendWriteRequest(data);
	}

	@Override
	public void onWriteCompleted(BluetoothCharacteristic characteristic, BluetoothStatus status) {
		this.listener.onDataSent();
	}

	@Override
	public void onNotificationReceived(BluetoothCharacteristic characteristic, byte[] value) {
		if (characteristic == this.txChar) {
			this.listener.onDataReceived(value);
		}
	}
}
