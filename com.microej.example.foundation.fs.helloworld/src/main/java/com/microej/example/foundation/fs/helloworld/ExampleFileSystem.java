/*
 * Java
 *
 * Copyright 2014-2019 MicroEJ Corp. All rights reserved.
 * For demonstration purpose only.
 * MicroEJ Corp. PROPRIETARY. Use is subject to license terms.
 */
package com.microej.example.foundation.fs.helloworld;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

/**
 * <p>Demonstrates some usage of file system actions such as directory creation,
 * file creation, file content writing, file deletion, ...</p>
 */
public class ExampleFileSystem {

	/**
	 * <p>
	 * Creates a an alphabetical folder hierarchy:
	 * </p>
	 * <ul>
	 * <li><code>rootName</code>
	 * <ul>
	 * <li>A</li>
	 * <li>B</li>
	 * <li>C</li>
	 * <li>...</li>
	 * <li>Z</li>
	 * </ul>
	 * </li>
	 * </ul>
	 *
	 * @param root
	 *            name of the root folder to create
	 * @throws IOException
	 *             if 'root' cannot be created
	 */
	public static void createAlphabeticalFolderHierarchy(File root) throws IOException {
		String rootName;
		try {
			rootName = root.getCanonicalPath();
		} catch (IOException e) {
			rootName = root.getAbsolutePath();
		}
		System.out.println("Creating folder hierarchy: "+rootName);

		if(root.exists()) {
			System.out.println("Delete root ("+root+")...");
			recursiveDeleteFolder(root);
		}

		if (!root.mkdirs()) {
			throw new IOException("Cannot create root");
		}

		System.out.println("for");
		for(char c = 'A'; c <= 'Z';c++) {
			File letterDir = new File(root, String.valueOf(c));
			if(!letterDir.mkdir()){
				System.out.println("Cannot create "+c+" folder");
			}
		}
	}


	/**
	 * <p>Recursively lists on standard output the folders and files of the given root.</p>
	 * @param root
	 */
	protected static void listFolders(File root) {
		listFolders(root, 0);
	}

	/**
	 * <p>Recursively lists on standard output the folders and files of the given root.</p>
	 * @param root
	 * @param level deep level for tabulation purpose
	 */
	protected static void listFolders(File root, int level) {
		boolean isDir = root.isDirectory();
		for(int i = level; --i >= 0; ) { System.out.print('\t'); }
		System.out.print('[');
		System.out.print( (isDir) ? "DIR" : "FILE");
		System.out.print("] ");
		System.out.println(root.getName());
		if(isDir) {
			File[] children = root.listFiles();
			int nChildren = children.length;
			if(nChildren > 0) {
				//non empty folder
				for(int i = nChildren; --i >= 0; ) {
					File child = children[i];
					listFolders(child, level+1);
				}
			}
		}
	}

	/**
	 * <p>Deletes the given resource, if this is a directory, deletes its children first.</p>
	 * @param resource the resource to recursively delete
	 */
	public static void recursiveDeleteFolder(File resource) {
		if(!resource.exists()) {
			return;
		}

		//file
		if(resource.isFile()) {
			if(resource.delete()){
				System.out.println(resource+" has been deleted");
			}else{
				System.out.println(resource+" cannot be deleted");
			}
			return;
		}

		//empty folder
		File[] children = resource.listFiles();
		if(children == null || children.length == 0) {
			if(resource.delete()){
				System.out.println(resource+" has been deleted");
			}else{
				System.out.println(resource+" cannot be deleted");
			}
			return;
		}

		//non empty folder
		for(int i = children.length; --i >= 0; ) {
			recursiveDeleteFolder(children[i]);
		}

		//the folder is now empty, delete it
		if(resource.delete()){
			System.out.println(resource+" has been deleted");
		}else{
			System.out.println(resource+" cannot be deleted");
		}
	}

	public static void main(String[] args) throws IOException {
		File root = new File("letters");
		createAlphabeticalFolderHierarchy(root);

		// create a file for each name listed here in the folder matching the
		// first letter of the name
		String[] names = new String[] { "Joe", "Michael", "John", "Bob",
		"William" };
		for (int i = names.length; --i >= 0;) {
			String name = names[i];
			char startLetter = Character.toUpperCase(name.charAt(0));
			StringBuffer pathToNameBuffer = new StringBuffer();
			// root/X/Xxx
			pathToNameBuffer.append(root).append(File.separator);
			pathToNameBuffer.append(startLetter).append(File.separator);
			pathToNameBuffer.append(name);
			File f = new File(pathToNameBuffer.toString());

			String fileName;
			try {
				fileName = f.getCanonicalPath();
			} catch (IOException e1) {
				// problem while retrieving canonical path... use the absolute one instead
				fileName = f.getAbsolutePath();
			}
			if (!f.exists()) {
				try {
					f.createNewFile();
					System.out.print(f.getAbsolutePath());
					System.out.println(" successfully created.");
				} catch (IOException e) {
					System.err.println("Error while creating file: " + fileName);
				}
			}

			OutputStream os = null;
			try {
				os = new FileOutputStream(f, true); // append mode
			} catch (IOException e) {
				System.err.println("Error while opening file output stream on: " +
						fileName);
			}

			Date date = new Date(System.currentTimeMillis());
			String content = date.toString();

			// each time this example is called, the current date is appended to the file
			if (os != null) {
				try {
					System.out.println("Writing content to " + fileName);
					System.out.println("\t-> content=" + content);
					// write current date into file
					os.write(content.getBytes());
					os.write('\n');
					os.close();
				} catch (IOException e) {
					System.err.println("Error while writing content into " + fileName);
				}
			}
		}

		listFolders(root);

		// comment to keep created files and folders
		recursiveDeleteFolder(root);
	}
}
