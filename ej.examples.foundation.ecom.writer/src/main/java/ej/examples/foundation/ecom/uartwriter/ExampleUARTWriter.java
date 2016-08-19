/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.ecom.uartwriter;

import java.io.OutputStream;

import ej.ecom.io.CommConnection;
import ej.examples.foundation.ecom.AbstractCommTest;

/**
 * This example repeatedly outputs the string {@link #OUTPUT_STRING} through a comm connection output stream.
 * By default, this example is configured to use the logical communication device 'com51' (see {@link #CONNECTION_STRING}).
 * Check the launch configuration to see how that is mapped onto the target.
 */
public class ExampleUARTWriter extends AbstractCommTest implements Runnable{

	/**
	 * Comm connection string: used to open the comm connection.
	 */
	public static final String CONNECTION_STRING = "comm:com42;baudrate=9600;bitsperchar=8;stopbits=1;parity=none";

	/**
	 * String to output throw the comm connection.
	 */
	private static final String OUTPUT_STRING 		= "Hello World !\n";

	/**
	 * Execution time in milliseconds: after this time the example closes the comm connection and returns.
	 */
	private static final int TIME_LIMIT				= 5000;

	/**
	 * Test's fields
	 */
	protected CommConnection connection;	// current comm connection
	protected OutputStream out;			// current comm connection's output stream

	/**
	 * Main entry point: creates the test and starts it
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		new ExampleUARTWriter().launch(CONNECTION_STRING);
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

		// 2- Try to open the output stream from the comm connection
		out = openOutputStream(connection);
		if (out == null) {
			// we should close the connection now.
			closeConnection(connection);
			return;
		}

		//3- Create and launch a thread which will use the output stream
		new Thread(this).start();
	}

	/**
	 * Print the message on the comm connection's output stream.
	 */
	@Override
	public void run() {

		byte[] msg = OUTPUT_STRING.getBytes();
		long time = System.currentTimeMillis();

		while(System.currentTimeMillis() - time <= TIME_LIMIT) {
			try {
				out.write(msg);
			} catch (Exception e) {
				showMessage("Cannot send any more bytes.", true);
				break;
			}

			try {
				out.flush();
			} catch (Exception e) {
				showMessage("Cannot flush bytes.", true);
				break;
			}
		}

		// we should close the output stream now.
		closeOutputStream(out);

		// we should close the connection now.
		closeConnection(connection);
	}
}
