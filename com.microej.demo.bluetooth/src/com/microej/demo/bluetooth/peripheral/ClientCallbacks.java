package com.microej.demo.bluetooth.peripheral;

import ej.bluetooth.gatt.client.BluetoothClient;
import ej.bluetooth.gatt.client.BluetoothClientCallbacksDefault;
import ej.bluetooth.gatt.data.BluetoothService;

public class ClientCallbacks extends BluetoothClientCallbacksDefault {

	@Override
	public void onServicesDiscovered(BluetoothClient client, BluetoothService[] services) {
		System.out.println("services: " + services.length);
	}
}