
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

import java.math.BigDecimal;

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

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;



/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* *************************************
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED
* for this machine, so Jigloo or this code cannot be used legally
* for any corporate or commercial purpose.
* *************************************
*/
public class CurrencyText extends Composite {
 private Text text;
 public int textLimit;
 VerifyListener listener;

 public CurrencyText(Composite arg0, int arg1) {
  super(arg0, SWT.NONE);
  text = new Text(this, SWT.RIGHT);
  textLimit =22;
  text.setTextLimit(textLimit);

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
 	int numberOfDecimals =2;
 	Text control = (Text)e.widget;
    String textcontrol = control.getText();
    e.doit = false;
    System.out.println(e.start);
    System.out.println(e.end);
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