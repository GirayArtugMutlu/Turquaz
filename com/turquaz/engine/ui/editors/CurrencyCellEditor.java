
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
    int numberOfDecimal =2;
    public CurrencyCellEditor(Composite parent,int numOfDec) {
	
        super(parent,SWT.RIGHT);
		numberOfDecimal = numOfDec;		
	
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
		 
		 text.addListener(SWT.Traverse, new Listener() {
				public void handleEvent(Event e) {
					// do whatever it is you want to do on commit

					// this will prevent the return from 

					// traversing to the button

					e.doit = true;
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
	 	Text control = (Text)e.widget;
	    String textcontrol = control.getText();
	    e.doit = false;
	    String newText = textcontrol.substring(0, e.start) + e.text + textcontrol.substring(e.end);
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
	    Pattern realNumberPattern = Pattern.compile("-?[0-9]+[0-9]*([" +decimalSymbol + "][0-9]{0,"+numberOfDecimal+"})?");
	    Matcher matcher = realNumberPattern.matcher(newText);
	    boolean valid = matcher.matches();
	    

	    if (valid){
	    	text.removeVerifyListener(listener);
	    	boolean isLastSeperator=(newText.toCharArray()[newText.length()-1]==decimalSymbol) ? true : false;
	    	String formatted="";
	    	TurquazDecimalFormat tdf=new TurquazDecimalFormat();
	    	String tempText=newText.replaceAll("\\.",",");
	        int indexPoint=tempText.indexOf(",");
	    	if (indexPoint > 0)
	    	{
	    		BigDecimal bd=new BigDecimal(tempText.substring(0,indexPoint));        	
	        	formatted=tdf.format(bd);
	        	formatted += tempText.substring(indexPoint);
	    	}
	    	else
	    	{
	    		BigDecimal bd=new BigDecimal(tempText);
	    		formatted=tdf.format(bd);
	    	}

	    	String s=textcontrol.substring(0,e.start)+e.text;
	    	int sepIndex=s.indexOf(",");
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
	    		newText=newText.substring(0,index);
	    		int count=newText.length()/3;
	    		int count2=(newText.length()-s.length())/3;
	    		diff=count-count2;
	    	}
	    	
	    	int offset;
	    	if (sepIndex!=-1 && sepIndex < e.start)
	    		offset=e.start+e.text.length();
	    	else
	    		offset=s.length()+diff;
	    	if (SWT.getPlatform().equals("gtk"))
	    	{
	    		/*
	    		text.setText("");
	    		String toSetEvent="";
	    		String toSetBox="";
	    		if (formatted.length() > offset)
	    		{
	    			toSetEvent=formatted.substring(0,offset);
	    			toSetBox=formatted.substring(offset);
	    			//System.out.println(toSetEvent);
	    			//System.out.println(toSetBox);
	    		}
	    		else
	    		{
	    			toSetEvent=formatted;
	    		}
	    		e.text=toSetEvent;
	    		text.setText(toSetBox);
	    		//System.out.println(text.getText());
	    		e.start=-1;
	    		e.end=-1;
	    		e.doit=true;
	    		//System.out.println(text.getText());*/
	    		
	    		
	    		text.setText("");
	    		e.text=formatted;
	    		e.doit=true;
	    		
	    		
	    		text.addVerifyListener(listener);
	    		
	    		return;
	    		
	    	}
	    	text.setText(formatted);
	    	text.setSelection(offset);
	    	text.addVerifyListener(listener);
	    }
	   }
	

}
