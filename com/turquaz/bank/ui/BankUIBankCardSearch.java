package com.turquaz.bank.ui;

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
* @author  Ceday
* @version  $Id$
*/


import java.util.List;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.bank.Messages;
import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.bl.EngBLUtils;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.turquaz.engine.ui.component.SearchComposite;
import org.eclipse.swt.custom.CCombo;


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
public class BankUIBankCardSearch extends  Composite implements SearchComposite {

	private CCombo comboCurrency;
	private CLabel lblCurrency;
	private TableColumn tableColumnCurrency;
	private TableColumn tableColumnAccountNo;
	private TableColumn tableColumnBankBrancName;
	private TableColumn tableColoumnBankName;
	private Text txtBankAccountNo;
	private CLabel lblBankAccountNo;
	private Text txtBankBranchName;
	private CLabel lblBankBranchName;
	private Text txtBankName;
	private CLabel lblBankName;
	private TableColumn tavleColumnDefinition;
	private Table tableBankCards;
	private Composite composite1;
	public BankUIBankCardSearch(Composite parent, int style) {
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
	
			composite1 = new Composite(this,SWT.NULL);
			lblBankName = new CLabel(composite1,SWT.NULL);
			txtBankName = new Text(composite1,SWT.NULL);
			lblBankBranchName = new CLabel(composite1,SWT.NULL);
			txtBankBranchName = new Text(composite1,SWT.NULL);
			lblBankAccountNo = new CLabel(composite1,SWT.NULL);
			txtBankAccountNo = new Text(composite1,SWT.NULL);
			lblCurrency = new CLabel(composite1,SWT.NULL);
			comboCurrency = new CCombo(composite1,SWT.NULL);
			tableBankCards = new Table(this,SWT.MULTI| SWT.FULL_SELECTION);
			tableColoumnBankName = new TableColumn(tableBankCards,SWT.NULL);
			tableColumnBankBrancName = new TableColumn(tableBankCards,SWT.NULL);
			tableColumnAccountNo = new TableColumn(tableBankCards,SWT.NULL);
			tableColumnCurrency = new TableColumn(tableBankCards,SWT.NULL);
	
			this.setSize(new org.eclipse.swt.graphics.Point(531,300));
	
			GridData composite1LData = new GridData();
			composite1LData.verticalAlignment = GridData.CENTER;
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.widthHint = -1;
			composite1LData.heightHint = 122;
			composite1LData.horizontalIndent = 0;
			composite1LData.horizontalSpan = 1;
			composite1LData.verticalSpan = 1;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1LData.grabExcessVerticalSpace = false;
			composite1.setLayoutData(composite1LData);
			composite1.setSize(new org.eclipse.swt.graphics.Point(521,122));
	
			GridData lblBankNameLData = new GridData();
			lblBankNameLData.verticalAlignment = GridData.CENTER;
			lblBankNameLData.horizontalAlignment = GridData.BEGINNING;
			lblBankNameLData.widthHint = -1;
			lblBankNameLData.heightHint = -1;
			lblBankNameLData.horizontalIndent = 0;
			lblBankNameLData.horizontalSpan = 1;
			lblBankNameLData.verticalSpan = 1;
			lblBankNameLData.grabExcessHorizontalSpace = false;
			lblBankNameLData.grabExcessVerticalSpace = false;
			lblBankName.setLayoutData(lblBankNameLData);
			lblBankName.setText(Messages.getString("BankUIBankCardSearch.0")); //$NON-NLS-1$
	
			GridData txtBankNameLData = new GridData();
			txtBankName.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode==SWT.CR)
						search();
				}
			});
			txtBankNameLData.verticalAlignment = GridData.CENTER;
			txtBankNameLData.horizontalAlignment = GridData.BEGINNING;
			txtBankNameLData.widthHint = 254;
			txtBankNameLData.heightHint = 13;
			txtBankNameLData.horizontalIndent = 0;
			txtBankNameLData.horizontalSpan = 1;
			txtBankNameLData.verticalSpan = 1;
			txtBankNameLData.grabExcessHorizontalSpace = false;
			txtBankNameLData.grabExcessVerticalSpace = false;
			txtBankName.setLayoutData(txtBankNameLData);
			txtBankName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lblBankBranchNameLData = new GridData();
			lblBankBranchNameLData.verticalAlignment = GridData.CENTER;
			lblBankBranchNameLData.horizontalAlignment = GridData.BEGINNING;
			lblBankBranchNameLData.widthHint = -1;
			lblBankBranchNameLData.heightHint = -1;
			lblBankBranchNameLData.horizontalIndent = 0;
			lblBankBranchNameLData.horizontalSpan = 1;
			lblBankBranchNameLData.verticalSpan = 1;
			lblBankBranchNameLData.grabExcessHorizontalSpace = false;
			lblBankBranchNameLData.grabExcessVerticalSpace = false;
			lblBankBranchName.setLayoutData(lblBankBranchNameLData);
			lblBankBranchName.setText(Messages.getString("BankUIBankCardSearch.1")); //$NON-NLS-1$
	
			GridData txtBankBranchNameLData = new GridData();
			txtBankBranchName.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode == SWT.CR)
						search();
				}
			});
			txtBankBranchNameLData.verticalAlignment = GridData.CENTER;
			txtBankBranchNameLData.horizontalAlignment = GridData.BEGINNING;
			txtBankBranchNameLData.widthHint = 254;
			txtBankBranchNameLData.heightHint = 13;
			txtBankBranchNameLData.horizontalIndent = 0;
			txtBankBranchNameLData.horizontalSpan = 1;
			txtBankBranchNameLData.verticalSpan = 1;
			txtBankBranchNameLData.grabExcessHorizontalSpace = false;
			txtBankBranchNameLData.grabExcessVerticalSpace = false;
			txtBankBranchName.setLayoutData(txtBankBranchNameLData);
			txtBankBranchName.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lblBankAccountNoLData = new GridData();
			lblBankAccountNoLData.verticalAlignment = GridData.CENTER;
			lblBankAccountNoLData.horizontalAlignment = GridData.BEGINNING;
			lblBankAccountNoLData.widthHint = -1;
			lblBankAccountNoLData.heightHint = -1;
			lblBankAccountNoLData.horizontalIndent = 0;
			lblBankAccountNoLData.horizontalSpan = 1;
			lblBankAccountNoLData.verticalSpan = 1;
			lblBankAccountNoLData.grabExcessHorizontalSpace = false;
			lblBankAccountNoLData.grabExcessVerticalSpace = false;
			lblBankAccountNo.setLayoutData(lblBankAccountNoLData);
			lblBankAccountNo.setText(Messages.getString("BankUIBankCardSearch.2")); //$NON-NLS-1$
	
			GridData txtBankAccountNoLData = new GridData();
			txtBankAccountNo.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode==SWT.CR)
						search();
				}
			});
			txtBankAccountNoLData.verticalAlignment = GridData.CENTER;
			txtBankAccountNoLData.horizontalAlignment = GridData.BEGINNING;
			txtBankAccountNoLData.widthHint = 254;
			txtBankAccountNoLData.heightHint = 13;
			txtBankAccountNoLData.horizontalIndent = 0;
			txtBankAccountNoLData.horizontalSpan = 1;
			txtBankAccountNoLData.verticalSpan = 1;
			txtBankAccountNoLData.grabExcessHorizontalSpace = false;
			txtBankAccountNoLData.grabExcessVerticalSpace = false;
			txtBankAccountNo.setLayoutData(txtBankAccountNoLData);
			txtBankAccountNo.setSize(new org.eclipse.swt.graphics.Point(254,13));
	
			GridData lblCurrencyLData = new GridData();
			lblCurrencyLData.verticalAlignment = GridData.CENTER;
			lblCurrencyLData.horizontalAlignment = GridData.BEGINNING;
			lblCurrencyLData.widthHint = -1;
			lblCurrencyLData.heightHint = -1;
			lblCurrencyLData.horizontalIndent = 0;
			lblCurrencyLData.horizontalSpan = 1;
			lblCurrencyLData.verticalSpan = 1;
			lblCurrencyLData.grabExcessHorizontalSpace = false;
			lblCurrencyLData.grabExcessVerticalSpace = false;
			lblCurrency.setLayoutData(lblCurrencyLData);
			lblCurrency.setText(Messages.getString("BankUIBankCardSearch.3")); //$NON-NLS-1$
	
			GridData comboCurrencyLData = new GridData();
			comboCurrencyLData.widthHint = 67;
			comboCurrencyLData.heightHint = 16;
			comboCurrency.setLayoutData(comboCurrencyLData);
			GridLayout composite1Layout = new GridLayout(2, true);
			composite1.setLayout(composite1Layout);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 2;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
			composite1.layout();
	
			GridData tableBankCardsLData = new GridData();
			tableBankCardsLData.verticalAlignment = GridData.FILL;
			tableBankCardsLData.horizontalAlignment = GridData.FILL;
			tableBankCardsLData.widthHint = -1;
			tableBankCardsLData.heightHint = -1;
			tableBankCardsLData.horizontalIndent = 0;
			tableBankCardsLData.horizontalSpan = 1;
			tableBankCardsLData.verticalSpan = 1;
			tableBankCardsLData.grabExcessHorizontalSpace = false;
			tableBankCardsLData.grabExcessVerticalSpace = true;
			tableBankCards.setLayoutData(tableBankCardsLData);
			tableBankCards.setHeaderVisible(true);
			tableBankCards.setLinesVisible(true);
			tableBankCards.setSize(new org.eclipse.swt.graphics.Point(505,147));
			tableBankCards.addMouseListener( new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableBankCardsMouseDoubleClick(evt);
				}
			});
	
			tableColoumnBankName.setText(Messages.getString("BankUIBankCardSearch.4")); //$NON-NLS-1$
			tableColoumnBankName.setWidth(120);
	
			tableColumnBankBrancName.setText(Messages.getString("BankUIBankCardSearch.5")); //$NON-NLS-1$
			tableColumnBankBrancName.setWidth(120);
	
			
			tableColumnAccountNo.setText(Messages.getString("BankUIBankCardSearch.6")); //$NON-NLS-1$
			tableColumnAccountNo.setWidth(120);
	
			tableColumnCurrency.setText(Messages.getString("BankUIBankCardSearch.7")); //$NON-NLS-1$
			tableColumnCurrency.setWidth(120);
			{
				tavleColumnDefinition = new TableColumn(
					tableBankCards,
					SWT.NONE);
				tavleColumnDefinition.setText(Messages.getString("BankUIBankCardSearch.8")); //$NON-NLS-1$
				tavleColumnDefinition.setWidth(150);
			}
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
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
			FillCurrencyCombo();			
		}
		catch(Exception ex){
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
	}
	
	private void FillCurrencyCombo() throws Exception
	{
		try{
			comboCurrency.removeAll();
			comboCurrency.setText(""); //$NON-NLS-1$
			List currencies=EngBLCommon.getCurrencies();
			for(int k=0; k<currencies.size(); k++){
				TurqCurrency currency=(TurqCurrency)currencies.get(k);
				comboCurrency.add(currency.getCurrenciesAbbreviation());
				comboCurrency.setData(currency.getCurrenciesAbbreviation(),currency);
				
			}
		}
		catch(Exception ex){
			throw ex;
		}
	}

	public void delete(){
	}
	
	public void save(){
	}
	
	public void newForm(){
	}
	
	public void search()
	{
		try
		{
			tableBankCards.removeAll();
			List listBankCards=BankBLBankCardSearch.searchBankCards(txtBankName.getText().trim(),
																txtBankBranchName.getText().trim(),
																txtBankAccountNo.getText().trim(),
																(TurqCurrency)(comboCurrency.getData(comboCurrency.getText())));
			Object[] result;
			for(int k=0; k<listBankCards.size(); k++)
			{
				result=(Object[])listBankCards.get(k);
				TableItem item=new TableItem(tableBankCards, SWT.NULL);
				
				Integer bankId=(Integer)result[0];
				String bankName=(String)result[1];
				String bankBranchName=(String)result[2];
				String bankAccNo=(String)result[3];
				String abbr=(String) result[4];
				String bankDefinition=(String)result[5];				
				
				item.setData(bankId);
				item.setText(new String[]{bankName,
						bankBranchName,
						bankAccNo,
						abbr,
						bankDefinition});
			}

		}
		catch(Exception ex){
			MessageBox msg= new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());	
			msg.open();
			ex.printStackTrace();
		}
	}

	public void exportToExcel(){
		
		EngBLUtils.Export2Excel(tableBankCards);
		
	}
	/** Auto-generated event handler method */
	protected void tableBankCardsMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem [] selection= tableBankCards.getSelection();	
	
			if(selection.length>0)
			{
				Integer bankId=(Integer)selection[0].getData();
				TurqBanksCard card = BankBLBankCardSearch.getBankCardByBankCardId(bankId);
				BankBLBankCardSearch.initializeBankCard(card);
				boolean updated=new BankUIBankCardUpdate(this.getShell(),SWT.NULL,card).open();
				if (updated)
					search();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg=new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
	}
	public void printTable(){
	    EngBLUtils.printTable(tableBankCards,Messages.getString("BankUIBankCardSearch.9")); //$NON-NLS-1$
	    
	}
}
