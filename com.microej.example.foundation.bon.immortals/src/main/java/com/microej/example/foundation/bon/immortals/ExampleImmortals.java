/*
 * Java
 *
 * Copyright 2016-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.bon.immortals;

import ej.bon.Immortals;

/**
 * How to create Immortal objects (not managed by GC and always at the same physical memory location).
 * Show the heap and immortal heap usage.
 */
public class ExampleImmortals {

	public static final int DEPTH = 50;

	public static Object O1;
	public static Object O2;

	static {
		O1 = new Object();
		Immortals.setImmortal(O1);
		O2 = new Object();
	}

	public static void main(String[] args) {
		System.out.println("O1 is" + (Immortals.isImmortal(O1) ? "" : " not") + " immortal");
		System.out.println("O2 is" + (Immortals.isImmortal(O2) ? "" : " not") + " immortal");

		Runtime runtime = Runtime.getRuntime();
		printHeaps(runtime);

		System.out.println("Creates a simple object");
		Object o = new Object();
		printHeaps(runtime);

		System.out.println("Turns this object into immortal");
		o = Immortals.setImmortal(o);
		printHeaps(runtime);

		System.out.println("Creates the linked object root");
		LinkedObject linkedObject = new LinkedObject(-1, null);
		printHeaps(runtime);

		System.out.println("Turns it into immortal");
		linkedObject = (LinkedObject) Immortals.setImmortal(linkedObject);
		printHeaps(runtime);

		System.out.println("Creates " + DEPTH + " more linked objects");
		for(int i = -1; ++i < DEPTH;) {
			linkedObject = new LinkedObject(i, linkedObject);
		}
		printHeaps(runtime);

		System.out.println("Turns them recursively into immortals");
		//linkedObject -> previous -> ... -> root
		Immortals.deepImmortal(linkedObject);
		printHeaps(runtime);

	}

	public static void printHeaps(Runtime runtime) {
		System.gc();
		long heapSize = runtime.totalMemory();
		long heapUsage = heapSize - runtime.freeMemory();
		long immortalsSize = Immortals.totalMemory();
		long immortalsUsage = immortalsSize - Immortals.freeMemory();
		System.out.println("Heap usage:\n\t" + heapUsage + " / " + heapSize + " bytes");
		System.out.println("Immortal heap usage:\n\t" + immortalsUsage + " / " + immortalsSize + " bytes");
		System.out.println();
	}

}

class LinkedObject {
	private final int id;
	private final LinkedObject previous;
	public LinkedObject(int id, LinkedObject previous) {
		super();
		this.id = id;
		this.previous = previous;
	}

	public int getID() {
		return id;
	}

	public LinkedObject getPrevious() {
		return previous;
	}
}
