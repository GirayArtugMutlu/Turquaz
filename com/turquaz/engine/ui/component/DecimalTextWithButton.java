package com.turquaz.engine.ui.component;

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
* @author  Onsel Armagan
* @version  $Id$
*/
import java.math.BigDecimal;
import com.cloudgarden.resource.SWTResourceManager;


import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.SWT;

/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class DecimalTextWithButton extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}


	private Button button1;
	private CurrencyText text1;
	private Object data; 
	public DecimalTextWithButton(Composite parent, int style) {
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
	
			text1 = new CurrencyText(this,SWT.NULL);
			button1 = new Button(this,SWT.PUSH| SWT.CENTER);
	
			this.setSize(296, 19);
			this.setEnabled(true);
	
			GridData text1LData = new GridData();
			text1.setBackground(SWTResourceManager.getColor(255, 255, 255));
			
			text1LData.verticalAlignment = GridData.FILL;
			text1LData.horizontalAlignment = GridData.FILL;
			text1LData.widthHint = -1;
			text1LData.heightHint = -1;
			text1LData.horizontalIndent = 0;
			text1LData.horizontalSpan = 1;
			text1LData.verticalSpan = 1;
			text1LData.grabExcessHorizontalSpace = true;
			text1LData.grabExcessVerticalSpace = true;
			text1.setLayoutData(text1LData);
			text1.setSize(new org.eclipse.swt.graphics.Point(240,32));

			GridData button1LData = new GridData();
			button1LData.verticalAlignment = GridData.FILL;
			button1LData.horizontalAlignment = GridData.BEGINNING;
			button1LData.widthHint = 28;
			button1LData.heightHint = -1;
			button1LData.horizontalIndent = 0;
			button1LData.horizontalSpan = 1;
			button1LData.verticalSpan = 1;
			button1LData.grabExcessHorizontalSpace = false;
			button1LData.grabExcessVerticalSpace = false;
			button1.setLayoutData(button1LData);
			button1.setText("...");
			button1.setSize(new org.eclipse.swt.graphics.Point(28,32));
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
			addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
				}
			});
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Add your pre-init code in here 	*/
	public void preInitGUI(){
		
		  addListener(SWT.Resize, new Listener() {
		    public void handleEvent(Event e) {
		     onResize();
		    }
		   });

		   addListener(SWT.FocusIn, new Listener() {
		    public void handleEvent(Event e) {
		     onFocusIn();
		    }
		   });
		 
		
	}
	
	
	public void setData(Object obj){
		data =obj;
	}
	public Object getData(){
		return data;
	}
    
	public void addMouseListener(MouseAdapter adapter){
		button1.addMouseListener(adapter);
		
	}
	
	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		
		
		
	}
	 void onResize() {
	 	  Rectangle area = getClientArea();
	 	  this.setBounds(0, 0, area.width, area.height);
	 	 }

	void onFocusIn() {
	  text1.setFocus();
	 }
 
	void onMouseUp(){

	}
	
	public void setText(String txt){
		  text1.setText(txt);
		 	
		 }
		 public void setBackground(Color c){
		 	text1.setBackground(c);
		 }
		 public Color getBackground(){
		 	return text1.getBackground();
		 }
		 public String getText(){
		 	return text1.getText();
		 }
		 public void selectAll(){
		 	text1.selectAll();
		 }
		 public void setEditable(boolean arg0){
		 	text1.setEditable(arg0);
		 }
		 public boolean getEditable(){
		 	return text1.getEditable();
		 }
		 
		 public BigDecimal getBigDecimalValue(){
		 	
		 	return this.text1.getBigDecimalValue();
		 	
		 	
		 }
	
}
