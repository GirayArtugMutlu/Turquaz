
package com.turquaz.engine.ui.editors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

public class NumericCellEditor extends TextCellEditor {
    VerifyListener listener;
    Text text;
    public NumericCellEditor(Composite parent) {
		super(parent,SWT.RIGHT);
		
	}
    protected void doSetValue(Object object) {
		// Workaround for 32926

		if (object==null) object = ""; //$NON-NLS-1$

		super.doSetValue(object);
	}
    public Control createControl(Composite parent) {
		  text=(Text) super.createControl(parent);
		  
		  
	
		  listener = new VerifyListener() {
		 	public void verifyText(VerifyEvent evt) {		 	    
		 	  
		 	    text3VerifyText(evt);
		 			
		 	}
		 };
		 
		
		
		 
	 text.addVerifyListener(listener);
		return text;
	
  }
    protected void text3VerifyText(VerifyEvent evt){
     	Text control = (Text)evt.widget;
        String textcontrol = control.getText();
     	String newText = textcontrol.substring(0, evt.start) + evt.text + textcontrol.substring(evt.end);
     		Pattern pattern = Pattern.compile("[0-9]{0,9}");

     		Matcher m = pattern.matcher(newText);
           // ONLY NUMERICAL VALUES ARE ACCEPTED    .

           if (!m.matches()) {

               evt.doit = false;
              }
    	}


}
