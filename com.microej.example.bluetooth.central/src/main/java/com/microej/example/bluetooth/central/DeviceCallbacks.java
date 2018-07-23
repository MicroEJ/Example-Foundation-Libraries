/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.central;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothDeviceCallbacksDefault;
import ej.bon.Timer;
import ej.bon.TimerTask;

public class DeviceCallbacks extends BluetoothDeviceCallbacksDefault {

	@Override
	public void onConnected(final BluetoothDevice device) {
		System.out.println("Connected");

		device.discoverServices(new ClientCallbacks());

		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				device.disconnect();
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, 5000);
	}

	@Override
	public void onDisconnected(BluetoothDevice device) {
		System.out.println("Disconnected");
	}

	@Override
	public boolean onPairingRequest(BluetoothDevice device) {
		return false;
	}
}
