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

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.SWT;

import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.CoolItem;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.CoolBar;
import org.eclipse.swt.widgets.Dialog;

import com.turquaz.inventory.Messages;
import com.turquaz.inventory.bl.InvBLCardUpdate;
import com.turquaz.inventory.ui.InvUICardAdd;
import com.turquaz.inventory.ui.comp.InvUIPrice;
import com.turquaz.inventory.ui.comp.InvUIPriceList;

import com.turquaz.engine.bl.EngBLPermissions;
import com.turquaz.engine.dal.TurqAccountingAccount;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqInventoryUnit;
import com.turquaz.engine.ui.component.NumericText;


import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

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
public class InvUICardUpdateDialog extends Dialog{

	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this.getParent());
	}

	private InvUICardAdd compInvUICard;
	private Composite compMain;
	private ToolItem toolCancel;
	private ToolItem toolDelete;
	private ToolItem toolUpdate;
	private ToolBar toolBarTop;
	private CoolItem coolTop;
	private CoolBar coolBarTop;
	private Shell dialogShell;
    private TurqInventoryCard invCard;
    private InvBLCardUpdate cardUpdate = new InvBLCardUpdate();


	
	public InvUICardUpdateDialog(Shell parent, int style,TurqInventoryCard invCard) {
		super(parent, style);
		this.invCard = invCard;
	}

	/**
	* Opens the Dialog Shell.
	* Auto-generated code - any changes you make will disappear.
	*/
	public void open(){
		try {
			preInitGUI();
	
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText(getText());
			coolBarTop = new CoolBar(dialogShell,SWT.NULL);
			coolTop = new CoolItem(coolBarTop,SWT.DROP_DOWN);
			toolBarTop = new ToolBar(coolBarTop,SWT.SHADOW_OUT);
			toolUpdate = new ToolItem(toolBarTop,SWT.NULL);
			toolDelete = new ToolItem(toolBarTop,SWT.NULL);
			compMain = new Composite(dialogShell,SWT.NULL);
			compInvUICard = new InvUICardAdd(compMain,SWT.NULL);
	
			dialogShell.setSize(613, 367);
	
			GridData coolBarTopLData = new GridData();
			coolBarTopLData.horizontalAlignment = GridData.FILL;
			coolBarTopLData.heightHint = 52;
			coolBarTopLData.grabExcessHorizontalSpace = true;
			coolBarTop.setLayoutData(coolBarTopLData);

			coolTop.setControl(toolBarTop);
			coolTop.setSize(45, 49);
			coolTop.setPreferredSize(new org.eclipse.swt.graphics.Point(45, 49));
			coolTop.setMinimumSize(new org.eclipse.swt.graphics.Point(45, 49));
	
	
			toolUpdate.setText(Messages.getString("InvUICardUpdateDialog.0")); //$NON-NLS-1$
			toolUpdate.setImage(SWTResourceManager.getImage("icons/save_edit.gif")); //$NON-NLS-1$
			toolUpdate.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolUpdateWidgetSelected(evt);
				}
			});
	
			toolDelete.setText(Messages.getString("InvUICardUpdateDialog.9")); //$NON-NLS-1$
			toolDelete.setToolTipText(Messages.getString("InvUICardUpdateDialog.1")); //$NON-NLS-1$
			toolDelete.setImage(SWTResourceManager.getImage("icons/Delete16.gif")); //$NON-NLS-1$
			{
				toolCancel = new ToolItem(toolBarTop, SWT.NONE);
				toolCancel.setText(Messages.getString("InvUICardUpdateDialog.2")); //$NON-NLS-1$
				toolCancel.setImage(SWTResourceManager.getImage("icons/cancel.jpg")); //$NON-NLS-1$
				toolCancel.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						dialogShell.close();
					}
				});
			}
			toolDelete.addSelectionListener( new SelectionAdapter() {
				public void widgetSelected(SelectionEvent evt) {
					toolDeleteWidgetSelected(evt);
				}
			});
	
			GridData compMainLData = new GridData();
			compMainLData.verticalAlignment = GridData.FILL;
			compMainLData.horizontalAlignment = GridData.FILL;
			compMainLData.widthHint = -1;
			compMainLData.heightHint = -1;
			compMainLData.horizontalIndent = 0;
			compMainLData.horizontalSpan = 1;
			compMainLData.verticalSpan = 1;
			compMainLData.grabExcessHorizontalSpace = true;
			compMainLData.grabExcessVerticalSpace = true;
			compMain.setLayoutData(compMainLData);
			compMain.setSize(new org.eclipse.swt.graphics.Point(603,306));
	
			compInvUICard.setSize(new org.eclipse.swt.graphics.Point(603,306));
			compInvUICard.layout();
			FillLayout compMainLayout = new FillLayout(256);
			compMain.setLayout(compMainLayout);
			compMainLayout.type = SWT.HORIZONTAL;
			compMainLayout.marginWidth = 0;
			compMainLayout.marginHeight = 0;
			compMainLayout.spacing = 0;
			compMain.layout();
			GridLayout dialogShellLayout = new GridLayout(1, true);
			dialogShell.setLayout(dialogShellLayout);
			dialogShellLayout.marginWidth = 5;
			dialogShellLayout.marginHeight = 5;
			dialogShellLayout.numColumns = 1;
			dialogShellLayout.makeColumnsEqualWidth = true;
			dialogShellLayout.horizontalSpacing = 5;
			dialogShellLayout.verticalSpacing = 5;
			dialogShell.layout();
			Rectangle bounds = dialogShell.computeTrim(0, 0, 613,348);
			dialogShell.setSize(bounds.width, bounds.height);
			postInitGUI();
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/** Add your pre-init code in here 	*/
	public void preInitGUI(){
	}

	/** Add your post-init code in here 	*/
	public void postInitGUI(){
	    
		toolUpdate.setEnabled(false);
		toolDelete.setEnabled(false);
		    
		if(EngBLPermissions.getPermission(compInvUICard.getClass().getName())==2){
		    toolUpdate.setEnabled(true); 
		}
		else if(EngBLPermissions.getPermission(compInvUICard.getClass().getName())==3){
		    toolDelete.setEnabled(true);
		    toolUpdate.setEnabled(true); 
		}    
	    
	
	Point parentLocation =this.getParent().getLocation();
	Point parentSize = this.getParent().getSize();	
    Point dialogSize = dialogShell.getSize();
     
    int location_X = (parentLocation.x + parentSize.x)/2 - (dialogSize.x/2);
    int location_Y = (parentLocation.y + parentSize.y)/2 - (dialogSize.y/2);
    
    dialogShell.setLocation(location_X,location_Y);
	
	setButtonPermissions();
		
	compInvUICard.getTxtInvCardCode().setText(invCard.getCardInventoryCode());
	compInvUICard.getTxtInvCardDefinition().setText(invCard.getCardDefinition());
	compInvUICard.getTxtInvCardDiscount().setText(invCard.getCardDiscount());
	compInvUICard.getTxtInvCardInAcc().setData(invCard.getTurqAccountingAccountByAccountingAccountsIdBuy());
	compInvUICard.getTxtInvCardInAcc().setData(invCard.getTurqAccountingAccountByAccountingAccountsIdBuy());
	compInvUICard.getTxtInvCardName().setText(invCard.getCardName());
	compInvUICard.getTxtInvCardOutAcc().setData(invCard.getTurqAccountingAccountByAccountingAccountsIdSell());
	compInvUICard.getTxtInvCardOutAcc().setData(invCard.getTurqAccountingAccountByAccountingAccountsIdSell());
	compInvUICard.getTxtInvCardVat().setText(invCard.getCardVat());
	compInvUICard.getTxtnumInvCardMax().setText(invCard.getCardMaximumAmount());
	compInvUICard.getTxtnumInvCardMin().setText(invCard.getCardMinimumAmount());
	compInvUICard.getNumTextSpecailVATPercent().setText(invCard.getCardSpecialVat());
	compInvUICard.getDecTextSpecialVatAmount().setText(invCard.getCardSpecialVatEach().toString());
	fillUnits();
	fillGroups();
	fillPrices();
	
	
		
	}
	public void setButtonPermissions(){

	int level = EngBLPermissions.getPermission(compInvUICard.getClass().getName());
	if(level==3){
		toolDelete.setEnabled(true);
		toolUpdate.setEnabled(true);
	}
	else{
		toolDelete.setEnabled(false);
		toolUpdate.setEnabled(false);		
	}
	
	
	}
	
	public void fillPrices(){
	try {
	
	Iterator it = invCard.getTurqInventoryPrices().iterator();
	TurqInventoryPrice invPrice;
	InvUIPriceList priceList = compInvUICard.getPriceList();
	while(it.hasNext()){
     
     invPrice = (TurqInventoryPrice)it.next();
     InvUIPrice price = new InvUIPrice();
     price.priceType=Messages.getString("InvUICardUpdateDialog.3"); //$NON-NLS-1$
     if(invPrice.isPricesType()){
     price.priceType =Messages.getString("InvUICardUpdateDialog.4"); //$NON-NLS-1$
     }
     price.amount =invPrice.getPricesAmount().toString();
     price.abrev = invPrice.getTurqCurrency().getCurrenciesAbbreviation();
     priceList.addPrice(price);
              
     }
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	
	
	}
	
	public void fillGroups(){
	try {
	
	Iterator it = invCard.getTurqInventoryCardGroups().iterator();
    TurqInventoryCardGroup cardGroup; 
    TurqInventoryGroup group;
    Table tableRegisteredGroups = compInvUICard.getTableInvCardAddGroupsRegisteredGroups();
   
    while(it.hasNext()){
     
     cardGroup = (TurqInventoryCardGroup)it.next();
     String groupName = cardGroup.getTurqInventoryGroup().getGroupsName();
       TableItem registeredItem = new TableItem(
							tableRegisteredGroups, SWT.NULL);
	 registeredItem.setText(groupName);
	 registeredItem.setData(cardGroup.getTurqInventoryGroup());
     removeRegisteredGroup(groupName);
     }
	
	
	
	
	
	}
	catch(Exception ex){
	ex.printStackTrace();
	}
	}
	
    public void fillUnits(){
    try{
    
    	
    Iterator it = invCard.getTurqInventoryCardUnits().iterator();
    TurqInventoryCardUnit cardUnit; 
    TurqInventoryUnit unit;
    Table tableRegisteredUnits = compInvUICard.getTableInvCardAddRegisteredUnits();
    while(it.hasNext()){   
    
     cardUnit = (TurqInventoryCardUnit)it.next();
     if(cardUnit.getCardUnitsFactor()==1){
         
     compInvUICard.getComboInvCardUnits().setText( cardUnit.getTurqInventoryUnit().getUnitsName());
     
     }
     else {
     String unitName= cardUnit.getTurqInventoryUnit().getUnitsName();
      TableItem registeredItem = new TableItem(
							tableRegisteredUnits, SWT.NULL);
					registeredItem.setText(unitName);
					registeredItem.setData(cardUnit.getTurqInventoryUnit());
					TableEditor editor = new TableEditor(
							tableRegisteredUnits);
					editor.grabHorizontal = true;
					NumericText nText = new NumericText(
							tableRegisteredUnits, SWT.NONE);
					nText.setText(cardUnit.getCardUnitsFactor());
					editor.setEditor(nText, registeredItem, 1);
					compInvUICard.mapEditorsTableInvCardAddRegisteredUnits.put(unitName,
							editor); 
			removeRegisteredUnit(unitName);				
     	
     }
     
    }
    }
     catch(Exception ex){
     ex.printStackTrace();
     }
        
    }
    public void removeRegisteredGroup(String groupName){
     TableItem items[] = compInvUICard.getTableInvCardAddGroupsAllGroups().getItems();
     for(int i=0;i<items.length;i++){
     if(items[i].getText().equals(groupName)){
      compInvUICard.getTableInvCardAddGroupsAllGroups().remove(i);
      break;
     }
     }
     }
     public void removeRegisteredUnit(String unitName){
     TableItem items[] = compInvUICard.getTableInvCardAddAllUnits().getItems();
     for(int i=0;i<items.length;i++){
     if(items[i].getText().equals(unitName)){
      compInvUICard.getTableInvCardAddAllUnits().remove(i);
      break;
     }
     }
     
     
     
    } 
    
    public void updateInvUnits(){
    try{
    
   
    //First remove groups then re-add them..
	Iterator it = invCard.getTurqInventoryCardUnits().iterator();
    TurqInventoryCardUnit cardUnit; 
 
    while(it.hasNext()){   
    
     cardUnit = (TurqInventoryCardUnit)it.next();
     cardUpdate.deleteObject(cardUnit);				
	}
   compInvUICard.saveInvUnits(invCard.getInventoryCardsId());
   
    }
    
    catch(Exception ex){
    ex.printStackTrace();
    }
   }
 public void deleteInvUnits(){
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
   
   
   public void updateInvGroups(){
   try{
   Iterator it = invCard.getTurqInventoryCardGroups().iterator();
    TurqInventoryCardGroup cardGroup; 
      
    while(it.hasNext()){
     
     cardGroup = (TurqInventoryCardGroup)it.next();
     cardUpdate.deleteObject(cardGroup);
     }
   
    compInvUICard.saveInvGroups(invCard.getInventoryCardsId());
   
   }
   catch(Exception ex){
   ex.printStackTrace();
   
   }
   
   }
   public void updatePrices(){
   try{
   Iterator it = invCard.getTurqInventoryPrices().iterator();
   TurqInventoryPrice invPrice;
	
	while(it.hasNext()){
     
     invPrice = (TurqInventoryPrice)it.next();
    
     cardUpdate.deleteObject(invPrice);
    
              
     }
     compInvUICard.saveInvPrices(invCard.getInventoryCardsId());
	
   
   
   
   
   
   
   }
   catch(Exception ex){
   ex.printStackTrace();
   }
   
   
   
   }
   public void deletePrices(){
   try{
   Iterator it = invCard.getTurqInventoryPrices().iterator();
   TurqInventoryPrice invPrice;
	
	while(it.hasNext()){
     
     invPrice = (TurqInventoryPrice)it.next();
    
     cardUpdate.deleteObject(invPrice);
    
              
     }
    }
   catch(Exception ex){
   	MessageBox msg = new MessageBox(this.getParent(),SWT.ICON_ERROR);
   	msg.setMessage(ex.getMessage());
    ex.printStackTrace();
   }
     
   
   }
    
    public void update(){
    try {
    if(compInvUICard.verifyFields()){
    
    // Update Inventory Card Fields
   TurqAccountingAccount accountIdSell = (TurqAccountingAccount) compInvUICard.getTxtInvCardOutAcc().getData();
   TurqAccountingAccount accountIdBuy = (TurqAccountingAccount) compInvUICard.getTxtInvCardInAcc().getData();
       
    cardUpdate.updateInvCard(compInvUICard.getTxtInvCardCode().getText()
						.trim(), compInvUICard.getTxtInvCardName().getText().trim(), compInvUICard.getTxtInvCardDefinition().getText().trim(),
						 compInvUICard.getTxtnumInvCardMin().getIntValue(),compInvUICard.getTxtnumInvCardMax().getIntValue(),
						compInvUICard.getTxtInvCardVat().getIntValue(), compInvUICard.getTxtInvCardDiscount().getIntValue(), accountIdBuy, accountIdSell,
						compInvUICard.getNumTextSpecailVATPercent().getIntValue()
						,compInvUICard.getDecTextSpecialVatAmount().getBigDecimalValue(),invCard);	
	
	 //Update Inventory Groups			
	updateInvUnits();
	updateInvGroups();
	updatePrices();
	MessageBox msg = new MessageBox(this.getParent(),SWT.NULL);
	msg.setMessage(Messages.getString("InvUICardUpdateDialog.5"));	 //$NON-NLS-1$
	msg.open();	
	this.dialogShell.close();
	}
	}
		catch(Exception ex){
		ex.printStackTrace();
		
		}
		
     
    }
    
    public void delete(){
    	MessageBox msg=new MessageBox(this.getParent(),SWT.YES|SWT.NO);
      try{
      
      msg.setMessage(Messages.getString("InvUICardUpdateDialog.7")); //$NON-NLS-1$
      if (msg.open()==SWT.NO)
       return;
     
     // if the inventory card contains transactions 
     if(cardUpdate.hasTransactions(invCard))
     {
     	MessageBox msg2 = new MessageBox(this.getParent(),SWT.ICON_WARNING);
    	msg2.setMessage("Inventory card contains transactions and \ncan not be deleted. Delete them first. ");  //$NON-NLS-1$
		msg2.open();
		return;
     }
    //First Delete Groups
    deleteInvGroups();
    //delete Units
    deleteInvUnits();
    // delete Prices
    deletePrices();
    // delete invCard
    
    cardUpdate.deleteObject(invCard);
    msg = new MessageBox(this.getParent(),SWT.NULL);
	msg.setMessage(Messages.getString("InvUICardUpdateDialog.6"));	 //$NON-NLS-1$
	msg.open();	 
	this.dialogShell.dispose(); 
       
           
    }
    catch(Exception ex){
    	
    ex.printStackTrace();	
    msg = new MessageBox(this.getParent(),SWT.ICON_ERROR);	
    msg.setMessage(ex.getMessage());
    msg.open();
    dialogShell.close();
 
    
    }
    
    
    }
      
   public void deleteInvGroups(){
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
	

	/** Auto-generated event handler method */
	protected void toolUpdateWidgetSelected(SelectionEvent evt){
		update();
	}

	/** Auto-generated event handler method */
	protected void toolDeleteWidgetSelected(SelectionEvent evt){
		delete();
	}
}
