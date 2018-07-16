package com.microej.demo.bluetooth.profiles.sps;

import com.microej.demo.bluetooth.profiles.DefaultServices;

import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothPermission;
import ej.bluetooth.gatt.data.BluetoothProperty;
import ej.bluetooth.gatt.data.BluetoothService;
import ej.bluetooth.gatt.data.BluetoothServiceType;

public class SerialPortService {

	public static final String SERVICE_UUID = null;
	public static final String TX_UUID = null;
	public static final String RX_UUID = null;

	private SerialPortService() {
		// private constructor
	}

	public static BluetoothService createService() {
		return new BluetoothService.Builder(SERVICE_UUID, BluetoothServiceType.PRIMARY) //
				.addCharacteristic(createSpsTx()) //
				.addCharacteristic(createSpsRx()) //
				.build();
	}

	private static BluetoothCharacteristic createSpsTx() {
		return new BluetoothCharacteristic.Builder(TX_UUID, //
				BluetoothProperty.NOTIFY,
				BluetoothPermission.NONE) //
				.addDescriptor(DefaultServices.createCCC()) //
				.addDescriptor(DefaultServices.createCUD()) //
				.build();
	}

	private static BluetoothCharacteristic createSpsRx() {
		return new BluetoothCharacteristic.Builder(RX_UUID, //
				BluetoothProperty.WRITE_NO_RESPONSE, //
				BluetoothPermission.WRITE) //
				.addDescriptor(DefaultServices.createCUD()) //
				.build();
	}
}
