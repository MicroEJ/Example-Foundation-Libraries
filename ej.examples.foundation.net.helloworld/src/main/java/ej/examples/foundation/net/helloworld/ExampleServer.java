/*
 * Java
 *
 * Copyright 2014-2015 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.net.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This example open a client socket, send a "Hello World!" message to a server and close the connection.
 * The server read the client message and close the remote socket.
 */
public class ExampleServer implements HelloWorldConstants{

	/**
	 * Application logger.
	 */
	private static Logger Logger = java.util.logging.Logger.getLogger(ExampleServer.class.getSimpleName());

	/**
	 * Server main entry point.
	 */
	public static void main(String[] args) {
		// Display all messages.
		Logger.setLevel(Level.ALL);

		Logger.info("server initialization...");
		// initiate a structure to append characters sent by the client
		StringBuffer sb = new StringBuffer();
		ServerSocket serv = null;
		Socket client = null;
		InputStream is = null;
		try {
			// server initialization
			serv = new ServerSocket(PORT);
			Logger.info("server initialized. Waiting for connection..");
			// wait the client connection
			client = serv.accept();
			Logger.info("client connected.");
			// read client message and stop the server
			is = client.getInputStream();
			int readByte = -1;
			while((readByte = is.read()) != -1){
				sb.append((char)readByte);
			}
			Logger.info("client say \"" + sb.toString() + "\".");
		} catch (IOException e) {
			String errMsg = e.getMessage();
			if(errMsg == null){
				e.printStackTrace();
			}else{
				Logger.severe(errMsg);
			}
		} finally{
			// close the connection
			try{
				if(is != null){
					is.close();
				}
				if(client != null){
					client.close();
				}
				if(serv != null){
					serv.close();
				}
			} catch (IOException e) {}
			Logger.info("server stopped.");
		}
	}

}
