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
* @author  Cem Dayanik
* @version  $Id$
*/

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqInventoryCard;
import com.turquaz.engine.dal.TurqInventoryCardGroup;
import com.turquaz.engine.dal.TurqInventoryCardUnit;
import com.turquaz.engine.dal.TurqInventoryGroup;
import com.turquaz.engine.dal.TurqInventoryPrice;
import com.turquaz.engine.dal.TurqViewInventoryTotal;
import com.turquaz.engine.ui.component.SearchComposite;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

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
import com.turquaz.inventory.ui.comp.InventoryPicker;
import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.current.ui.comp.CurrentCodePicker;
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


public class InvUITransactionsTotalReport extends  Composite implements SearchComposite {

	private InvBLCardAdd invBLCardAdd = new InvBLCardAdd();
	InvBLCardUpdate cardUpdate = new InvBLCardUpdate();
	private Composite compInvCardSearch;
	private CLabel lblInvName;
	private TableColumn tableColumnInvName;
	private CCombo comboTransType;
	private CurrentCodePicker txtCurCardEnd;
	private CLabel lblCurCardEnd;
	private CLabel lblTransType;
	private CurrentCodePicker txtCurCardStart;
	private CLabel lblCurCardStart;
	private TableColumn tableColumnAmountIn;
	private TableColumn tableColumnInventoryCode;
	private TableColumn tableColumnAmountOut;
	private TableColumn tableColumnBalanceAmountIn;
	private TableColumn tableColumnBalanceAmountOut;
	private TableColumn tableColumnPriceIn;
	private TableColumn tableColumnPriceOut;
	private Table tableSearcResults;
	private CCombo comboInvGroup;
	private CLabel lblInvGroup;
	private Text txtInvName;
	private InventoryPicker txtInvCode;
	private CLabel lblInvCode;
	private Composite compInvCardSearchPanel;
	InvBLCardSearch cardSearch = new InvBLCardSearch();
	public InvUITransactionsTotalReport(Composite parent, int style) {
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
				compInvCardSearch.setSize(600, 437);
				compInvCardSearchLayout.makeColumnsEqualWidth = true;
				compInvCardSearch.setLayout(compInvCardSearchLayout);
				{
					compInvCardSearchPanel = new Composite(compInvCardSearch, SWT.NONE);
					GridLayout compInvCardSearchPanelLayout = new GridLayout();
					compInvCardSearchPanelLayout.numColumns = 4;
					GridData compInvCardSearchPanelLData = new GridData();
					compInvCardSearchPanel.setLayout(compInvCardSearchPanelLayout);
					compInvCardSearchPanelLData.horizontalAlignment = GridData.FILL;
					compInvCardSearchPanelLData.heightHint = 71;
					compInvCardSearchPanelLData.grabExcessHorizontalSpace = true;
					compInvCardSearchPanel.setLayoutData(compInvCardSearchPanelLData);
					{
						lblInvCode = new CLabel(compInvCardSearchPanel, SWT.NONE);
						GridData cLabel2LData = new GridData();
						cLabel2LData.widthHint = 97;
						cLabel2LData.heightHint = 17;
						lblInvCode.setLayoutData(cLabel2LData);
						lblInvCode.setText(Messages.getString("InvUITransactionsTotalReport.0")); //$NON-NLS-1$
						lblInvCode.setSize(new org.eclipse.swt.graphics.Point(
							97,
							17));
					}
					{
						txtInvCode = new InventoryPicker(compInvCardSearchPanel, SWT.NONE);
						GridData txtInvCodeLData = new GridData();
						txtInvCodeLData.widthHint = 141;
						txtInvCodeLData.heightHint = 17;
						txtInvCode.setLayoutData(txtInvCodeLData);
						txtInvCode.setSize(new org.eclipse.swt.graphics.Point(147,17));
					}
					{
						lblInvName = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvName.setText(Messages.getString("InvUITransactionsTotalReport.1")); //$NON-NLS-1$
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
						lblCurCardStart = new CLabel(
							compInvCardSearchPanel,
							SWT.NONE);
						lblCurCardStart.setText("Cari Kart - Ba?lang?ç");
					}
					{
						txtCurCardStart = new CurrentCodePicker(compInvCardSearchPanel, SWT.NONE);
						GridData txtCurCardLData = new GridData();
						txtCurCardLData.widthHint = 148;
						txtCurCardLData.heightHint = 16;
						txtCurCardStart.setLayoutData(txtCurCardLData);
					}
					{
						lblCurCardEnd = new CLabel(
							compInvCardSearchPanel,
							SWT.NONE);
						lblCurCardEnd.setText("Cari Kart - Biti?");
					}
					{
						txtCurCardEnd = new CurrentCodePicker(
							compInvCardSearchPanel,
							SWT.NONE);
						GridData txtCurCardEndLData = new GridData();
						txtCurCardEndLData.widthHint = 167;
						txtCurCardEndLData.heightHint = 12;
						txtCurCardEnd.setLayoutData(txtCurCardEndLData);
					}
					{
						lblInvGroup = new CLabel(compInvCardSearchPanel, SWT.NONE);
						lblInvGroup.setText(Messages.getString("InvUITransactionsTotalReport.2")); //$NON-NLS-1$
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
					{
						lblTransType = new CLabel(
							compInvCardSearchPanel,
							SWT.NONE);
						lblTransType.setText("Tipi");
						GridData lblTransTypeLData = new GridData();
						lblTransTypeLData.widthHint = 48;
						lblTransTypeLData.heightHint = 17;
						lblTransType.setLayoutData(lblTransTypeLData);
					}
					{
						comboTransType = new CCombo(
							compInvCardSearchPanel,
							SWT.NONE);
						comboTransType.setText("Hepsi");
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
						tableColumnInvName.setText(Messages.getString("InvUITransactionsTotalReport.3")); //$NON-NLS-1$
						tableColumnInvName.setWidth(69);
						
						
						
						
					}
					{
						tableColumnInventoryCode = new TableColumn(
							tableSearcResults,
							SWT.NONE);
						tableColumnInventoryCode.setText(Messages.getString("InvUICardSearch.4"));  //$NON-NLS-1$
						tableColumnInventoryCode.setWidth(107);
					}
					{
						tableColumnAmountIn = new TableColumn(
							tableSearcResults,
							SWT.RIGHT);
						tableColumnAmountIn.setText(Messages.getString("InvUICardSearch.5"));  //$NON-NLS-1$
						tableColumnAmountIn.setWidth(60);
					}
					{
						tableColumnAmountOut = new TableColumn(
							tableSearcResults,
							SWT.RIGHT);
						tableColumnAmountOut.setText(Messages.getString("InvUICardSearch.7"));  //$NON-NLS-1$
						tableColumnAmountOut.setWidth(60);
					}
					{
						tableColumnBalanceAmountIn = new TableColumn(
							tableSearcResults,
							SWT.RIGHT);
						tableColumnBalanceAmountIn.setText(Messages.getString("InvUICardSearch.8"));  //$NON-NLS-1$
						tableColumnBalanceAmountIn.setWidth(69);
					}
					{
						tableColumnBalanceAmountOut = new TableColumn(
							tableSearcResults,
							SWT.RIGHT);
						tableColumnBalanceAmountOut.setText(Messages.getString("InvUICardSearch.9"));  //$NON-NLS-1$
						tableColumnBalanceAmountOut.setWidth(71);
					}
					{
						tableColumnPriceIn = new TableColumn(
							tableSearcResults,
							SWT.RIGHT);
						tableColumnPriceIn.setText(Messages.getString("InvUICardSearch.10"));  //$NON-NLS-1$
						tableColumnPriceIn.setWidth(75);
					}
					{
						tableColumnPriceOut = new TableColumn(
							tableSearcResults,
							SWT.RIGHT);
						tableColumnPriceOut.setText(Messages.getString("InvUICardSearch.11"));  //$NON-NLS-1$
						tableColumnPriceOut.setWidth(76);
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
	public void deleteInvUnits(TurqInventoryCard invCard)
	{
	    try
		{	    
	
	    	//First remove groups then re-add them..
	    	Iterator it = invCard.getTurqInventoryCardUnits().iterator();
	    	TurqInventoryCardUnit cardUnit; 
	 
	    	while(it.hasNext())
	    	{   
	    
	    		cardUnit = (TurqInventoryCardUnit)it.next();
	    		cardUpdate.deleteObject(cardUnit);				
	    	} 
	   
	    }
	    
	    catch(Exception ex)
		{
	    	ex.printStackTrace();
	    }
	 }
	 public void deleteInvGroups(TurqInventoryCard invCard)
	 {
	     try
		 {
	     	Iterator it = invCard.getTurqInventoryCardGroups().iterator();
	     	TurqInventoryCardGroup cardGroup; 
	        
	     	while(it.hasNext())
	     	{
	       
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
	   try{
	    
	     InvBLCardSearch blCardSearch = new InvBLCardSearch();
		   blCardSearch.initializeInventoryCard(invCard);
	   }
	   catch(Exception ex){
	   	ex.printStackTrace();
	   }
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
	    search();	       
	           
	    }
	    catch(Exception ex)
		{
	    	
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
	
	
	String invCode = objs[1].toString();
	String invName = objs[2].toString();
	Integer cardId = (Integer)objs[3];
	
	
	TurqViewInventoryTotal invView=(TurqViewInventoryTotal)((Object[])result.get(i))[0];
	item = new TableItem(tableSearcResults,SWT.NULL);
	
	item.setData(cardId);
	
	BigDecimal totalAmountIn =(invView.getTotalAmountIn()==null) ? new BigDecimal(0): invView.getTotalAmountIn();
	BigDecimal totalAmountOut = (invView.getTotalAmountOut()==null) ? new BigDecimal(0) : invView.getTotalAmountOut();
	BigDecimal totalPriceIn = (invView.getTotalPriceIn()==null) ? new BigDecimal(0) : invView.getTotalPriceIn();
	BigDecimal totalPriceOut = (invView.getTotalPriceOut()==null)?new BigDecimal(0) : invView.getTotalPriceOut();	
	
	BigDecimal balanceAmountIn = new BigDecimal(0);
	BigDecimal balanceAmountOut = new BigDecimal(0);	
	
	if((totalAmountIn.subtract(totalAmountOut).doubleValue()<=0)){
		balanceAmountOut = totalAmountOut.subtract(totalAmountIn);
		
	}
	
	else{
		balanceAmountIn = totalAmountIn.subtract(totalAmountOut);
		
	}
	
	TurkishCurrencyFormat format = new TurkishCurrencyFormat();
	
	item.setText(new String[]{invCode,
							  invName,
					          totalAmountIn.toString(),
							  totalAmountOut.toString(),
							  balanceAmountIn.toString(),
							  balanceAmountOut.toString(),
							  format.format(totalPriceIn),
							  format.format(totalPriceOut)
							  });
	
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
			InvUITransactionsTotalReport inst = new InvUITransactionsTotalReport(shell, SWT.NULL);
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
	try{
	Integer cardId = (Integer)selection[0].getData();
	TurqInventoryCard card = cardSearch.initializeInventoryCard(cardId);
	boolean updated=new InvUICardUpdateDialog(this.getShell(),SWT.NULL,card).open();
	if (updated)
		search();
	}
	
	
	catch(Exception ex)
	{
	    ex.printStackTrace();
	}
	}
	}
	public void exportToExcel()
	{
		
		EngBLUtils.Export2Excel(tableSearcResults);
		
	}	
	public void printTable()
	{
	    EngBLUtils.printTable(tableSearcResults,""); //$NON-NLS-1$
	    
	}	
}
