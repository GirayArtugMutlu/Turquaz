
package com.turquaz.engine.bl;

import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import net.sf.jasperreports.engine.JasperManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.jasperassistant.designer.viewer.ViewerApp;

import com.turquaz.current.bl.CurBLCurrentCardSearch;
import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.EngDALConnection;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqBillConsignmentCommon;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.dal.TurqCurrentCard;
import com.turquaz.engine.dal.TurqViewCurrentAmountTotal;

import com.turquaz.engine.ui.component.SWTPTable;

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
	private static Calendar cal=Calendar.getInstance();
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
	
	public static void printBill(TurqBill bill,Shell parent){
	    
		try{
			SimpleDateFormat dformat=new SimpleDateFormat("dd-MM-yyyy");
			Map parameters = new HashMap();
			String sqlparam="Select invTrans.inventory_transactions_id," +
					" invCardUnits.card_units_factor, " +
					" invCard.card_inventory_code, invCard.card_name,"+
					((bill.getBillsType()==EngBLCommon.BILL_TRANS_TYPE_BUY) ? 
					"invTrans.transactions_amount_in as amount," : "invTrans.transactions_total_amount_out as amount,")+
					" invTrans.transactions_unit_price, invTrans.transactions_total_price"+
					" from turq_inventory_transactions invTrans," +
					" turq_inventory_cards invCard, turq_inventory_card_units invCardUnits where" +
					" invTrans.engine_sequences_id="+bill.getTurqEngineSequence().getEngineSequencesId().intValue()+
					" and invTrans.inventory_cards_id=invCard.inventory_cards_id" +
					" and invCardUnits.inventory_cards_id=invTrans.inventory_cards_id" +
					" and invCardUnits.inventory_units_id=invTrans.inventory_units_id";
			
			

			System.out.println(sqlparam);
			parameters.put("sqlparam",sqlparam);	
			TurqBillConsignmentCommon billCommon=bill.getTurqBillConsignmentCommon();
			BigDecimal invoiceSum=billCommon.getTotalAmount().add(billCommon.getSpecialVatAmount());
			BigDecimal discount=billCommon.getDiscountAmount();
			BigDecimal specialVAT=billCommon.getSpecialVatAmount();
			BigDecimal invoiceTotal=invoiceSum.subtract(discount);
			BigDecimal grandTotal=invoiceTotal.add(specialVAT);
			parameters.put("invoiceSum",invoiceSum);
			parameters.put("invoiceTotal",invoiceTotal);
			parameters.put("invoiceDiscount",discount);
			parameters.put("invoiceVAT",specialVAT);
			parameters.put("invoiceGrandTotal",grandTotal);
			parameters.put("invoiceGrandTotalText",EngBLCurrencyToWords.getTurkishCarrencyInWords(grandTotal));
			parameters.put("invoiceDate",dformat.format(bill.getBillsDate()));
			TurqCurrentCard curCard=billCommon.getTurqCurrentCard();
			parameters.put("currentName",curCard.getCardsName());
			parameters.put("currentAddress",curCard.getCardsAddress());
			parameters.put("currentTaxNumber",curCard.getCardsTaxNumber());
			parameters.put("currentTaxDepartment",curCard.getCardsTaxDepartment());
			parameters.put("currentId", curCard.getCardsCurrentCode());
			
			TurqConsignment cons = (TurqConsignment)bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator().next();

			parameters.put("despatchNoteDate",dformat.format(cons.getConsignmentsDate()));
			parameters.put("despatchNoteId",billCommon.getConsignmentDocumentNo());
			
			TurqViewCurrentAmountTotal currentView=curBLCurCardSearch.getCurrentCardView(curCard);
			BigDecimal allTotal=currentView.getTransactionsBalanceNow();
			BigDecimal oldAllTotal=allTotal.subtract(grandTotal);
			
			parameters.put("currentBalance", oldAllTotal);
			parameters.put("currentNewBalance", allTotal);
			
			NumberFormat formatter =NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(2);
            formatter.setMinimumFractionDigits(2);
            parameters.put("formatter",formatter); 
			EngDALConnection db=new EngDALConnection();
			db.connect();
			JasperReport jasperReport = JasperManager.loadReport("reports/invoice/template1.jasper"); 
			final JasperPrint jasperPrint = JasperManager.fillReport(jasperReport,parameters,db.getCon());
			
			ViewerApp viewerApp = new ViewerApp();
			viewerApp.getReportViewer().setDocument(jasperPrint);
			viewerApp.open();
			
			//reportViewer.getReportViewer().setDocument(jasperPrint);
			
					
			}
			catch(Exception ex){
                  ex.printStackTrace();
			}
	
	}

}
