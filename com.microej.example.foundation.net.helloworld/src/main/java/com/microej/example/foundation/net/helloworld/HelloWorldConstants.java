/*
 * Java
 *
 * Copyright 2014-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.net.helloworld;

/**
 * NetHelloWorld example settings
 */
public interface HelloWorldConstants {

	public static final String UNKNOWN_HOST = "x.x.x.x";

	/**
	 * Remote host address
	 */
	public static final String HOST = UNKNOWN_HOST;

	/**
	 * Remote host port
	 */
	public static final int PORT = 12345;

	/**
	 * Message sent by the client
	 */
	public static final String HELLO_WORLD_CLIENT_MSG = "Hello World!";

	/**
	 * Message sent by the remote host
	 */
	public static final String HELLO_WORLD_HOST_MSG = "Hello";

}
