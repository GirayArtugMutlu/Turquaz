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
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.SearchTableViewer;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class BankUIBankCardSearch extends Composite implements SearchComposite
{
	SearchTableViewer tableViewer = null;
	private CLabel lblBankName;
	private TableColumn tavleColumnDefinition;
	private TableColumn tableColumnCurrency;
	private TableColumn tableColumnAccountNo;
	private TableColumn tableColumnBankBrancName;
	private TableColumn tableColoumnBankName;
	private Table tableBankCards;
	private CCombo comboCurrency;
	private CLabel lblCurrency;
	private Text txtBankAccountNo;
	private CLabel lblBankAccountNo;
	private Text txtBankBranchName;
	private CLabel lblBankBranchName;
	private Text txtBankName;
	private Composite composite1;

	public BankUIBankCardSearch(Composite parent, int style)
	{
		super(parent, style);
		initGUI();
	}

	/**
	 * Initializes the GUI. Auto-generated code - any changes you make will disappear.
	 */
	public void initGUI()
	{
		try
		{
			preInitGUI();
			this.setSize(753, 438);
			GridLayout thisLayout = new GridLayout(1, true);
			this.setLayout(thisLayout);
//			START >>  composite1

			composite1 = new Composite(this, SWT.NONE);
			GridData composite1LData = new GridData();
			composite1LData.horizontalAlignment = GridData.FILL;
			composite1LData.heightHint = 111;
			composite1LData.grabExcessHorizontalSpace = true;
			composite1.setLayoutData(composite1LData);
			
			GridLayout composite1Layout = new GridLayout(2, true);
			composite1Layout.marginWidth = 5;
			composite1Layout.marginHeight = 5;
			composite1Layout.numColumns = 2;
			composite1Layout.makeColumnsEqualWidth = false;
			composite1Layout.horizontalSpacing = 5;
			composite1Layout.verticalSpacing = 5;
            composite1.setLayout(composite1Layout);
			
			composite1.layout();
			//START >>  lblBankName
			lblBankName = new CLabel(composite1, SWT.NONE);
			lblBankName.setText(Messages.getString("BankUIBankCardSearch.0"));
			GridData lblBankNameLData = new GridData();
			lblBankName.setLayoutData(lblBankNameLData);
			//END <<  lblBankName
			//START >>  txtBankName
			txtBankName = new Text(composite1, SWT.NONE);
			txtBankName.setSize(248, 13);
			GridData txtBankNameLData = new GridData();
			txtBankName.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode == SWT.CR)
						search();
				}
			});
			txtBankNameLData.widthHint = 150;
			txtBankNameLData.heightHint = 17;
			txtBankName.setLayoutData(txtBankNameLData);
			//END <<  txtBankName
			//START >>  lblBankBranchName
			lblBankBranchName = new CLabel(composite1, SWT.NONE);
			lblBankBranchName.setText(Messages.getString("BankUIBankCardSearch.1"));
			GridData lblBankBranchNameLData = new GridData();
			lblBankBranchName.setLayoutData(lblBankBranchNameLData);
			//END <<  lblBankBranchName
			//START >>  txtBankBranchName
			txtBankBranchName = new Text(composite1, SWT.NONE);
			txtBankBranchName.setSize(new org.eclipse.swt.graphics.Point(254, 13));
			GridData txtBankBranchNameLData = new GridData();
			txtBankBranchName.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode == SWT.CR)
						search();
				}
			});
			txtBankBranchNameLData.widthHint = 150;
			txtBankBranchNameLData.heightHint = 17;
			txtBankBranchName.setLayoutData(txtBankBranchNameLData);
			//END <<  txtBankBranchName
			//START >>  lblBankAccountNo
			lblBankAccountNo = new CLabel(composite1, SWT.NONE);
			lblBankAccountNo.setText(Messages.getString("BankUIBankCardSearch.2"));
			GridData lblBankAccountNoLData = new GridData();
			lblBankAccountNo.setLayoutData(lblBankAccountNoLData);
			//END <<  lblBankAccountNo
			//START >>  txtBankAccountNo
			txtBankAccountNo = new Text(composite1, SWT.NONE);
			txtBankAccountNo.setSize(new org.eclipse.swt.graphics.Point(254, 13));
			GridData txtBankAccountNoLData = new GridData();
			txtBankAccountNo.addKeyListener(new KeyAdapter() {
				public void keyReleased(KeyEvent evt) {
					if (evt.keyCode == SWT.CR)
						search();
				}
			});
			txtBankAccountNoLData.widthHint = 150;
			txtBankAccountNoLData.heightHint = 17;
			txtBankAccountNo.setLayoutData(txtBankAccountNoLData);
			//END <<  txtBankAccountNo
			//START >>  lblCurrency
			lblCurrency = new CLabel(composite1, SWT.NONE);
			lblCurrency.setText(Messages.getString("BankUIBankCardSearch.3"));
			GridData lblCurrencyLData = new GridData();
			lblCurrency.setLayoutData(lblCurrencyLData);
			//END <<  lblCurrency
			//START >>  comboCurrency
			comboCurrency = new CCombo(composite1, SWT.NONE);
			GridData comboCurrencyLData = new GridData();
			comboCurrency.setLayoutData(comboCurrencyLData);
			comboCurrencyLData.widthHint = 135;
			comboCurrencyLData.heightHint = 17;
			comboCurrency.setLayoutData(comboCurrencyLData);
			//END <<  comboCurrency
			//END <<  composite1

			//START >>  tableBankCards
			tableBankCards = new Table(this, SWT.MULTI | SWT.FULL_SELECTION);
			tableBankCards.setHeaderVisible(true);
			tableBankCards.setLinesVisible(true);
			tableBankCards.setSize(new org.eclipse.swt.graphics.Point(505, 147));
			GridData tableBankCardsLData = new GridData();
			tableBankCards.addMouseListener(new MouseAdapter() {
				public void mouseDoubleClick(MouseEvent evt) {
					tableBankCardsMouseDoubleClick(evt);
				}
			});
			tableBankCardsLData.verticalAlignment = GridData.FILL;
			tableBankCardsLData.horizontalAlignment = GridData.FILL;
			tableBankCardsLData.grabExcessVerticalSpace = true;
			tableBankCards.setLayoutData(tableBankCardsLData);
			//START >>  tableColoumnBankName
			tableColoumnBankName = new TableColumn(tableBankCards, SWT.NONE);
			tableColoumnBankName.setText(Messages.getString("BankUIBankCardSearch.4"));
			tableColoumnBankName.setWidth(120);
			//END <<  tableColoumnBankName
			//START >>  tableColumnBankBrancName
			tableColumnBankBrancName = new TableColumn(tableBankCards, SWT.NONE);
			tableColumnBankBrancName.setText(Messages.getString("BankUIBankCardSearch.5"));
			tableColumnBankBrancName.setWidth(120);
			//END <<  tableColumnBankBrancName
			//START >>  tableColumnAccountNo
			tableColumnAccountNo = new TableColumn(tableBankCards, SWT.NONE);
			tableColumnAccountNo.setText(Messages.getString("BankUIBankCardSearch.6"));
			tableColumnAccountNo.setWidth(120);
			//END <<  tableColumnAccountNo
			//START >>  tableColumnCurrency
			tableColumnCurrency = new TableColumn(tableBankCards, SWT.NONE);
			tableColumnCurrency.setText(Messages.getString("BankUIBankCardSearch.7"));
			tableColumnCurrency.setWidth(120);
			//END <<  tableColumnCurrency
			//START >>  tavleColumnDefinition
			tavleColumnDefinition = new TableColumn(tableBankCards, SWT.NONE);
			tavleColumnDefinition.setText(Messages.getString("BankUIBankCardSearch.8")); //$NON-NLS-1$
			tavleColumnDefinition.setWidth(150);
			//END <<  tavleColumnDefinition
			//END <<  tableBankCards
			
			thisLayout.marginWidth = 5;
			thisLayout.marginHeight = 5;
			thisLayout.numColumns = 1;
			thisLayout.makeColumnsEqualWidth = true;
			thisLayout.horizontalSpacing = 5;
			thisLayout.verticalSpacing = 5;
			this.layout();
			postInitGUI();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/** Add your pre-init code in here */
	public void preInitGUI()
	{
	}

	/** Add your post-init code in here */
	public void postInitGUI()
	{
		try
		{
			FillCurrencyCombo();
			createTableViewer();
		}
		catch (Exception ex)
		{
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			ex.printStackTrace();
		}
	}

	public void createTableViewer()
	{
		int columnTypes[] = new int[5];
		columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_STRING;
		columnTypes[4] = TurquazTableSorter.COLUMN_TYPE_STRING;
		tableViewer = new SearchTableViewer(tableBankCards,columnTypes,true);
		
	}
	private void FillCurrencyCombo() throws Exception
	{
		try
		{
			comboCurrency.removeAll();
			comboCurrency.setText(""); //$NON-NLS-1$
			List currencies = EngBLCommon.getCurrencies();
			for (int k = 0; k < currencies.size(); k++)
			{
				TurqCurrency currency = (TurqCurrency) currencies.get(k);
				comboCurrency.add(currency.getCurrenciesAbbreviation());
				comboCurrency.setData(currency.getCurrenciesAbbreviation(), currency);
			}
		}
		catch (Exception ex)
		{
			throw ex;
		}
	}

	public void delete()
	{
	}

	public void save()
	{
	}

	public void newForm()
	{
	}

	public void search()
	{
		try
		{
			tableViewer.removeAll();
			
			List listBankCards = BankBLBankCardSearch.searchBankCards(txtBankName.getText().trim(), txtBankBranchName.getText().trim(),
					txtBankAccountNo.getText().trim(), (TurqCurrency) (comboCurrency.getData(comboCurrency.getText())));
			Object[] result;
			for (int k = 0; k < listBankCards.size(); k++)
			{
				result = (Object[]) listBankCards.get(k);
				
				Integer bankId = (Integer) result[0];
				String bankName = (String) result[1];
				String bankBranchName = (String) result[2];
				String bankAccNo = (String) result[3];
				String abbr = (String) result[4];
				String bankDefinition = (String) result[5];
				tableViewer.addRow(new String[]{bankName, bankBranchName, bankAccNo, abbr, bankDefinition},bankId);
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
			
		}
	}

	public void exportToExcel()
	{
		EngBLUtils.Export2Excel(tableBankCards);
	}

	/** Auto-generated event handler method */
	protected void tableBankCardsMouseDoubleClick(MouseEvent evt)
	{
		try
		{
			TableItem[] selection = tableBankCards.getSelection();
			if (selection.length > 0)
			{
				ITableRow row = (ITableRow) selection[0].getData();
				Integer bankId = (Integer) row.getDBObject();
				TurqBanksCard card = BankBLBankCardSearch.getBankCardByBankCardId(bankId);
				BankBLBankCardSearch.initializeBankCard(card);
				boolean updated = new BankUIBankCardUpdate(this.getShell(), SWT.NULL, card).open();
				if (updated)
					search();
			}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
			msg.setMessage(ex.getMessage());
			msg.open();
		}
	}

	public void printTable()
	{
		EngBLUtils.printTable(tableBankCards, Messages.getString("BankUIBankCardSearch.9")); //$NON-NLS-1$
	}
}