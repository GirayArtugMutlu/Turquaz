/*  Copyright (C) 2004 by Friederich Kupzog Elektronik & Software
 
 This library is free software; you can redistribute it and/or
 modify it under the terms of the GNU Lesser General Public
 License as published by the Free Software Foundation; either
 version 2.1 of the License, or (at your option) any later version.

 This library is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 Lesser General Public License for more details.

 You should have received a copy of the GNU Lesser General Public
 License along with this library; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 
 Author: Friederich Kupzog  
 fkmk@kupzog.de
 www.kupzog.de/fkmk
 */
package de.kupzog.ktools.kprint.gui;

import java.util.StringTokenizer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.*;

/**
 * A Message Box class used to display messages.
 * 
 * @author Friederich Kupzog
 */
public class MsgBox
{
	/**
	 * 
	 */
	private Display d;
	private Shell s;
	private Label bild, meldung;
	private Control additionalControl;
	public boolean ende;
	/**
	 * Der Text des Buttons, der vom Benutzer betätigt wurde
	 */
	public String pressedButton;

	public MsgBox(Display d, String title, String message, String buttons)
	{
		this.d = d;
		this.s = new Shell(d, SWT.TITLE | SWT.APPLICATION_MODAL | SWT.RESIZE | SWT.MAX);
		this.s.setText(title);
		additionalControl = null;
		ende = false;
		FormLayout fl = new FormLayout();
		this.s.setLayout(fl);
		bild = new Label(this.s, SWT.LEFT);
		bild.setImage(IconSource.getImage("MsgBox"));
		bild.setBackground(d.getSystemColor(SWT.COLOR_WHITE));
		FormData f = new FormData();
		f.top = new FormAttachment(0, 0);
		f.left = new FormAttachment(0, 0);
		f.bottom = new FormAttachment(100, 0);
		bild.setLayoutData(f);
		Label separator = new Label(this.s, SWT.SEPARATOR);
		f = new FormData();
		f.top = new FormAttachment(0, 0);
		f.left = new FormAttachment(bild, 0);
		f.bottom = new FormAttachment(100, 0);
		separator.setLayoutData(f);
		meldung = new Label(s, SWT.LEFT | SWT.WRAP);
		meldung.setText(message);
		f = new FormData();
		f.top = new FormAttachment(0, 25);
		f.left = new FormAttachment(bild, 25);
		f.right = new FormAttachment(100, -25);
		f.bottom = new FormAttachment(100, -55);
		meldung.setLayoutData(f);
		ButtonBar butBar = new ButtonBar(s, 80);
		StringTokenizer t = new StringTokenizer(buttons, ",");
		boolean first = true;
		while (t.hasMoreTokens())
		{
			Button but = butBar.addButton(t.nextToken(), "", new SelectionAdapter()
			{
				public void widgetSelected(SelectionEvent e)
				{
					pressedButton = ((Button) e.getSource()).getText();
					ende = true;
				}
			});
			if (first)
			{
				first = false;
				s.setDefaultButton(but);
			}
		}
		f = new FormData();
		f.bottom = new FormAttachment(100, -4);
		f.left = new FormAttachment(bild, 15);
		f.right = new FormAttachment(100, -15);
		butBar.setLayoutData(f);
	}

	/**
	 * Erlaubt das Hinzufügen weiterer Steuerelemente zur MsgBox. Diese werden unter dem Text und über der Buttonleiste engezeigt.
	 * Benutzung: MsgBox box = new MsgBox(display,"Box","Beispiel","OK"); Text feld = new Text(box.getShell(),SWT.BORDER);
	 * box.addControl(feld); box.open(); (hier Zugriff auf feld) box.dispose();
	 * 
	 * @param c
	 *             das anzuzeigende Control.
	 */
	public void addControl(Control c)
	{
		// Meldung neu abstützen
		FormData f = new FormData();
		f.top = new FormAttachment(0, 25);
		f.left = new FormAttachment(bild, 25);
		f.right = new FormAttachment(100, -25);
		//f.bottom = new FormAttachment(100,-55);
		meldung.setLayoutData(f);
		// Neues Control layouten
		f = new FormData();
		f.top = new FormAttachment(meldung, 5);
		f.left = new FormAttachment(bild, 25);
		f.right = new FormAttachment(100, -25);
		f.bottom = new FormAttachment(100, -55);
		c.setLayoutData(f);
		additionalControl = c;
	}

	public void setImage(Image newImg)
	{
		bild.setImage(newImg);
	}

	/**
	 * Gibt die Shell der MsgBox zurück.
	 * 
	 * @return Shell
	 */
	public Shell getShell()
	{
		return s;
	}

	/**
	 * Zeigt die MsgBox an.
	 */
	public void open()
	{
		s.pack();
		s.setLocation((d.getBounds().width - s.getBounds().width) / 2, (d.getBounds().height - s.getBounds().height) / 2);
		s.open();
		if (additionalControl != null)
			additionalControl.setFocus();
		while (!ende)
		{
			if (!d.readAndDispatch())
				d.sleep();
		}
	}

	/**
	 * Muss nach box.open() aufgerufen werden!
	 */
	public void dispose()
	{
		s.close();
		s.dispose();
	}

	/**
	 * Baut eine fertige MsgBox auf und zeigt diese an.
	 * 
	 * @param d
	 * @param title
	 * @param message
	 * @param buttons
	 * @return String
	 */
	public static String show(Display d, String title, String message, String buttons)
	{
		MsgBox box = new MsgBox(d, title, message, buttons);
		box.open();
		box.dispose();
		return box.pressedButton;
	}

	/**
	 * Baut eine fertige MsgBox auf und zeigt diese an
	 * 
	 * @param d
	 * @param message
	 * @return String
	 */
	public static String show(Display d, String message)
	{
		return show(d, "Meldung", message, "OK");
	}

	public static String show(String title, String message, String buttons)
	{
		MsgBox box = new MsgBox(Display.getCurrent(), title, message, buttons);
		box.open();
		box.dispose();
		return box.pressedButton;
	}

	public static String show(String message)
	{
		return show("Meldung", message, "OK");
	}
}