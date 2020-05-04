/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.server;

import java.util.Calendar;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothDevice;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.BluetoothStatus;
import ej.bluetooth.callbacks.impl.DefaultServerCallbacks;
import ej.bon.ByteArray;

public class CurrentTimeServer extends DefaultServerCallbacks {

	private final BluetoothService service;
	private final BluetoothCharacteristic currentTimeChar;
	private final BluetoothCharacteristic localTimeInfoChar;

	public CurrentTimeServer() {
		this.service = CurrentTimeBuilder.createService();
		this.service.setServerCallbacks(this);

		this.currentTimeChar = this.service.findCharacteristic(CurrentTimeService.CURRENT_TIME_UUID);
		this.localTimeInfoChar = this.service.findCharacteristic(CurrentTimeService.LOCAL_TIME_INFO_UUID);
	}

	public BluetoothService getService() {
		return this.service;
	}

	@Override
	public void onReadRequest(BluetoothCharacteristic characteristic, BluetoothDevice device) {
		if (characteristic == this.currentTimeChar) {
			characteristic.sendReadResponse(device, BluetoothStatus.OK, makeCurrentTime());
		} else if (characteristic == this.localTimeInfoChar) {
			characteristic.sendReadResponse(device, BluetoothStatus.OK, makeLocalTimeInfo());
		} else {
			super.onReadRequest(characteristic, device);
		}
	}

	private static byte[] makeCurrentTime() {
		Calendar calendar = Calendar.getInstance();

		int localTimeOffset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
		calendar.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND) - localTimeOffset);

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);

		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		if (dayOfWeek == Calendar.SUNDAY) {
			dayOfWeek = 7;
		} else {
			dayOfWeek = dayOfWeek - 1;
		}

		int fractionsOfSecond = (int) (calendar.getTimeInMillis() * 256 / 1000);
		int adjustReason = 0;

		byte[] value = new byte[10];
		ByteArray.writeShort(value, 0, year, ByteArray.LITTLE_ENDIAN);
		value[2] = (byte) month;
		value[3] = (byte) day;
		value[4] = (byte) hour;
		value[5] = (byte) minute;
		value[6] = (byte) second;
		value[7] = (byte) dayOfWeek;
		value[8] = (byte) fractionsOfSecond;
		value[9] = (byte) adjustReason;
		return value;
	}

	private static byte[] makeLocalTimeInfo() {
		Calendar calendar = Calendar.getInstance();

		int timezoneOffset = calendar.get(Calendar.ZONE_OFFSET) / (15 * 60 * 1000);
		int dstOffset = calendar.get(Calendar.DST_OFFSET) / (15 * 60 * 1000);

		byte[] value = new byte[2];
		value[0] = (byte) timezoneOffset;
		value[1] = (byte) dstOffset;
		return value;
	}
}
