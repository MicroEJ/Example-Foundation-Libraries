/*
 * Java
 *
 * Copyright 2018-2020 MicroEJ Corp. All rights reserved.
 * This library is provided in source code for use, modification and test, subject to license terms.
 * Any modification of the source code will break MicroEJ Corp. warranties on the whole library.
 */
package com.microej.example.bluetooth.peripheral;

import ej.annotation.Nullable;
import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothConnection;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.listeners.impl.DefaultConnectionListener;
import ej.bluetooth.util.AdvertisementData;
import ej.bluetooth.util.AttributeNotFoundException;
import ej.bluetooth.util.GattHelper;
import ej.bluetooth.util.services.cts.CurrentTimeConstants;
import ej.bluetooth.util.services.sps.SerialPortConstants;

public class PeripheralConnectionManager extends DefaultConnectionListener {

	private static final String DEVICE_NAME = "Example";

	private @Nullable EchoSerialPortServer echoSerialPortServer;
	private @Nullable PrintCurrentTimeClient printCurrentTimeClient;

	public void start() {
		// Enable adapter
		BluetoothAdapter adapter = BluetoothAdapter.getAdapter();
		adapter.enable();
		adapter.setConnectionListener(this);

		// Add the serial port service
		BluetoothService serialPortService = adapter.addService(SerialPortConstants.getServiceDefinition());
		if (serialPortService == null) {
			System.out.println("Could not add serial port service");
		} else {
			try {
				this.echoSerialPortServer = new EchoSerialPortServer(serialPortService);
			} catch (AttributeNotFoundException e) {
				System.out.println("Invalid serial port service");
			}
		}

		// Start advertising
		startAdvertising();
	}

	public void stop() {
		if (this.printCurrentTimeClient != null) {
			this.printCurrentTimeClient.close();
			this.printCurrentTimeClient = null;
		}

		if (this.echoSerialPortServer != null) {
			this.echoSerialPortServer.close();
			this.echoSerialPortServer = null;
		}

		BluetoothAdapter.getAdapter().disable();
	}

	@Override
	public void onConnected(BluetoothConnection connection) {
		System.out.println("Connected");

		connection.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothConnection connection) {
		System.out.println("Disconnected");

		if (this.printCurrentTimeClient != null) {
			this.printCurrentTimeClient.close();
			this.printCurrentTimeClient = null;
		}

		startAdvertising();
	}

	@Override
	public void onDiscoveryResult(BluetoothConnection connection, BluetoothService service) {
		GattHelper.printService(service, System.out);

		if (service.getUuid().equals(CurrentTimeConstants.SERVICE_UUID)) {
			try {
				this.printCurrentTimeClient = new PrintCurrentTimeClient(connection, service);
				this.printCurrentTimeClient.requestTime();
			} catch (AttributeNotFoundException e) {
				System.out.println("Invalid current time service");
			}
		}
	}

	private void startAdvertising() {
		System.out.println("Start advertising");
		AdvertisementData data = new AdvertisementData();
		data.setDeviceName(DEVICE_NAME);
		BluetoothAdapter.getAdapter().startAdvertising(data.serialize());
	}
}
