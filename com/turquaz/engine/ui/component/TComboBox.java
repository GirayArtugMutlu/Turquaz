/*
 * Created on Sep 27, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.turquaz.engine.ui.component;

import java.awt.Component;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import com.turquaz.engine.dal.TurqInventoryUnit;


/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
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
