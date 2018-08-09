/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.sps.client;

public interface SerialPortListener {

	void onDataSent();

	void onDataReceived(byte[] data);
}
