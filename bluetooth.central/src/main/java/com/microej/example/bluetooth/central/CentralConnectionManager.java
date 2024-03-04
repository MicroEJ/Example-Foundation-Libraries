/*
 * Copyright 2018-2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.bluetooth.central;

import ej.annotation.Nullable;
import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothAddress;
import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothDataTypes;
import ej.bluetooth.BluetoothScanFilter;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.listeners.impl.DefaultConnectionListener;
import ej.bluetooth.util.AdvertisementData;
import ej.bluetooth.util.AttributeNotFoundException;
import ej.bluetooth.util.ServiceHelper;
import ej.bluetooth.util.services.cts.CurrentTimeClient;
import ej.bluetooth.util.services.cts.CurrentTimeConstants;

/**
 * Manages the Bluetooth connection.
 */
public class CentralConnectionManager extends DefaultConnectionListener {

	private static final String PERIPHERAL_NAME = "Example";

	private boolean deviceFound;
	private @Nullable CurrentTimeClient currentTimeClient;

	/**
	 * Starts this central connection manager.
	 */
	public void start() {
		BluetoothAdapter.getAdapter().setConnectionListener(this);

		startScanning();
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
	public void onDiscoveryResult(BluetoothConnection connection, BluetoothService service) {
		ServiceHelper.printService(service, System.out);

		if (service.getUuid().equals(CurrentTimeConstants.SERVICE_UUID)) {
			CurrentTimeClient currentTimeClient;
			try {
				currentTimeClient = createCurrentTimeClient(connection, service);
			} catch (AttributeNotFoundException e) {
				System.out.println("Invalid current time service");
				return;
			}

			currentTimeClient.start();
			currentTimeClient.requestTime();

			this.currentTimeClient = currentTimeClient;
		}
	}

	@Override
	public void onDisconnected(BluetoothConnection connection) {
		System.out.println("Disconnected");

		CurrentTimeClient currentTimeClient = this.currentTimeClient;
		if (currentTimeClient != null) {
			currentTimeClient.stop();
			this.currentTimeClient = null;
		}

		startScanning();
	}

	private void startScanning() {
		System.out.println("Start scanning");
		this.deviceFound = false;
		BluetoothScanFilter filter = BluetoothScanFilter.fieldExists(BluetoothDataTypes.COMPLETE_LOCAL_NAME);
		BluetoothAdapter.getAdapter().startScanning(filter);
	}

	private static CurrentTimeClient createCurrentTimeClient(BluetoothConnection connection, BluetoothService service)
			throws AttributeNotFoundException {
		return new CurrentTimeClient(connection, service) {
			@Override
			protected void onCurrentTimeUpdate(long currentTime) {
				System.out.println("Current time: " + currentTime);
			}

			@Override
			protected void onLocalTimeUpdate(long localTimeOffset) {
				System.out.println("Local time offset: " + localTimeOffset);
			}
		};
	}
}
