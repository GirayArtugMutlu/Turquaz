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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.bank.bl.BankBLBankCardSearch;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.engine.dal.TurqBanksCard;
import com.turquaz.engine.dal.TurqCurrency;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.component.SecureComposite;
import org.eclipse.swt.custom.CCombo;


/**
* This code was generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a
* for-profit company or business) then you should purchase
* a license - please visit www.cloudgarden.com for details.
*/
public class BankUIBankCardSearch extends  Composite implements SecureComposite {

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
	private Table tableBankCards;
	private Composite composite1;
	public BankUIBankCardSearch(Composite parent, int style) {
		super(parent, style);
		initGUI();
	}
	
	private BankBLBankCardSearch bankBLBankCardSearch= new BankBLBankCardSearch();
	private EngBLCommon engBLCom=new EngBLCommon();
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
			lblBankName.setText("Bank Name");
	
			GridData txtBankNameLData = new GridData();
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
			lblBankBranchName.setText("Bank Branch Name");
	
			GridData txtBankBranchNameLData = new GridData();
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
			lblBankAccountNo.setText("Bank Account No");
	
			GridData txtBankAccountNoLData = new GridData();
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
			lblCurrency.setText("Currency");
	
			GridData comboCurrencyLData = new GridData();
			comboCurrencyLData.verticalAlignment = GridData.CENTER;
			comboCurrencyLData.horizontalAlignment = GridData.BEGINNING;
			comboCurrencyLData.widthHint = -1;
			comboCurrencyLData.heightHint = -1;
			comboCurrencyLData.horizontalIndent = 0;
			comboCurrencyLData.horizontalSpan = 1;
			comboCurrencyLData.verticalSpan = 1;
			comboCurrencyLData.grabExcessHorizontalSpace = false;
			comboCurrencyLData.grabExcessVerticalSpace = false;
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
	
			tableColoumnBankName.setText("Bank Name");
			tableColoumnBankName.setWidth(120);
	
			tableColumnBankBrancName.setText("Branch Name");
			tableColumnBankBrancName.setWidth(120);
	
			tableColumnAccountNo.setText("Account No");
			tableColumnAccountNo.setWidth(120);
	
			tableColumnCurrency.setText("Currency");
			tableColumnCurrency.setWidth(120);
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
			comboCurrency.setText("");
			List currencies=engBLCom.getCurrencies();
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
	
	public void search(){
		try{
			tableBankCards.removeAll();
			List listBankCards=bankBLBankCardSearch.searchBankCards(txtBankName.getText().trim(),
																txtBankBranchName.getText().trim(),
																txtBankAccountNo.getText().trim(),
																(TurqCurrency)(comboCurrency.getData(comboCurrency.getText())));
			for(int k=0; k<listBankCards.size(); k++){
				TurqBanksCard aBankCard=(TurqBanksCard)listBankCards.get(k);
				TableItem item=new TableItem(tableBankCards, SWT.NULL);
				item.setData(aBankCard);
				item.setText(new String[]{aBankCard.getBankName(),aBankCard.getBankBranchName(),aBankCard.getBankAccountNo(),aBankCard.getTurqCurrency().getCurrenciesAbbreviation()});
			}
			System.out.println(listBankCards.size());
		}
		catch(Exception ex){
			MessageBox msg= new MessageBox(this.getShell(),SWT.NULL);
			msg.setMessage(ex.getMessage());	
			msg.open();
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
			BankUIBankCardSearch inst = new BankUIBankCardSearch(shell, SWT.NULL);
			shell.setLayout(new org.eclipse.swt.layout.FillLayout());
			Rectangle shellBounds = shell.computeTrim(0,0,531,300);
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
	protected void tableBankCardsMouseDoubleClick(MouseEvent evt){
		//TODO add your handler code here
		TableItem [] selection= tableBankCards.getSelection();	
	
		if(selection.length>0){
	
			TurqBanksCard card = (TurqBanksCard)selection[0].getData();
			new BankUIBankCardUpdate(this.getShell(),SWT.NULL,card).open();
		search();
		}
	}
}
