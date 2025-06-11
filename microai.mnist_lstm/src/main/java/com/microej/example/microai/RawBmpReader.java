/*
 * Copyright 2025 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.microai;

import java.io.IOException;
import java.io.InputStream;

/**
 * The RawBmpReader class converts a BMP file into a raw byte pixel array.
 */
public class RawBmpReader {

    private static final int HEADER_LENGTH = 14;
    private static final int DIB_HEADER_LENGTH = 40;

    byte[] pixels;
    int width;
    int height;
    int bitsPerPixel;
    public RawBmpReader(String imagePath) throws IOException {
        try (InputStream is = RawBmpReader.class.getResourceAsStream(imagePath)) {
            if (is == null) {
                throw new IOException("BMP file not found");
            }

            int bytesRead;
            // Read BMP Header
            byte[] header = new byte[HEADER_LENGTH];
            bytesRead = is.read(header, 0, HEADER_LENGTH);
            if (bytesRead != HEADER_LENGTH) {
                throw new UnsupportedOperationException("Cannot read BMP header");
            }
            byte[] dibHeader = new byte[DIB_HEADER_LENGTH];
            bytesRead = is.read(dibHeader, 0, DIB_HEADER_LENGTH);
            if (bytesRead != DIB_HEADER_LENGTH) {
                throw new UnsupportedOperationException("Cannot read BMP DIB header");
            }

            this.width = readIntLE(dibHeader, 4);
            this.height = readIntLE(dibHeader, 8);
            this.bitsPerPixel = readShortLE(dibHeader, 14);
            int dataOffset = readIntLE(header, 10);

            if (this.bitsPerPixel != 24) {
                throw new UnsupportedOperationException("Only 24-bit BMP supported");
            }

            // Skip to pixel data
            int skipBytes = dataOffset - HEADER_LENGTH - DIB_HEADER_LENGTH;
            if (skipBytes > 0) {
                long skippedBytes = is.skip(skipBytes);
                if (skippedBytes != skipBytes) {
                    throw new UnsupportedOperationException("Cannot skip header");
                }
            }

            // Round up to the next multiple of 32bit, see https://en.wikipedia.org/wiki/BMP_file_format#Pixel_storage
            int rowSize = ((bitsPerPixel * this.width + 31) / 32) * 4;
            byte[] row = new byte[rowSize];

            this.pixels = new byte[this.height * this.width];

            // BMP rows are reversed
            for (int y = this.height-1; y >= 0 ; y--) {
                is.read(row, 0, rowSize);
                for (int x = 0; x < this.width; x++) {
                    // read only one color value, as they are all the same
                    int pixelIndex = x * 3;
                    pixels[y*this.width + x] = row[pixelIndex];
                }
            }
        }
    }

    public byte[] getPixelData() {
        return this.pixels;
    }

    public void printPixelData() {
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                System.out.print(pixels[y*this.width + x] == 0 ? "-" : "*"); // NOSONAR use print for visual effects
            }
            System.out.println(); // NOSONAR use print for visual effects
        }
    }

    // Little-endian 4-byte int
    private static int readIntLE(byte[] b, int offset) {
        return (b[offset] & 0xFF) |
                ((b[offset + 1] & 0xFF) << 8) |
                ((b[offset + 2] & 0xFF) << 16) |
                ((b[offset + 3] & 0xFF) << 24);
    }

    // Little-endian 2-byte short
    private static int readShortLE(byte[] b, int offset) {
        return (b[offset] & 0xFF) | ((b[offset + 1] & 0xFF) << 8);
    }

}
