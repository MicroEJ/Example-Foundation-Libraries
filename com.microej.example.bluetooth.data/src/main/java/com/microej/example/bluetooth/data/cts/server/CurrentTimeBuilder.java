/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.server;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothPermission;
import ej.bluetooth.gatt.BluetoothProperty;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothServiceType;
import ej.bluetooth.gatt.callbacks.BluetoothServerCallbacksDefault;

public class CurrentTimeBuilder extends BluetoothServerCallbacksDefault {

	private CurrentTimeBuilder() {
		// private constructor
	}

	public static BluetoothService createService() {
		String uuid = CurrentTimeService.SERVICE_UUID;
		BluetoothService service = new BluetoothService(uuid, BluetoothServiceType.PRIMARY);
		service.addCharacteristic(createCurrentTime());
		service.addCharacteristic(createLocalTimeInfo());
		return service;
	}

	private static BluetoothCharacteristic createCurrentTime() {
		String uuid = CurrentTimeService.CURRENT_TIME_UUID;
		int prop = BluetoothProperty.READ | BluetoothProperty.NOTIFY;
		int perm = BluetoothPermission.READ;
		return new BluetoothCharacteristic(uuid, prop, perm);
	}

	private static BluetoothCharacteristic createLocalTimeInfo() {
		String uuid = CurrentTimeService.LOCAL_TIME_INFO_UUID;
		int prop = BluetoothProperty.READ;
		int perm = BluetoothPermission.READ;
		return new BluetoothCharacteristic(uuid, prop, perm);
	}
}
