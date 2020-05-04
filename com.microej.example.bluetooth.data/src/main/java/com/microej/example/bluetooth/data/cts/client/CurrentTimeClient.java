/*
 * Java
 *
 * Copyright 2018 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.microej.example.bluetooth.data.cts.client;

import java.util.Calendar;

import com.microej.example.bluetooth.data.cts.CurrentTimeService;

import ej.bluetooth.BluetoothCharacteristic;
import ej.bluetooth.BluetoothService;
import ej.bluetooth.BluetoothStatus;
import ej.bluetooth.callbacks.impl.DefaultClientCallbacks;
import ej.bon.ByteArray;

public class CurrentTimeClient extends DefaultClientCallbacks {

	private final BluetoothCharacteristic currentTimeChar;
	private final BluetoothCharacteristic localTimeInfoChar;

	private final CurrentTimeListener listener;

	public CurrentTimeClient(BluetoothService service, CurrentTimeListener listener) {
		this.currentTimeChar = service.findCharacteristic(CurrentTimeService.CURRENT_TIME_UUID);
		this.localTimeInfoChar = service.findCharacteristic(CurrentTimeService.LOCAL_TIME_INFO_UUID);

		if (this.currentTimeChar == null) {
			throw new IllegalArgumentException();
		}

		this.listener = listener;

		service.setClientCallbacks(this);
	}

	public void requestTime() {
		this.currentTimeChar.sendReadRequest();

		if (this.localTimeInfoChar != null) {
			this.localTimeInfoChar.sendReadRequest();
		}
	}

	@Override
	public void onReadCompleted(BluetoothCharacteristic characteristic, int status, byte[] value) {
		if (status == BluetoothStatus.OK) {
			if (characteristic == this.currentTimeChar) {
				long currentTime = readCurrentTime(value);
				this.listener.onCurrentTimeUpdate(currentTime);
			} else if (characteristic == this.localTimeInfoChar) {
				long localTimeOffset = readLocalTimeOffset(value);
				this.listener.onLocalTimeUpdate(localTimeOffset);
			}
		}
	}

	private static long readCurrentTime(byte[] value) {
		int year = (ByteArray.readShort(value, 0, ByteArray.LITTLE_ENDIAN) & 0xFFFF);
		int month = (value[2] & 0xFF);
		int day = (value[3] & 0xFF);
		int hour = (value[4] & 0xFF);
		int minute = (value[5] & 0xFF);
		int second = (value[6] & 0xFF);
		int dayOfWeek = (value[7] & 0xFF);
		int fractionsOfSecond = (value[8] & 0xFF);

		Calendar calendar = Calendar.getInstance();

		int localTimeOffset = calendar.get(Calendar.ZONE_OFFSET) + calendar.get(Calendar.DST_OFFSET);
		calendar.set(Calendar.MILLISECOND, calendar.get(Calendar.MILLISECOND) - localTimeOffset);

		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR_OF_DAY, hour);
		calendar.set(Calendar.MINUTE, minute);
		calendar.set(Calendar.SECOND, second);

		if (dayOfWeek == 7) {
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		} else {
			calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek + 1);
		}

		calendar.set(Calendar.MILLISECOND, fractionsOfSecond * 1000 / 256);

		return calendar.getTimeInMillis();
	}

	private static long readLocalTimeOffset(byte[] value) {
		int timezoneOffset = (value[0] & 0xFF);
		int dstOffset = (value[1] & 0xFF);
		return (timezoneOffset + dstOffset) * 15 * 60 * 1000;
	}
}
