package com.turquaz.inventory.ui;


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
 * @author onsel
 * @version $Id$
 */

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;
import java.io.*;
import java.util.regex.Matcher;
import com.turquaz.engine.ui.component.NumericText;
import com.turquaz.engine.ui.component.DecimalText;
import java.util.regex.Pattern;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class InvUICardAdd extends SecureComposite {

	private Text text5;
	private CLabel cLabel7;
	private Text cCombo2;
	private CLabel cLabel6;
	private Text cCombo1;
	private CLabel cLabel5;
	private DecimalText text4;
	private CLabel cLabel4;
	private NumericText text3;
	private CLabel cLabel3;
	private Text text2;
	private CLabel cLabel2;
	private Text text1;
	private CLabel cLabel1;
	public InvUICardAdd(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			cLabel1 = new CLabel(this,SWT.RIGHT);
			text1 = new Text(this,SWT.NULL);
			cLabel2 = new CLabel(this,SWT.RIGHT);
			text2 = new Text(this,SWT.NULL);
			cLabel3 = new CLabel(this,SWT.RIGHT);
			text3 = new NumericText(this,SWT.NULL);
			cLabel4 = new CLabel(this,SWT.RIGHT);
			text4 = new DecimalText(this,SWT.NULL);
			cLabel5 = new CLabel(this,SWT.RIGHT);
			cCombo1 = new Text(this,SWT.NULL);
			cLabel6 = new CLabel(this,SWT.RIGHT);
			cCombo2 = new Text(this,SWT.NULL);
			cLabel7 = new CLabel(this,SWT.RIGHT);
			text5 = new Text(this,SWT.MULTI| SWT.WRAP| SWT.H_SCROLL| SWT.V_SCROLL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(500,400));
			final Color InvUICardAddbackground = new Color(Display.getDefault(),128,128,255);
			this.setBackground(InvUICardAddbackground);
	
			GridData cLabel1LData = new GridData();
			cLabel1LData.verticalAlignment = GridData.CENTER;
			cLabel1LData.horizontalAlignment = GridData.FILL;
			cLabel1LData.widthHint = -1;
			cLabel1LData.heightHint = 15;
			cLabel1LData.horizontalIndent = 0;
			cLabel1LData.horizontalSpan = 1;
			cLabel1LData.verticalSpan = 1;
			cLabel1LData.grabExcessHorizontalSpace = false;
			cLabel1LData.grabExcessVerticalSpace = false;
			cLabel1.setLayoutData(cLabel1LData);
			cLabel1.setText("Stok Kodu");
			cLabel1.setSize(new org.eclipse.swt.graphics.Point(106,15));
	
			GridData text1LData = new GridData();
			text1LData.verticalAlignment = GridData.CENTER;
			text1LData.horizontalAlignment = GridData.FILL;
			text1LData.widthHint = -1;
			text1LData.heightHint = 20;
			text1LData.horizontalIndent = 0;
			text1LData.horizontalSpan = 1;
			text1LData.verticalSpan = 1;
			text1LData.grabExcessHorizontalSpace = true;
			text1LData.grabExcessVerticalSpace = false;
			text1.setLayoutData(text1LData);
			text1.setSize(new org.eclipse.swt.graphics.Point(368,20));
	
			GridData cLabel2LData = new GridData();
			cLabel2LData.verticalAlignment = GridData.CENTER;
			cLabel2LData.horizontalAlignment = GridData.FILL;
			cLabel2LData.widthHint = -1;
			cLabel2LData.heightHint = 15;
			cLabel2LData.horizontalIndent = 0;
			cLabel2LData.horizontalSpan = 1;
			cLabel2LData.verticalSpan = 1;
			cLabel2LData.grabExcessHorizontalSpace = false;
			cLabel2LData.grabExcessVerticalSpace = false;
			cLabel2.setLayoutData(cLabel2LData);
			cLabel2.setText("Stok Ad?");
			cLabel2.setSize(new org.eclipse.swt.graphics.Point(106,15));
	
			GridData text2LData = new GridData();
			text2LData.verticalAlignment = GridData.CENTER;
			text2LData.horizontalAlignment = GridData.FILL;
			text2LData.widthHint = -1;
			text2LData.heightHint = 15;
			text2LData.horizontalIndent = 0;
			text2LData.horizontalSpan = 1;
			text2LData.verticalSpan = 1;
			text2LData.grabExcessHorizontalSpace = false;
			text2LData.grabExcessVerticalSpace = false;
			text2.setLayoutData(text2LData);
			text2.setSize(new org.eclipse.swt.graphics.Point(368,15));
	
			GridData cLabel3LData = new GridData();
			cLabel3LData.verticalAlignment = GridData.CENTER;
			cLabel3LData.horizontalAlignment = GridData.FILL;
			cLabel3LData.widthHint = -1;
			cLabel3LData.heightHint = 15;
			cLabel3LData.horizontalIndent = 0;
			cLabel3LData.horizontalSpan = 1;
			cLabel3LData.verticalSpan = 1;
			cLabel3LData.grabExcessHorizontalSpace = false;
			cLabel3LData.grabExcessVerticalSpace = false;
			cLabel3.setLayoutData(cLabel3LData);
			cLabel3.setText("Stok Minimum Miktar");
			cLabel3.setSize(new org.eclipse.swt.graphics.Point(106,15));
	
			GridData text3LData = new GridData();
			text3LData.verticalAlignment = GridData.CENTER;
			text3LData.horizontalAlignment = GridData.FILL;
			text3LData.widthHint = -1;
			text3LData.heightHint = 20;
			text3LData.horizontalIndent = 0;
			text3LData.horizontalSpan = 1;
			text3LData.verticalSpan = 1;
			text3LData.grabExcessHorizontalSpace = false;
			text3LData.grabExcessVerticalSpace = false;
			text3.setLayoutData(text3LData);
			text3.setSize(new org.eclipse.swt.graphics.Point(368,20));
	
			GridData cLabel4LData = new GridData();
			cLabel4LData.verticalAlignment = GridData.CENTER;
			cLabel4LData.horizontalAlignment = GridData.FILL;
			cLabel4LData.widthHint = -1;
			cLabel4LData.heightHint = 15;
			cLabel4LData.horizontalIndent = 0;
			cLabel4LData.horizontalSpan = 1;
			cLabel4LData.verticalSpan = 1;
			cLabel4LData.grabExcessHorizontalSpace = false;
			cLabel4LData.grabExcessVerticalSpace = false;
			cLabel4.setLayoutData(cLabel4LData);
			cLabel4.setText("Stok Maximum Miktar");
			cLabel4.setSize(new org.eclipse.swt.graphics.Point(106,15));
	
			GridData text4LData = new GridData();
			text4LData.verticalAlignment = GridData.CENTER;
			text4LData.horizontalAlignment = GridData.FILL;
			text4LData.widthHint = -1;
			text4LData.heightHint = 20;
			text4LData.horizontalIndent = 0;
			text4LData.horizontalSpan = 1;
			text4LData.verticalSpan = 1;
			text4LData.grabExcessHorizontalSpace = false;
			text4LData.grabExcessVerticalSpace = false;
			text4.setLayoutData(text4LData);
			text4.setSize(new org.eclipse.swt.graphics.Point(368,20));
	
			GridData cLabel5LData = new GridData();
			cLabel5LData.verticalAlignment = GridData.CENTER;
			cLabel5LData.horizontalAlignment = GridData.FILL;
			cLabel5LData.widthHint = -1;
			cLabel5LData.heightHint = 15;
			cLabel5LData.horizontalIndent = 0;
			cLabel5LData.horizontalSpan = 1;
			cLabel5LData.verticalSpan = 1;
			cLabel5LData.grabExcessHorizontalSpace = false;
			cLabel5LData.grabExcessVerticalSpace = false;
			cLabel5.setLayoutData(cLabel5LData);
			cLabel5.setText("KDV yüzdesi");
			cLabel5.setSize(new org.eclipse.swt.graphics.Point(106,15));
	
			GridData cCombo1LData = new GridData();
			cCombo1LData.verticalAlignment = GridData.CENTER;
			cCombo1LData.horizontalAlignment = GridData.BEGINNING;
			cCombo1LData.widthHint = 54;
			cCombo1LData.heightHint = 20;
			cCombo1LData.horizontalIndent = 0;
			cCombo1LData.horizontalSpan = 1;
			cCombo1LData.verticalSpan = 1;
			cCombo1LData.grabExcessHorizontalSpace = false;
			cCombo1LData.grabExcessVerticalSpace = false;
			cCombo1.setLayoutData(cCombo1LData);
			cCombo1.setSize(new org.eclipse.swt.graphics.Point(54,20));
	
			GridData cLabel6LData = new GridData();
			cLabel6LData.verticalAlignment = GridData.CENTER;
			cLabel6LData.horizontalAlignment = GridData.FILL;
			cLabel6LData.widthHint = -1;
			cLabel6LData.heightHint = -1;
			cLabel6LData.horizontalIndent = 0;
			cLabel6LData.horizontalSpan = 1;
			cLabel6LData.verticalSpan = 1;
			cLabel6LData.grabExcessHorizontalSpace = false;
			cLabel6LData.grabExcessVerticalSpace = false;
			cLabel6.setLayoutData(cLabel6LData);
			cLabel6.setText("?ndirim Yüzdesi");
	
			GridData cCombo2LData = new GridData();
			cCombo2LData.verticalAlignment = GridData.CENTER;
			cCombo2LData.horizontalAlignment = GridData.BEGINNING;
			cCombo2LData.widthHint = 54;
			cCombo2LData.heightHint = 20;
			cCombo2LData.horizontalIndent = 0;
			cCombo2LData.horizontalSpan = 1;
			cCombo2LData.verticalSpan = 1;
			cCombo2LData.grabExcessHorizontalSpace = false;
			cCombo2LData.grabExcessVerticalSpace = false;
			cCombo2.setLayoutData(cCombo2LData);
			cCombo2.setSize(new org.eclipse.swt.graphics.Point(54,20));
	
			GridData cLabel7LData = new GridData();
			cLabel7LData.verticalAlignment = GridData.BEGINNING;
			cLabel7LData.horizontalAlignment = GridData.FILL;
			cLabel7LData.widthHint = -1;
			cLabel7LData.heightHint = 19;
			cLabel7LData.horizontalIndent = 0;
			cLabel7LData.horizontalSpan = 1;
			cLabel7LData.verticalSpan = 1;
			cLabel7LData.grabExcessHorizontalSpace = false;
			cLabel7LData.grabExcessVerticalSpace = false;
			cLabel7.setLayoutData(cLabel7LData);
			cLabel7.setText("Aç?klama");
			cLabel7.setSize(new org.eclipse.swt.graphics.Point(106,19));
	
			GridData text5LData = new GridData();
			text5LData.verticalAlignment = GridData.CENTER;
			text5LData.horizontalAlignment = GridData.FILL;
			text5LData.widthHint = -1;
			text5LData.heightHint = 60;
			text5LData.horizontalIndent = 0;
			text5LData.horizontalSpan = 1;
			text5LData.verticalSpan = 1;
			text5LData.grabExcessHorizontalSpace = false;
			text5LData.grabExcessVerticalSpace = false;
			text5.setLayoutData(text5LData);
			text5.setSize(new org.eclipse.swt.graphics.Point(351,60));
			GridLayout thisLayout = new GridLayout(2, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 10;
			thisLayout.numColumns = 2;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 10;
			thisLayout.verticalSpacing = 10;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					InvUICardAddbackground.dispose();
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		
		
	}
	public void save(){
		System.out.println("Save Button Pushed!");
		try{
		 // Open the file that is the first 
        // command line parameter
        FileInputStream fstream = new FileInputStream("sayi.txt");

        // Convert our input stream to a
        // DataInputStream
        DataInputStream in = new DataInputStream(fstream);

        // Continue to read lines while 
        // there are still some left to read
        int a =0;
        long total=0;
        while (in.available() !=0)
        {
          String s = in.readLine();
          try{
           a = Integer.parseInt(s);
           total+=a;
          }
          catch(Exception ex){
          	
          }
          
        }
        System.out.println(total);
        
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}
	public void delete(){
		System.out.println("Delete Button Pushed!");
	}
	public void newForm(){
		System.out.println("New Button Pushed!");
	}
	public void search(){
		System.out.println("Search Button Pushed!");
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			InvUICardAdd inst = new InvUICardAdd(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,500,400);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
