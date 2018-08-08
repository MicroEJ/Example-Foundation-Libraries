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
import ej.bluetooth.gatt.BluetoothPermission;
import ej.bluetooth.gatt.BluetoothProperty;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothServiceType;
import ej.bluetooth.gatt.BluetoothStatus;
import ej.bluetooth.gatt.callbacks.BluetoothServerCallbacksDefault;

public class SerialPortServer extends BluetoothServerCallbacksDefault {

	private static final String TX_CUD = "TX data";
	private static final String RX_CUD = "RX data";

	private final BluetoothService service;

	public SerialPortServer() {
		this.service = createService();
		this.service.setServerCallbacks(this);
	}

	public BluetoothService getService() {
		return this.service;
	}

	public static BluetoothService createService() {
		String uuid = SerialPortService.SERVICE_UUID;
		BluetoothService service = new BluetoothService(uuid, BluetoothServiceType.PRIMARY);
		service.addCharacteristic(createSpsTx());
		service.addCharacteristic(createSpsRx());
		return service;
	}

	private static BluetoothCharacteristic createSpsTx() {
		String uuid = SerialPortService.TX_UUID;
		int prop = BluetoothProperty.NOTIFY;
		int perm = BluetoothPermission.NONE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(uuid, prop, perm);
		tx.addDescriptor(DefaultServices.createCCC());
		tx.addDescriptor(DefaultServices.createCUD(TX_CUD));
		return tx;
	}

	private static BluetoothCharacteristic createSpsRx() {
		String uuid = SerialPortService.RX_UUID;
		int prop = BluetoothProperty.WRITE_NO_RESPONSE;
		int perm = BluetoothPermission.WRITE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(uuid, prop, perm);
		tx.addDescriptor(DefaultServices.createCUD(RX_CUD));
		return tx;
	}

	@Override
	public void onReadRequest(BluetoothDescriptor descriptor, BluetoothDevice device) {
		if (descriptor.matchesUuid(DefaultServices.CUD_UUID)) {
			BluetoothCharacteristic characteristic = descriptor.getCharacteristic();
			if (characteristic.matchesUuid(SerialPortService.TX_UUID)) {
				descriptor.sendReadResponse(device, BluetoothStatus.OK, TX_CUD.getBytes());
			} else if (characteristic.matchesUuid(SerialPortService.RX_UUID)) {
				descriptor.sendReadResponse(device, BluetoothStatus.OK, RX_CUD.getBytes());
			}
		}
	}
}
