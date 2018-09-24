/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.peripheral;

import com.microej.example.bluetooth.data.BluetoothPayload;
import com.microej.example.bluetooth.data.sps.server.SerialPortListener;
import com.microej.example.bluetooth.data.sps.server.SerialPortServer;

import ej.bluetooth.BluetoothAdapter;
import ej.bluetooth.BluetoothDevice;

public class Main implements SerialPortListener {

	private static final int STOP_ADVERTISING_DELAY = 15000;

	private static final byte[] PAYLOAD = new byte[] { 9, (byte) BluetoothPayload.MANUFACTURER_DATA, (byte) 0xFF,
			(byte) 0xFF, 0x00, 0x10, 0x12, 0x34, 0x56, 0x78, 8, BluetoothPayload.COMPLETE_LOCAL_NAME, 'E', 'x', 'a',
			'm', 'p', 'l', 'e' };

	private final SerialPortServer serialPortServer;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

		this.serialPortServer = new SerialPortServer(this);
		adapter.addService(this.serialPortServer.getService());

		System.out.println("Start advertising");
		adapter.startAdvertising(new AppAdvertisementCallbacks(), new AppConnectionCallbacks(), PAYLOAD);

		try {
			Thread.sleep(STOP_ADVERTISING_DELAY);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (adapter.isAdvertising()) {
			adapter.stopAdvertising();
		}
	}

	@Override
	public void onDataSent(BluetoothDevice device, boolean success) {
		System.out.println("onDataSent()");
	}

	@Override
	public void onDataReceived(BluetoothDevice device, byte[] data) {
		System.out.println("onDataReceived()");
		this.serialPortServer.sendData(device, data); // echo data
	}
}
