package com.turquaz.inventory.ui;

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

import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;


import com.turquaz.current.bl.CurBLCurrentCardUpdate;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqViewInventoryAmountTotal;
import com.turquaz.engine.ui.component.SearchComposite;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardAdd;
import com.turquaz.inventory.bl.InvBLCardSearch;
import com.turquaz.inventory.bl.InvBLCardUpdate;

import org.eclipse.swt.layout.GridData;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.SWT;

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


public class InvUICardSearch extends  Composite implements SearchComposite {

	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	InvBLCardUpdate cardUpdate = new InvBLCardUpdate();
	private Composite compInvCardSearch;
	private CLabel lblInvName;
	private TableColumn tableColumnInvName;
	private TableColumn tableColumnAmount;
	private TableColumn tableColumnInventoryCode;
	private Table tableSearcResults;
	private CCombo comboInvGroup;
	private CLabel lblInvGroup;
	private Text txtInvName;
	private Text txtInvCode;
	private CLabel lblInvCode;
	private Composite compInvCardSearchPanel;
	public InvUICardSearch(Composite parent, int style) {
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

			this.setSize(new org.eclipse.swt.graphics.Point(573,437));

			FillLayout thisLayout = new FillLayout(256);
			this.setLayout(thisLayout);
			{
				compInvCardSearch = new Composite(this, SWT.NONE);
				GridLayout compInvCardSearchLayout = new GridLayout();
				compInvCardSearchLayout.makeColumnsEqualWidth = true;
				compInvCardSearch.setLayout(compInvCardSearchLayout);
				compInvCardSearch.setSize(new org.eclipse.swt.graphics.Point(
					573,
					437));
				{
					compInvCardSearchPanel = new Composite(compInvCardSearch, SWT.NONE);
					GridLayout compInvCardSearchPanelLayout = new GridLayout();
					compInvCardSearchPanelLayout.numColumns = 4;
					compInvCardSearchPanel
						.setSize(new org.eclipse.swt.graphics.Point(563, 84));
					GridData compInvCardSearchPanelLData = new GridData();
					compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
					compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
					compInvCardSearchPanelLData.heightHint = 84;
					compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
					compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
					{
						lblInvCode = new CLabel(compInvCardSearchPanel, SWT.NONE);
						GridData cLabel2LData = new GridData();
						cLabel2LData.widthHint = 97;
						cLabel2LData.heightHint = 17;
						lblInvCode.setLayoutData(cLabel2LData);
						lblInvCode.setText(Messages
							.getString("InvUICardSearch.1")); //$NON-NLS-1$
						lblInvCode.setSize(new org.eclipse.swt.graphics.Point(
							97,
							17));
					}
					{
						txtInvCode = new Text(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvCodeLData = new GridData();
						txtInvCode.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent evt) {
								if (evt.keyCode == SWT.CR)
									search();
							}
						});
						txtInvCodeLData.widthHint = 141;
						txtInvCodeLData.heightHint = 17;
						txtInvCode.setLayoutData(txtInvCodeLData);
						txtInvCode.setSize(new org.eclipse.swt.graphics.Point(
							147,
							17));
					}
					{
						lblInvName = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvName.setText(Messages
							.getString("InvUICardSearch.0")); //$NON-NLS-1$
						lblInvName.setSize(100, 18);
						GridData lblInvNameLData = new GridData();
						lblInvNameLData.widthHint = 100;
						lblInvNameLData.heightHint = 18;
						lblInvName.setLayoutData(lblInvNameLData);
					}
					{
						txtInvName = new Text(compInvCardSearchPanel, SWT.NONE);
						txtInvName.setSize(new org.eclipse.swt.graphics.Point(
							168,
							16));
						GridData txtInvNameLData = new GridData();
						txtInvName.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent evt) {
								if (evt.keyCode == SWT.CR)
									search();
							}
						});
						txtInvNameLData.widthHint = 162;
						txtInvNameLData.heightHint = 16;
						txtInvName.setLayoutData(txtInvNameLData);
					}
					{
						lblInvGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvGroup.setText(Messages
							.getString("InvUICardSearch.2")); //$NON-NLS-1$
						lblInvGroup.setSize(new org.eclipse.swt.graphics.Point(
							110,
							17));
						GridData lblInvGroupLData = new GridData();
						lblInvGroupLData.widthHint = 110;
						lblInvGroupLData.heightHint = 17;
						lblInvGroup.setLayoutData(lblInvGroupLData);
					}
					{
						comboInvGroup = new CCombo(compInvCardSearchPanel, SWT.NONE);
						comboInvGroup
							.setSize(new org.eclipse.swt.graphics.Point(119, 16));
						GridData comboInvGroupLData = new GridData();
						comboInvGroup.addKeyListener(new KeyAdapter() {
							public void keyReleased(KeyEvent evt) {
								if (evt.keyCode == SWT.CR)
									search();
							}
						});
						comboInvGroupLData.widthHint = 97;
						comboInvGroupLData.heightHint = 16;
						comboInvGroup.setLayoutData(comboInvGroupLData);
					}
				}
				{
					tableSearcResults = new Table(compInvCardSearch, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
					tableSearcResults.setHeaderVisible(true);
					tableSearcResults.setLinesVisible(true);
					tableSearcResults
						.setSize(new org.eclipse.swt.graphics.Point(543, 318));
					GridData tableSearcResultsLData = new GridData();
					tableSearcResults.addMouseListener(new MouseAdapter() {
						public void mouseDoubleClick(MouseEvent evt) {
							tableSearcResultsMouseDoubleClick(evt);
						}
					});
					tableSearcResultsLData.verticalAlignment = GridData.FILL;
					tableSearcResultsLData.horizontalAlignment = GridData.FILL;
					tableSearcResultsLData.grabExcessHorizontalSpace = true;
					tableSearcResultsLData.grabExcessVerticalSpace = true;
					tableSearcResults.setLayoutData(tableSearcResultsLData);
					{
						tableColumnInvName = new TableColumn(
							tableSearcResults,
							SWT.NONE);
						tableColumnInvName.setText("Stok Kodu"); //$NON-NLS-1$
						tableColumnInvName.setWidth(115);
					}
					{
						tableColumnInventoryCode = new TableColumn(
							tableSearcResults,
							SWT.NONE);
						tableColumnInventoryCode.setText("Stok Cinsi"); //$NON-NLS-1$
						tableColumnInventoryCode.setWidth(107);
					}
					{
						tableColumnAmount = new TableColumn(
							tableSearcResults,
							SWT.NONE);
						tableColumnAmount.setText(Messages
							.getString("InvUICardSearch.5")); //$NON-NLS-1$
						tableColumnAmount.setWidth(118);
					}
				}
			}
			thisLayout.type = SWT.HORIZONTAL;
			thisLayout.marginWidth = 0;
			thisLayout.marginHeight = 0;
			thisLayout.spacing = 0;
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

		
		fillComboGroup();
		
				
	}
	public void fillComboGroup(){
	try {
			java.util.List groupLst = invBLCardAdd.getInventoryGroups();
			TableItem item = null;
			TurqInventoryGroup trqInvGroup;
			for (int i = 0; i < groupLst.size(); i++) {
				trqInvGroup = (TurqInventoryGroup) groupLst.get(i);
				comboInvGroup.add(trqInvGroup.getGroupsName());
				comboInvGroup.setData(trqInvGroup.getGroupsName(), trqInvGroup);
					

			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	
	
	}
	
	public void save(){
		
	}
	public void deleteInvUnits(TurqInventoryCard invCard){
	    try{
	    
	   
	    //First remove groups then re-add them..
		Iterator it = invCard.getTurqInventoryCardUnits().iterator();
	    TurqInventoryCardUnit cardUnit; 
	 
	    while(it.hasNext()){   
	    
	     cardUnit = (TurqInventoryCardUnit)it.next();
	     cardUpdate.deleteObject(cardUnit);				
		} 
	   
	    }
	    
	    catch(Exception ex){
	    ex.printStackTrace();
	    }
	   }
	 public void deleteInvGroups(TurqInventoryCard invCard){
	     try{
	     Iterator it = invCard.getTurqInventoryCardGroups().iterator();
	      TurqInventoryCardGroup cardGroup; 
	        
	      while(it.hasNext()){
	       
	       cardGroup = (TurqInventoryCardGroup)it.next();
	       cardUpdate.deleteObject(cardGroup);
	       }
	     
	     
	     
	     }
	     catch(Exception ex){
	     ex.printStackTrace();
	     }
	     
	     }
	 public void deletePrices(TurqInventoryCard invCard){
	     try{
	     Iterator it = invCard.getTurqInventoryPrices().iterator();
	     TurqInventoryPrice invPrice;
	  	
	  	while(it.hasNext()){
	       
	       invPrice = (TurqInventoryPrice)it.next();
	      
	       cardUpdate.deleteObject(invPrice);
	      
	                
	       }
	      }
	     catch(Exception ex){
	     	MessageBox msg = new MessageBox(this.getShell(),SWT.ICON_ERROR);
	     	msg.setMessage(ex.getMessage());
	      ex.printStackTrace();
	     }
	       
	     
	     }
	      
	      
	  	
	public void delete(){
	    TableItem items[]=tableSearcResults.getSelection();
	    if(items.length>0){
	   
	     TurqInventoryCard invCard = (TurqInventoryCard)items[0].getData();
	    MessageBox msg=new MessageBox(this.getShell(),SWT.YES|SWT.NO);
	      try{
	      
	      msg.setMessage(Messages.getString("InvUICardUpdateDialog.7")); //$NON-NLS-1$
	      if (msg.open()==SWT.NO)
	       return;
	     
	     // if the inventory card contains transactions 
	     if(cardUpdate.hasTransactions(invCard))
	     {
	     	MessageBox msg2 = new MessageBox(this.getShell(),SWT.ICON_WARNING);
	    	msg2.setMessage("Inventory card contains transactions and \ncan not be deleted. Delete them first. ");  //$NON-NLS-1$
			msg2.open();
			return;
	     }
	    //First Delete Groups
	    deleteInvGroups(invCard);
	    //delete Units
	    deleteInvUnits(invCard);
	    // delete Prices
	    deletePrices(invCard);
	    // delete invCard
	    
	    cardUpdate.deleteObject(invCard);
	    msg = new MessageBox(this.getShell(),SWT.NULL);
		msg.setMessage(Messages.getString("InvUICardUpdateDialog.6"));	 //$NON-NLS-1$
		msg.open();	 
	
	       
	           
	    }
	    catch(Exception ex){
	    	
	    ex.printStackTrace();	
	    msg = new MessageBox(this.getShell(),SWT.ICON_ERROR);	
	    msg.setMessage(ex.getMessage());
	    msg.open();
	   
	 
	    
	    }
	    }
	    
		
	}
	public void newForm(){
		
	}
	public void search(){
	tableSearcResults.removeAll();
	InvBLCardSearch cardSearch = new InvBLCardSearch();
	List result;
	try{
	if(comboInvGroup.getSelectionIndex()==-1){
	result = cardSearch.searchCards(txtInvName.getText().trim(),txtInvCode.getText().trim(),null);
	
	}
	else{
	result = cardSearch.searchCards(txtInvName.getText().trim(),txtInvCode.getText().trim(),(TurqInventoryGroup)comboInvGroup.getData(comboInvGroup.getText()));
	
	}
	
	TableItem item;
	int listSize = result.size();
	for(int i =0; i<listSize;i++){
	Object[] objs=(Object[])result.get(i);
	TurqInventoryCard card = (TurqInventoryCard)objs[1];
	TurqViewInventoryAmountTotal invView=(TurqViewInventoryAmountTotal)((Object[])result.get(i))[0];
	item = new TableItem(tableSearcResults,SWT.NULL);
	item.setData(card);
	String totalAmountNow=(invView.getTransactionsTotalAmountNow()==null) ? "0" : invView.getTransactionsTotalAmountNow().toString();
	item.setText(new String[]{card.getCardInventoryCode(),card.getCardName(),totalAmountNow});
	
	
	}
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	
	
	
	
		
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
			InvUICardSearch inst = new InvUICardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,573,437);
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
	protected void tableSearcResultsMouseDoubleClick(MouseEvent evt){
    TableItem [] selection= tableSearcResults.getSelection();	
	
	if(selection.length>0){
	
	TurqInventoryCard card = (TurqInventoryCard)selection[0].getData();
	new InvUICardUpdateDialog(this.getShell(),SWT.NULL,card).open();
	search();
	
	}
	}
	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableSearcResults);
		
	}
	public void printTable(){
	    EngBLUtils.printTable(tableSearcResults,Messages.getString("InvUICardSearch.6")); //$NON-NLS-1$
	    
	}
}
