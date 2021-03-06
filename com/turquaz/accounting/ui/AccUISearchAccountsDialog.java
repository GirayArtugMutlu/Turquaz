package com.turquaz.accounting.ui;

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
import java.util.HashMap;

import org.eclipse.swt.widgets.Display;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;

import com.turquaz.common.HashBag;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.interfaces.SearchDialogInterface;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.tx.EngTXCommon;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.SearchDialogMenu;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;

import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Color;

import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLAccountAdd;
import com.turquaz.accounting.bl.AccBLAccountSearch;

public class AccUISearchAccountsDialog extends org.eclipse.swt.widgets.Dialog implements SearchDialogInterface
{
    private Shell dialogShell;

    private Composite composite1;

    private Table tableResults;

    private Text txtAccountCode;

    private CLabel lblAccountName;

    private Text txtAccountName;

    private SearchDialogMenu searchDialogMenu1;

    private CLabel lblAccountCode;

    private TableColumn tableColumnBalance;

    private TableColumn tableColumnCredit;

    private TableColumn tableColumnDept;

    private TableColumn tableColumnAccountName;

    private TableColumn tableColumnAccCode;

    private Tree accountTree;

    private AccBLAccountAdd blAccount;
    private String returnData ="" ;

    Object returnObj[] = new Object[2];

    public AccUISearchAccountsDialog(Shell parent, int style)
    {
        super(parent, style);
    }

    /**
     * Opens the Dialog Shell. Auto-generated code - any changes you make will
     * disappear.
     */
    public String open()
    {
        try
        {
            preInitGUI();
            Shell parent = getParent();
            dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL |SWT.RESIZE | SWT.MAX);

            {    // Register as a resource user - SWTResourceManager will
                // handle the obtaining and disposing of resources
                SWTResourceManager.registerResourceUser(dialogShell);
            }

            dialogShell.setText(getText());
            dialogShell.setSize(new org.eclipse.swt.graphics.Point(387, 260));
            final Color composite1background = new Color(Display.getDefault(), 255, 255, 255);
            GridLayout dialogShellLayout = new GridLayout();
            dialogShell.setLayout(dialogShellLayout);
            dialogShell.layout();
            dialogShell.addDisposeListener(new DisposeListener()
            {
                public void widgetDisposed(DisposeEvent e)
                {
                    composite1background.dispose();
                }
            });
            Rectangle bounds = dialogShell.computeTrim(0, 0, 387, 260);
            dialogShell.setSize(593, 438);
            {
                searchDialogMenu1 = new SearchDialogMenu(dialogShell, SWT.NONE, this);
            }
            {
                composite1 = new Composite(dialogShell, SWT.NONE);
                GridLayout composite1Layout = new GridLayout();
                composite1Layout.numColumns = 4;
                GridData composite1LData = new GridData();
                composite1LData.grabExcessHorizontalSpace = true;
                composite1LData.horizontalAlignment = GridData.FILL;
                composite1LData.heightHint = 38;
                composite1.setLayoutData(composite1LData);
                composite1.setLayout(composite1Layout);
                {
                    lblAccountCode = new CLabel(composite1, SWT.NONE);
                    lblAccountCode.setText(AccLangKeys.STR_ACCOUNT_CODE);
                }
                {
                    GridData txtAccountCodeLData = new GridData();
                    txtAccountCodeLData.widthHint = 156;
                    txtAccountCodeLData.heightHint = 15;
                    txtAccountCode = new Text(composite1, SWT.NONE);
                    txtAccountCode.setLayoutData(txtAccountCodeLData);
                }
                {
                    lblAccountName = new CLabel(composite1, SWT.NONE);
                    lblAccountName.setText(AccLangKeys.STR_ACCOUNT_NAME);
                }
                {
                    GridData txtAccountNameLData = new GridData();
                    txtAccountNameLData.heightHint = 15;
                    txtAccountNameLData.widthHint = 156;
                    txtAccountName = new Text(composite1, SWT.NONE);
                    txtAccountName.setLayoutData(txtAccountNameLData);
                }
            }
            {
                GridData tableResultsLData = new GridData();
                tableResultsLData.grabExcessHorizontalSpace = true;
                tableResultsLData.horizontalAlignment = GridData.FILL;
                tableResultsLData.grabExcessVerticalSpace = true;
                tableResultsLData.verticalAlignment = GridData.FILL;
                tableResults = new Table(dialogShell, SWT.FULL_SELECTION);
                tableResults.setLayoutData(tableResultsLData);
                tableResults.setHeaderVisible(true);
                tableResults.setLinesVisible(true);
                tableResults.addMouseListener(new MouseAdapter() {
                    public void mouseDoubleClick(MouseEvent evt) {
                      
                        choose();
                        
                    }
                });
                {
                    tableColumnAccCode = new TableColumn(tableResults, SWT.NONE);
                    tableColumnAccCode.setText(AccLangKeys.STR_ACCOUNT_CODE);
                    tableColumnAccCode.setWidth(100);
                }
                {
                    tableColumnAccountName = new TableColumn(tableResults, SWT.NONE);
                    tableColumnAccountName.setText(AccLangKeys.STR_ACCOUNT_NAME);
                    tableColumnAccountName.setWidth(111);
                }
                {
                    tableColumnDept = new TableColumn(tableResults, SWT.NONE);
                    tableColumnDept.setText(AccLangKeys.STR_TOTAL_DEBIT);
                    tableColumnDept.setWidth(115);
                }
                {
                    tableColumnCredit = new TableColumn(tableResults, SWT.NONE);
                    tableColumnCredit.setText(AccLangKeys.STR_TOTAL_CREDIT);
                    tableColumnCredit.setWidth(100);
                }
                {
                    tableColumnBalance = new TableColumn(tableResults, SWT.NONE);
                    tableColumnBalance.setText(AccLangKeys.STR_BALANCE);
                    tableColumnBalance.setWidth(100);
                }
            }
            postInitGUI();
            dialogShell.open();
            Display display = dialogShell.getDisplay();
            while (!dialogShell.isDisposed())
            {
                if (!display.readAndDispatch())
                    display.sleep();
            }
        } catch (Exception e)
        {
            EngBLLogger.log(this.getClass(),e,getParent());
        }
        return returnData;
    }

    /** Add your pre-init code in here */
    public void preInitGUI()
    {

    }

    /** Add your post-init code in here */
    public void postInitGUI()
    {
       EngUICommon.centreWindow(dialogShell);
    }
    
    

    public void choose()
    {
        if(tableResults.getSelection().length>0)
        {
            returnData = tableResults.getSelection()[0].getData().toString();
            dialogShell.close();
        }
     

    }

    public void search()
    {
        try
        {
            tableResults.removeAll();
            HashMap argMap = new HashMap();
            
            argMap.put(AccKeys.ACC_ACCOUNT_CODE,txtAccountCode.getText().trim());
            argMap.put(AccKeys.ACC_ACCOUNT_NAME,txtAccountName.getText().trim());
            
            HashBag mainBranches = (HashBag) EngTXCommon.doSelectTX(AccBLAccountSearch.class.getName(), "searchAccounts", argMap);
            TableItem item ;
            
            HashMap accountsMap=(HashMap)mainBranches.get(AccKeys.ACC_ACCOUNTS);

            BigDecimal dept;
            BigDecimal credit;
            BigDecimal balance;
            
            TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
            for(int k=0; k<accountsMap.size(); k++)
            {  
            	HashMap accountMap=(HashMap)accountsMap.get(new Integer(k));
                
            	dept = (BigDecimal)accountMap.get(EngKeys.DEPT_AMOUNT);
                credit = (BigDecimal)accountMap.get(EngKeys.CREDIT_AMOUNT);
                
                balance = dept.subtract(credit);
                
                item = new TableItem(tableResults,SWT.NULL);
                
                Integer accountId=(Integer)accountMap.get(AccKeys.ACC_ACCOUNT_ID);
                String accountCode=(String)accountMap.get(AccKeys.ACC_ACCOUNT_CODE);
                String accountName=(String)accountMap.get(AccKeys.ACC_ACCOUNT_NAME);
                
                item.setText(new String[]{accountCode,accountName,cf.format(dept),cf.format(credit),cf.format(balance) } );
           
                item.setData(accountCode);             
            }             
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex,getParent());  
        }
    }
    
  

}