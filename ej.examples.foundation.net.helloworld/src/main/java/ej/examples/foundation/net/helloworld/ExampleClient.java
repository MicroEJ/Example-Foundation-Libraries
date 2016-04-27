/*
 * Java
 *
 * Copyright 2014-2015 IS2T. All rights reserved.
 * For demonstration purpose only.
 * IS2T PROPRIETARY. Use is subject to license terms.
 */
package ej.examples.foundation.net.helloworld;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This example open a client socket, send a "Hello World!" message to a server and close the connection.
 * The server read the client message and close the remote socket.
 */
public class ExampleClient implements HelloWorldConstants{

	/**
	 * Application logger.
	 */
	private static Logger Logger = java.util.logging.Logger.getLogger(ExampleClient.class.getSimpleName());

	/**
	 * Client main entry point.
	 * Open a remote connection on {@link HelloWorldConstants#HOST}:{@link HelloWorldConstants#PORT},
	 * send a {@link HelloWorldConstants#HELLO_WORLD_MSG} message to the remote host, and close the connection.
	 */
	public static void main(String[] args) {
		// Display all messages.
		Logger.setLevel(Level.ALL);

		Socket s = null;
		OutputStream os = null;
		try {
			if(HOST.equals(UNKNOWN_HOST)){
				Logger.severe("Please set the HOST address (" + HOST + " is not a valid host address)");
				return;
			}

			Logger.info("trying to connect to " + HOST + ":" + PORT + "...");
			// connect to the remote host
			s = new Socket(HOST, PORT);
			Logger.info("client connected to the remote host.");
			// write message to the remote host
			os = s.getOutputStream();
			os.write(HELLO_WORLD_CLIENT_MSG.getBytes());
			Logger.info("\"" + HELLO_WORLD_CLIENT_MSG + "\" message sent.");
		} catch (IOException e) {
			String errMsg = e.getMessage();
			if(errMsg == null){
				e.printStackTrace();
			}else{
				Logger.severe(errMsg);
			}
		}finally{
			// close the connection
			try{
				if(os != null){
					os.close();
				}
				if(s != null){
					s.close();
				}
			} catch (IOException e) {}
			Logger.info("remote connection closed.");
		}
	}

}
