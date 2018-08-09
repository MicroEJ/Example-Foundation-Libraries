/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.server;

import com.microej.example.bluetooth.data.DefaultServices;
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

	private final byte[] txCCCValue;

	public SerialPortServer() {
		this.service = SerialPortBuilder.createService();
		this.service.setServerCallbacks(this);

		this.txChar = this.service.findCharacteristic(SerialPortService.TX_UUID);
		this.rxChar = this.service.findCharacteristic(SerialPortService.RX_UUID);
		this.txCUD = this.txChar.findDescriptor(DefaultServices.CUD_UUID);
		this.rxCUD = this.rxChar.findDescriptor(DefaultServices.CUD_UUID);
		this.txCCC = this.txChar.findDescriptor(DefaultServices.CCC_UUID);

		this.txCCCValue = new byte[] { 0x00, 0x00 };
	}

	public BluetoothService getService() {
		return this.service;
	}

	@Override
	public void onReadRequest(BluetoothDescriptor descriptor, BluetoothDevice device) {
		if (descriptor == this.txCUD) {
			descriptor.sendReadResponse(device, BluetoothStatus.OK, TX_CUD.getBytes());
		} else if (descriptor == this.rxCUD) {
			descriptor.sendReadResponse(device, BluetoothStatus.OK, RX_CUD.getBytes());
		} else if (descriptor == this.txCCC) {
			descriptor.sendReadResponse(device, BluetoothStatus.OK, this.txCCCValue);
		} else {
			super.onReadRequest(descriptor, device);
		}
	}

	@Override
	public void onWriteRequest(BluetoothDescriptor descriptor, BluetoothDevice device, byte[] data) {
		if (descriptor == this.txCCC) {
			if (data.length == 2) {
				System.arraycopy(data, 0, this.txCCCValue, 0, 2);
				descriptor.sendWriteResponse(device, BluetoothStatus.OK);
			} else {
				descriptor.sendWriteResponse(device, BluetoothStatus.INVALID_VALUE_LENGTH);
			}
		} else {
			super.onWriteRequest(descriptor, device, data);
		}
	}
}
