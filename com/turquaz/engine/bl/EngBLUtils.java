
package com.turquaz.engine.bl;
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

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.jasperassistant.designer.viewer.ViewerApp;

import com.turquaz.admin.bl.AdmBLCompanyInfo;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqViewCurrentAmountTotal;

import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SWTPTable;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.inventory.bl.InvBLCardSearch;

import de.kupzog.ktools.kprint.boxes.PBox;
import de.kupzog.ktools.kprint.boxes.PDocument;
import de.kupzog.ktools.kprint.boxes.PHLine;

import de.kupzog.ktools.kprint.boxes.PTableBoxProvider;
import de.kupzog.ktools.kprint.boxes.PTextBox;
import de.kupzog.ktools.kprint.boxes.PTextStyle;
import de.kupzog.ktools.kprint.boxes.PVSpace;
import de.kupzog.ktools.kprint.gui.IconSource;
import de.kupzog.ktools.kprint.gui.PrintPreview;



/**
 * @author onsel
 *
 */
public class EngBLUtils {
	
	public static String logoURL;
	private static CurBLCurrentCardSearch curBLCurCardSearch=new CurBLCurrentCardSearch();
	private static InvBLCardSearch blCardSearch=new InvBLCardSearch();
	private static Calendar cal=Calendar.getInstance();
	private static AdmBLCompanyInfo admBLComInfo=new AdmBLCompanyInfo();
	//private static ViewerComposite reportViewer;
	
	
	public static void Export2Excel(Table table){
		 try{
			
			FileDialog dialog = new FileDialog (table.getShell(), SWT.SAVE);
			dialog.setFilterNames (new String [] {"Excel File", "(*.xls)"}); //$NON-NLS-1$ //$NON-NLS-2$
			dialog.setFilterExtensions (new String [] {"*.xls"}); //Windows wild cards //$NON-NLS-1$
			dialog.setFileName ("excel_cikti"); //$NON-NLS-1$

			String filepath = dialog.open();
			
			if(filepath!=null){
			short rownum;

//			 create a new file
			FileOutputStream out = new FileOutputStream(filepath);
//			 create a new workbook
			HSSFWorkbook wb = new HSSFWorkbook();
//			 create a new sheet
			HSSFSheet s = wb.createSheet();
//			 declare a row object reference
			HSSFRow r = null;
//			 declare a cell object reference
			HSSFCell c = null;
//			
//			 set the sheet name in Unicode
			wb.setSheetName(0, "Sheet1",  //$NON-NLS-1$
			                HSSFWorkbook.ENCODING_COMPRESSED_UNICODE);
			
//			 in case of compressed Unicode
//			 wb.setSheetName(0, "HSSF Test", HSSFWorkbook.ENCODING_COMPRESSED_UNICODE );
//			 create a sheet with 30 rows (0-29)
			
			TableItem items[] = table.getItems();
			int colCount = table.getColumnCount();
			for (int i=1; i <= items.length; i++)
			{
			    // create a row
			    r = s.createRow(i);
		
			   
			    for (short j=0;j<colCount;j++)
			    {
			    	
			        String cell_value=items[i-1].getText(j);
			    			    	
			        
			        c = r.createCell(j);
			       
			        // set the cell's string value
		            c.setEncoding( HSSFCell.ENCODING_UTF_16 );
			             
			        c.setCellValue(cell_value);

			        
			    }
			}

			wb.write(out);
			out.close();
			}
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		
		
	}
	public static void printTable(Table table, String title){
//	  create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing");		 //$NON-NLS-1$
		
		// put some header text on it
		PTextBox t;
		
		t = new PTextBox(doc);
		t.setText(title);
		
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.5);
		
		// create the table
		

		SWTPTable ptable = new SWTPTable(doc);
		ptable.setTable(table);
		ptable.setBoxProvider(new PTableBoxProvider());		
		
		PrintPreview pr = new PrintPreview(null, title, IconSource.getImage("print"), doc); //$NON-NLS-1$
		pr.open();
	    
	}
	
	public static void printSubsidiaryLedgerTable(Table table,String title,Properties prop){
	    
      //create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing");		 //$NON-NLS-1$
		
		// put some header text on it
		PTextBox t;
		t = new PTextBox(doc);
		t.setText(title);
		t.getTextStyle().textAlign = PTextStyle.ALIGN_CENTER;
		
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.1);
		
		
		t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.8")+ prop.getProperty("account_code")); //$NON-NLS-1$ //$NON-NLS-2$
	    t.getTextStyle().fontSize = 8;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    t = new PTextBox (doc, PBox.GRAB|PBox.POS_RIGHT);	    
	    t.setText(Messages.getString("EngBLUtils.10")+ prop.getProperty("start_date")); //$NON-NLS-1$ //$NON-NLS-2$
	    t.getTextStyle().fontSize = 8;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.12") + prop.getProperty("account_name")); //$NON-NLS-1$ //$NON-NLS-2$
	    t.getTextStyle().fontSize = 8;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    
	    t = new PTextBox (doc, PBox.GRAB|PBox.POS_RIGHT);	    
	    t.setText(Messages.getString("EngBLUtils.14")+ prop.getProperty("end_date")); //$NON-NLS-1$ //$NON-NLS-2$
	    t.getTextStyle().fontSize = 8;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.16")+ prop.getProperty("top_account")); //$NON-NLS-1$ //$NON-NLS-2$
	    t.getTextStyle().fontSize = 8;
	    t.getTextStyle().fontStyle = SWT.BOLD;
		
	    
		
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.5);
		
		
		
		// create the table
		

		SWTPTable ptable = new SWTPTable(doc);
		ptable.setTable(table);
		ptable.setBoxProvider(new PTableBoxProvider());		
		
		PrintPreview pr = new PrintPreview(null, title, IconSource.getImage("print"), doc); //$NON-NLS-1$
		pr.open();
		
	}
	
	public static void printBill(TurqBill bill, boolean balance){
	    
		try{
			TurqConsignment cons = (TurqConsignment)bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator().next();

			SimpleDateFormat dformat=new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			Map parameters = new HashMap();
			String sqlparam="Select invTrans.inventory_transactions_id," + //$NON-NLS-1$
					" invCardUnits.card_units_factor, " + //$NON-NLS-1$
					" invCard.card_inventory_code, invCard.card_name, units.units_name,"+ //$NON-NLS-1$
					((bill.getBillsType()==EngBLCommon.BILL_TRANS_TYPE_BUY) ? 
					"invTrans.transactions_amount_in as amount," : "invTrans.transactions_total_amount_out as amount,")+ //$NON-NLS-1$ //$NON-NLS-2$
					" invTrans.transactions_unit_price, invTrans.transactions_total_price"+ //$NON-NLS-1$
					" from turq_inventory_transactions invTrans, turq_inventory_units units," + //$NON-NLS-1$
					" turq_inventory_cards invCard, turq_inventory_card_units invCardUnits where" + //$NON-NLS-1$
					" invTrans.engine_sequences_id="+cons.getTurqEngineSequence().getEngineSequencesId().intValue()+ //$NON-NLS-1$
					" and invTrans.inventory_cards_id=invCard.inventory_cards_id" + //$NON-NLS-1$
					" and invCardUnits.inventory_cards_id=invTrans.inventory_cards_id" + //$NON-NLS-1$
					" and invCardUnits.inventory_units_id=invTrans.inventory_units_id" + //$NON-NLS-1$
					" and units.inventory_units_id=invTrans.inventory_units_id"; //$NON-NLS-1$
			
			

			parameters.put("sqlparam",sqlparam);	 //$NON-NLS-1$
		
			TurqBillConsignmentCommon billCommon=bill.getTurqBillConsignmentCommon();
			BigDecimal discount=billCommon.getDiscountAmount();
			BigDecimal VAT=billCommon.getVatAmount();
			BigDecimal invoiceSum=billCommon.getTotalAmount().subtract(VAT).add(discount);

			BigDecimal invoiceTotal=invoiceSum.subtract(discount);
			BigDecimal grandTotal=invoiceTotal.add(VAT);
			parameters.put("invoiceSum",invoiceSum); //$NON-NLS-1$
			parameters.put("invoiceTotal",invoiceTotal); //$NON-NLS-1$
			parameters.put("invoiceDiscount",discount); //$NON-NLS-1$
			parameters.put("invoiceVAT",VAT); //$NON-NLS-1$
			parameters.put("invoiceGrandTotal",grandTotal); //$NON-NLS-1$
			parameters.put("invoiceGrandTotalText",EngBLCurrencyToWords.getTurkishCarrencyInWords(grandTotal)); //$NON-NLS-1$
			parameters.put("invoiceDate",dformat.format(bill.getBillsDate())); //$NON-NLS-1$
			parameters.put("dueDate",dformat.format(bill.getDueDate())); //$NON-NLS-1$
			TurqCurrentCard curCard=billCommon.getTurqCurrentCard();
			parameters.put("currentName",curCard.getCardsName()); //$NON-NLS-1$
			parameters.put("currentAddress",curCard.getCardsAddress()); //$NON-NLS-1$
			parameters.put("currentTaxNumber",curCard.getCardsTaxNumber()); //$NON-NLS-1$
			parameters.put("currentTaxDepartment",curCard.getCardsTaxDepartment()); //$NON-NLS-1$
			parameters.put("currentId", curCard.getCardsCurrentCode()); //$NON-NLS-1$
			parameters.put("totalSpecVAT",billCommon.getSpecialVatAmount()); //$NON-NLS-1$
	
			parameters.put("despatchNoteDate",dformat.format(cons.getConsignmentsDate())); //$NON-NLS-1$
			parameters.put("despatchNoteId",billCommon.getConsignmentDocumentNo()); //$NON-NLS-1$
			
			TurqViewCurrentAmountTotal currentView=curBLCurCardSearch.getCurrentCardView(curCard);
			BigDecimal allTotal=currentView.getTransactionsBalanceNow();
			allTotal = allTotal.multiply(new BigDecimal(-1));
			BigDecimal oldAllTotal=allTotal.subtract(grandTotal);
			
			System.out.println(new Boolean(balance));
			parameters.put("showBalance",new Boolean(balance)); //$NON-NLS-1$
			parameters.put("currentBalance", oldAllTotal); //$NON-NLS-1$
			parameters.put("currentNewBalance", allTotal); //$NON-NLS-1$
			
			parameters.put("definition",bill.getBillsDefinition()); //$NON-NLS-1$
			
			NumberFormat formatter =DecimalFormat.getInstance();
            formatter.setMaximumFractionDigits(2);
            formatter.setMinimumFractionDigits(2);
            parameters.put("formatter",formatter);  //$NON-NLS-1$
			EngDALConnection db=new EngDALConnection();
			db.connect();
			
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/invoice/template2.jasper");  //$NON-NLS-1$
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());
			
			ViewerApp viewer = new ViewerApp();
			viewer.getReportViewer().setDocument(jasperPrint);
			viewer.open();			
			
		   }
			catch(Exception ex){
                  ex.printStackTrace();
			}	
	}
	
	public static void PrintConsignment(TurqConsignment cons)
	{
		try
		{
			//TurqConsignment cons = (TurqConsignment)bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator().next();
			
			SimpleDateFormat dformat=new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			Map parameters = new HashMap();
			String sqlparam="Select invTrans.inventory_transactions_id," + //$NON-NLS-1$
					" invCardUnits.card_units_factor, " + //$NON-NLS-1$
					" invCard.card_inventory_code, invCard.card_name, units.units_name,"+ //$NON-NLS-1$
					((cons.getConsignmentsType()==EngBLCommon.CONSIGNMENT_TRANS_TYPE_BUY) ? 
					"invTrans.transactions_amount_in as amount," : "invTrans.transactions_total_amount_out as amount,")+ //$NON-NLS-1$ //$NON-NLS-2$
					" invTrans.transactions_unit_price, invTrans.transactions_total_price"+ //$NON-NLS-1$
					" from turq_inventory_transactions invTrans, turq_inventory_units units," + //$NON-NLS-1$
					" turq_inventory_cards invCard, turq_inventory_card_units invCardUnits where" + //$NON-NLS-1$
					" invTrans.engine_sequences_id="+cons.getTurqEngineSequence().getEngineSequencesId().intValue()+ //$NON-NLS-1$
					" and invTrans.inventory_cards_id=invCard.inventory_cards_id" + //$NON-NLS-1$
					" and invCardUnits.inventory_cards_id=invTrans.inventory_cards_id" + //$NON-NLS-1$
					" and invCardUnits.inventory_units_id=invTrans.inventory_units_id" + //$NON-NLS-1$
					" and units.inventory_units_id=invTrans.inventory_units_id"; //$NON-NLS-1$
			
			

			parameters.put("sqlparam",sqlparam);	 //$NON-NLS-1$
			TurqBillConsignmentCommon billCommon=cons.getTurqBillConsignmentCommon();
			BigDecimal invoiceSum=billCommon.getTotalAmount().add(billCommon.getSpecialVatAmount());
			BigDecimal discount=billCommon.getDiscountAmount();
			BigDecimal specialVAT=billCommon.getVatAmount();
			BigDecimal invoiceTotal=invoiceSum.subtract(discount);
			BigDecimal grandTotal=invoiceTotal.add(specialVAT);
			parameters.put("invoiceSum",invoiceSum); //$NON-NLS-1$
			parameters.put("invoiceTotal",invoiceTotal); //$NON-NLS-1$
			parameters.put("invoiceDiscount",discount); //$NON-NLS-1$
			parameters.put("invoiceVAT",specialVAT); //$NON-NLS-1$
			parameters.put("invoiceGrandTotal",grandTotal); //$NON-NLS-1$
			parameters.put("invoiceGrandTotalText",EngBLCurrencyToWords.getTurkishCarrencyInWords(grandTotal)); //$NON-NLS-1$
			TurqCurrentCard curCard=billCommon.getTurqCurrentCard();
			parameters.put("currentName",curCard.getCardsName()); //$NON-NLS-1$
			parameters.put("currentAddress",curCard.getCardsAddress()); //$NON-NLS-1$
			parameters.put("currentTaxNumber",curCard.getCardsTaxNumber()); //$NON-NLS-1$
			parameters.put("currentTaxDepartment",curCard.getCardsTaxDepartment()); //$NON-NLS-1$
			parameters.put("currentId", curCard.getCardsCurrentCode()); //$NON-NLS-1$
					
			parameters.put("despatchNoteDate",dformat.format(cons.getConsignmentsDate())); //$NON-NLS-1$
			parameters.put("despatchNoteId",billCommon.getConsignmentDocumentNo()); //$NON-NLS-1$
			
			TurqViewCurrentAmountTotal currentView=curBLCurCardSearch.getCurrentCardView(curCard);
			BigDecimal allTotal=(currentView.getTransactionsBalanceNow()==null) ? new BigDecimal(0): currentView.getTransactionsBalanceNow();
			BigDecimal oldAllTotal=allTotal.subtract(grandTotal);
			
			
			parameters.put("currentBalance", oldAllTotal); //$NON-NLS-1$
			parameters.put("currentNewBalance", allTotal); //$NON-NLS-1$
			parameters.put("definition",cons.getConsignmentsDefinition()); //$NON-NLS-1$
			NumberFormat formatter =DecimalFormat.getInstance();
            formatter.setMaximumFractionDigits(2);
            formatter.setMinimumFractionDigits(2);
            parameters.put("formatter",formatter);  //$NON-NLS-1$
			EngDALConnection db=new EngDALConnection();
			db.connect();
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/consignment/template1.jasper");  //$NON-NLS-1$
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());
			
			ViewerApp viewerApp = new ViewerApp();
			
			viewerApp.getReportViewer().setDocument(jasperPrint);
			viewerApp.open();
			
			//reportViewer.getReportViewer().setDocument(jasperPrint);			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void PrintTransaction(TurqAccountingTransaction trans)
	{
		try
		{
			
			SimpleDateFormat dformat=new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			Map parameters = new HashMap();
			String sqlparam="Select account.account_name as accountName, account.account_code as accountCode," + //$NON-NLS-1$
					" topacc.account_name as topAccountName,topacc.account_code as topAccountCode," + //$NON-NLS-1$
					" transColumns.dept_amount,transColumns.credit_amount, " +  //$NON-NLS-1$
					" transColumns.transaction_definition, transColumns.accounting_transaction_columns_id as columnId" + //$NON-NLS-1$
					" from turq_accounting_transaction_columns transColumns," + //$NON-NLS-1$
					" turq_accounting_accounts topacc, turq_accounting_accounts account" + //$NON-NLS-1$
					" where account.accounting_accounts_id=transColumns.accounting_accounts_id" + //$NON-NLS-1$
					" and topacc.accounting_accounts_id=account.top_account" + //$NON-NLS-1$
					" and transColumns.accounting_transactions_id="+trans.getAccountingTransactionsId().intValue()+ //$NON-NLS-1$
					" order by topAccountCode"; //$NON-NLS-1$

			parameters.put("sqlparam",sqlparam);	 //$NON-NLS-1$
	
			TurqCompany company=admBLComInfo.getCompany();
			parameters.put("companyName", company.getCompanyName()); //$NON-NLS-1$
			parameters.put("transDate", dformat.format(trans.getTransactionsDate())); //$NON-NLS-1$
			parameters.put("transNo", trans.getTransactionDocumentNo()); //$NON-NLS-1$
			NumberFormat formatter =DecimalFormat.getInstance();
            formatter.setMaximumFractionDigits(2);
            formatter.setMinimumFractionDigits(2);
            parameters.put("formatter",formatter);  //$NON-NLS-1$
			EngDALConnection db=new EngDALConnection();
			db.connect();
			JasperReport jasperReport =(JasperReport)JRLoader.loadObject("reports/accounting/AccountingTransaction.jasper");  //$NON-NLS-1$
	    	final JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,db.getCon());
			
			ViewerApp viewerApp = new ViewerApp();
			
			viewerApp.getReportViewer().setDocument(jasperPrint);
			viewerApp.open();
					
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}
	
	public static void printCurrentTrans(TurqCurrentTransaction curtrans)
	{
	    double space = 0.5;
	    TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
//	  create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing");		 //$NON-NLS-1$
		
		// put some header text on it
		PTextBox t;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.92")); //$NON-NLS-1$
		t.getTextStyle().textAlign = PTextStyle.ALIGN_CENTER;
		
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.1);
		
		t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.93")+"      ");  //$NON-NLS-1$
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    t = new PTextBox (doc, PBox.POS_RIGHT);	    
	    t.setText(curtrans.getTurqCurrentCard().getCardsCurrentCode()); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    new PVSpace(doc, space);
	    
	    t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.94")+"    ");  //$NON-NLS-1$
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    t = new PTextBox (doc, PBox.POS_RIGHT);	    
	    t.setText(curtrans.getTurqCurrentCard().getCardsName()); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    
	    new PVSpace(doc, space);
	    
	    
	    t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.95")+"     ");  //$NON-NLS-1$
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    t = new PTextBox (doc, PBox.POS_RIGHT);	    
	    t.setText(DatePicker.formatter.format(curtrans.getTransactionsDate())); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    
	    new PVSpace(doc, space);
	    
	    
	    t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.96")+"       ");  //$NON-NLS-1$
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    t = new PTextBox (doc, PBox.POS_RIGHT);	    
	    t.setText(curtrans.getTransactionsDefinition()); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    
	    new PVSpace(doc, space);
	    
	    
	    t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.97")+"      ");  //$NON-NLS-1$
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    t = new PTextBox (doc, PBox.POS_RIGHT);	    
	    t.setText(cf.format(curtrans.getTransactionsTotalDept())); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    
	    new PVSpace(doc, space);
	    
	    
	    
	    t = new PTextBox(doc);
	    t.setText(Messages.getString("EngBLUtils.98")+"  ");  //$NON-NLS-1$
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    t = new PTextBox (doc, PBox.POS_RIGHT);	    
	    t.setText(cf.format(curtrans.getTransactionsTotalCredit())); 
	    t.getTextStyle().fontSize = 10;	    
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    new PVSpace(doc, space);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		
		PrintPreview pr = new PrintPreview(null, Messages.getString("EngBLUtils.99"), IconSource.getImage("print"), doc);  //$NON-NLS-1$ //$NON-NLS-2$
		pr.open();
		
	}
	
}
