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

public class DecimalText extends Composite {
 private Text text;

 public DecimalText(Composite arg0, int arg1) {
  super(arg0, SWT.NONE);
  text = new Text(this, arg1);
  text.setTextLimit(20);

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
 protected void text3VerifyText(VerifyEvent e){
 	char decimalSymbol =',';
 	int numberOfDecimals =2;
 	Text control = (Text)e.widget;
    String text = control.getText();
    e.doit = false;

    if (e.keyCode == SWT.BS || e.keyCode == SWT.DEL){
     e.doit = true;
     return;
    }

    String newText = text.substring(0, e.start) + e.text +
text.substring(e.end);

    if (newText.equals("")){
     e.doit = true;
     return;
    }

    Pattern realNumberPattern = Pattern.compile("-?[1-9]*[0-9]{1}([" +
decimalSymbol + "][0-9]+)?");
    Matcher matcher = realNumberPattern.matcher(newText);
    boolean valid = matcher.matches();

    e.doit = valid;

    if (newText.length() > 2){
     int pos = newText.indexOf('-');
     if (pos != -1 && newText.indexOf('-', pos + 1) != -1){
      e.doit = false;
      return;
     }
     if (newText.charAt(0) == '-' && newText.charAt(1) == '0' &&
       newText.charAt(2) != decimalSymbol){
      e.doit = false;
      return;
     }
     pos = newText.indexOf(decimalSymbol);
     if (pos != -1) {
      e.doit = true;
      if (newText.indexOf(decimalSymbol, pos + 1) != -1){
       e.doit = false;
       return;
      }

      if (newText.substring(pos + 1).length() > numberOfDecimals){
       e.doit = false;
       return;
      }
     }
    }
    else {
     if (newText.length() == 1 && newText.charAt(0) == '-'){
      e.doit = true;
     }
    }
   }
  
 public void setText(String txt){
  text.setText(txt);
 	
 }
 public String getText(){
 	return text.getText();
 }
 public void selectAll(){
 	text.selectAll();
 }
 public void setEditable(boolean arg0){
 	text.setEditable(arg0);
 }
 public boolean getEditable(){
 	return text.getEditable();
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