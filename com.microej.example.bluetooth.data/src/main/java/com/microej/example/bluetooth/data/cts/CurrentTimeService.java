/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts;

import ej.bluetooth.BluetoothUuid;

public interface CurrentTimeService {

	BluetoothUuid SERVICE_UUID = new BluetoothUuid(0x1805);
	BluetoothUuid CURRENT_TIME_UUID = new BluetoothUuid(0x2A2B);
	BluetoothUuid LOCAL_TIME_INFO_UUID = new BluetoothUuid(0x2A0F);
}
