package com.turquaz.current.ui;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.SWT;

import com.turquaz.current.bl.CurBLSearchTransaction;
import com.turquaz.current.bl.CurBLTransactionUpdate;
import com.turquaz.engine.dal.TurqCurrentTransaction;

import com.turquaz.engine.ui.editors.CurrencyCellEditor;
import com.turquaz.engine.ui.viewers.ITableRow;
import com.turquaz.engine.ui.viewers.ITableRowListViewer;
import com.turquaz.engine.ui.viewers.TableRowList;
import com.turquaz.engine.ui.viewers.TurquazCellModifier;
import com.turquaz.engine.ui.viewers.TurquazContentProvider;
import com.turquaz.engine.ui.viewers.TurquazLabelProvider;



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
public class CurUIInitialTransaction extends org.eclipse.swt.widgets.Composite {
	private Table tableInitialTrans;
	private TableColumn tableColumnCredit;
	private TableColumn tableColumnDebit;
	private TableColumn tableColumnCurrentCard;

	final static String CURRENT_CARD = "Cari Kart";
	final static String DEPT = "Borç";
	final static String CREDIT = "Alacak";
	
	TableCursor cursor;

	private List columnList = new ArrayList();

	TableRowList rowList = new TableRowList();

	// Set column names
	private String[] columnNames = new String[] { CURRENT_CARD,DEPT, CREDIT

	};
	public TableViewer tableViewer;
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		showGUI();
	}
		
	/**
	* Auto-generated method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void showGUI() {
		Display display = Display.getDefault();
		Shell shell = new Shell(display);
		CurUIInitialTransaction inst = new CurUIInitialTransaction(shell, SWT.NULL);
		Point size = inst.getSize();
		shell.setLayout(new FillLayout());
		shell.layout();
		if(size.x == 0 && size.y == 0) {
			inst.pack();
			shell.pack();
		} else {
			Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
			int MENU_HEIGHT = 22;
			if (shell.getMenuBar() != null)
				shellBounds.height -= MENU_HEIGHT;
			shell.setSize(shellBounds.width, shellBounds.height);
		}
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

	public CurUIInitialTransaction(org.eclipse.swt.widgets.Composite parent, int style) {
		super(parent, style);
		initGUI();
	}

	private void initGUI() {
		try {
			this.setLayout(new GridLayout());
			this.setSize(611, 459);
            {
                tableInitialTrans = new Table(this, SWT.FULL_SELECTION | SWT.HIDE_SELECTION);
                GridData tableInitialTransLData = new GridData();
                tableInitialTrans.setHeaderVisible(true);
                tableInitialTrans.setLinesVisible(true);
                tableInitialTransLData.horizontalAlignment = GridData.FILL;
                tableInitialTransLData.verticalAlignment = GridData.FILL;
                tableInitialTransLData.grabExcessHorizontalSpace = true;
                tableInitialTransLData.grabExcessVerticalSpace = true;
                tableInitialTrans.setLayoutData(tableInitialTransLData);
                {
                    tableColumnCurrentCard = new TableColumn(
                        tableInitialTrans,
                        SWT.NONE);
                    tableColumnCurrentCard.setText("Cari Kart");
                    tableColumnCurrentCard.setWidth(233);
                }
                {
                    tableColumnDebit = new TableColumn(tableInitialTrans, SWT.RIGHT);
                    tableColumnDebit.setText("Borç");
                    tableColumnDebit.setWidth(100);
                }
                {
                    tableColumnCredit = new TableColumn(tableInitialTrans, SWT.RIGHT);
                    tableColumnCredit.setText("Alacak");
                    tableColumnCredit.setWidth(100);
                }
            }
            postInitGUI();
			this.layout();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void postInitGUI(){
	    createTableViewer();
	    fillTable();    
	    
	    
	    
	}
	
	
	public void fillTable(){
	    try{
	        CurBLSearchTransaction blSearch = new CurBLSearchTransaction();
	        
	        List list = blSearch.getInitialTransactions();
	        
	        TurqCurrentTransaction curTrans;
	        for(int i=0;i<list.size();i++){
	            
	            curTrans = (TurqCurrentTransaction)list.get(i);
	            CurUIInitialTransTableRow row = new CurUIInitialTransTableRow();
	            row.setDBObject(curTrans);
	            rowList.addTask(row);
	            rowList.taskChanged(row);
	        }
	        
	        
	        
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	}
	
	public void createTableViewer(){
	    
	    columnList.add(CURRENT_CARD);
		columnList.add(DEPT);
		columnList.add(CREDIT);
		
		tableViewer = new TableViewer(tableInitialTrans);
		tableViewer.setUseHashlookup(true);
		tableViewer.setColumnProperties(columnNames);
		//     Create the cell editors
		CellEditor[] editors = new CellEditor[columnNames.length];
		editors[0] = new TextCellEditor(tableInitialTrans);
		editors[1] = new CurrencyCellEditor(tableInitialTrans);
		editors[2] = new CurrencyCellEditor(tableInitialTrans);
		
		TurquazContentProvider contentProvider = new TurquazContentProvider(
				tableViewer, rowList);
		tableViewer.setCellModifier(new TurquazCellModifier(columnList,
				contentProvider));
		tableViewer.setContentProvider(contentProvider);
		tableViewer.setLabelProvider(new TurquazLabelProvider());
		tableViewer.setInput(rowList);

		// Assign the cell editors to the viewer
		tableViewer.setCellEditors(editors);
	    
//		 create a TableCursor to navigate around the table
		cursor = new TableCursor(tableInitialTrans, SWT.NONE);
		cursor.setEnabled(true);
		cursor.addSelectionListener(new SelectionAdapter() {
			// when the TableEditor is over a cell, select the corresponding
			// rowtable
			public void widgetSelected(SelectionEvent e) {

			}

			// when the user hits "ENTER" in the TableCursor, pop up a
			// text/combo editor
			// so that they can change the text of the cell for
			// controlType=="input" || "select1"<br>
			// if controlType==TableViewerExample.TYPE_CHECKBOX, toogle it
			public void widgetDefaultSelected(SelectionEvent e) {

				tableViewer.editElement(cursor.getRow().getData(), cursor
						.getColumn());

			}
		});
		cursor.addMouseListener(new MouseAdapter() {
			public void mouseDoubleClick(MouseEvent arg0) {
				tableViewer.editElement(cursor.getRow().getData(), cursor
						.getColumn());

			}
		});
		 // Listener for rowList
	    rowList.addChangeListener(new ITableRowListViewer(){
	       public void updateRow(ITableRow row){     
	       
	           try{
	           
	               CurBLTransactionUpdate.updateTrans(row.getDBObject());
	           
	           }
	           catch(Exception ex){
	               ex.printStackTrace();
	           }
	       
	       }
	       public void removeRow(ITableRow row){
	          
	                 
	       }
	       public void addRow(ITableRow row){
	          
	       }
	    });
	        

	    
	}
	

}
