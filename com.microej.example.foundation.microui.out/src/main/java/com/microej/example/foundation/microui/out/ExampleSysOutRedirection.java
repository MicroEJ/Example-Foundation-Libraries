/**
 * Java
 *
 * Copyright 2009-2019 MicroEJ Corp. All rights reserved.
 *For demonstration purpose only.
 *MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.microui.out;

import java.io.IOException;

import ej.microui.MicroUI;

/**
 * Prints some traces on standard output stream, which has been
 * redirected to LCD display.
 * @see MicroEJ Launch [EXAMPLE sysoutRedirection ...], option
 * "Java output stream"
 */
public class ExampleSysOutRedirection {

	public static void main(String[] args) throws IOException {
		// Start MicroUI
		MicroUI.start();

		// Print some traces
		for(int i = 3; --i >= 0;) {
			printSomeTraces();
			printSeparatorLine();
		}

		// print too an exception
		printException();
	}

	private static void printSomeTraces() {
		System.out.println("MicroEJ at a glance");
		System.out.println();
		System.out.println("MicroEJ is the editor of the highly-scalable");
		System.out.println("MicroEJ solution to prototype, design,");
		System.out.println("test and deploy software to embedded");
		System.out.println("devices.");
		System.out.println();
		System.out.println("MicroEJ integrated prototyping technology");
		System.out.println("enables instant PC simulation of embedded");
		System.out.println("applications in the earliest stage of a");
		System.out.println("project, reducing the usually time-consuming");
		System.out.println("specification process, and engaging");
		System.out.println("Marketing and Development teams into a");
		System.out.println("collaborative work.");
	}

	private static void printException() {
		System.out.println("Print an exception:");
		System.out.println();
		new Exception().printStackTrace();
	}

	private static void printSeparatorLine() {
		System.out.println();
		System.out.println("-----------------------------------------------");
		System.out.println();
	}
}
