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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import com.jasperassistant.designer.viewer.ViewerApp;
import com.turquaz.accounting.AccKeys;
import com.turquaz.accounting.bl.AccBLTransactionSearch;
import com.turquaz.admin.bl.AdmBLCompanyInfo;
import com.turquaz.bill.BillKeys;
import com.turquaz.bill.bl.BillBLSearchBill;
import com.turquaz.bill.dal.BillDALSearchBill;
import com.turquaz.consignment.ConsKeys;
import com.turquaz.consignment.bl.ConBLSearchConsignment;
import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.EngConfiguration;
import com.turquaz.engine.EngKeys;
import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.TurqAccountingTransaction;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillInEngineSequence;
import com.turquaz.engine.dal.TurqCompany;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqCurrentTransaction;
import com.turquaz.engine.dal.TurqViewBillTransTotal;
import com.turquaz.engine.dal.TurqViewCurrentAmountTotal;
import com.turquaz.engine.dal.TurqViewInvPriceTotal;
import com.turquaz.engine.tx.EngTXCommon;
import com.turquaz.engine.ui.EngUICommon;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SWTPTable;
import com.turquaz.engine.ui.component.TurkishCurrencyFormat;
import com.turquaz.engine.ui.report.HibernateQueryResultDataSource;
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
 */
public class EngBLUtils
{
	public static String logoURL;

	public static void Export2Excel(Table table)
	{
		try
		{
			TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
			FileDialog dialog = new FileDialog(table.getShell(), SWT.SAVE);
			dialog.setFilterNames(new String[]{"Excel File", "(*.xls)"}); //$NON-NLS-1$ //$NON-NLS-2$
			dialog.setFilterExtensions(new String[]{"*.xls"}); //Windows wild cards //$NON-NLS-1$
			dialog.setFileName("Rapor"); //$NON-NLS-1$
			String filepath = dialog.open();
			if (filepath != null)
			{
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
				wb.setSheetName(0, "Sheet1", //$NON-NLS-1$
						HSSFWorkbook.ENCODING_COMPRESSED_UNICODE);
				//			 in case of compressed Unicode
				//			 wb.setSheetName(0, "HSSF Test", HSSFWorkbook.ENCODING_COMPRESSED_UNICODE );
				//			 create a sheet with 30 rows (0-29)
				TableItem items[] = table.getItems();
				int colCount = table.getColumnCount();
				for (int i = 1; i <= items.length; i++)
				{
					// create a row
					r = s.createRow(i);
					for (short j = 0; j < colCount; j++)
					{
						String cell_value = items[i - 1].getText(j);
						c = r.createCell(j);
						// set the cell's string value
						c.setEncoding(HSSFCell.ENCODING_UTF_16);
						Pattern alphabet = Pattern.compile("[A-Za-z]+"); //$NON-NLS-1$
						Matcher matcher = alphabet.matcher(cell_value);
						if (matcher.find())
						{
							c.setCellValue(cell_value);
						}
						else
						{
							try
							{
								double dc = (cf.parse(cell_value)).doubleValue();
								c.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
								c.setCellValue(dc);
							}
							catch (Exception ex)
							{
								c.setCellValue(cell_value);
							}
						}
					}
				}
				wb.write(out);
				out.close();
			}
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLUtils.class,ex);
		}
	}

	public static void printTable(Table table, String title)
	{
		//	  create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing"); //$NON-NLS-1$
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

	public static void printSubsidiaryLedgerTable(Table table, String title, Properties prop)
	{
		//create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing"); //$NON-NLS-1$
		// put some header text on it
		PTextBox t;
		t = new PTextBox(doc);
		t.setText(title);
		t.getTextStyle().textAlign = PTextStyle.ALIGN_CENTER;
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.1);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.8") + prop.getProperty("account_code")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.GRAB | PBox.POS_RIGHT);
		t.setText(Messages.getString("EngBLUtils.10") + prop.getProperty("start_date")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.12") + prop.getProperty("account_name")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.GRAB | PBox.POS_RIGHT);
		t.setText(Messages.getString("EngBLUtils.14") + prop.getProperty("end_date")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.16") + prop.getProperty("top_account")); //$NON-NLS-1$ //$NON-NLS-2$
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

	public static void printMonthlyAccountingBalance(Table table, String title, Map props)
	{
		//		create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing"); //$NON-NLS-1$
		// put some header text on it
		PTextBox t;
		t = new PTextBox(doc);
		t.setText(title);
		t.getTextStyle().textAlign = PTextStyle.ALIGN_CENTER;
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.1);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.2") + props.get("start_account_code")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.GRAB | PBox.POS_RIGHT);
		t.setText(Messages.getString("EngBLUtils.0") + props.get("month")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.6") + props.get("end_account_code")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.13") + props.get("report_date")); //$NON-NLS-1$ //$NON-NLS-2$
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

	public static void printAccountingBalance(Table table, String title, Map props)
	{
		//		create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing"); //$NON-NLS-1$
		// put some header text on it
		PTextBox t;
		t = new PTextBox(doc);
		t.setText(title);
		t.getTextStyle().textAlign = PTextStyle.ALIGN_CENTER;
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.1);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.2") + props.get("start_account_code")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.GRAB | PBox.POS_RIGHT);
		t.setText(Messages.getString("EngBLUtils.4") + props.get("start_date")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.6") + props.get("end_account_code")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.GRAB | PBox.POS_RIGHT);
		t.setText(Messages.getString("EngBLUtils.9") + props.get("end_date")); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 8;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.13") + props.get("report_date")); //$NON-NLS-1$ //$NON-NLS-2$
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

	public static void printBill(HashMap argMap)
	{
		try
		{
			TurqBill bill=(TurqBill)argMap.get(BillKeys.BILL);
			BillDALSearchBill.initializeBill(bill);
			Boolean balance=(Boolean)argMap.get(BillKeys.BILL_BALANCE);
			if (EngConfiguration.getString("invoice_template") == null) { //$NON-NLS-1$
				EngUICommon.showMessageBox(Display.getCurrent().getActiveShell(), Messages.getString("EngBLUtils.1"), SWT.ICON_WARNING); //$NON-NLS-1$
				return;
			}
			List list=BillBLSearchBill.getBillInfo(bill);
			SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			Map parameters = new HashMap();
			TurqViewBillTransTotal billview=BillBLSearchBill.getBillView(bill.getId());
			BigDecimal discount = billview.getDiscountamount();
			BigDecimal VAT = billview.getVatamount();
			BigDecimal specialVATAmount= billview.getSpecialvatamount();
			BigDecimal invoiceSum =billview.getTotalprice();
			BigDecimal invoiceTotal = invoiceSum.subtract(discount);
			BigDecimal grandTotal = invoiceTotal.add(VAT).add(specialVATAmount);
			parameters.put("invoiceSum", invoiceSum);
			parameters.put("invoiceTotal", invoiceTotal);
			parameters.put("invoiceDiscount", discount); 
			parameters.put("invoiceVAT", VAT);
			parameters.put("invoiceGrandTotal", grandTotal); 
			parameters.put("invoiceGrandTotalText",EngBLCurrencyToWords.getTurkishCarrencyInWords(grandTotal));
			parameters.put("invoiceDate",dformat.format(bill.getBillsDate())); 
			parameters.put("dueDate", dformat.format(bill.getDueDate()));
			TurqCurrentCard curCard = bill.getTurqCurrentCard();
			parameters.put("currentName",curCard.getCardsName());
			parameters.put("currentAddress", curCard.getCardsAddress());
			parameters.put("currentTaxNumber", curCard.getCardsTaxNumber());
			parameters.put("currentTaxDepartment",curCard.getCardsTaxDepartment());
			parameters.put("currentId", curCard.getCardsCurrentCode());
			parameters.put("totalSpecVAT",specialVATAmount);
			Iterator iter=bill.getTurqBillInEngineSequences().iterator();
			if (iter.hasNext())
			{
				Iterator iter2=((TurqBillInEngineSequence)iter.next()).getTurqEngineSequence().getTurqConsignments().iterator();
				TurqConsignment cons=null;
				if (iter2.hasNext())
				{
					cons=(TurqConsignment)iter2.next();			
					parameters.put("despatchNoteDate",dformat.format(cons.getConsignmentsDate()));
					parameters.put("despatchNoteId",cons.getConsignmentDocumentNo());
				}
				else
				{
					parameters.put("despatchNoteDate","");
					parameters.put("despatchNoteId","");				
				}
			}
			else
			{
				parameters.put("despatchNoteDate","");
				parameters.put("despatchNoteId","");				
			}
			parameters.put("billType", (bill.getBillsType() ==EngBLCommon.BILL_TRANS_TYPE_BUY) ? new Integer(1) : new Integer(0)); 
			
			
			 argMap = new HashMap();
			argMap.put(EngKeys.CURRENT_CARD,curCard);

			
			TurqViewCurrentAmountTotal currentView =(TurqViewCurrentAmountTotal)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getCurrentCardView",argMap);
			
			
			
			BigDecimal allTotal = currentView.getTransactionsBalanceNow();
			allTotal =allTotal.multiply(new BigDecimal(-1)); 
			BigDecimal oldAllTotal = allTotal.subtract(grandTotal);
			parameters.put("showBalance",balance);
			parameters.put("currentBalance", oldAllTotal); 
			parameters.put("currentNewBalance", allTotal); 
			parameters.put("definition", bill.getBillsDefinition());
			NumberFormat formatter = DecimalFormat.getInstance(); 
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2); 
			parameters.put("formatter", formatter);
			NumberFormat formatter2 =DecimalFormat.getInstance();
			formatter2.setMaximumFractionDigits(4);
			formatter2.setMinimumFractionDigits(4);
			parameters.put("formatter2", formatter2); 			
			String[] fields = new String[]{"trans_id", "card_units_factor", "card_inventory_code",
					"card_name", "units_name", "amount", "unit_price", "total_price",
					"warehouses_name","transactions_vat"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/invoice/" +EngConfiguration.getString("invoice_template"));
			//JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/invoice/" +EngConfiguration.getString("invoice_template")); 
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			ViewerApp viewer = new ViewerApp();
			viewer.getReportViewer().setDocument(jasperPrint);
			viewer.open();
			 
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLUtils.class,ex);
		}
	}

	public static void PrintConsignment(HashMap argMap)
	{
		try
		{
			TurqConsignment cons=(TurqConsignment)argMap.get(ConsKeys.CONS);
			List list=ConBLSearchConsignment.getConsignmentInfo(cons);
			Map parameters = new HashMap();
			SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$
			TurqViewInvPriceTotal billView=ConBLSearchConsignment.getViewInvTotal(cons.getTurqEngineSequence().getId());
			BigDecimal invoiceSum = billView.getTotalprice().add(billView.getSpecialvatamount());
			BigDecimal discount = billView.getDiscountamount();
			BigDecimal specialVAT = billView.getVatamount();
			BigDecimal invoiceTotal = invoiceSum.subtract(discount);
			BigDecimal grandTotal = invoiceTotal.add(specialVAT);
			parameters.put("invoiceSum", invoiceSum);
			parameters.put("invoiceTotal", invoiceTotal);
			parameters.put("invoiceDiscount", discount);
			parameters.put("invoiceVAT", specialVAT);
			parameters.put("invoiceGrandTotal", grandTotal);
			parameters.put("invoiceGrandTotalText", EngBLCurrencyToWords.getTurkishCarrencyInWords(grandTotal));
			TurqCurrentCard curCard = cons.getTurqCurrentCard();
			parameters.put("currentName", curCard.getCardsName());
			parameters.put("currentAddress", curCard.getCardsAddress());
			parameters.put("currentTaxNumber", curCard.getCardsTaxNumber());
			parameters.put("currentTaxDepartment", curCard.getCardsTaxDepartment());
			parameters.put("currentId", curCard.getCardsCurrentCode());
			parameters.put("despatchNoteDate", dformat.format(cons.getConsignmentsDate()));
			parameters.put("despatchNoteId", cons.getConsignmentDocumentNo());
			
			argMap = new HashMap();
			argMap.put(EngKeys.CURRENT_CARD,curCard);

			
			TurqViewCurrentAmountTotal currentView =(TurqViewCurrentAmountTotal)EngTXCommon.doSelectTX(CurBLCurrentCardSearch.class.getName(),"getCurrentCardView",argMap);
			
			
			
			
			BigDecimal allTotal = (currentView.getTransactionsBalanceNow() == null) ? new BigDecimal(0) : currentView
					.getTransactionsBalanceNow();
			BigDecimal oldAllTotal = allTotal.subtract(grandTotal);
			parameters.put("currentBalance", oldAllTotal);
			parameters.put("currentNewBalance", allTotal);
			parameters.put("definition", cons.getConsignmentsDefinition());
			NumberFormat formatter = DecimalFormat.getInstance();
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2);
			parameters.put("formatter", formatter);
			String[] fields = new String[]{"trans_id", "card_units_factor", "card_inventory_code",
					"card_name", "units_name", "amount", "unit_price", "total_price"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/consignment/template1.jrxml");
			//JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/consignment/template1.jasper"); //$NON-NLS-1$
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			ViewerApp viewer = new ViewerApp();
			viewer.getReportViewer().setDocument(jasperPrint);
			viewer.open();

		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLUtils.class,ex);
		}
	}

	public static void PrintTransaction(HashMap argMap)
	{
		try
		{
			TurqAccountingTransaction trans=(TurqAccountingTransaction)argMap.get(AccKeys.ACC_TRANSACTION);
			SimpleDateFormat dformat = new SimpleDateFormat("dd-MM-yyyy"); //$NON-NLS-1$	
			List list=AccBLTransactionSearch.getAccTransInfo(trans.getId());
			TurqCompany company = AdmBLCompanyInfo.getCompany();
			Map parameters = new HashMap();
			parameters.put("companyName", company.getCompanyName()); //$NON-NLS-1$
			parameters.put("transDate", dformat.format(trans.getTransactionsDate())); //$NON-NLS-1$
			parameters.put("transNo", trans.getTransactionDocumentNo()); //$NON-NLS-1$
			NumberFormat formatter = DecimalFormat.getInstance();
			formatter.setMaximumFractionDigits(2);
			formatter.setMinimumFractionDigits(2);
			parameters.put("formatter", formatter); //$NON-NLS-1$

			String[] fields = new String[]{"accountName", "accountCode", "topAccountName",
					"topAccountCode", "dept_amount", "credit_amount", "transaction_definition", "columnId"};
			HibernateQueryResultDataSource ds = new HibernateQueryResultDataSource(list, fields);
			JasperReport jasperReport = JasperCompileManager.compileReport("reports/accounting/AccountingTransaction.jrxml");
			//JasperReport jasperReport = (JasperReport) JRLoader.loadObject("reports/accounting/AccountingTransaction.jasper"); //$NON-NLS-1$
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, ds);
			ViewerApp viewer = new ViewerApp();
			viewer.getReportViewer().setDocument(jasperPrint);
			viewer.open();
		}
		catch (Exception ex)
		{
            EngBLLogger.log(EngBLUtils.class,ex);
		}
	}

	public static void printCurrentTrans(TurqCurrentTransaction curtrans)
	{
		double space = 0.5;
		TurkishCurrencyFormat cf = new TurkishCurrencyFormat();
		//	  create a document with default settings from PageSetup
		PDocument doc = new PDocument("Turquaz Printing"); //$NON-NLS-1$
		// put some header text on it
		PTextBox t;
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.92")); //$NON-NLS-1$
		t.getTextStyle().textAlign = PTextStyle.ALIGN_CENTER;
		new PVSpace(doc, 0.1);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		new PVSpace(doc, 0.1);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.93") + "      "); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.POS_RIGHT);
		t.setText(curtrans.getTurqCurrentCard().getCardsCurrentCode());
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		new PVSpace(doc, space);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.94") + "    "); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.POS_RIGHT);
		t.setText(curtrans.getTurqCurrentCard().getCardsName());
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		new PVSpace(doc, space);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.95") + "     "); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.POS_RIGHT);
		t.setText(DatePicker.formatter.format(curtrans.getTransactionsDate()));
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		new PVSpace(doc, space);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.96") + "       "); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.POS_RIGHT);
		t.setText(curtrans.getTransactionsDefinition());
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		new PVSpace(doc, space);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.97") + "      "); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.POS_RIGHT);
		t.setText(cf.format(curtrans.getTransactionsTotalDept()));
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		new PVSpace(doc, space);
		t = new PTextBox(doc);
		t.setText(Messages.getString("EngBLUtils.98") + "  "); //$NON-NLS-1$ //$NON-NLS-2$
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().fontStyle = SWT.BOLD;
		t = new PTextBox(doc, PBox.POS_RIGHT);
		t.setText(cf.format(curtrans.getTransactionsTotalCredit()));
		t.getTextStyle().fontSize = 10;
		t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
		new PVSpace(doc, space);
		new PHLine(doc, 0.02, SWT.COLOR_BLACK);
		PrintPreview pr = new PrintPreview(null, Messages.getString("EngBLUtils.99"), IconSource.getImage("print"), doc); //$NON-NLS-1$ //$NON-NLS-2$
		pr.open();
	}
}