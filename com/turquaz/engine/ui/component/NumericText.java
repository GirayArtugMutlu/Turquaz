/*************************************************************************	**********/
/* TURQUAZ: Higly Modular Accounting/ERP Program              		*/
/* ============================================     		*/
/* Copyright (c) 2004 by Turquaz Software Development Group		*/
/*									*/
/* This program is free software. You can redistribute it and/or modify	*/
/* it under the terms of the GNU General Public License as published by	*/
/* the Free Software Foundation; either version 2 of the License, or	*/
/* (at your option) any later version.       			  		*/
/* 									*/
/* This program is distributed in the hope that it will be useful,		*/
/* but WITHOUT ANY WARRANTY; without even the implied warranty of	*/
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE	*/
/* See the GNU General Public License for more details.         		*/
/************************************************************************************/


/**
 * @author onsel
 * @version $Id$
 */
package com.turquaz.engine.ui.component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class NumericText extends Composite {
 private Text text;

 public NumericText(Composite arg0, int arg1) {
  super(arg0, SWT.NONE);
  text = new Text(this, arg1);

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
  
  text.addVerifyListener(new VerifyListener() {
	public void verifyText(VerifyEvent evt) {
		text3VerifyText(evt);
	}
});

 }
 protected void text3VerifyText(VerifyEvent evt){
    Pattern pattern = Pattern.compile("[0-9]*");

       Matcher m = pattern.matcher(evt.text);

       // ONLY NUMERICAL VALUES ARE ACCEPTED    .

       if (!m.matches()) {

           evt.doit = false;

       }
	}

 public Point computeSize(int wHint, int hHint,boolean arg) {
 	return text.computeSize(wHint, hHint, arg);
 }

 public Rectangle computeTrim(int x, int y, int width, int height) {
  return text.computeTrim(x, y, width, height);
 }

 void onResize() {
  Rectangle area = getClientArea();
  text.setBounds(0, 0, area.width, area.height);
 }

 void onFocusIn() {
  text.setFocus();
 }



}