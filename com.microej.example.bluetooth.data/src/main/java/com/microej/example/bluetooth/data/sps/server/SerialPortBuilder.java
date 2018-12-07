/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.server;

import com.microej.example.bluetooth.data.DefaultServices;
import com.microej.example.bluetooth.data.sps.SerialPortService;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothPermissions;
import ej.bluetooth.BluetoothProperties;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.BluetoothServiceType;
import ej.bluetooth.BluetoothUuid;

public class SerialPortBuilder {

	private SerialPortBuilder() {
		// private constructor
	}

	public static BluetoothService createService() {
		BluetoothUuid uuid = SerialPortService.SERVICE_UUID;
		BluetoothService service = new BluetoothService(uuid, BluetoothServiceType.PRIMARY);
		service.addCharacteristic(createSpsTx());
		service.addCharacteristic(createSpsRx());
		return service;
	}

	private static BluetoothCharacteristic createSpsTx() {
		BluetoothUuid uuid = SerialPortService.TX_UUID;
		int prop = BluetoothProperties.NOTIFY;
		int perm = BluetoothPermissions.NONE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(uuid, prop, perm);
		tx.addDescriptor(DefaultServices.createCUD());
		tx.addDescriptor(DefaultServices.createCCC());
		return tx;
	}

	private static BluetoothCharacteristic createSpsRx() {
		BluetoothUuid uuid = SerialPortService.RX_UUID;
		int prop = BluetoothProperties.WRITE_NO_RESPONSE;
		int perm = BluetoothPermissions.WRITE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(uuid, prop, perm);
		tx.addDescriptor(DefaultServices.createCUD());
		return tx;
	}
}
