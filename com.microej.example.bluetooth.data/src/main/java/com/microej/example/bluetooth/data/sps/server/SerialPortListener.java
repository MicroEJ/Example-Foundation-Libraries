/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.server;

import ej.bluetooth.gap.BluetoothDevice;

public interface SerialPortListener {

	void onDataSent(BluetoothDevice device, boolean success);

	void onDataReceived(BluetoothDevice device, byte[] data);
}
