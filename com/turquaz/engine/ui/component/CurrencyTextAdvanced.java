
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

import java.math.BigDecimal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;



import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
/**
 * @author Ceday
 *
 * Window - Preferences - Java - Code Style - Code Templates
 */


public class CurrencyTextAdvanced extends Composite {
 private Text text;
 public int textLimit;
 VerifyListener listener;
 int numberOfDecimal;

 public CurrencyTextAdvanced(Composite arg0, int arg1, int numOfDec) {
  super(arg0, SWT.NONE);
  text = new Text(this, SWT.RIGHT);
  textLimit =24;
  text.setTextLimit(textLimit);
  numberOfDecimal=numOfDec;

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
  listener = new VerifyListener() {
	public void verifyText(VerifyEvent evt) {
		//if (SWT.getPlatform().equals("gtk"))
			//gtkTextVerify(evt);
		//else
			text3VerifyText(evt);
	}
};
  text.addVerifyListener(listener);


 }
 
 public CurrencyTextAdvanced(Composite arg0, int arg1) {
 	  super(arg0, SWT.NONE);
 	  text = new Text(this, SWT.RIGHT);
 	  textLimit =24;
 	  text.setTextLimit(textLimit);
 	  numberOfDecimal=2;

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
 	  listener = new VerifyListener() {
 		public void verifyText(VerifyEvent evt) {
 			//if (SWT.getPlatform().equals("gtk"))
 				//gtkTextVerify(evt);
 			//else
 				text3VerifyText(evt);
 		}
 	};
 	  text.addVerifyListener(listener);


 	 }
 public void setTextLimit(int a){
 	textLimit = a;
 	text.setTextLimit(a);
 }
 public int getTextLimit(){
 	return textLimit;
 }
 protected void gtkTextVerify(VerifyEvent e)
 {
 	char decimalSymbol=',';
 	Text control = (Text)e.widget;
    String textcontrol = control.getText();
    e.doit = false;
    String newText = textcontrol.substring(0, e.start) + e.text + textcontrol.substring(e.end);
    
    if (newText.equals(""))
    {
    	e.doit=true;
    	return;
    }

    Pattern realNumberPattern = Pattern.compile("-?[0-9][0-9]{0,14}(([" +decimalSymbol + "][0-9]?[0-9]?)|(["+decimalSymbol+"]))?");
    Matcher matcher = realNumberPattern.matcher(newText);
    boolean valid = matcher.matches();
    
    if (valid)
    {
    	e.doit=true;    	
    }
 	
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
  
 
 public void setText(String txt){
 	text.setTextLimit(textLimit);
 	txt = txt.replaceAll("\\.",",");
 	text.setText(txt);	 	
 }
 
 public void setBackground(Color c){
 	text.setBackground(c);
 }
 public Color getBackground(){
 	return text.getBackground();
 }
 public String getText(){
 	String formatted=text.getText(); 	
 	formatted=formatted.replaceAll("\\.","");
 	return formatted.replaceAll(",",".");
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
 
 public BigDecimal getBigDecimalValue(){
 	String text = getText();
 	if(text.equals("")){
 		return new BigDecimal(0);
 	}
 	
 	return new BigDecimal(text);
 	
 	
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