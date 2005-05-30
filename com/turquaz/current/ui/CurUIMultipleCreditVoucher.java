package com.turquaz.current.ui;

/************************************************************************/
/* TURQUAZ: Higly Modular Accounting/ERP Program                        */
/* ============================================                         */
/* Copyright (c) 2004 by Turquaz Software Development Group             */
/*                                                                      */
/* This program is free software. You can redistribute it and/or modify */
/* it under the terms of the GNU General Public License as published by */
/* the Free Software Foundation; either version 2 of the License, or    */
/* (at your option) any later version.                                  */
/*                                                                      */
/* This program is distributed in the hope that it will be useful,      */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of       */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the        */
/* GNU General Public License for more details.                         */
/************************************************************************/
/**
 * @author  Onsel Armagan
 * @version  $Id$
 */
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Table;
import com.cloudgarden.resource.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.bl.EngBLCommon;
import com.turquaz.current.CurKeys;
import com.turquaz.current.bl.CurBLCurrentTransactionAdd;
import com.turquaz.current.ui.comp.CurrentPicker;
import com.turquaz.engine.bl.EngBLLogger;
import com.turquaz.engine.dal.TurqAccountingTransactionColumn;
import com.turquaz.engine.dal.TurqCurrency;
import com.turquaz.engine.dal.TurqCurrencyExchangeRate;
import com.turquaz.engine.interfaces.SecureComposite;
import com.turquaz.engine.lang.AccLangKeys;
import com.turquaz.engine.lang.CurLangKeys;
import com.turquaz.engine.lang.EngLangCommonKeys;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.editors.AccountingCellEditor;
import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.SaveTableViewer;
import com.turquaz.engine.ui.viewers.TableSpreadsheetCursor;
import com.turquaz.engine.ui.viewers.TurquazTableSorter;
import org.eclipse.swt.widgets.Text;

import com.turquaz.accounting.ui.AccUITransactionPaymentTableRow;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.events.VerifyEvent;

/**
 * This code was generated using CloudGarden's Jigloo SWT/Swing GUI Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose whatever) then you should purchase a license for each developer
 * using Jigloo. Please visit www.cloudgarden.com for details. Use of Jigloo implies acceptance of these licensing terms.
 * ************************************* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED for this machine, so Jigloo or this code cannot be used
 * legally for any corporate or commercial purpose. *************************************
 */
public class CurUIMultipleCreditVoucher extends Composite implements SecureComposite
{
    {
        //Register as a resource user - SWTResourceManager will
        //handle the obtaining and disposing of resources
        SWTResourceManager.registerResourceUser(this);
    }
    private TurqCurrency baseCurrency;
    private TurqCurrency exchangeCurrency;
    private TurqCurrencyExchangeRate exchangeRate;
    private TableItem item;
    private TableSpreadsheetCursor cursor;
    private TableColumn tableColumnDeptAmount;
    private TableColumn tableColumnDefinition;
    private TableColumn tableColumnAccountName;
    private TableColumn tableColumnAccountCode;
    private Table tableTransactionRows;
    private Text txtDefinition;
    private CLabel lblDefinition;
    private CCombo comboCurrencyType;
    private CLabel lblCurrency;
    private DatePicker datePickerTransactionDate;
    private CLabel lblDate;
    private Text txtDocumentNo;
    private CLabel lbldocumentNo;
    private CurrentPicker currentPicker;
    private CLabel lblCreditor;

    /**
     * @return Returns the exchangeRate.
     */
    public TurqCurrencyExchangeRate getExchangeRate()
    {
        return exchangeRate;
    }
    private BigDecimal totalCredit;
    //   Set the table column property names
    private final String ACCOUNT_CODE = AccLangKeys.STR_ACCOUNT_CODE; //$NON-NLS-1$
    private final String ACCOUNT_NAME = AccLangKeys.STR_ACCOUNT_NAME; //$NON-NLS-1$
    private final String DEFINITION = EngLangCommonKeys.STR_DESCRIPTION;
    private final String DEBIT = EngLangCommonKeys.STR_DEPT; //$NON-NLS-1$
    private List columnList = new ArrayList();
    // Set column names
    private String[] columnNames = new String[]{ACCOUNT_CODE, ACCOUNT_NAME, DEFINITION, DEBIT};
    public SaveTableViewer tableViewer;

    public CurUIMultipleCreditVoucher(Composite parent, int style)
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
            this.setSize(600, 451);
            GridLayout thisLayout = new GridLayout();
            this.setLayout(thisLayout);
            //START >>  lblCreditor
            lblCreditor = new CLabel(this, SWT.NONE);
            lblCreditor.setText("Cari Kart"); //$NON-NLS-1$
            //END <<  lblCreditor
            //START >>  currentPicker
            currentPicker = new CurrentPicker(this, SWT.NONE);
            GridData comboCreditorLData = new GridData();
            comboCreditorLData.widthHint = 370;
            comboCreditorLData.heightHint = 15;
            comboCreditorLData.horizontalSpan = 3;
            currentPicker.setLayoutData(comboCreditorLData);
            //END <<  currentPicker
            //START >>  lbldocumentNo
            lbldocumentNo = new CLabel(this, SWT.NONE);
            lbldocumentNo.setText("Belge No"); //$NON-NLS-1$
            lbldocumentNo.setSize(new org.eclipse.swt.graphics.Point(93, 18));
            //END <<  lbldocumentNo
            //START >>  txtDocumentNo
            txtDocumentNo = new Text(this, SWT.NONE);
            GridData txtDocumentNoLData = new GridData();
            txtDocumentNoLData.widthHint = 150;
            txtDocumentNoLData.heightHint = 17;
            txtDocumentNo.setLayoutData(txtDocumentNoLData);
            //END <<  txtDocumentNo
            //START >>  lblDate
            lblDate = new CLabel(this, SWT.NONE);
            lblDate.setText(EngLangCommonKeys.STR_DATE); //$NON-NLS-1$
            lblDate.setSize(new org.eclipse.swt.graphics.Point(49, 19));
            //END <<  lblDate
            //START >>  datePickerTransactionDate
            datePickerTransactionDate = new DatePicker(this, SWT.NONE);
            GridData datePickerTransactionDateLData = new GridData();
            datePickerTransactionDateLData.widthHint = 157;
            datePickerTransactionDateLData.heightHint = 23;
            datePickerTransactionDate.setLayoutData(datePickerTransactionDateLData);
            //END <<  datePickerTransactionDate
            //START >>  lblCurrency
            lblCurrency = new CLabel(this, SWT.NONE);
            lblCurrency.setText(EngLangCommonKeys.STR_CURRENCY); //$NON-NLS-1$
            //END <<  lblCurrency
            //START >>  comboCurrencyType
            comboCurrencyType = new CCombo(this, SWT.NONE);
            GridData comboCurrencyTypeLData = new GridData();
            comboCurrencyTypeLData.widthHint = 135;
            comboCurrencyTypeLData.heightHint = 17;
            comboCurrencyTypeLData.horizontalSpan = 3;
            comboCurrencyType.setLayoutData(comboCurrencyTypeLData);
            //END <<  comboCurrencyType
            //START >>  lblDefinition
            lblDefinition = new CLabel(this, SWT.NONE);
            lblDefinition.setText(EngLangCommonKeys.STR_DESCRIPTION); //$NON-NLS-1$
            //END <<  lblDefinition
            //START >>  txtDefinition
            txtDefinition = new Text(this, SWT.MULTI | SWT.V_SCROLL);
            GridData txtDefinitionLData = new GridData();
            txtDefinition.addVerifyListener(new VerifyListener() {
                public void verifyText(VerifyEvent evt) {
                    if (evt.character == SWT.TAB) {
                        tableTransactionRows.setFocus();
                        evt.doit = false;
                    }
                }
            });
            txtDefinitionLData.verticalAlignment = GridData.FILL;
            txtDefinitionLData.horizontalSpan = 3;
            txtDefinitionLData.widthHint = 349;
            txtDefinition.setLayoutData(txtDefinitionLData);
            //END <<  txtDefinition
            //START >>  tableTransactionRows
            tableTransactionRows = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION | SWT.BORDER);
            tableTransactionRows.setHeaderVisible(true);
            tableTransactionRows.setLinesVisible(true);
            GridData tableTransactionRowsLData = new GridData();
            tableTransactionRowsLData.verticalAlignment = GridData.FILL;
            tableTransactionRowsLData.horizontalAlignment = GridData.FILL;
            tableTransactionRowsLData.horizontalSpan = 4;
            tableTransactionRowsLData.grabExcessHorizontalSpace = true;
            tableTransactionRowsLData.grabExcessVerticalSpace = true;
            tableTransactionRows.setLayoutData(tableTransactionRowsLData);
            //START >>  tableColumnAccountCode
            tableColumnAccountCode = new TableColumn(tableTransactionRows, SWT.NONE);
            tableColumnAccountCode.setText(ACCOUNT_CODE); //$NON-NLS-1$
            tableColumnAccountCode.setWidth(126);
            //END <<  tableColumnAccountCode
            //START >>  tableColumnAccountName
            tableColumnAccountName = new TableColumn(tableTransactionRows, SWT.NONE);
            tableColumnAccountName.setText(ACCOUNT_NAME); //$NON-NLS-1$
            tableColumnAccountName.setWidth(150);
            //END <<  tableColumnAccountName
            //START >>  tableColumnDefinition
            tableColumnDefinition = new TableColumn(tableTransactionRows, SWT.NONE);
            tableColumnDefinition.setText(DEFINITION); //$NON-NLS-1$
            tableColumnDefinition.setWidth(150);
            //END <<  tableColumnDefinition
            //START >>  tableColumnDeptAmount
            tableColumnDeptAmount = new TableColumn(tableTransactionRows, SWT.RIGHT);
            tableColumnDeptAmount.setText(DEBIT); //$NON-NLS-1$
            tableColumnDeptAmount.setWidth(100);
            //END <<  tableColumnDeptAmount
           
            //END <<  tableTransactionRows
            thisLayout.numColumns = 4;
            this.layout();
            postInitGUI();
        }
        catch (Exception e)
        {
            EngBLLogger.log(this.getClass(),e,getShell());
        }
    }

    /** Add your pre-init code in here */
    public void preInitGUI()
    {
    }

    /** Add your post-init code in here */
    public void postInitGUI()
    {
        totalCredit = new BigDecimal(0);
        fillCurrencyCombo();
        createTableViewer();
        for (int i = 0; i < EngBLCommon.TABLE_ROW_COUNT; i++)
        {
            //          enter empty table rows.
            AccUITransactionPaymentTableRow row = new AccUITransactionPaymentTableRow(tableViewer.getRowList());
            tableViewer.addRow(row);
        }
        tableViewer.addChangeListener(new ITableRowListViewer()
        {
            public void updateRow(ITableRow row)
            {
                Vector vec = tableViewer.getRowList().getTasks();
                int index = vec.indexOf(row);
                if (index == vec.size() - 1)
                {
                    if (row.okToSave())
                    {
                        AccUITransactionPaymentTableRow row2 = new AccUITransactionPaymentTableRow(tableViewer.getRowList());
                        tableViewer.addRow(row2);
                    }
                }
            }

            public void removeRow(ITableRow row)
            {
            }

            public void addRow(ITableRow row)
            {
            }
        });
        
        int columnTypes[] = new int[4];
        columnTypes[0] = TurquazTableSorter.COLUMN_TYPE_STRING;
        columnTypes[1] = TurquazTableSorter.COLUMN_TYPE_STRING;
        columnTypes[2] = TurquazTableSorter.COLUMN_TYPE_STRING;
        columnTypes[3] = TurquazTableSorter.COLUMN_TYPE_DECIMAL;
        tableViewer.addSortingSupport(columnTypes);
    }

    public void fillCurrencyCombo()
    {
        try
        {
            List currencies = (List)EngTXCommon.doSelectTX(AccBLTransactionSearch.class.getName(),"getCurrencies",null); //$NON-NLS-1$
            for (int k = 0; k < currencies.size(); k++)
            {
                TurqCurrency currency = (TurqCurrency) currencies.get(k);
                comboCurrencyType.add(currency.getCurrenciesAbbreviation());
                comboCurrencyType.setData(currency.getCurrenciesAbbreviation(), currency);
                if (currency.isDefaultCurrency())
                {
                    comboCurrencyType.setText(currency.getCurrenciesAbbreviation());
                    baseCurrency = currency;
                }
            }
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex,getShell());
        }
    }

    public boolean verifyFields()
    {
        try
        {
            calculateTotalCredit();
            MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
            if (totalCredit.doubleValue() <= 0)
            {
                msg.setMessage(AccLangKeys.MSG_VOUCHER_AMOUNT_NOT_ZERO); //$NON-NLS-1$
                msg.open();
                return false;
            }
            else if (tableTransactionRows.getItems().length == 0)
            {
                msg.setMessage(AccLangKeys.MSG_ENTER_AT_LEAST_ONE_ROW); //$NON-NLS-1$
                msg.open();
                return false;
            }
            else if (datePickerTransactionDate.getData() == null)
            {
                msg.setMessage(AccLangKeys.MSG_ENTER_VOUCHER_DATE); //$NON-NLS-1$
                msg.open();
                return false;
            }
            else if (currentPicker.getData() == null)
            {
                msg.setMessage(CurLangKeys.MSG_SELECT_CUR_CARD);  //$NON-NLS-1$
                msg.open();
                return false;
            }
            else if ((exchangeCurrency = (TurqCurrency) comboCurrencyType.getData(comboCurrencyType.getText())) == null)
            {
                msg.setMessage(EngLangCommonKeys.MSG_SELECT_CURRENCY); //$NON-NLS-1$
                msg.open();
                comboCurrencyType.setFocus();
                return false;
            }
            if (baseCurrency.getId().intValue() != exchangeCurrency.getId().intValue())
            {
                exchangeRate = EngBLCommon.getCurrencyExchangeRate(baseCurrency, exchangeCurrency, datePickerTransactionDate.getDate());
                if (exchangeRate == null)
                {
                    msg.setMessage(EngLangCommonKeys.MSG_DEFINE_DAILY_EXCHANGE_RATE); //$NON-NLS-1$
                    msg.open();
                    return false;
                }
            }
            else
            {
                exchangeRate = EngBLCommon.getBaseCurrencyExchangeRate();
            }
            return true;
        }
        catch (Exception ex)
        {
            EngBLLogger.log(this.getClass(),ex,getShell());
            return false;
        }
    }

    public boolean okToDelete()
    {
        MessageBox msg = new MessageBox(this.getShell(), SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
        msg.setMessage(EngLangCommonKeys.MSG_DELETE_REALLY); //$NON-NLS-1$
        if (msg.open() == SWT.OK)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void createTableViewer()
    {
        columnList.add(ACCOUNT_CODE);
        columnList.add(ACCOUNT_NAME);
        columnList.add(DEFINITION);
        columnList.add(DEBIT);
        //     Create the cell editors
       
        CellEditor[] editors = new CellEditor[columnNames.length];
        editors[0] = new AccountingCellEditor(tableTransactionRows,ACCOUNT_CODE);
        editors[1] = new TextCellEditor(tableTransactionRows);
        editors[2] = new TextCellEditor(tableTransactionRows);
        editors[3] = new CurrencyCellEditor(tableTransactionRows, 2);
      
        tableViewer = new SaveTableViewer(tableTransactionRows,editors);
        ((AccountingCellEditor)editors[0]).setTableViewer(tableViewer.getViewer());
        
        //START >>  cursor
        cursor = new TableSpreadsheetCursor(tableTransactionRows,SWT.NONE,tableViewer,true);
        cursor.setEnabled(true);
        cursor.addSelectionListener(new SelectionAdapter() {
            public void widgetDefaultSelected(SelectionEvent evt) {
                tableViewer.editElement(cursor.getRow().getData(), cursor.getColumn());
            }
            public void widgetSelected(SelectionEvent evt) {
            }
        });
        //END <<  cursor
        // Assign the cell editors to the viewer
        // create a TableCursor to navigate around the table
    }
    public void save()
    {
            saveTrans();
            clearFields();
        
    }
    public void saveTrans()
    {
        if (verifyFields())
        {
            MessageBox msg = new MessageBox(this.getShell(), SWT.NULL);
            try
            {               
                
                HashMap argMap = new HashMap();
                argMap.put(CurKeys.CUR_CARD,currentPicker.getData());
                argMap.put(AccKeys.ACC_TRANSACTIONS,getTransactionColumns());
                argMap.put(EngKeys.DATE,datePickerTransactionDate.getDate());
                argMap.put(EngKeys.DOCUMENT_NO,txtDocumentNo.getText().trim());
                argMap.put(CurKeys.CUR_IS_CREDIT,new Boolean(true));
                argMap.put(CurKeys.CUR_TRANS_AMOUNT,totalCredit);
                argMap.put(EngKeys.DEFINITION,txtDefinition.getText());
                argMap.put(EngKeys.TYPE,new Integer(EngBLCommon.CURRENT_TRANS_MULTIPLE_CREDIT));
                argMap.put(EngKeys.EXCHANGE_RATE,exchangeRate);
                
               Integer result =(Integer)EngTXCommon.doTransactionTX(CurBLCurrentTransactionAdd.class.getName(),"saveMultipleOtherTransaction",argMap);          //$NON-NLS-1$
                
               if(result.intValue()==1)
               {
                msg.setMessage(EngLangCommonKeys.MSG_SAVED_SUCCESS); //$NON-NLS-1$
                msg.open();
               }
               else if(result.intValue()==-1)
               {
                   msg.setMessage(CurLangKeys.MSG_NOT_SAVED_ACCOUNTING_TRANSACTIONS); //$NON-NLS-1$
                   msg.open();
               }               
            }
            catch (Exception ex)
            {
                EngBLLogger.log(this.getClass(),ex,getShell());
            }
        }
    }

    public void clearFields()
    {
        CurUIMultipleCreditVoucher curCard = new CurUIMultipleCreditVoucher(this.getParent(), this.getStyle());
        CTabFolder tabfld = (CTabFolder) this.getParent();
        tabfld.getSelection().setControl(curCard);
        this.dispose();
    }
    
    public List getTransactionColumns()
    {
        List transColumns=new ArrayList();
        TableItem items[] = tableTransactionRows.getItems();
        BigDecimal total=new BigDecimal(0);
        for (int i = 0; i < items.length; i++)
        {
            AccUITransactionPaymentTableRow row = (AccUITransactionPaymentTableRow) items[i].getData();
            if (row.okToSave())
            {
                TurqAccountingTransactionColumn tcol=(TurqAccountingTransactionColumn)row.getDBObject();
                transColumns.add(tcol);
                total=total.add(tcol.getDeptAmount());
            }
        }
       
        return transColumns;
    }


    public void search()
    {
    }

    public void newForm()
    {
        clearFields();
    }

    public void delete()
    {
    }

    void calculateTotalCredit()
    {
        TableItem items[] = tableTransactionRows.getItems();
        totalCredit = new BigDecimal(0);
        for (int i = 0; i < items.length; i++)
        {
            TurqAccountingTransactionColumn column = (TurqAccountingTransactionColumn) ((AccUITransactionPaymentTableRow) items[i].getData()).getDBObject();
            if (column != null && ((AccUITransactionPaymentTableRow) items[i].getData()).okToSave())
            {
                totalCredit = totalCredit.add(column.getDeptAmount());
            }
        }
    }

    /**
     * @return Returns the datePickerTransactionDate.
     */
    public DatePicker getDatePickerTransactionDate()
    {
        return datePickerTransactionDate;
    }

    /**
     * @return Returns the tableTransactionRows.
     */
    public Table getTableTransactionRows()
    {
        return tableTransactionRows;
    }

    /**
     * @return Returns the txtDocumentNo.
     */
    public Text getTxtDocumentNo()
    {
        return txtDocumentNo;
    }

    /**
     * @return Returns the comboCurrencyType.
     */
    public CCombo getComboCurrencyType()
    {
        return comboCurrencyType;
    }

    /**
     * @param comboCurrencyType
     *             The comboCurrencyType to set.
     */
    public void setComboCurrencyType(CCombo comboCurrencyType)
    {
        this.comboCurrencyType = comboCurrencyType;
    }

   

    /**
     * @return Returns the txtDefinition.
     */
    public Text getTxtDefinition()
    {
        return txtDefinition;
    }

    /**
     * @param txtDefinition
     *             The txtDefinition to set.
     */
    public void setTxtDefinition(Text txtDefinition)
    {
        this.txtDefinition = txtDefinition;
    }

    public CurrentPicker getCurrentPicker()
    {
        return currentPicker;
    }
    
    
}