package com.microej.example.bluetooth.data.cts;

import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothPermission;
import ej.bluetooth.gatt.data.BluetoothProperty;
import ej.bluetooth.gatt.data.BluetoothService;
import ej.bluetooth.gatt.data.BluetoothServiceType;

public class CurrentTimeService {

	public static final String SERVICE_UUID = "00001805-0000-1000-8000-00805f9b34fb";
	public static final String CURRENT_TIME_UUID = "00002a2b-0000-1000-8000-00805f9b34fb";
	public static final String LOCAL_TIME_INFO_UUID = "00002a0f-0000-1000-8000-00805f9b34fb";

	private CurrentTimeService() {
		// private constructor
	}

	public static BluetoothService createService() {
		BluetoothService service = new BluetoothService(SERVICE_UUID, BluetoothServiceType.PRIMARY);
		service.addCharacteristic(createCurrentTime());
		service.addCharacteristic(createLocalTimeInfo());
		return service;
	}

	private static BluetoothCharacteristic createCurrentTime() {
		int prop = BluetoothProperty.READ | BluetoothProperty.NOTIFY;
		int perm = BluetoothPermission.READ;
		return new BluetoothCharacteristic(CURRENT_TIME_UUID, prop, perm);
	}

	private static BluetoothCharacteristic createLocalTimeInfo() {
		int prop = BluetoothProperty.READ;
		int perm = BluetoothPermission.READ;
		return new BluetoothCharacteristic(LOCAL_TIME_INFO_UUID, prop, perm);
	}
}
