
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
    Text text;
    public CurrencyCellEditor(Composite parent) {
		super(parent);
		
	}
  
    protected void doSetValue(Object object) {
		// Workaround for 32926

		if (object==null) object = ""; //$NON-NLS-1$

		super.doSetValue(object);
	}
    public Control createControl(Composite parent) {
		  text = (Text) super.createControl(parent);
	
		  listener = new VerifyListener() {
		 	public void verifyText(VerifyEvent evt) {		 	    
		 	  
		 	    text3VerifyText(evt);
		 			
		 	}
		 };
		 
		 text.addListener(SWT.Traverse, new Listener() {
				public void handleEvent(Event e) {
					// do whatever it is you want to do on commit

					// this will prevent the return from 

					// traversing to the button

					e.doit = true;
					text.setText(text.getText());
				}
			});
		
		 
	 text.addVerifyListener(listener);
		return text;
	
    }
    
    public void forceCommit() {
		if (isDirty())
			fireApplyEditorValue();
	}

	protected void text3VerifyText(VerifyEvent e){
		char decimalSymbol ='.';
	 	int numberOfDecimals =2;
	    String textcontrol = text.getText();
	    System.out.println(textcontrol);
	    e.doit = false;
	    String newText="";
	    try{
	    newText = textcontrol.substring(0, e.start) + e.text + textcontrol.substring(e.end);
	    }
	    catch(Exception ex){
	        return;
	    }
	    String tempnewText=newText.replaceAll("\\.","");
	    if (tempnewText.equals("") && !tempnewText.equals(newText))
	    {
	    	e.doit=false;
	    	return;    	
	    }
	    
	    newText=tempnewText;
	    newText=newText.replaceAll(",",".");
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
	    	int indexPoint=newText.indexOf(".");
	    	boolean isLastZero=false;
	    	boolean addSeperator=false;
	    	boolean addSecondZero=false;
	    	if (indexPoint > 0)
	    	{
	    		isLastZero=(newText.toCharArray()[newText.length()-1]=='0') ? true : false;
	    		if (isLastZero)
	    		{
	    			if (newText.toCharArray()[newText.length()-2]=='0') 
	    			{
	    				addSeperator=true;
	    				addSecondZero=true;
	    			}
	    			else
	    				addSeperator=(indexPoint==newText.length()-2) ? true : false;
	    		}
	    	}
	    	BigDecimal bd=new BigDecimal(newText);
	    	TurquazDecimalFormat tdf=new TurquazDecimalFormat();
	    	String formatted=tdf.format(bd);
	    	if (isLastSeperator)
	    		formatted +=",";
	    	if (addSeperator)
	    		formatted+=",";
	    	if (isLastZero)
	    		formatted +="0";
	    	if (addSecondZero)
	    		formatted +="0";
	    
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
