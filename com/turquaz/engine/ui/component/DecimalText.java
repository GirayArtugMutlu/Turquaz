/*
 * Created on Sep 22, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * 
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