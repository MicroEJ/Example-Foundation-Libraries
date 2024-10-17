/*
 * Copyright 2024 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.audio;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import ej.audio.AudioFormat;
import ej.audio.AudioTrack;
import ej.audio.format.PcmAudioFormat;

public class ExampleTrack {

	private static final Logger LOGGER = Logger.getLogger(ExampleTrack.class.getName());
	private static final String INPUT_RESOURCE = "/track.raw";
	private static final AudioFormat FORMAT = new PcmAudioFormat(16_000, 1, 16, false, true);
	private static final int TRACK_BUFFER_SIZE = 32000; // 1000ms
	private static final int CHUNK_BUFFER_SIZE = 480; // 15ms

	public static void main(String[] args) {
		LOGGER.info("Starting playback");

		try (InputStream inputStream = ExampleTrack.class.getResourceAsStream(INPUT_RESOURCE)) {
			assert (inputStream != null);

			try (AudioTrack audioTrack = new AudioTrack(FORMAT, TRACK_BUFFER_SIZE)) {
				byte[] chunkBuffer = new byte[CHUNK_BUFFER_SIZE];

				while (true) {
					int bytesRead = inputStream.read(chunkBuffer, 0, chunkBuffer.length);
					if (bytesRead == -1) {
						break;
					}
					audioTrack.writeBuffer(chunkBuffer, 0, bytesRead);
				}

				LOGGER.info("End of file, waiting for audio track flush");
				audioTrack.waitForBufferFlushed();
				LOGGER.info("Audio track flushed, stopping playback");
			}
		} catch (IOException e) {
			LOGGER.info("Error reading resource");
		}
	}
}
