
package com.turquaz.engine.ui.editors;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.turquaz.engine.ui.component.TurquazDecimalFormat;

public class CurrencyCellEditor extends TextCellEditor{
    VerifyListener listener;
    public CurrencyCellEditor(Composite parent) {
		super(parent);
		setValueValid(true);
	}
    
    protected void doSetValue(Object object) {
		// Workaround for 32926

		if (object==null) object = ""; //$NON-NLS-1$

		super.doSetValue(object);
    }
	public Control createControl(Composite parent) {
		Text text = (Text) super.createControl(parent);

		text.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event e) {
				// do whatever it is you want to do on commit

				handleEnter();
				// this will prevent the return from 

				// traversing to the button

				e.doit = false;
			}
		});
		  listener = new VerifyListener() {
		 	public void verifyText(VerifyEvent evt) {
		 		text3VerifyText(evt);
		 	}
		 };
		   text.addVerifyListener(listener);
		return text;
	}
	
	public void forceCommit() {
		if (isDirty())
			fireApplyEditorValue();
	}

	private void handleEnter() {
		fireApplyEditorValue();
	}
	protected void text3VerifyText(VerifyEvent e){
	 	char decimalSymbol ='.';
	 	int numberOfDecimals =2;
	 	Text control = (Text)e.widget;
	    String textcontrol = control.getText();
	    e.doit = false;
	    String newText = textcontrol.substring(0, e.start) + e.text + textcontrol.substring(e.end);
	    //newText=newText.replaceAll(",","");
	    newText=newText.replaceAll("\\.","");
	    newText=newText.replaceAll(",",".");
	   /* if (e.keyCode == SWT.BS || e.keyCode == SWT.DEL){
	    	e.doit=true;
	    
	      return;
	    }*/
	   int maxdecimaldigit=15;
	   int indexof=newText.indexOf(".");
	   if (indexof==-1){
	   	if (newText.length() > maxdecimaldigit)
	   		return;
	   }
	   else
	   {
	   	if (newText.substring(0,indexof).length() > maxdecimaldigit)
	   		return;
	   }
	  
	    
	    if (newText.equals("")){
	     e.doit=true;
	     return;
	    }
	    Pattern realNumberPattern = Pattern.compile("-?[0-9]+[0-9]*(([" +decimalSymbol + "][0-9]?[0-9]?)|(["+decimalSymbol+"]))?");
	    Matcher matcher = realNumberPattern.matcher(newText);
	    boolean valid = matcher.matches();
	    

	    if (valid){
	    	text.removeVerifyListener(listener);
	    	boolean isLastSeperator=(newText.toCharArray()[newText.length()-1]==decimalSymbol) ? true : false;
	    	BigDecimal bd=new BigDecimal(newText);
	    	TurquazDecimalFormat tdf=new TurquazDecimalFormat();
	    	String formatted=tdf.format(bd);
	    	if (isLastSeperator)
	    		formatted +=",";
	    	text.setText(formatted);
	    	String s=textcontrol.substring(0,e.start)+e.text;
	        s=s.replaceAll("\\.","");
	        s=s.replaceAll(",",".");
	    	int index=newText.indexOf(".");
	    	int diff=0;
	    	if (index==-1)
	    	{
	    		int count=newText.length()/3;
	    		if (newText.length()%3 ==0)
	    			count--;
	    		int count2=(newText.length()-s.length())/3;
	    		diff=count-count2;
	    	}
	    	else
	    	{
	    		newText=newText.substring(0,index-1);
	    		int count=newText.length()/3;
	    		int count2=(newText.length()-s.length())/3;
	    		diff=count-count2;
	    	}
	    	int offset=s.length()+diff;
	    	text.setSelection(offset);
	    	text.addVerifyListener(listener);
	    }
	   }

}
