/*
 * Copyright 2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.audio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

import ej.audio.AudioFormat;
import ej.audio.AudioRecord;
import ej.audio.format.PcmAudioFormat;
import ej.bon.Util;

public class ExampleRecord {

	private static final Logger LOGGER = Logger.getLogger(ExampleRecord.class.getName());
	private static final String OUTPUT_FILE = "record.raw";
	private static final AudioFormat FORMAT = new PcmAudioFormat(16_000, 1, 16, false, true);
	private static final int RECORD_BUFFER_SIZE = 1600; // 50ms
	private static final int CHUNK_BUFFER_SIZE = 480; // 15ms
	private static final long DURATION = 5_000; // 5s

	public static void main(String[] args) {
		LOGGER.info("Starting recording");

		try (OutputStream outputStream = new FileOutputStream(OUTPUT_FILE)) {
			try (AudioRecord audioRecord = new AudioRecord(FORMAT, RECORD_BUFFER_SIZE)) {
				byte[] chunkBuffer = new byte[CHUNK_BUFFER_SIZE];
				long endTime = Util.platformTimeMillis() + DURATION;

				do {
					audioRecord.readBuffer(chunkBuffer, 0, chunkBuffer.length);
					outputStream.write(chunkBuffer, 0, chunkBuffer.length);
				} while (Util.platformTimeMillis() < endTime);
			}

			LOGGER.info("Stopping recording");
		} catch (IOException e) {
			LOGGER.info("Error writing file");
		}
	}
}
