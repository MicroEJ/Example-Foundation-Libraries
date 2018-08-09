/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.server;

import com.microej.example.bluetooth.data.DefaultServices;
import com.microej.example.bluetooth.data.ServerStorage;
import com.microej.example.bluetooth.data.sps.SerialPortService;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothDescriptor;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothStatus;
import ej.bluetooth.gatt.callbacks.BluetoothServerCallbacksDefault;

public class SerialPortServer extends BluetoothServerCallbacksDefault {

	private static final String TX_CUD = "TX data";
	private static final String RX_CUD = "RX data";

	private final BluetoothService service;
	private final BluetoothCharacteristic txChar;
	private final BluetoothCharacteristic rxChar;
	private final BluetoothDescriptor txCUD;
	private final BluetoothDescriptor rxCUD;
	private final BluetoothDescriptor txCCC;

	private final SerialPortListener listener;

	public SerialPortServer(SerialPortListener listener) {
		this.service = SerialPortBuilder.createService();
		this.service.setServerCallbacks(this);

		this.txChar = this.service.findCharacteristic(SerialPortService.TX_UUID);
		this.rxChar = this.service.findCharacteristic(SerialPortService.RX_UUID);
		this.txCUD = this.txChar.findDescriptor(DefaultServices.CUD_UUID);
		this.rxCUD = this.rxChar.findDescriptor(DefaultServices.CUD_UUID);
		this.txCCC = this.txChar.findDescriptor(DefaultServices.CCC_UUID);

		this.listener = listener;
	}

	public BluetoothService getService() {
		return this.service;
	}

	public void sendData(BluetoothDevice device, byte[] data) {
		byte[] txCCCValue = ServerStorage.get(device, this.txCCC);
		if (txCCCValue != null && DefaultServices.checkNotificationsEnabled(txCCCValue)) {
			this.txChar.sendNotification(device, data, false);
		}
	}

	@Override
	public void onNotificationSent(BluetoothCharacteristic characteristic, BluetoothDevice device, boolean success) {
		this.listener.onDataSent(device, success);
	}

	@Override
	public void onWriteRequest(BluetoothCharacteristic characteristic, BluetoothDevice device, byte[] value) {
		if (characteristic == this.rxChar) {
			characteristic.sendWriteResponse(device, BluetoothStatus.OK);
			this.listener.onDataReceived(device, value);
		} else {
			super.onWriteRequest(characteristic, device, value);
		}
	}

	@Override
	public void onReadRequest(BluetoothDescriptor descriptor, BluetoothDevice device) {
		if (descriptor == this.txCUD) {
			descriptor.sendReadResponse(device, BluetoothStatus.OK, TX_CUD.getBytes());
		} else if (descriptor == this.rxCUD) {
			descriptor.sendReadResponse(device, BluetoothStatus.OK, RX_CUD.getBytes());
		} else if (descriptor == this.txCCC) {
			byte[] txCCCValue = ServerStorage.get(device, this.txCCC);
			if (txCCCValue == null) {
				txCCCValue = new byte[] { 0, 0 };
			}
			descriptor.sendReadResponse(device, BluetoothStatus.OK, txCCCValue);
		} else {
			super.onReadRequest(descriptor, device);
		}
	}

	@Override
	public void onWriteRequest(BluetoothDescriptor descriptor, BluetoothDevice device, byte[] value) {
		if (descriptor == this.txCCC) {
			if (value.length == 2) {
				ServerStorage.set(device, this.txCCC, value);
				descriptor.sendWriteResponse(device, BluetoothStatus.OK);
			} else {
				descriptor.sendWriteResponse(device, BluetoothStatus.INVALID_VALUE_LENGTH);
			}
		} else {
			super.onWriteRequest(descriptor, device, value);
		}
	}
}
