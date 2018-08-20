/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data;

/**
 * Refer to <a href="https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile">Bluetooth
 * Assigned Numbers</a>.
 */
public class BluetoothPayload {

	public static final int FLAGS = 0x01;
	public static final int SERVICE_UUID16_PARTIAL_LIST = 0x02;
	public static final int SERVICE_UUID16_FULL_LIST = 0x03;
	public static final int SERVICE_UUID32_PARTIAL_LIST = 0x04;
	public static final int SERVICE_UUID32_FULL_LIST = 0x05;
	public static final int SERVICE_UUID128_PARTIAL_LIST = 0x06;
	public static final int SERVICE_UUID128_FULL_LIST = 0x07;
	public static final int SHORTENED_LOCAL_NAME = 0x08;
	public static final int COMPLETE_LOCAL_NAME = 0x09;
	public static final int TX_POWER_LEVEL = 0x0A;
	public static final int CONNECTION_INTERVAL = 0x12;
	public static final int SOLICITATION_UUID16_LIST = 0x14;
	public static final int SOLICITATION_UUID128_LIST = 0x15;
	public static final int SERVICE_DATA_UUID16 = 0x16;
	public static final int PUBLIC_TARGET_ADDRESS = 0x17;
	public static final int RANDOM_TARGET_ADDRESS = 0x18;
	public static final int APPEARANCE = 0x19;
	public static final int ADVERTISING_INTERVAL = 0x1A;
	public static final int SOLICITATION_UUID32_LIST = 0x1F;
	public static final int SERVICE_DATA_UUID32 = 0x20;
	public static final int SERVICE_DATA_UUID128 = 0x21;
	public static final int URI = 0x24;
	public static final int MANUFACTURER_DATA = 0xFF;

	private BluetoothPayload() {
		// private constructor
	}

	public static byte[] parseBytes(byte[] payload, int wantedType) {
		int i = 0;
		while (i < payload.length) {
			int length = payload[i++];
			if (length == 0 || i + length - 1 >= payload.length) {
				return null;
			}

			int type = payload[i++];
			length--;

			if (type == wantedType) {
				byte[] data = new byte[length];
				System.arraycopy(payload, i, data, 0, length);
				return data;
			}
			i += length;
		}

		return null;
	}

	public static String parseString(byte[] payload, int wantedType) {
		byte[] data = parseBytes(payload, wantedType);
		if (data == null) {
			return null;
		}
		return new String(data);
	}

	public static Byte parseByte(byte[] payload, int type) {
		byte[] data = parseBytes(payload, type);
		if (data == null || data.length != 1) {
			return null;
		}
		return Byte.valueOf(data[0]);
	}
}
