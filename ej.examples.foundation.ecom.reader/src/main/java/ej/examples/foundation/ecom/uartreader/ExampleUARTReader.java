/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package ej.examples.foundation.ecom.uartreader;

import java.io.InputStream;

import ej.ecom.io.CommConnection;
import ej.examples.foundation.ecom.AbstractCommTest;

/**
 * This example reads bytes from a comm port and redirect them on the standard Java output stream.
 * Sender has to send the character '\n' (Ctrl-J, 0x0A) to see the text.
 * By default, this example is configured to use the logical communication device 'com51' (see CONNECTION_STRING).
 * Check the launch configuration to see how that is mapped onto the target.
 */
public class ExampleUARTReader extends AbstractCommTest implements Runnable{

	/**
	 * Comm connection string: used to open the comm connection.
	 */
	private static final String CONNECTION_STRING = "comm:com42;baudrate=9600;bitsperchar=8;stopbits=1;parity=none";

	/**
	 * Execution time in milliseconds: at the next opportunity after this time the example closes the comm connection and returns.
	 */
	private static final int TIME_LIMIT				= 10000;

	/**
	 * Test's fields
	 */
	protected CommConnection connection;	// current comm connection
	protected InputStream in;				// current comm connection's input stream

	/**
	 * Main entry point: creates the test and starts it
	 */
	public static void main(String[] args) {
		new ExampleUARTReader().launch(CONNECTION_STRING);
	}

	/**
	 * Start the test
	 * @param connectionString the string used to open the comm connection
	 */
	private void launch(String connectionString) {

		// 1- Try to open the comm connection
		connection = openConnection(connectionString);

		if (connection == null) {
			return;
		}

		// 2- Try to open the input stream from the comm connection
		in = openInputStream(connection);
		if (in == null) {
			// we should close the connection now.
			closeConnection(connection);
			return;
		}

		//3- Create and launch a thread which will use the input stream
		new Thread(this).start();

		// 4- Check that execution doesn't take more than TIME_LIMIT ms
		long time = System.currentTimeMillis();
		while (System.currentTimeMillis() - time <= TIME_LIMIT) {
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				showMessage("Thread has been interrupted.", true);
			}
		}
		showMessage("Time limit has been reached, so we close the comm connection.", false);
		// we should close the input stream now.
		closeInputStream(in);
		// we should close the connection now.
		closeConnection(connection);
	}

	/**
	 * Print the message on the comm connection's input stream.
	 */
	@Override
	public void run() {
		while (true) {
			try {
				// Read a byte from the input stream.
				// If there is nothing to read, this method never returns.
				int ret = in.read();

				// print the received byte as a character.
				System.out.print((char) ret);

			} catch (Exception e) {
				showMessage("Cannot receive any more bytes.", true);
				break;
			}
		}
	}

}
