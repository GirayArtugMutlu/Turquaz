
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

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;



public class TComboBox extends Composite{
	private CCombo combo;

	 public TComboBox(Composite c, int style){
	 	super(c,style);
	 	combo = new CCombo(this,style);
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

	 public Point computeSize(int wHint, int hHint,boolean arg) {
	 	return combo.computeSize(wHint, hHint, arg);
	 }

	 public Rectangle computeTrim(int x, int y, int width, int height) {
	  return combo.computeTrim(x, y, width, height);
	 }

	 void onResize() {
	  Rectangle area = getClientArea();
	  combo.setBounds(0, 0, area.width, area.height);
	 }

	 void onFocusIn() {
	  combo.setFocus();
	 }


	
}
