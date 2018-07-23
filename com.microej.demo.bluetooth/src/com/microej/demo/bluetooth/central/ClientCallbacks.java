package com.microej.demo.bluetooth.central;

import com.microej.demo.bluetooth.profiles.DefaultServices;
import com.microej.demo.bluetooth.profiles.sps.SerialPortService;

import ej.bluetooth.gatt.client.BluetoothClient;
import ej.bluetooth.gatt.client.BluetoothClientCallbacksDefault;
import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothDescriptor;
import ej.bluetooth.gatt.data.BluetoothService;
import ej.bluetooth.gatt.data.BluetoothStatus;

public class ClientCallbacks extends BluetoothClientCallbacksDefault {

	@Override
	public void onServicesDiscovered(BluetoothClient client) {
		for (BluetoothService service : client.getServices()) {
			System.out.println("[SERVICE] " + service.getUuid());
			for (BluetoothCharacteristic characteristic : service.getCharacteristics()) {
				System.out.println("\t[CHAR] " + characteristic.getUuid());
				for (BluetoothDescriptor descriptor : characteristic.getDescriptors()) {
					System.out.println("\t\t[DESC] " + descriptor.getUuid());
				}
			}
		}

		BluetoothService spsService = client.findService(SerialPortService.SERVICE_UUID);
		if (spsService == null) {
			System.out.println("Error: could not find SPS service");
		} else {
			initializeSps(client, spsService);
		}
	}

	private void initializeSps(BluetoothClient client, BluetoothService spsService) {
		BluetoothCharacteristic spsTx = spsService.findCharacteristic(SerialPortService.TX_UUID);
		BluetoothCharacteristic spsRx = spsService.findCharacteristic(SerialPortService.RX_UUID);

		if (spsTx != null && spsRx != null) {
			BluetoothDescriptor spsTxCCC = spsTx.findDescriptor(DefaultServices.CCC_UUID);
			client.writeDescriptor(spsTxCCC, new byte[] { 0x00, 0x01 });
		}
	}

	@Override
	public void onCharacteristicChanged(BluetoothClient client, BluetoothCharacteristic characteristic, byte[] value) {
		if (characteristic.getUuid().equals(SerialPortService.TX_UUID)) {
			System.out.println("tx: " + value.length);
		}
	}

	@Override
	public void onDescriptorWrite(BluetoothClient client, BluetoothDescriptor descriptor, BluetoothStatus status) {
		// TODO
	}
}