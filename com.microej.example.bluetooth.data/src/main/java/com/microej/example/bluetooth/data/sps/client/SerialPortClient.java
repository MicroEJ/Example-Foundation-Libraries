/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.client;

import com.microej.example.bluetooth.data.DefaultServices;
import com.microej.example.bluetooth.data.sps.SerialPortService;

import ej.bluetooth.gatt.client.BluetoothClientCallbacksDefault;
import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothDescriptor;
import ej.bluetooth.gatt.data.BluetoothService;
import ej.bluetooth.gatt.data.BluetoothStatus;

public class SerialPortClient extends BluetoothClientCallbacksDefault {

	private final BluetoothService service;
	private final BluetoothCharacteristic txChar;
	private final BluetoothCharacteristic rxChar;

	private final SerialPortListener listener;

	public SerialPortClient(BluetoothService service, SerialPortListener listener) {
		this.service = service;
		this.txChar = service.findCharacteristic(SerialPortService.TX_UUID);
		this.rxChar = service.findCharacteristic(SerialPortService.RX_UUID);

		if (this.txChar == null || this.rxChar == null) {
			throw new IllegalArgumentException();
		}

		BluetoothDescriptor txCCC = this.txChar.findDescriptor(DefaultServices.CCC_UUID);
		if (txCCC == null) {
			throw new IllegalArgumentException();
		}

		this.listener = listener;

		service.setClientCallbacks(this);
		service.writeDescriptor(txCCC, new byte[] { 0x00, 0x01 });
	}

	public void sendData(byte[] data) {
		this.service.writeCharacteristic(this.rxChar, data);
	}

	@Override
	public void onNotification(BluetoothCharacteristic characteristic, byte[] value) {
		if (characteristic == this.txChar) {
			System.out.println("tx: " + value.length);
			this.listener.onDataReceived(value);
		}
	}

	@Override
	public void onWriteResponse(BluetoothDescriptor descriptor, BluetoothStatus status) {
		// TODO
	}
}
