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
import com.cloudgarden.resource.SWTResourceManager;
import com.turquaz.engine.EngConfiguration;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;
import org.vafada.swtcalendar.SWTCalendarEvent;
import org.vafada.swtcalendar.SWTCalendarListener;

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
public class DatePicker extends org.eclipse.swt.widgets.Composite {

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}


	public final  static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	Calendar calendar = Calendar.getInstance();
	private Button button1;
	private Text text1;
	DateMask dateMask = new DateMask();
	public DatePicker(Composite parent, int style) {
		super(parent, style);
	
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
		    dateMask.setMask("##/##/####");
			preInitGUI();

			this.setSize(282, 27);
			this.setEnabled(true);

			
			GridLayout thisLayout = new GridLayout(4, true);
			this.setLayout(thisLayout);
			{
				text1 = new Text(this, SWT.READ_ONLY);
				text1.setSize(new org.eclipse.swt.graphics.Point(244, 35));
				GridData text1LData = new GridData();
                text1.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent evt) {
                        dateMask.textMaskGeneric(evt);
                    }
                });
                text1.addFocusListener(new FocusAdapter() {
                    public void focusLost(FocusEvent evt) {
                        try {
                            Date d = DatePicker.formatter
                                .parse(text1.getText());
                            text1.setText(DatePicker.formatter.format(d));
                            setDate(d);

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
				text1.setBackground(SWTResourceManager.getColor(255, 255, 255));
				text1LData.verticalAlignment = GridData.FILL;
				text1LData.horizontalAlignment = GridData.FILL;
				text1LData.grabExcessHorizontalSpace = true;
				text1LData.grabExcessVerticalSpace = true;
				text1.setLayoutData(text1LData);
			}
			{
				button1 = new Button(this, SWT.PUSH | SWT.BORDER);
				button1.setImage(SWTResourceManager.getImage("icons/day_obj.gif"));
				GridData button1LData = new GridData();
				button1.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						button1MouseUp(evt);
					}
				});
				button1LData.verticalAlignment = GridData.FILL;
				button1LData.widthHint = 37;
				button1.setLayoutData(button1LData);
			}
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.numColumns = 4;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 0;
			thisLayout.verticalSpacing = 0;
			this.layout();
		
	
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
	
		setDate(EngConfiguration.getCurrentDate());
		
	}
	
	public Date getDate(){
	    try{
	    Date d = DatePicker.formatter.parse(text1.getText());
	    return d;
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	        return null;
	    }
		
	}
	
	public void setDate(Date date){
		text1.setText(formatter.format(date));
		this.setData(date);	
	}
	 
	/** Auto-generated event handler method */
	protected void button1MouseUp(MouseEvent evt){
		final SWTCalendarDialog cal = new SWTCalendarDialog(this.getDisplay());
	
		 
         final Composite comp = this;
          cal.addDateChangedListener(new SWTCalendarListener() {
              public void dateChanged(SWTCalendarEvent calendarEvent) {
                  text1.setText(formatter.format(calendarEvent.getCalendar().getTime()));
                  comp.setData(calendarEvent.getCalendar().getTime());
             
              }
          });

          if (text1.getText() != null && text1.getText().length() > 0) {
              try {
                  Date d = formatter.parse(text1.getText());
                  cal.setDate(d);
              } catch (ParseException pe) {

              }
          }
          cal.open();
          }
	
	public Object getData(){
	    return getDate();
	}
	
	public static Date getFirstDayOfYear()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),0,1);
	    return cal.getTime();
	}
	public static Date getLastDayOfYear()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR),11,31);
	    return cal.getTime();
	}
	
	public void setFirstDayOfYear(){

		calendar.set(calendar.get(Calendar.YEAR),0,1);
		setDate(calendar.getTime());
	
	}
	
	public void setLastDayOfYear(){
		
		calendar.set(calendar.get(Calendar.YEAR),11,31);
		setDate(calendar.getTime());
		
		
	}
}
