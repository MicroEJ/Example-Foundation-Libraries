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
import ej.bluetooth.BluetoothDataTypes;
import ej.bluetooth.BluetoothDescriptor;
import ej.bluetooth.BluetoothObjectNotFoundException;
import ej.bluetooth.BluetoothScanFilter;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.listeners.impl.DefaultConnectionListener;
import ej.bluetooth.util.AdvertisementData;
import ej.bluetooth.util.services.cts.CurrentTimeServer;
import ej.bluetooth.util.services.sps.SerialPortConstants;

public class CentralConnectionListener extends DefaultConnectionListener {

	private static final String PERIPHERAL_NAME = "Example";

	private boolean deviceFound;

	public void start() {
		// Enable adapter
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();
		adapter.setConnectionListener(this);

		// Add the current time service
		CurrentTimeServer currentTimeServer = new CurrentTimeServer();
		adapter.addService(currentTimeServer.getService());

		// Start scanning
		startScanning();
	}

	public void stop() {
		BluetoothAdapter.getAdapter().disable();
	}

	@Override
	public void onScanResult(BluetoothAddress address, byte[] advertisementData, int rssi) {
		if (!this.deviceFound) {
			AdvertisementData data = AdvertisementData.parse(advertisementData);
			String deviceName = data.getDeviceName();
			System.out.println("Scanned device: address=" + address.toString() + " name=" + deviceName);

			if (deviceName != null && deviceName.equals(PERIPHERAL_NAME)) {
				this.deviceFound = true;
				System.out.println("Connecting...");
				BluetoothAdapter.getAdapter().connect(address);
			}
		}
	}

	@Override
	public void onConnectFailed(BluetoothAddress address) {
		System.out.println("Connect failed");

		startScanning();
	}

	@Override
	public void onConnected(BluetoothConnection connection) {
		System.out.println("Connected");

		connection.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothConnection connection) {
		System.out.println("Disconnected");

		startScanning();
	}

	@Override
	public void onDiscoveryResult(BluetoothConnection connection, BluetoothService service) {
		printService(service);

		if (service.getUuid().equals(SerialPortConstants.SERVICE_UUID)) {
			try {
				HelloWorldSerialPortClient client = new HelloWorldSerialPortClient(connection, service);
				client.sendHelloWorld();
			} catch (BluetoothObjectNotFoundException e) {
				// The remote device doesn't support the current time service
				e.printStackTrace();
			}
		}
	}

	private void startScanning() {
		System.out.println("Start scanning");
		this.deviceFound = false;
		BluetoothScanFilter filter = BluetoothScanFilter.fieldExists(BluetoothDataTypes.COMPLETE_LOCAL_NAME);
		BluetoothAdapter.getAdapter().startScanning(filter);
	}

	private static void printService(BluetoothService service) {
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
