package com.microej.demo.bluetooth.peripheral;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothDeviceCallbacksDefault;

public class DeviceCallbacks extends BluetoothDeviceCallbacksDefault {

	@Override
	public void onConnected(BluetoothDevice device) {
		System.out.println("connected");

		device.discoverServices(new ClientCallbacks());
	}

	@Override
	public void onDisconnected(BluetoothDevice device) {
		// do nothing
	}

	@Override
	public boolean onPairingRequest(BluetoothDevice device) {
		return false;
	}
}
