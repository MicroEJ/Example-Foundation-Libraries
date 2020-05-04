/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps;

import ej.bluetooth.BluetoothUuid;

public interface SerialPortService {

	BluetoothUuid SERVICE_UUID = new BluetoothUuid("0783b03e-8535-b5a0-7140-a304d2495cb7");
	BluetoothUuid TX_UUID = new BluetoothUuid("0783b03e-8535-b5a0-7140-a304d2495cb8");
	BluetoothUuid RX_UUID = new BluetoothUuid("0783b03e-8535-b5a0-7140-a304d2495cba");
}
