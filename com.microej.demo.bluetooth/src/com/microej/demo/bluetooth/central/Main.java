package com.microej.demo.bluetooth.central;

import com.microej.demo.bluetooth.profiles.cts.CurrentTimeCallbacks;
import com.microej.demo.bluetooth.profiles.cts.CurrentTimeService;

import ej.bluetooth.gap.BluetoothAdapter;
import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gap.BluetoothPayload;
import ej.bluetooth.gap.BluetoothScanCallbacks;

public class Main implements BluetoothScanCallbacks {

	private static final String PERIPHERAL_ADDR = "80:EA:22:65:DB:CD";

	private boolean deviceFound;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();

		// adapter.setAddress("80:EA:00:00:00:02");
		// adapter.setName("BluetoothCentral");
		// adapter.setAppearance(BluetoothAppearance.GENERIC_PHONE);
		// adapter.setIOCapability(BluetoothIOCapability.KEYBOARD_DISPLAY);

		adapter.addProfile(CurrentTimeService.createService(), new CurrentTimeCallbacks());

		this.deviceFound = false;

		adapter.startScanning(this);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		adapter.stopScanning();
	}

	@Override
	public void onScanResult(BluetoothDevice device, BluetoothPayload advData) {
		System.out.println("Scanned device addr: " + device.getAddress());

		if (!this.deviceFound && device.getAddress().equals(PERIPHERAL_ADDR)) {
			this.deviceFound = true;
			device.getAdapter().stopScanning();
			device.connect(new DeviceCallbacks());
		}
	}

	@Override
	public void onScanComplete() {
		System.out.println("Scan complete");
	}
}
