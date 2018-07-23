package com.microej.demo.bluetooth.peripheral;

import ej.bluetooth.gatt.client.BluetoothClient;
import ej.bluetooth.gatt.client.BluetoothClientCallbacksDefault;

public class ClientCallbacks extends BluetoothClientCallbacksDefault {

	@Override
	public void onServicesDiscovered(BluetoothClient client) {
		System.out.println("services: " + client.getServices().length);
	}
}