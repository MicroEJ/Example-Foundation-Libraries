/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps;

import com.microej.example.bluetooth.data.DefaultServices;

import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothPermission;
import ej.bluetooth.gatt.data.BluetoothProperty;
import ej.bluetooth.gatt.data.BluetoothService;
import ej.bluetooth.gatt.data.BluetoothServiceType;

public class SerialPortService {

	public static final String SERVICE_UUID = "0783b03e-8535-b5a0-7140-a304d2495cb7";
	public static final String TX_UUID = "0783b03e-8535-b5a0-7140-a304d2495cb8";
	public static final String RX_UUID = "0783b03e-8535-b5a0-7140-a304d2495cba";

	private static final String TX_CUD = "TX data";
	private static final String RX_CUD = "RX data";

	private SerialPortService() {
		// private constructor
	}

	public static BluetoothService createService() {
		BluetoothService service = new BluetoothService(SERVICE_UUID, BluetoothServiceType.PRIMARY);
		service.addCharacteristic(createSpsTx());
		service.addCharacteristic(createSpsRx());
		return service;
	}

	private static BluetoothCharacteristic createSpsTx() {
		int prop = BluetoothProperty.NOTIFY;
		int perm = BluetoothPermission.NONE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(TX_UUID, prop, perm);
		tx.addDescriptor(DefaultServices.createCCC());
		tx.addDescriptor(DefaultServices.createCUD(TX_CUD));
		return tx;
	}

	private static BluetoothCharacteristic createSpsRx() {
		int prop = BluetoothProperty.WRITE_NO_RESPONSE;
		int perm = BluetoothPermission.WRITE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(RX_UUID, prop, perm);
		tx.addDescriptor(DefaultServices.createCUD(RX_CUD));
		return tx;
	}
}
