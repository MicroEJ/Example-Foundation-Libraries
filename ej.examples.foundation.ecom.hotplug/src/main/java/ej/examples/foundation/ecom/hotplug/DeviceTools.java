/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * IS2T PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package ej.examples.foundation.ecom.hotplug;

import ej.ecom.Device;
import ej.ecom.HardwareDescriptor;

/**
 * Utility class.
 */
public class DeviceTools {

	/**
	 * Dump the given {@link Device} descriptor to a JSON formatted String.
	 * @param c {@link Device} to dump
	 * @return null if {@link Device} has been unplugged and its descriptor is no more available.
	 */
	public static String toJSONString(Device c){
		String name = c.getName();
		HardwareDescriptor<Device> descriptor = c.getDescriptor();
		String descriptorName = descriptor.getName();
		String[] propertyNames = descriptor.getPropertyNames();
		String[] propertyValues = descriptor.getPropertyValues();
		if(name == Device.UNKNOWN_NAME){
			System.out.println("name unknown");
		}else if (descriptorName == Device.UNKNOWN_NAME){
			System.out.println("descriptor name unknown");
		}else if(propertyNames.length != propertyValues.length){
			System.out.println("wrong properties "+propertyNames.length+"!="+propertyValues.length);
		}
		if(
				name == Device.UNKNOWN_NAME ||
				descriptorName == Device.UNKNOWN_NAME ||
				propertyNames.length != propertyValues.length
				){
			// the device has been unplugged while taking a snapshot of its descriptor
			return null;
		}

		StringBuilder sb = new StringBuilder();
		String lineSep = System.getProperty("line.separator");
		sb.append('{').append(lineSep);
		sb.append('\t').append(toJSONString("name")).append(": ").append(toJSONString(name)).append(',').append(lineSep);
		sb.append('\t').append(toJSONString("descriptor")).append(": ").append('{').append(lineSep);
		sb.append("\t\t").append(toJSONString("name")).append(": ").append(toJSONString(descriptorName)).append(',').append(lineSep);
		sb.append("\t\t").append(toJSONString("properties")).append(": ").append('{').append(lineSep);
		int nbProperties = propertyNames.length;
		for(int i=-1; ++i<nbProperties;){
			String propertyName = propertyNames[i];
			String propertyValue = propertyValues[i];
			sb.append("\t\t\t").append(toJSONString(propertyName)).append(": ").append(toJSONString(propertyValue)).append(',').append(lineSep);
		}
		sb.append("\t\t").append('}').append(lineSep);
		sb.append('\t').append('}').append(lineSep);
		sb.append('}');
		return sb.toString();
	}

	private static String toJSONString(String s){
		return '"'+s+'"';
	}
}
