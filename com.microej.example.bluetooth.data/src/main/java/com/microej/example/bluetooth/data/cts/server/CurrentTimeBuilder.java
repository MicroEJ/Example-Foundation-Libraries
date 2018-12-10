/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.server;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothPermissions;
import ej.bluetooth.BluetoothProperties;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.BluetoothService.Type;
import ej.bluetooth.BluetoothUuid;
import ej.bluetooth.callbacks.impl.DefaultServerCallbacks;

public class CurrentTimeBuilder extends DefaultServerCallbacks {

	private CurrentTimeBuilder() {
		// private constructor
	}

	public static BluetoothService createService() {
		BluetoothUuid uuid = CurrentTimeService.SERVICE_UUID;
		BluetoothService service = new BluetoothService(uuid, Type.PRIMARY);
		service.addCharacteristic(createCurrentTime());
		service.addCharacteristic(createLocalTimeInfo());
		return service;
	}

	private static BluetoothCharacteristic createCurrentTime() {
		BluetoothUuid uuid = CurrentTimeService.CURRENT_TIME_UUID;
		int prop = BluetoothProperties.READ | BluetoothProperties.NOTIFY;
		int perm = BluetoothPermissions.READ;
		return new BluetoothCharacteristic(uuid, prop, perm);
	}

	private static BluetoothCharacteristic createLocalTimeInfo() {
		BluetoothUuid uuid = CurrentTimeService.LOCAL_TIME_INFO_UUID;
		int prop = BluetoothProperties.READ;
		int perm = BluetoothPermissions.READ;
		return new BluetoothCharacteristic(uuid, prop, perm);
	}
}
