package com.microej.demo.bluetooth.central;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothDeviceCallbacksDefault;

public class DeviceCallbacks extends BluetoothDeviceCallbacksDefault {

	@Override
	public void onConnected(BluetoothDevice device) {
		System.out.println("Connected");

		// device.discoverServices(new ClientCallbacks());
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
