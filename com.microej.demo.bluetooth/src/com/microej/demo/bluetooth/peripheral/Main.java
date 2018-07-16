package com.microej.demo.bluetooth.peripheral;

import com.microej.demo.bluetooth.profiles.sps.SerialPortCallbacks;
import com.microej.demo.bluetooth.profiles.sps.SerialPortService;

import ej.bluetooth.gap.BluetoothAdapter;
import ej.bluetooth.gap.BluetoothAdvertisingMode;
import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothDeviceCallbacksDefault;
import ej.bluetooth.gap.BluetoothPayload;

public class Main extends BluetoothDeviceCallbacksDefault {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

		// adapter.setAddress("80:EA:00:00:00:01");
		// adapter.setName("BluetoothPeripheral");
		// adapter.setAppearance(BluetoothAppearance.GENERIC_WATCH);
		// adapter.setIOCapability(BluetoothIOCapability.DISPLAY_ONLY);

		adapter.addProfile(SerialPortService.createService(), new SerialPortCallbacks());

		BluetoothPayload advData = new BluetoothPayload.Builder() //
				.setDeviceName(adapter.getName()) //
				.build();
		adapter.startAdvertising(BluetoothAdvertisingMode.CONNECTABLE, 100, advData, this);
	}

	@Override
	public void onConnected(BluetoothDevice device) {
		System.out.println("Connected to device " + device.getAddress());
	}
}
