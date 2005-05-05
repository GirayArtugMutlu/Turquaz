package com.turquaz.engine;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group			    */
/*																		*/
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.       							*/
/* 																		*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of		*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the		*/
/* GNU General Public License for more details.         				*/
/************************************************************************/
/**
 * @author Huseyin Ergun
 * @version $Id$
 */

import java.io.File;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.ui.EngUIEntryFrame;
import java.net.*;

public class EngStartup {

	public static void addFile(String s) throws Exception {
		File f = new File(s);
		addFile(f);
	}//end method

	public static void addFile(File f) throws Exception {
		addURL(f.toURL());
	}//end method

	public static void addURL(URL u) throws Exception {
		URL urls[] = new URL[] { u };
		ClassLoader aCL = Thread.currentThread().getContextClassLoader();
		URLClassLoader aUrlCL = new URLClassLoader(urls, aCL);
		
		Thread.currentThread().setContextClassLoader(aUrlCL);
	}

	public static void addClasspath(String filename) {
		try {
			File file = new File(filename);
			File[] filelist = file.listFiles();

			for (int i = 0; i < filelist.length; i++) {
				if (!filelist[i].isDirectory()) {
					String name = filelist[i].getName();
					if (name.toLowerCase().endsWith(".jar")) {
						addFile(filelist[i]);
					}
				}
			}
		} catch (Exception ex) {
            EngBLLogger.log(EngStartup.class,ex);
		}
	}

	public static void main(String[] args) {

		addClasspath("lib");
		addClasspath("lib/windows");
		Display display = new Display();
		Shell shell = new Shell(display);
		EngUIEntryFrame inst = new EngUIEntryFrame(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setText(EngLangCommonKeys.STR_APPLICATION_NAME); //$NON-NLS-1$
		shell.setLayout(new FillLayout());
		shell.layout();
		if (size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}
}
