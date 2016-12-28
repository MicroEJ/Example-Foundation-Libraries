/**
 * Java
 *
 * Copyright 2010-2012 IS2T. All rights reserved.
 * 
 * Use of this source code is subject to license terms.
 */
package com.microej.example.foundation.nls.helloworld;

import ej.microui.MicroUI;
import ej.microui.display.Colors;
import ej.microui.display.Display;
import ej.microui.display.ExplicitFlush;
import ej.microui.display.Font;
import ej.microui.display.GraphicsContext;
import ej.nls.BasicImmutablesNLS;
import ej.nls.NLS;

/**
 * Internationalization demo.
 * Shows how to refer to an input nls file, browse the different locales and
 * display a message into the available languages.
 */
public class ExampleNLS {

	public static void main(String[] args) {
		//initialize the drawing system
		initialize();

		//create new NLS for the header "helloworld"
		NLS nls = new BasicImmutablesNLS("helloworld");

		//list all available locales
		String[] locales = nls.getAvailableLocales();
		int localesLength = locales.length;
		print("Available locales:", true);
		for (int i = -1; ++i < localesLength;) {
			print("- " + locales[i], false);
		}

		//print the messages for each locale
		print("Saying:", true);
		for (int i = -1; ++i < localesLength;) {
			nls.setCurrentLocale(locales[i]);
			print("- " + nls.getMessage(HelloWorld.HELLO_WORLD) + " in " + nls.getDisplayName(nls.getCurrentLocale()) + " (" + locales[i] + ")", false);
		}
	}

	//drawings
	private static Display display;
	private static int displayWidth;
	private static int displayHeight;
	private static GraphicsContext g;
	private static int x;
	private static int y;
	private static Font defaultFont;
	private static int lineHeight;
	private static int columnWidth;

	private static void initialize() {
		// initialize graphics
		MicroUI.start();
		display = Display.getDefaultDisplay();
		if (display != null) {
			displayWidth = display.getWidth();
			displayHeight = display.getHeight();

			// Draw background
			ExplicitFlush explicitFlush = display.getNewExplicitFlush();
			explicitFlush.setColor(Colors.WHITE);
			explicitFlush.fillRect(0, 0, displayWidth, displayHeight);
			explicitFlush.flush();

			// Set
			g = display.getNewGraphicsContext();
			defaultFont = Font.getDefaultFont();
			lineHeight = defaultFont.getHeight()+10;
			g.setColor(Colors.BLACK);
			columnWidth = 0;
		}
	}

	private static void print(String string, boolean title) {
		System.out.println(string);

		if (display != null) {
			g.setFont(Font.getFont(Font.HAN, 16, title ? Font.STYLE_BOLD : Font.STYLE_PLAIN));
			//print one line
			if(y + lineHeight > displayHeight) {
				x += columnWidth;
				y = 0;
			}
			g.drawString(string, x, y, GraphicsContext.LEFT | GraphicsContext.TOP);
			y += lineHeight;
			int sw = defaultFont.stringWidth(string);
			if(sw > columnWidth) {
				columnWidth = sw;
			}
		}
	}

}
