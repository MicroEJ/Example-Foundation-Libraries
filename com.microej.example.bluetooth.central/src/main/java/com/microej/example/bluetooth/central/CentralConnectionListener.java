/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothAddress;
import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothDescriptor;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.listeners.impl.DefaultConnectionListener;
import ej.bluetooth.util.AdvertisementData;

public class CentralConnectionListener extends DefaultConnectionListener {

	private static final String PERIPHERAL_NAME = "Example";

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

		HelloWorldSerialPortClient.sendHelloWorld(connection);
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
