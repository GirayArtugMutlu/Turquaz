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

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
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
import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;

import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentCardsGroup;
import com.turquaz.engine.dal.TurqCurrentContact;
import com.turquaz.engine.dal.TurqCurrentGroup;
import com.turquaz.engine.dal.TurqViewCurrentAmountTotal;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
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
public class CurUICurrentCardSearch extends  Composite implements SearchComposite {

	private CurBLCurrentCardSearch curBLCurrentCardSearch=new CurBLCurrentCardSearch();
	private TableColumn tableColumnBalance;
	private TableColumn tableColumnContactName;
	private TableColumn tableColumnTotalDept;
	private TableColumn tableColumnTotalCredit;
	private TableColumn tableColumnCurrentName;
	private TableColumn tableColumnCurrentCode;
	private Table tableCurrentCardSearch;
	private CCombo comboTurqGroupName;
	private CLabel lblTurqGroupName;
	private Text txtCurrentName;
	private CLabel lblCurrentName;
	private Text txtCurrentCode;
	private CLabel lblCurrentCode;
	private Composite compCurrentCardSearch;
	private EngBLCommon engBLCom=new EngBLCommon();
	CurBLCurrentCardUpdate blUpdate = new CurBLCurrentCardUpdate();
	Menu popup;
	
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

			this.setSize(552, 317);

			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			{
				compCurrentCardSearch = new Composite(this, SWT.NONE);
				GridLayout compCurrentCardSearchLayout = new GridLayout();
				compCurrentCardSearchLayout.numColumns = 2;
				GridData compCurrentCardSearchLData = new GridData();
				compCurrentCardSearch.setLayout(compCurrentCardSearchLayout);
				compCurrentCardSearchLData.widthHint = 380;
				compCurrentCardSearchLData.heightHint = 90;
				compCurrentCardSearch.setLayoutData(compCurrentCardSearchLData);
				{
					lblCurrentCode = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentCode.setText(Messages
						.getString("CurUICurrentCardSearch.0"));
					GridData lblCurrentCodeLData = new GridData();
					lblCurrentCode.setLayoutData(lblCurrentCodeLData);
				}
				{
					txtCurrentCode = new Text(compCurrentCardSearch, SWT.NONE);
					GridData txtCurrentCodeLData = new GridData();
					txtCurrentCode.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent evt) {
							if (evt.keyCode == SWT.CR)
								search();
						}
					});
					txtCurrentCodeLData.widthHint = 238;
					txtCurrentCodeLData.heightHint = 16;
					txtCurrentCode.setLayoutData(txtCurrentCodeLData);
				}
				{
					lblCurrentName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblCurrentName.setText(Messages
						.getString("CurUICurrentCardSearch.1"));
					GridData lblCurrentNameLData = new GridData();
					lblCurrentName.setLayoutData(lblCurrentNameLData);
				}
				{
					txtCurrentName = new Text(compCurrentCardSearch, SWT.NONE);
					GridData txtCurrentNameLData = new GridData();
					txtCurrentName.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent evt) {
							if (evt.keyCode == SWT.CR)
								search();
						}
					});
					txtCurrentNameLData.widthHint = 238;
					txtCurrentNameLData.heightHint = 19;
					txtCurrentName.setLayoutData(txtCurrentNameLData);
				}
				{
					lblTurqGroupName = new CLabel(compCurrentCardSearch, SWT.NONE);
					lblTurqGroupName.setText(Messages
						.getString("CurUICurrentCardSearch.2"));
					GridData lblTurqGroupNameLData = new GridData();
					lblTurqGroupNameLData.widthHint = 91;
					lblTurqGroupNameLData.heightHint = 21;
					lblTurqGroupName.setLayoutData(lblTurqGroupNameLData);
					lblTurqGroupName.setSize(91,21);
				}
				{
					comboTurqGroupName = new CCombo(compCurrentCardSearch, SWT.NONE);
					GridData comboTurqGroupNameLData = new GridData();
					comboTurqGroupNameLData.widthHint = 150;
					comboTurqGroupNameLData.heightHint = 29;
					comboTurqGroupName.setSize(150, 29);

					comboTurqGroupName.setLayoutData(comboTurqGroupNameLData);
				}
			}
			{
				tableCurrentCardSearch = new Table(this, SWT.FULL_SELECTION
					| SWT.H_SCROLL);
				tableCurrentCardSearch.setHeaderVisible(true);
				tableCurrentCardSearch.setLinesVisible(true);
				GridData tableCurrentCardSearchLData = new GridData();
				tableCurrentCardSearch.addMouseListener(new MouseAdapter() {
					public void mouseDoubleClick(MouseEvent evt) {
						tableCurrentCardSearchMouseDoubleClick(evt);
					}
				});
				tableCurrentCardSearchLData.verticalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.horizontalAlignment = GridData.FILL;
				tableCurrentCardSearchLData.grabExcessHorizontalSpace = true;
				tableCurrentCardSearchLData.grabExcessVerticalSpace = true;
				tableCurrentCardSearch
					.setLayoutData(tableCurrentCardSearchLData);
				{
					tableColumnCurrentCode = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnCurrentCode.setText(Messages
						.getString("CurUICurrentCardSearch.0"));
					tableColumnCurrentCode.setWidth(120);
				}
				{
					tableColumnCurrentName = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnCurrentName.setText(Messages
						.getString("CurUICurrentCardSearch.1"));
					tableColumnCurrentName.setWidth(120);
				}
				{
					tableColumnTotalCredit = new TableColumn(
						tableCurrentCardSearch,
						SWT.RIGHT);
					tableColumnTotalCredit.setText("Toplam Bor�");
					tableColumnTotalCredit.setWidth(120);
				}
				{
					tableColumnTotalDept = new TableColumn(
						tableCurrentCardSearch,
						SWT.RIGHT);
					tableColumnTotalDept.setText("Toplam Alacak");
					tableColumnTotalDept.setWidth(120);
				}
				{
					tableColumnBalance = new TableColumn(
						tableCurrentCardSearch,
						SWT.RIGHT);
					tableColumnBalance.setText("Bakiye");
					tableColumnBalance.setWidth(120);
				}
				{
					tableColumnContactName = new TableColumn(
						tableCurrentCardSearch,
						SWT.NONE);
					tableColumnContactName.setText(Messages
						.getString("CurUICurrentCardSearch.5"));
					tableColumnContactName.setWidth(120);
				}
			}
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
			
		     popup = new Menu(this.getShell(),SWT.POP_UP);
		     MenuItem item = new MenuItem (popup, SWT.PUSH);
			 item.setText("Cari kart hareketlerini getir");    	  
			
			 item.addListener(SWT.Selection, new Listener () {
				public void handleEvent (Event e) {					
					TableItem items[] = tableCurrentCardSearch.getSelection();
					if (items.length > 0)
					{
						new CurUICurrentCardTransactions(getShell(),SWT.NULL,(TurqCurrentCard)items[0].getData()).open();
					}
					}
			 });
			 
			tableCurrentCardSearch.setMenu(popup);
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

	
	public void delete()
	{
		try
		{
			TableItem items[]=tableCurrentCardSearch.getSelection();
			if(items.length>0)
			{
	   	 		TurqCurrentCard currentCard = (TurqCurrentCard)items[0].getData();
	        
	   	 		MessageBox msg = new MessageBox(this.getShell(),SWT.NULL);
				MessageBox msg2 = new MessageBox(this.getShell(),SWT.OK|SWT.CANCEL);
	
				msg2.setMessage(Messages.getString("CurUICurrentCardUpdate.21")); //$NON-NLS-1$
				int result = msg2.open();
	    
				if(result==SWT.OK)
				{	 
			
					deleteRelations(currentCard);
				
					blUpdate.deleteObject(currentCard);
				
					msg.setMessage(Messages.getString("CurUICurrentCardUpdate.22")); //$NON-NLS-1$
					msg.open();
				}
				search();
				
			}
		}
	    catch(Exception ex){
		    MessageBox msg3 = new MessageBox(this.getShell(),SWT.ICON_WARNING);
			ex.printStackTrace();
			msg3.setMessage(Messages.getString("CurUICurrentCardSearch.3")); //$NON-NLS-1$
			msg3.open();
		}
	
	
	
	}
//	Delete card Phones
	//Delete Contacts
	//Delete registered group relations
	public void deleteRelations(TurqCurrentCard currentCard)throws Exception{
	try{
	
	    
	 Iterator it=currentCard.getTurqCurrentCardsGroups().iterator();
	 while(it.hasNext()){
				TurqCurrentCardsGroup currentGroup=(TurqCurrentCardsGroup)it.next();
				blUpdate.deleteObject(currentGroup);
			}
			 it=currentCard.getTurqCurrentCardsPhones().iterator();
			while(it.hasNext()){
				
				blUpdate.deleteObject(it.next());
			}
	
			it=currentCard.getTurqCurrentContacts().iterator();
			while(it.hasNext()){
				
				blUpdate.deleteObject(it.next());
			}
	}
	catch(Exception ex ){
	throw ex;
	}
	
	}
	
	public void search(){
		try{
			tableCurrentCardSearch.removeAll();
			List listCurrentCards=curBLCurrentCardSearch.searchCurrentCard(txtCurrentCode.getText().trim(),
																		txtCurrentName.getText().trim(),(TurqCurrentGroup)comboTurqGroupName.getData(comboTurqGroupName.getText()));
			TurkishCurrencyFormat cf=new TurkishCurrencyFormat();
			for(int k=0; k<listCurrentCards.size(); k++){
				TurqCurrentCard aCurrentCard=(TurqCurrentCard)((Object[])listCurrentCards.get(k))[1];
				TurqViewCurrentAmountTotal currentView=(TurqViewCurrentAmountTotal)((Object[])listCurrentCards.get(k))[0];
				BigDecimal totalCredit=(currentView.getTransactionsTotalCredit()==null) ? new BigDecimal(0) : currentView.getTransactionsTotalCredit();
				BigDecimal totalDept=(currentView.getTransactionsTotalDept()==null) ? new BigDecimal(0) : currentView.getTransactionsTotalDept();
				BigDecimal balance=(currentView.getTransactionsBalanceNow()== null) ? new BigDecimal(0) : currentView.getTransactionsBalanceNow();
				TableItem item=new TableItem(tableCurrentCardSearch, SWT.NULL);
				item.setData(aCurrentCard);
 				
 				String contactName =""; //$NON-NLS-1$
 				Set contacts = aCurrentCard.getTurqCurrentContacts();
 				
 				if(contacts.size()>0){
 				Object curContact[] = contacts.toArray();
 				contactName = ((TurqCurrentContact)curContact[0]).getContactsName();
 				
 				}
 					
 				
 				item.setText(new String[]{aCurrentCard.getCardsCurrentCode(),aCurrentCard.getCardsName(),cf.format(totalDept),cf.format(totalCredit),cf.format(balance), contactName});
                  			
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
	public void printTable(){
	    EngBLUtils.printTable(tableCurrentCardSearch,Messages.getString("CurUICurrentCardSearch.4")); //$NON-NLS-1$
	    
	}
}
