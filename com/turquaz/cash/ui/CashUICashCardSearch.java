package com.turquaz.cash.ui;

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


import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import com.turquaz.accounting.ui.comp.AccountPicker;
import com.turquaz.engine.ui.component.SearchComposite;

import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;


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

/**
 * 
 * @author onsel
 * @version Id: $$
*/

public class CashUICashCardSearch extends org.eclipse.swt.widgets.Composite implements SearchComposite{
	private Composite composite1;
	private CLabel lblCardCode;
	private CLabel lblAccountCode;
	private TableColumn tableColumnAccount;
	private TableColumn tableColumnDefinition;
	private TableColumn tableColumnCashCode;
	private Table tableCashCards;
	private AccountPicker accountPicker;
	private Text txtCardCode;

	public CashUICashCardSearch(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(528, 232);
            {
                composite1 = new Composite(this, SWT.NONE);
                GridLayout composite1Layout = new GridLayout();
                GridData composite1LData = new GridData();
                composite1LData.heightHint = 75;
                composite1LData.grabExcessHorizontalSpace = true;
                composite1LData.horizontalAlignment = GridData.FILL;
                composite1.setLayoutData(composite1LData);
                composite1Layout.numColumns = 2;
                composite1.setLayout(composite1Layout);
                {
                    lblCardCode = new CLabel(composite1, SWT.NONE);
                    lblCardCode.setText("Kart Kodu");
                }
                {
                    txtCardCode = new Text(composite1, SWT.NONE);
                    GridData txtCardCodeLData = new GridData();
                    txtCardCode.setSize(138, 14);
                    txtCardCodeLData.widthHint = 138;
                    txtCardCodeLData.heightHint = 14;
                    txtCardCode.setLayoutData(txtCardCodeLData);
                }
                {
                    lblAccountCode = new CLabel(composite1, SWT.NONE);
                    lblAccountCode.setText("Muhasebe Hesab?");
                }
                {
                    accountPicker = new AccountPicker(composite1, SWT.NONE);
                    GridData accountPickerLData = new GridData();
                    accountPickerLData.widthHint = 144;
                    accountPickerLData.heightHint = 14;
                    accountPicker.setLayoutData(accountPickerLData);
                }
            }
            {
                tableCashCards = new Table(this, SWT.NONE);
                GridData tableCashCardsLData = new GridData();
                tableCashCards.setLinesVisible(true);
                tableCashCards.setHeaderVisible(true);
                tableCashCardsLData.grabExcessHorizontalSpace = true;
                tableCashCardsLData.grabExcessVerticalSpace = true;
                tableCashCardsLData.horizontalAlignment = GridData.FILL;
                tableCashCardsLData.verticalAlignment = GridData.FILL;
                tableCashCards.setLayoutData(tableCashCardsLData);
                {
                    tableColumnCashCode = new TableColumn(
                        tableCashCards,
                        SWT.NONE);
                    tableColumnCashCode.setText("Kasa Kodu");
                    tableColumnCashCode.setWidth(100);
                }
                {
                    tableColumnDefinition = new TableColumn(
                        tableCashCards,
                        SWT.NONE);
                    tableColumnDefinition.setText("Aç?klama");
                    tableColumnDefinition.setWidth(100);
                }
                {
                    tableColumnAccount = new TableColumn(
                        tableCashCards,
                        SWT.NONE);
                    tableColumnAccount.setText("Muh. Hesab?");
                    tableColumnAccount.setWidth(125);
                }
            }
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

    public void delete() {
        // TODO Auto-generated method stub

    }
    public void exportToExcel() {
        // TODO Auto-generated method stub

    }
    public void printTable() {
        // TODO Auto-generated method stub

    }
    public void search() {
        // TODO Auto-generated method stub

    }
}
