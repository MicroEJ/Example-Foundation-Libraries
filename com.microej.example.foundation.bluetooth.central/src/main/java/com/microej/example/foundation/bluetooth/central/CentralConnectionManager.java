/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.foundation.bluetooth.central;

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
import ej.bluetooth.util.services.cts.CurrentTimeConstants;
import ej.bluetooth.util.services.cts.CurrentTimeServer;
import ej.bluetooth.util.services.sps.SerialPortConstants;

public class CentralConnectionManager extends DefaultConnectionListener {

	private static final String PERIPHERAL_NAME = "Example";

	private @Nullable CurrentTimeServer currentTimeServer;
	private @Nullable HelloWorldSerialPortClient helloWorldSerialPortClient;

	private boolean deviceFound;

	public void start() {
		// Enable adapter
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();
		adapter.setConnectionListener(this);

		// Add the current time service
		BluetoothService currentTimeService = adapter.addService(CurrentTimeConstants.getServiceDefinition());
		if (currentTimeService == null) {
			System.out.println("Could not add current time service");
		} else {
			try {
				this.currentTimeServer = new CurrentTimeServer(currentTimeService);
			} catch (AttributeNotFoundException e) {
				System.out.println("Invalid current time service");
			}
		}

		// Start scanning
		startScanning();
	}

	public void stop() {
		if (this.helloWorldSerialPortClient != null) {
			this.helloWorldSerialPortClient.close();
			this.helloWorldSerialPortClient = null;
		}

		if (this.currentTimeServer != null) {
			this.currentTimeServer.close();
			this.currentTimeServer = null;
		}

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

		if (this.helloWorldSerialPortClient != null) {
			this.helloWorldSerialPortClient.close();
			this.helloWorldSerialPortClient = null;
		}

		startScanning();
	}

	@Override
	public void onDiscoveryResult(BluetoothConnection connection, BluetoothService service) {
		ServiceHelper.printService(service, System.out);

		if (service.getUuid().equals(SerialPortConstants.SERVICE_UUID)) {
			try {
				this.helloWorldSerialPortClient = new HelloWorldSerialPortClient(connection, service);
				this.helloWorldSerialPortClient.sendHelloWorld();
			} catch (AttributeNotFoundException e) {
				System.out.println("Invalid serial port service");
			}
		}
	}

	private void startScanning() {
		System.out.println("Start scanning");
		this.deviceFound = false;
		BluetoothScanFilter filter = BluetoothScanFilter.fieldExists(BluetoothDataTypes.COMPLETE_LOCAL_NAME);
		BluetoothAdapter.getAdapter().startScanning(filter);
	}
}
