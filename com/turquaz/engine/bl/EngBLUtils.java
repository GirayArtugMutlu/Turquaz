
package com.turquaz.engine.bl;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import de.kupzog.ktools.kprint.boxes.PDocument;
import de.kupzog.ktools.kprint.boxes.PHLine;
import de.kupzog.ktools.kprint.boxes.PTableBoxProvider;
import de.kupzog.ktools.kprint.boxes.PTextBox;
import de.kupzog.ktools.kprint.boxes.PVSpace;
import de.kupzog.ktools.kprint.boxes.SWTPTable;
import de.kupzog.ktools.kprint.gui.IconSource;
import de.kupzog.ktools.kprint.gui.PrintPreview;



/**
 * @author onsel
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class EngBLUtils {
	
	public static String logoURL;
	
	
	public static void Export2Excel(Table table){
		 try{
			
			FileDialog dialog = new FileDialog (table.getShell(), SWT.SAVE);
			dialog.setFilterNames (new String [] {"Excel File", "(*.xls)"});
			dialog.setFilterExtensions (new String [] {"*.xls"}); //Windows wild cards
			dialog.setFileName ("excel_cikti");

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
			wb.setSheetName(0, "Sheet1", 
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
		PDocument doc = new PDocument("Turquaz Printing");		
		
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
		
		PrintPreview pr = new PrintPreview(null, "Test", IconSource.getImage("print"), doc);
		pr.open();
	    
	}

}
