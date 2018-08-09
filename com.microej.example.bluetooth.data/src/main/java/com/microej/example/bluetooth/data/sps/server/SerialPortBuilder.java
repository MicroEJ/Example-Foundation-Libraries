/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.server;

import com.microej.example.bluetooth.data.DefaultServices;
import com.microej.example.bluetooth.data.sps.SerialPortService;

import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothPermission;
import ej.bluetooth.gatt.BluetoothProperty;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothServiceType;

public class SerialPortBuilder {

	private SerialPortBuilder() {
		// private constructor
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
		tx.addDescriptor(DefaultServices.createCUD());
		tx.addDescriptor(DefaultServices.createCCC());
		return tx;
	}

	private static BluetoothCharacteristic createSpsRx() {
		String uuid = SerialPortService.RX_UUID;
		int prop = BluetoothProperty.WRITE_NO_RESPONSE;
		int perm = BluetoothPermission.WRITE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(uuid, prop, perm);
		tx.addDescriptor(DefaultServices.createCUD());
		return tx;
	}
}
