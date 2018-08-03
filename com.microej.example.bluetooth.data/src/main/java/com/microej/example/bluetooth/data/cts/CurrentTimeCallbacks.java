/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts;

import ej.bluetooth.gap.BluetoothDevice;
import ej.bluetooth.gatt.data.BluetoothCharacteristic;
import ej.bluetooth.gatt.data.BluetoothStatus;
import ej.bluetooth.gatt.server.BluetoothProfile;
import ej.bluetooth.gatt.server.BluetoothProfileCallbacksDefault;

public class CurrentTimeCallbacks extends BluetoothProfileCallbacksDefault {

	@Override
	public boolean onReadCharacteristicRequest(BluetoothProfile profile, BluetoothDevice device,
			BluetoothCharacteristic characteristic) {
		String charUuid = characteristic.getUuid();
		if (charUuid.equals(CurrentTimeService.CURRENT_TIME_UUID)) {
			return profile.sendReadCharacteristicResponse(device, characteristic, BluetoothStatus.OK,
					makeCurrentTime());
		} else if (charUuid.equals(CurrentTimeService.LOCAL_TIME_INFO_UUID)) {
			return profile.sendReadCharacteristicResponse(device, characteristic, BluetoothStatus.OK,
					makeLocalTimeInfo());
		}

		return super.onReadCharacteristicRequest(profile, device, characteristic);
	}

	private static byte[] makeCurrentTime() {
		return "CurrentTime".getBytes();
		// return new byte[0];
	}

	private static byte[] makeLocalTimeInfo() {
		return "LocalTimeInfo".getBytes();
		// return new byte[0];
	}
}
