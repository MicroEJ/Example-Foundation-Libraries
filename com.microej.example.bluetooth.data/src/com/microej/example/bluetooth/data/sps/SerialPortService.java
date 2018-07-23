package com.microej.example.bluetooth.data.sps;

import com.microej.example.bluetooth.data.DefaultServices;

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
		tx.addDescriptor(DefaultServices.createCUD());
		return tx;
	}

	private static BluetoothCharacteristic createSpsRx() {
		int prop = BluetoothProperty.WRITE_NO_RESPONSE;
		int perm = BluetoothPermission.WRITE;
		BluetoothCharacteristic tx = new BluetoothCharacteristic(RX_UUID, prop, perm);
		tx.addDescriptor(DefaultServices.createCUD());
		return tx;
	}
}
