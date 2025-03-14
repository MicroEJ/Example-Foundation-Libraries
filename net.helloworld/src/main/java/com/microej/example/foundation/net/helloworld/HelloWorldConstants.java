/*
 * Copyright 2014-2025 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
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
	public static final int PORT = 1234;

	/**
	 * Message sent by the client
	 */
	public static final String HELLO_WORLD_CLIENT_MSG = "Hello World!";

	/**
	 * Message sent by the remote host
	 */
	public static final String HELLO_WORLD_HOST_MSG = "Hello";

}
