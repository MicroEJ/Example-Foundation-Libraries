/*
 * Java
 *
 * Copyright 2011-2016 IS2T. All rights reserved.
 * 
 * Use of this source code is governed by a BSD-style license that can be found at http://www.is2t.com/open-source-bsd-license/.
 */
package ej.examples.foundation.mwt.helloworld;

import ej.microui.MicroUI;
import ej.mwt.Desktop;
import ej.mwt.Panel;

public class ExampleHelloWorld {

	public static void main(String[] args) {
		// Start MicroUI
		MicroUI.start();

		// create the desktop
		Desktop desktop = new Desktop();

		// create the panel
		Panel panel = new Panel();

		// create the widget and link it to the panel
		Label label = new Label();
		label.setText("Hello World !");
		panel.setWidget(label);

		// show panel
		panel.show(desktop);
		// show desktop
		desktop.show();
	}

}
