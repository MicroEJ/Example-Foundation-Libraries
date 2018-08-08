/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.server;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.BluetoothCharacteristic;
import ej.bluetooth.gatt.BluetoothPermission;
import ej.bluetooth.gatt.BluetoothProperty;
import ej.bluetooth.gatt.BluetoothService;
import ej.bluetooth.gatt.BluetoothServiceType;
import ej.bluetooth.gatt.BluetoothStatus;
import ej.bluetooth.gatt.callbacks.BluetoothServerCallbacksDefault;

public class CurrentTimeServer extends BluetoothServerCallbacksDefault {

	private final BluetoothService service;

	public CurrentTimeServer() {
		this.service = createService();
		this.service.setServerCallbacks(this);
	}

	public BluetoothService getService() {
		return this.service;
	}

	private static BluetoothService createService() {
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

	@Override
	public void onReadRequest(BluetoothCharacteristic characteristic, BluetoothDevice device) {
		if (characteristic.matchesUuid(CurrentTimeService.CURRENT_TIME_UUID)) {
			characteristic.sendReadResponse(device, BluetoothStatus.OK, makeCurrentTime());
		} else if (characteristic.matchesUuid(CurrentTimeService.LOCAL_TIME_INFO_UUID)) {
			characteristic.sendReadResponse(device, BluetoothStatus.OK, makeLocalTimeInfo());
		}
	}

	private static byte[] makeCurrentTime() {
		// TODO: actual implementation
		return "CurrentTime".getBytes();
	}

	private static byte[] makeLocalTimeInfo() {
		// TODO: actual implementation
		return "LocalTimeInfo".getBytes();
	}
}
