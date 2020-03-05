/*
 * Java
 *
 * Copyright 2018-2020 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothAddress;
import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothDescriptor;
import ej.bluetooth.BluetoothObjectNotFoundException;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.listeners.impl.DefaultConnectionListener;
import ej.bluetooth.util.AdvertisementData;
import ej.bluetooth.util.services.sps.SerialPortClient;
import ej.bluetooth.util.services.sps.SerialPortListener;

public class CentralConnectionListener extends DefaultConnectionListener implements SerialPortListener {

	private static final String PERIPHERAL_NAME = "Example";
	private static final byte[] INITIAL_DATA = "Hello world".getBytes();

	private boolean deviceFound;

	@Override
	public void onScanCompleted() {
		System.out.println("Scan complete");
	}

	@Override
	public void onScanResult(BluetoothAddress address, byte[] advertisementData, int rssi) {
		AdvertisementData data = AdvertisementData.parse(advertisementData);
		String deviceName = data.getDeviceName();

		System.out.println("Scanned device: address=" + address.toString() + " public=" + address.isPublic() + " RSSI="
				+ rssi + " name=" + deviceName);

		if (!this.deviceFound && deviceName != null && deviceName.equals(PERIPHERAL_NAME)) {
			this.deviceFound = true;
			System.out.println("Connecting...");
			BluetoothAdapter.getAdapter().connect(address);
		}
	}

	@Override
	public void onConnectFailed(BluetoothAddress address) {
		System.out.println("Connect failed");
	}

	@Override
	public void onConnected(BluetoothConnection connection) {
		System.out.println("Connected");

		connection.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothConnection connection) {
		System.out.println("Disconnected");

		this.deviceFound = false;
		BluetoothAdapter.getAdapter().startScanning();
	}

	@Override
	public void onServicesDiscovered(BluetoothConnection connection) {
		printDeviceServices(connection);

		try {
			SerialPortClient serialPortClient = new SerialPortClient(connection, this);
			serialPortClient.sendData(INITIAL_DATA);
		} catch (BluetoothObjectNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onDataSent(boolean success) {
		System.out.println("Data sent");
	}

	@Override
	public void onDataReceived(byte[] data) {
		System.out.println("Data received: " + new String(data));
	}

	private static void printDeviceServices(BluetoothConnection connection) {
		for (BluetoothService service : connection.getServices()) {
			System.out.println("[SERVICE] " + service.getUuid());
			for (BluetoothCharacteristic characteristic : service.getCharacteristics()) {
				String propertiesString = Integer.toHexString(characteristic.getProperties());
				System.out.println("\t[CHAR] " + characteristic.getUuid() + " P=0x" + propertiesString);
				for (BluetoothDescriptor descriptor : characteristic.getDescriptors()) {
					System.out.println("\t\t[DESC] " + descriptor.getUuid());
				}
			}
		}
	}
}
