package com.turquaz.current.ui;
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
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

import com.turquaz.current.Messages;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.SecureComposite;

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
public class CurUICurrentCardSearch extends  Composite implements SecureComposite,SearchComposite {

	private CCombo comboTurqGroupName;
private TableColumn tableColumnCurrentName;

private TableColumn tableColumnContactName;

	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentCardSearch;
	private CLabel lblCurrentName;
	private CLabel lblCurrentCode;
	private Text txtCurrentCode;
	private Text txtCurrentName;
	private CLabel lblTurqGroupName;
	private Composite compCurrentCardSearch;
	
	private CurBLCurrentCardSearch curBLCurrentCardSearch=new CurBLCurrentCardSearch();
	private EngBLCommon engBLCom=new EngBLCommon();
	
	public CurUICurrentCardSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	/**
	* Initializes the GUI.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void initGUI(){
		try {
			preInitGUI();
	
			compCurrentCardSearch = new Composite(this,SWT.NULL);
			lblCurrentCode = new CLabel(compCurrentCardSearch,SWT.NULL);
			txtCurrentCode = new Text(compCurrentCardSearch,SWT.NULL);
			lblCurrentName = new CLabel(compCurrentCardSearch,SWT.NULL);
			txtCurrentName = new Text(compCurrentCardSearch,SWT.NULL);
			lblTurqGroupName = new CLabel(compCurrentCardSearch,SWT.NULL);
			tableCurrentCardSearch = new Table(this,SWT.FULL_SELECTION| SWT.H_SCROLL);
			tableColumnCurrentCode = new TableColumn(tableCurrentCardSearch,SWT.NULL);
			tableColumnCurrentName = new TableColumn(tableCurrentCardSearch,SWT.NULL);
			tableColumnContactName = new TableColumn(tableCurrentCardSearch,SWT.NULL);
	
			this.setSize(396, 323);
	
			GridData compCurrentCardSearchLData = new GridData();
			compCurrentCardSearchLData.widthHint = 380;
			compCurrentCardSearchLData.heightHint = 121;
			compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);

			GridData lblCurrentCodeLData = new GridData();
			lblCurrentCodeLData.verticalAlignment = GridData.CENTER;
			lblCurrentCodeLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentCodeLData.widthHint = -1;
			lblCurrentCodeLData.heightHint = -1;
			lblCurrentCodeLData.horizontalIndent = 0;
			lblCurrentCodeLData.horizontalSpan = 1;
			lblCurrentCodeLData.verticalSpan = 1;
			lblCurrentCodeLData.grabExcessHorizontalSpace = false;
			lblCurrentCodeLData.grabExcessVerticalSpace = false;
			lblCurrentCode.setLayoutData(lblCurrentCodeLData);
			lblCurrentCode.setText(Messages.getString("CurUICurrentCardSearch.0")); //$NON-NLS-1$
	
			GridData txtCurrentCodeLData = new GridData();
			txtCurrentCodeLData.widthHint = 238;
			txtCurrentCodeLData.heightHint = 16;
			txtCurrentCode.setLayoutData(txtCurrentCodeLData);

			GridData lblCurrentNameLData = new GridData();
			lblCurrentNameLData.verticalAlignment = GridData.CENTER;
			lblCurrentNameLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrentNameLData.widthHint = -1;
			lblCurrentNameLData.heightHint = -1;
			lblCurrentNameLData.horizontalIndent = 0;
			lblCurrentNameLData.horizontalSpan = 1;
			lblCurrentNameLData.verticalSpan = 1;
			lblCurrentNameLData.grabExcessHorizontalSpace = false;
			lblCurrentNameLData.grabExcessVerticalSpace = false;
			lblCurrentName.setLayoutData(lblCurrentNameLData);
			lblCurrentName.setText(Messages.getString("CurUICurrentCardSearch.1")); //$NON-NLS-1$
	
			GridData txtCurrentNameLData = new GridData();
			txtCurrentNameLData.widthHint = 238;
			txtCurrentNameLData.heightHint = 19;
			txtCurrentName.setLayoutData(txtCurrentNameLData);

			GridData lblTurqGroupNameLData = new GridData();
			lblTurqGroupNameLData.verticalAlignment = GridData.CENTER;
			lblTurqGroupNameLData.horizontalAlignment = GridData.BEGINNING;
			lblTurqGroupNameLData.widthHint = 65;
			lblTurqGroupNameLData.heightHint = 19;
			lblTurqGroupNameLData.horizontalIndent = 0;
			lblTurqGroupNameLData.horizontalSpan = 1;
			lblTurqGroupNameLData.verticalSpan = 1;
			lblTurqGroupNameLData.grabExcessHorizontalSpace = false;
			lblTurqGroupNameLData.grabExcessVerticalSpace = false;
			lblTurqGroupName.setLayoutData(lblTurqGroupNameLData);
			lblTurqGroupName.setText(Messages.getString("CurUICurrentCardSearch.2")); //$NON-NLS-1$
			lblTurqGroupName.setSize(new org.eclipse.swt.graphics.Point(65,19));
			{
				comboTurqGroupName = new CCombo(compCurrentCardSearch, SWT.NONE);
				GridData comboTurqGroupNameLData = new GridData();
				comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);

			}
			GridLayout compCurrentCardSearchLayout = new GridLayout(2, true);
			compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
			compCurrentCardSearchLayout.marginWidth = 5;
			compCurrentCardSearchLayout.marginHeight = 5;
			compCurrentCardSearchLayout.numColumns = 2;
			compCurrentCardSearchLayout.makeColumnsEqualWidth = false;
			compCurrentCardSearchLayout.horizontalSpacing = 5;
			compCurrentCardSearchLayout.verticalSpacing = 5;
			compCurrentCardSearch.layout();
	
			GridData tableCurrentCardSearchLData = new GridData();
			tableCurrentCardSearchLData.verticalAlignment = GridData.FILL;
			tableCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
			tableCurrentCardSearchLData.widthHint = -1;
			tableCurrentCardSearchLData.heightHint = -1;
			tableCurrentCardSearchLData.horizontalIndent = 0;
			tableCurrentCardSearchLData.horizontalSpan = 1;
			tableCurrentCardSearchLData.verticalSpan = 1;
			tableCurrentCardSearchLData.grabExcessHorizontalSpace = true;
			tableCurrentCardSearchLData.grabExcessVerticalSpace = true;
			tableCurrentCardSearch.setLayoutData(tableCurrentCardSearchLData);
			tableCurrentCardSearch.setHeaderVisible(true);
			tableCurrentCardSearch.setLinesVisible(true);
			tableCurrentCardSearch.setSize(new org.eclipse.swt.graphics.Point(409,168));
			tableCurrentCardSearch.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableCurrentCardSearchMouseDoubleClick(evt);
				}
			});
	
			tableColumnCurrentCode.setText(Messages.getString("CurUICurrentCardSearch.0")); //$NON-NLS-1$
			tableColumnCurrentCode.setWidth(120);
	
			tableColumnCurrentName.setText(Messages.getString("CurUICurrentCardSearch.1")); //$NON-NLS-1$
			tableColumnCurrentName.setWidth(120);
	
			tableColumnContactName.setText(Messages.getString("CurUICurrentCardSearch.5")); //$NON-NLS-1$
			tableColumnContactName.setWidth(120);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = false;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
	
			postInitGUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
		try{
			comboTurqGroupName.removeAll();
			comboTurqGroupName.setText(""); //$NON-NLS-1$
			List groups=engBLCom.getTurqCurrentGroups();
			for(int k=0; k<groups.size(); k++){
				TurqCurrentGroup group=(TurqCurrentGroup)groups.get(k);
				comboTurqGroupName.add(group.getGroupsName());
				comboTurqGroupName.setData(group.getGroupsName(),group);
			}
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
	}

	
	public void delete(){
	}
	
	public void search(){
		try{
			tableCurrentCardSearch.removeAll();
			List listCurrentCards=curBLCurrentCardSearch.searchCurrentCard(txtCurrentCode.getText().trim(),
																		txtCurrentName.getText().trim(),(TurqCurrentGroup)comboTurqGroupName.getData(comboTurqGroupName.getText()));

			for(int k=0; k<listCurrentCards.size(); k++){
				TurqCurrentCard aCurrentCard=(TurqCurrentCard)listCurrentCards.get(k);
				TableItem item=new TableItem(tableCurrentCardSearch, SWT.NULL);
				item.setData(aCurrentCard);
 				
 				String contactName =""; //$NON-NLS-1$
 				Set contacts = aCurrentCard.getTurqCurrentContacts();
 				
 				if(contacts.size()>0){
 				Object curContact[] = contacts.toArray();
 				contactName = ((TurqCurrentContact)curContact[0]).getContactsName();
 				
 				}
 					
 				
 				item.setText(new String[]{aCurrentCard.getCardsCurrentCode(),aCurrentCard.getCardsName(),contactName});
                  			
			}
		
	
		}
		catch(Exception ex){
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
	}
	
	public void newForm(){
	}
	
	public void save(){
	}

	/**
	* This static method creates a new instance of this class and shows
	* it inside a new Shell.
	*
	* It is a convenience method for showing the GUI, but it can be
	* copied and used as a basis for your own code.	*
	* It is auto-generated code - the body of this method will be
	* re-generated after any changes are made to the GUI.
	* However, if you delete this method it will not be re-created.	*/
	public static void showGUI(){
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			CurUICurrentCardSearch inst = new CurUICurrentCardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,435,318);
			shell.setSize(shellBounds.width, shellBounds.height);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/** Auto-generated event handler method */
	protected void tableCurrentCardSearchMouseDoubleClick(MouseEvent evt){
		//TODO add your handler code here
		TableItem [] selection= tableCurrentCardSearch.getSelection();	
	
		if(selection.length>0){
	
			TurqCurrentCard card = (TurqCurrentCard)selection[0].getData();
			new CurUICurrentCardUpdate(this.getShell(),SWT.NULL,card).open();
			search();
		}
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableCurrentCardSearch);
		
	}
}
