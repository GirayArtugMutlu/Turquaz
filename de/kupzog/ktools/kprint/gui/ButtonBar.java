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

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.events.*;
import java.util.*;

/**
 * Used by MsgBox.
 * 
 * @author Friederich Kupzog
 */
public class ButtonBar extends Composite
{
	private RowLayout myLayout;
	private ArrayList myButtons;
	private int myButtonWidth;

	/** Erzeugt neuen ButtonBar */
	public ButtonBar(Composite owner, int buttonWidth)
	{
		super(owner, SWT.NONE);
		myButtonWidth = buttonWidth;
		myLayout = new RowLayout();
		myLayout.justify = true;
		myLayout.type = SWT.HORIZONTAL;
		myLayout.wrap = true;
		myLayout.spacing = 4;
		this.setLayout(myLayout);
		myButtons = new ArrayList();
	}

	/**
	 * Fügt einen Button zur Leiste hinzu. Gibt eine Referenz auf den angelegten Button zurück.
	 */
	public Button addButton(String name, String toolTip, SelectionListener selListener)
	{
		Button b = new Button(this, SWT.PUSH);
		b.setText(name);
		b.setToolTipText(toolTip);
		b.setLayoutData(new RowData(myButtonWidth, 25));
		if (selListener != null)
			b.addSelectionListener(selListener);
		myButtons.add(b);
		return b;
	}

	/**
	 * Fügt einen Button zur Leiste hinzu, und registriert ihn bei der in myShell übergebenen Shell als DefaultButton.
	 */
	public Button addButton(String name, String toolTip, Shell myShell, SelectionListener selListener)
	{
		Button b = addButton(name, toolTip, selListener);
		myShell.setDefaultButton(b);
		return b;
	}
}