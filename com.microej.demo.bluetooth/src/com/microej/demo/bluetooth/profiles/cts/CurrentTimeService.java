package com.microej.demo.bluetooth.profiles.cts;

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
		return new BluetoothService.Builder(SERVICE_UUID, BluetoothServiceType.PRIMARY) //
				.addCharacteristic(createCurrentTime()) //
				.addCharacteristic(createLocalTimeInfo()) //
				.build();
	}

	private static BluetoothCharacteristic createCurrentTime() {
		return new BluetoothCharacteristic.Builder(CURRENT_TIME_UUID, //
				BluetoothProperty.READ | BluetoothProperty.NOTIFY, //
				BluetoothPermission.READ) //
				.build();
	}

	private static BluetoothCharacteristic createLocalTimeInfo() {
		return new BluetoothCharacteristic.Builder(LOCAL_TIME_INFO_UUID, //
				BluetoothProperty.READ, //
				BluetoothPermission.READ) //
				.build();
	}
}
