package com.turquaz.engine.ui.editors;

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
 * @author Onsel
 * @version $Id$
 */
import org.eclipse.jface.contentassist.TextContentAssistSubjectAdapter;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import com.turquaz.engine.ui.contentassist.TurquazContentAssistant;


public class AccountingCellEditor extends TextCellEditor
{
	/** Add your post-init code in here */
	TextContentAssistSubjectAdapter adapter;
	TurquazContentAssistant asistant;
   TableViewer viewer = null;
    String columnName = "";

	public AccountingCellEditor(Composite parent,String cName)
	{
		super(parent);
		setValueValid(true);
         this.columnName = cName;
	} 
    public void setTableViewer(TableViewer tableViewer)
    {
        this.viewer = tableViewer;
    }
	public Control createControl(Composite parent)
	{
       
		final Text text = (Text) super.createControl(parent);
		adapter = new TextContentAssistSubjectAdapter(text);
		asistant = new TurquazContentAssistant(adapter, 2);
        
        text.addModifyListener(new ModifyListener(){
            
            public void modifyText(ModifyEvent arg0)
            {
                if(viewer==null)
                {
                    
                }
                else if(viewer.getTable().getSelection().length>0)
                {
                   viewer.getCellModifier().modify( viewer.getTable().getSelection()[0],columnName,text.getText());   
                 
                }
            }
            
        });  
        
       
       
		return text;
	}
}