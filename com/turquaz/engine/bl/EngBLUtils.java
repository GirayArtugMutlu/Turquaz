
package com.turquaz.engine.bl;

import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import com.turquaz.engine.Messages;
import com.turquaz.engine.dal.TurqBill;
import com.turquaz.engine.dal.TurqConsignment;
import com.turquaz.engine.ui.component.DatePicker;
import com.turquaz.engine.ui.component.SWTPTable;

import de.kupzog.ktools.kprint.boxes.PBox;
import de.kupzog.ktools.kprint.boxes.PDocument;
import de.kupzog.ktools.kprint.boxes.PHLine;
import de.kupzog.ktools.kprint.boxes.PHSpace;
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
	    
	    PDocument doc = new PDocument("Turquaz Printing");
	    new PVSpace(doc,8);
	    PTextBox t;
	    
	    int style_below = PBox.POS_BELOW | PBox.ROW_ALIGN;
	    int style_right = PBox.POS_RIGHT | PBox.ROW_ALIGN;
	    int style_grab_right =PBox.GRAB|PBox.POS_RIGHT;
	    
	    new PHSpace(doc,style_below,3);
	    t = new PTextBox(doc,style_right,0,5);
	    
	    t.setText(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsName()); 
	    t.getTextStyle().fontSize = 10;
	    
	    
	    t = new PTextBox(doc,style_grab_right);
	    
	    t.setText(DatePicker.formatter.format(bill.getBillsDate())); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;	    
	    
	    
	    TurqConsignment cons = (TurqConsignment)bill.getTurqBillConsignmentCommon().getTurqConsignments().iterator().next();
	    
	    new PVSpace(doc,0.2);    
	    
	    t = new PTextBox(doc,style_grab_right);
	    
	    t.setText(DatePicker.formatter.format(cons.getConsignmentsDate())); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;	
	    
	    
	    new PHSpace(doc,style_below,3);   
	    
	    
	    t = new PTextBox(doc,style_right,0,5);
	    
	    t.setText(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsAddress()); 
	    t.getTextStyle().fontSize = 10;
	    
	    new PVSpace(doc,0.08);  
	    
	    t = new PTextBox(doc,style_grab_right);
	    
	    t.setText(bill.getTurqBillConsignmentCommon().getConsignmentDocumentNo()); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;	
	    
	   
	    new PVSpace(doc,0.1);
	    
	    new PHSpace(doc,style_below,3);
	    
	    t = new PTextBox(doc,style_right,0,5);
	    
	    t.setText(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsTaxDepartment()+" "
	             +bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsTaxNumber() ); 
	    t.getTextStyle().fontSize = 8;
	    
	   
	    t = new PTextBox(doc,style_grab_right);
	    
	    t.setText(bill.getTurqBillConsignmentCommon().getTurqCurrentCard().getCardsCurrentCode()); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;	
	    
	    new PVSpace(doc,8);
	        
	    t = new PTextBox(doc,style_grab_right);
	    
	    t.setText(bill.getTurqBillConsignmentCommon().getTotalAmount().toString()); 
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    t.getTextStyle().textAlign = PTextStyle.ALIGN_RIGHT;
	    
	    
	    t = new PTextBox(doc,style_below,0,5);
	    t.getTextStyle().fontSize = 10;
	    t.getTextStyle().fontStyle = SWT.BOLD;
	    
	    
	    
	    PrintPreview pr = new PrintPreview(parent, "", IconSource.getImage("print"), doc); //$NON-NLS-1$
		pr.open();    
	
	}

}
