/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package ej.examples.foundation.ecom;

import java.io.InputStream;
import java.io.OutputStream;

import ej.ecom.io.CommConnection;
import ej.ecom.io.Connector;

/**
 * Comm Connection super class. Contains some methods to manage a CommConnection
 */
public class AbstractCommTest {

	/**
	 * Opens and returns a comm connection from the given connection string.
	 * @param connectionString the string which describes the comm connection to open.
	 * @return a comm connection according to the connection string or null
	 */
	public CommConnection openConnection(String connectionString){
		try{
			CommConnection comm = (CommConnection)Connector.open(connectionString);
			showMessage("Comm connection opened.", false);
			return comm;
		}
		catch(Exception e){
			e.printStackTrace();
			showMessage("Cannot open the comm connection.", true);
			return null;
		}
	}

	/**
	 * Opens and returns an input stream from the given comm connection.
	 * @param connection the comm connection.
	 * @return an input stream or null
	 */
	public InputStream openInputStream(CommConnection connection){
		try{
			InputStream is = connection.openInputStream();
			showMessage("Input stream opened", false);
			return is;
		}
		catch(Exception e){
			showMessage("Cannot open the input stream.", true);
			return null;
		}
	}

	/**
	 * Closes the given comm connection.
	 * @param connection the comm connection to close.
	 * @return true if the connection has been closed.
	 */
	public boolean closeConnection(CommConnection connection){
		try{
			connection.close();
			showMessage("Comm connection closed.", false);
			return true;
		}
		catch(Exception e){
			showMessage("Cannot close the comm connection.", true);
			return false;
		}
	}

	/**
	 * Closes the given input stream.
	 * @param out the input stream to close.
	 * @return true if the input stream has been closed.
	 */
	public boolean closeInputStream(InputStream in){
		try{
			in.close();
			showMessage("Input stream closed.", false);
			return true;
		}
		catch(Exception e){
			showMessage("Cannot close the input stream.", true);
			return false;
		}
	}

	/**
	 * Opens and returns an output stream from the given comm connection.
	 * @param connection the comm connection.
	 * @return an output stream or null
	 */
	public OutputStream openOutputStream(CommConnection connection){
		try{
			OutputStream os = connection.openOutputStream();
			showMessage("Output stream opened", false);
			return os;
		}
		catch(Exception e){
			showMessage("Cannot open the output stream.", true);
			return null;
		}
	}

	/**
	 * Closes the given output stream.
	 * @param out the output stream to close.
	 * @return true if the output stream has been closed.
	 */
	public boolean closeOutputStream(OutputStream out){
		try{
			out.close();
			showMessage("Output stream closed.", false);
			return true;
		}
		catch(Exception e){
			showMessage("Cannot close the output stream.", true);
			return false;
		}
	}

	/**
	 * Show a message on the Java print stream
	 * @param message the message to show
	 * @param isAnError true if there is an error.
	 */
	public void showMessage(String message, boolean isAnError){
		StringBuffer sb = new StringBuffer();

		if (isAnError) {
			sb.append("[ERR] ");
		} else {
			sb.append("[LOG] ");
		}

		if (message != null) {
			sb.append(message);
		}

		System.out.println(sb.toString());
	}
}
