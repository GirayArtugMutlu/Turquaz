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
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.*;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

/**
 * A static data storage and a GUI dialog to change the data.
 * PDocument uses the settings of the static variables in PageSetup.
 * You can open a Dialog to changes these values by creating
 * a PageSetup and call the open() function.
 * 
 * @author Friederich Kupzog
 */
public class PageSetup 
extends KDialog
{
	protected Composite root;
	private Combo combFormat, cmbScalierung, cmbMargin;
	private Button butPortrait, butLandscape;
	
	public final static int MARGIN_SMALL = 0;
	public final static int MARGIN_MEDIUM = 1;
	public final static int MARGIN_HUGE = 2;
	public final static String[] formatNames = {"A3", "A4", "A5"};
	public final static String[] scalings = {"100%", "90%", "80%", "70%", "60%", "50%"};
	
	public static double paperHeight = 29.6; 
	public static double paperWidth = 20.6; 
	public static String format =  "A4";
	public static boolean portrait = true;
	public static int scaling = 100;
	public static int marginStyle = MARGIN_SMALL;
	
	
	public PageSetup(Shell parent) {
		super(parent, "Seite einrichten", IconSource.getImage("print"));
		createContents();
		
		setDialogImage(IconSource.getImage("SeiteEinrichten"));
		addButtonRight("OK","",true);
		addButtonRight("Abbrechen","");
		combFormat.setText(format);
	}
	
	public int getShellStyle() {
		return SWT.CLOSE | SWT.APPLICATION_MODAL;
	}

	
	protected void createContents() {
		guiMainArea.setLayout(new FillLayout());
		root = new Composite(guiMainArea, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.verticalSpacing = 10;
		gridLayout.numColumns = 2;
		root.setLayout(gridLayout);
		
		{
			final Label l = new Label(root, SWT.NONE);
			l.setText("Papierformat:");
			final GridData gridData_2 = new GridData();
			gridData_2.widthHint = 80;
			l.setLayoutData(gridData_2);
		}
		{
			combFormat = new Combo(root, SWT.BORDER|SWT.READ_ONLY);
			combFormat.setToolTipText("Bestimmt die Papiergröße. Diese muss mit der Druckereinstellung übereinstimmen.");
			for (int i = 0; i < formatNames.length; i++) {
				combFormat.add(formatNames[i]);
			}
			combFormat.setText(format);
	
			final GridData gridData_1 = new GridData(GridData.FILL_HORIZONTAL);
			gridData_1.widthHint = 180;
			combFormat.setLayoutData(gridData_1);
		}
		{
			final Label label = new Label(root, SWT.NONE);
			label.setText("Seitenränder:");
			label.setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		{
			cmbMargin = new Combo(root, SWT.READ_ONLY);
			cmbMargin.setToolTipText("Bestimmt die Breite der Ränder.");
			cmbMargin.add("Schmale Ränder");
			cmbMargin.add("Normale Ränder");
			cmbMargin.add("Breite Ränder");
			cmbMargin.select(marginStyle);
			cmbMargin.setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		{
			final Label label = new Label(root, SWT.NONE);
			final GridData gridData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
			gridData.horizontalSpan = 1;
			label.setLayoutData(gridData);
			label.setText("Ausrichtung:");
		}
		{
			butPortrait = new Button(root, SWT.RADIO);
			butPortrait.setToolTipText("Bestimmt, ob das Papier hochkant oder Breit bedruckt werden soll. \nDiese Einstellung muss mit der des Druckers übereinstimmen");
			butPortrait.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
			butPortrait.setText("Hochformat");
			butPortrait.setSelection(portrait);
		}
		{
			new Label(root, SWT.NONE);
		}
		{
			butLandscape = new Button(root, SWT.RADIO);
			butLandscape.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
			butLandscape.setText("Breitformat");
			butLandscape.setSelection(!portrait);
			butLandscape.setToolTipText("Bestimmt, ob das Papier hochkant oder quer bedruckt werden soll. \nDiese Einstellung muss mit der des Druckers übereinstimmen");
		}
		{
			final Label label = new Label(root, SWT.NONE);
			label.setText("Skalierung:");
			label.setLayoutData(new GridData(GridData.FILL_BOTH));
		}
		{
			cmbScalierung = new Combo(root, SWT.READ_ONLY);
			cmbScalierung.setItems(scalings);
			cmbScalierung.select(10-(scaling/10));
			cmbScalierung.setLayoutData(new GridData(GridData.FILL_BOTH));
			cmbScalierung.setToolTipText("Hiermit können Sie dir Größe des Ausdrucks veringern, so daß mehr auf eine Seite passt.");
		}
		
	}
	
	/* 
	 * overridden from superclass
	 */
	protected void onButton(Button button, String buttonText) {
		if (buttonText.equals("OK"))
		{
			saveSettings();
		}
		close();
	}

	protected void saveSettings()
	{
		format = combFormat.getText();
		scaling = 100-10*(cmbScalierung.getSelectionIndex());
		marginStyle = cmbMargin.getSelectionIndex();
			
		portrait = butPortrait.getSelection();
			
		if (portrait)
		{
			paperHeight = getPaperHeightInCm(format);
			paperWidth = getPaperWidthInCm(format);
		}
		else
		{
			paperWidth = getPaperHeightInCm(format);
			paperHeight = getPaperWidthInCm(format);
		}

	}

	public static double getPaperHeightInCm(String formatName)
	{
		if (formatName.equals("A5"))
		{
			return 20.8;
		}
		else if (formatName.equals("A4"))
		{
			return 29.6;
		}
		else if (formatName.equals("A3"))
		{
			return 41.6;
		}
		return 1.0;
	}
	
	public static double getPaperWidthInCm(String formatName)
	{
		if (formatName.equals("A5"))
		{
			return 14.8;
		}
		else if (formatName.equals("A4"))
		{
			return 20.6;
		}
		else if (formatName.equals("A3"))
		{
			return 29.6;
		}
		return 1.0;
	}
	


}
