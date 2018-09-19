/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import com.microej.example.bluetooth.data.sps.SerialPortService;
import com.microej.example.bluetooth.data.sps.client.SerialPortClient;
import com.microej.example.bluetooth.data.sps.client.SerialPortListener;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothDescriptor;
import ej.bluetooth.BluetoothDevice;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.callbacks.impl.DefaultConnectionCallbacks;

public class AppConnectionCallbacks extends DefaultConnectionCallbacks implements SerialPortListener {

	private static final byte[] INITIAL_DATA = //
			new byte[] { 0x42, 0x00, 0x05, 0x00, 0x03, (byte) 0xF9, (byte) 0xF7, 0x06, 0x27 };

	private SerialPortClient serialPortClient;

	@Override
	public void onConnected(BluetoothDevice device) {
		System.out.println("Connected");

		device.discoverServices();
	}

	@Override
	public void onDisconnected(BluetoothDevice device) {
		System.out.println("Disconnected");
	}

	@Override
	public void onPairCompleted(BluetoothDevice device, boolean success) {
		System.out.println("Pair completed: " + success);
	}

	@Override
	public void onPasskeyRequest(BluetoothDevice device) {
		System.out.println("Passkey request");
		device.passkeyReply(true, 0);
	}

	@Override
	public void onServicesDiscovered(BluetoothDevice device) {
		for (BluetoothService service : device.getServices()) {
			System.out.println("[SERVICE] " + service.getUuid());
			for (BluetoothCharacteristic characteristic : service.getCharacteristics()) {
				String propertiesString = Integer.toHexString(characteristic.getProperties());
				System.out.println("\t[CHAR] " + characteristic.getUuid() + " P=0x" + propertiesString);
				for (BluetoothDescriptor descriptor : characteristic.getDescriptors()) {
					System.out.println("\t\t[DESC] " + descriptor.getUuid());
				}
			}
		}

		BluetoothService spsService = device.findService(SerialPortService.SERVICE_UUID);
		if (spsService == null) {
			System.out.println("Error: could not find SPS service");
		} else {
			this.serialPortClient = new SerialPortClient(spsService, this);
			this.serialPortClient.sendData(INITIAL_DATA);
		}

		device.pair(true);
	}

	@Override
	public void onDataSent() {
		System.out.println("onDataSent()");
	}

	@Override
	public void onDataReceived(byte[] data) {
		System.out.println("onDataReceived()");
	}
}
