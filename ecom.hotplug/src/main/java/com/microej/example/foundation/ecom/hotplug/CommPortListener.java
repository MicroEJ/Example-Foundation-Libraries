/*
 * Copyright 2016-2020 MicroEJ Corp. All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be found with this software.
 */
package com.microej.example.foundation.ecom.hotplug;

import java.util.HashMap;

import ej.ecom.Device;
import ej.ecom.RegistrationEvent;
import ej.ecom.RegistrationListener;
import ej.ecom.io.CommPort;

class CommPortListener implements RegistrationListener<CommPort>{

	/**
	 * When unregistered, {@link Device} descriptor may be no more available.
	 * Keep a cache of the registered CommPort name.
	 */
	private final HashMap<CommPort, String> deviceName = new HashMap<>();

	@Override
	public void deviceRegistered(RegistrationEvent<CommPort> event) {
		CommPort newCommPort = event.getDevice();
		System.out.println("=> New CommPort plugged:");
		String result = DeviceTools.toJSONString(newCommPort);
		if(result == null){
			// When entering here, the device has been unplugged during toString process.
			result = "\t"+Device.UNKNOWN_NAME;
		}
		else{
			deviceName.put(newCommPort, newCommPort.getName());
		}
		System.out.println(result);
	}

	@Override
	public void deviceUnregistered(RegistrationEvent<CommPort> event) {
		CommPort c = event.getDevice();
		String name = deviceName.get(c);
		deviceName.remove(c);
		System.out.println("=> CommPort unplugged: "+name);
	}

}